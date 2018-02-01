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
import cz.cca.mojecca.db.imis.ZamMesDAO;
import cz.cca.mojecca.db.imis.model.PrichodOdchodEntity;
import cz.cca.mojecca.db.imis.model.ZamMesEntity;
import cz.cca.mojecca.db.imis.model.ZamMesFilterParameters;
import cz.cca.mojecca.service.KalendarService;
import cz.cca.mojecca.service.imis.data.DochazkaDataAdapter;
import cz.cca.mojecca.service.imis.data.PresentDataAdapter;
import cz.cca.mojecca.service.imis.model.EmployeeDayPrichodOdchods;
import cz.cca.mojecca.service.imis.model.EmployeeDayPrichodOdchodsFilterParameters;
import cz.cca.mojecca.service.imis.model.EmployeeNahradniVolno;
import cz.cca.mojecca.service.imis.model.EmployeeNahradniVolnoFilterParameters;
import cz.cca.mojecca.service.imis.model.NahradniVolnoSumVybrat;
import cz.cca.mojecca.service.model.Den;
import cz.cca.mojecca.service.model.DensFilterParameters;
import cz.cca.mojecca.util.DateUtils;

@RequestScoped
public class DochazkaService {

	@Inject
	private UzivatelService uzivatelService;

	@Inject
	private KalendarService kalendarService;

	@EJB
	private PrichodOdchodDAO prichodOdchodDAO;

	@EJB
	private VykazPraceDAO vykazPraceDAO;

	@EJB
	private ZamMesDAO zamMesDAO;

	public EmployeeDayPrichodOdchods getEmployeeDayPrichodOdchods(EmployeeDayPrichodOdchodsFilterParameters params) {
		String icp = uzivatelService.getIcp(params.getKodUzivatele());
		Date day = new LocalDate(params.getDate()).toDate();

		List<PrichodOdchodEntity> pos = prichodOdchodDAO.getEmployeePrichodOdchods(icp, day);

		EmployeeDayPrichodOdchods result = new EmployeeDayPrichodOdchods();
		result.setPrichodOdchodsText(PresentDataAdapter.toTodayPresentsString(pos));

		if (DateUtils.isToday(day)) {
			OdpracovanoHod o = calculateOpracovanoHod(icp, day);
			result.setOdpracovano(BigDecimal.valueOf(o.odpracovano));
			result.setOdchodPlan(calculateOdchodPlan(o));
			
			EmployeeNahradniVolnoFilterParameters envParams = new EmployeeNahradniVolnoFilterParameters();
			envParams.setKodUzivatele(params.getKodUzivatele());
			envParams.setFromObdobi(new LocalDate().withDayOfMonth(1).toDate().getTime());
			EmployeeNahradniVolno env = getEmployeeNahradniVolno(envParams);
			
			if (result.getOdchodPlan() != null) {
				result.setOdchodPlanWithNV(result.getOdchodPlan().subtract(env.getSumVybrat().getMusiNaDen()));
			}
		} else {
			result.setOdpracovano(vykazPraceDAO.getOdpracovanoHodVDen(icp, day));
		}

		return result;
	}

	private BigDecimal calculateOdchodPlan(OdpracovanoHod o) {
		if (o.firstPrichod == null) {
			return null;
		}
		
		double result = o.firstPrichod + 8;
		if (o.outTime > 0.5d) {
			result += o.outTime;
		} else {
			result += 0.5d;
		}
		return BigDecimal.valueOf(result);
	}

	public BigDecimal getOdpracovano(String icp, Date date) {
		if (DateUtils.isToday(date)) {
			return BigDecimal.valueOf(calculateOpracovanoHod(icp, date).odpracovano);
		} else {
			return vykazPraceDAO.getOdpracovanoHodVDen(icp, date);
		}
	}

