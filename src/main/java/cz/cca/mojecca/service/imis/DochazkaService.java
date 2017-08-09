package cz.cca.mojecca.service.imis;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.joda.time.LocalDate;

import cz.cca.mojecca.db.imis.PrichodOdchodDAO;
import cz.cca.mojecca.db.imis.VykazPraceDAO;
import cz.cca.mojecca.db.imis.model.PrichodOdchodEntity;
import cz.cca.mojecca.service.imis.data.PresentDataAdapter;
import cz.cca.mojecca.service.imis.model.EmployeeDayPrichodOdchods;
import cz.cca.mojecca.service.imis.model.EmployeeDayPrichodOdchodsFilterParameters;
import cz.cca.mojecca.util.DateUtils;

@RequestScoped
public class DochazkaService {

	@Inject
	private UzivatelService uzivatelService;

	@EJB
	private PrichodOdchodDAO prichodOdchodDAO;

	@EJB
	private VykazPraceDAO vykazPraceDAO;

	public EmployeeDayPrichodOdchods getEmployeeDayPrichodOdchods(EmployeeDayPrichodOdchodsFilterParameters params) {
		String icp = uzivatelService.getIcp(params.getKodUzivatele());
		Date day = new LocalDate(params.getDate()).toDate();

		List<PrichodOdchodEntity> pos = prichodOdchodDAO.getEmployeePrichodOdchods(icp, day);

		EmployeeDayPrichodOdchods result = new EmployeeDayPrichodOdchods();
		result.setPrichodOdchodsText(PresentDataAdapter.toTodayPresentsString(pos));

		if (DateUtils.isToday(day)) {
			OdpracovanoHod o = calculateOpracovanoHod(icp, day);
			result.setOdpracovano(new BigDecimal(o.odpracovano));
			result.setOdchodPlan(new BigDecimal(calculateOdchodPlan(o)));
		} else {
			result.setOdpracovano(vykazPraceDAO.getOdpracovanoHodVDen(icp, day));
		}

		return result;
	}

	private double calculateOdchodPlan(OdpracovanoHod o) {
		double result = o.firstPrichod + 8;
		if (o.outTime > 0.5d) {
			result += o.outTime;
		} else {
			result += 0.5d;
		}
		return result;
	}

	public BigDecimal getOdpracovano(String icp, Date date) {
		if (DateUtils.isToday(date)) {
			return new BigDecimal(calculateOpracovanoHod(icp, date).odpracovano);
		} else {
			return vykazPraceDAO.getOdpracovanoHodVDen(icp, date);
		}
	}

	private OdpracovanoHod calculateOpracovanoHod(String icp, Date date) {
		List<PrichodOdchodEntity> pos = prichodOdchodDAO.getEmployeePrichodOdchods(icp, date);

		OdpracovanoHod result = new OdpracovanoHod();

		if ((pos == null) || (pos.size() == 0)) {
			result.odpracovano = 0d;
			result.inTime = 0d;
			result.outTime = 0d;
			return result;
		}

		double inTime = 0;
		double outTime = 0;
		Double lastTime = null;
		boolean actIn = false;
		for (PrichodOdchodEntity po : pos) {
			if (!actIn &&
					(("P".equals(po.getKodPrichodOdchod()) && !"10".equals(po.getSpecPrichodOdchod())) ||
							("O".equals(po.getKodPrichodOdchod()) && ("01".equals(po.getSpecPrichodOdchod()))))) {

				if (lastTime != null) {
					outTime += po.getCas() - lastTime;
				}
				actIn = true;
				lastTime = po.getCas();
				if (result.firstPrichod == 0) {
					result.firstPrichod = po.getCas();
				}

			}

			if (actIn && "O".equals(po.getKodPrichodOdchod()) && !"01".equals(po.getSpecPrichodOdchod())) {
				if (lastTime != null) {
					inTime += po.getCas() - lastTime;
				}
				actIn = false;
				lastTime = po.getCas();

			}
		}

		if (actIn) {
			Calendar c = Calendar.getInstance();
			inTime += c.get(Calendar.HOUR_OF_DAY) + c.get(Calendar.MINUTE) / 60d - lastTime;
		}

		result.inTime = inTime;
		result.outTime = outTime;

		if ((inTime > 12) && (outTime < 1)) {
			double newTime = inTime - (1d - outTime);
			if (newTime < 12) {
				inTime = 12;
			} else {
				inTime = newTime;
			}
		} else if ((inTime > 6) && (outTime < 0.5d)) {
			double newTime = inTime - (0.5d - outTime);
			if (newTime < 6) {
				inTime = 6;
			} else {
				inTime = newTime;
			}
		}

		result.odpracovano = inTime;

		return result;
	}

}

class OdpracovanoHod {

	double odpracovano;
	double inTime;
	double outTime;
	double firstPrichod;

}