	private OdpracovanoHod calculateOpracovanoHod(String icp, Date date) {
		List<PrichodOdchodEntity> pos = prichodOdchodDAO.getEmployeePrichodOdchods(icp, date);

		OdpracovanoHod result = new OdpracovanoHod();

		if ((pos == null) || (pos.isEmpty())) {
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
				if (result.firstPrichod == null) {
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

	public EmployeeNahradniVolno getEmployeeNahradniVolno(EmployeeNahradniVolnoFilterParameters params) {
		String icp = uzivatelService.getIcp(params.getKodUzivatele());
		ZamMesFilterParameters pars = DochazkaDataAdapter.toZamMesFilterParameters(params, icp);

		List<ZamMesEntity> zamMess = zamMesDAO.getZamMess(pars);
		NahradniVolnoSumVybrat sumVybrat = calculateSumVybrat(params.getKodUzivatele());

		return DochazkaDataAdapter.toEmployeeNahradniVolno(zamMess, sumVybrat);
	}

	private NahradniVolnoSumVybrat calculateSumVybrat(String kodUzivatele) {
		String icp = uzivatelService.getIcp(kodUzivatele);

		EmployeeNahradniVolnoFilterParameters params = new EmployeeNahradniVolnoFilterParameters();
		ZamMesFilterParameters pars = DochazkaDataAdapter.toZamMesFilterParameters(params, icp);
		List<ZamMesEntity> zamMess = zamMesDAO.getZamMess(pars);

		LocalDate day = new LocalDate().withDayOfMonth(1);
		LocalDate today = new LocalDate();
		double vybranoNV = 0;
		while (today.compareTo(day) > 0) {
			OdpracovanoHod odpracovano = calculateOpracovanoHod(icp, day.toDate());

			if ((odpracovano.odpracovano > 0) && (Math.round(odpracovano.odpracovano * 1000d) / 1000d < 8d)) {
				vybranoNV += 8d - odpracovano.odpracovano;
			}

			day = day.plusDays(1);
		}

		double sumNV = zamMess.stream().mapToDouble(entity -> entity.getNahrVolno().doubleValue()).sum();
		double lzeVybrat = sumNV - vybranoNV;

		Date obdobiMusiVybrat = new LocalDate().withDayOfMonth(1).minusMonths(2).toDate();
//		double musiVybrat = zamMess.stream().filter(entity -> entity.getId().getObdobi().equals(obdobiMusiVybrat))
//				.mapToDouble(entity -> entity.getNahrVolno().doubleValue()).sum();
		
		double musiVybrat = zamMess.stream().filter(entity -> entity.getId().getObdobi().compareTo(obdobiMusiVybrat) >= 0)
				.mapToDouble(entity -> entity.getNahrVolno().doubleValue()).sum();

		musiVybrat -= vybranoNV;

		NahradniVolnoSumVybrat result = new NahradniVolnoSumVybrat();
		result.setLze(BigDecimal.valueOf(lzeVybrat));
		result.setMusi(BigDecimal.valueOf(musiVybrat));
		result.setPracovnichDniDoKonceMesice(calculatePracovnichDniDoKonceMesice(kodUzivatele));
		result.setMusiNaDen(BigDecimal.valueOf(musiVybrat / result.getPracovnichDniDoKonceMesice()));

		return result;
	}

	private long calculatePracovnichDniDoKonceMesice(String kodUzivatele) {
		DensFilterParameters params = new DensFilterParameters();
		params.setKodUzivatele(kodUzivatele);
		params.setFromDate(new LocalDate().toDate().getTime());
		params.setToDate(new LocalDate().withDayOfMonth(1).plusMonths(1).minusDays(1).toDate().getTime());
		List<Den> days = kalendarService.getDens(params);

		return days.stream().filter(
				entity -> "A".equals(entity.getImisDen().getVyrobniDen()) &&
						"P".equals(entity.getIszaDen().getDruhDne()))
				.count();
	}

}

class OdpracovanoHod {

	double odpracovano;
	double inTime;
	double outTime;
	Double firstPrichod;

}
