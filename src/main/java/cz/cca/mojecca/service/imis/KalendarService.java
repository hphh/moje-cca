package cz.cca.mojecca.service.imis;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import cz.cca.mojecca.db.imis.KalendarDAO;
import cz.cca.mojecca.db.imis.PrichodOdchodDAO;
import cz.cca.mojecca.db.imis.VykazPraceDAO;
import cz.cca.mojecca.db.imis.model.ImisDenEntity;
import cz.cca.mojecca.db.imis.model.PrichodOdchodEntity;
import cz.cca.mojecca.service.imis.data.KalendarDataAdapter;
import cz.cca.mojecca.service.imis.model.ImisDay;
import cz.cca.mojecca.service.imis.model.ImisDaysFilterParameters;
import cz.cca.mojecca.util.DateUtils;
import cz.cca.mojecca.util.MnozstviHodUtils;

@RequestScoped
public class KalendarService {

	@EJB
	private KalendarDAO kalendarDAO;

	@EJB
	private VykazPraceDAO vykazPraceDAO;

	@EJB
	private PrichodOdchodDAO prichodOdchodDAO;

	@Inject
	private UzivatelService uzivatelService;

	public List<ImisDay> getImisDays(ImisDaysFilterParameters params) {
		String icp = uzivatelService.getIcp(params.getKodUzivatele());

		List<ImisDenEntity> imisDenEntities = kalendarDAO.getImisDens(params.getFromDate(), params.getToDate(),
				params.getKodUzivatele(), icp);

		List<ImisDay> result = KalendarDataAdapter.toImisDays(imisDenEntities);

		fillOdpracovanoHod(result, icp);

		if (params.isUnsolvedDaysOnly()) {
			result = result.stream().filter(entity -> {
				return (MnozstviHodUtils.compare(entity.getVykazanoHod(), entity.getOdpracovanoHod()) != 0) ||
						("A".equals(entity.getPritomen()) && "N".equals(entity.getPotvrzeno())) ||
						("A".equals(entity.getVykazano()) && "N".equals(entity.getPotvrzeno()));

			}).collect(Collectors.toList());
		}

		return result;
	}

	private void fillOdpracovanoHod(List<ImisDay> result, String icp) {
		result.stream().forEach(entity -> {
			BigDecimal odprac = null;
			if (DateUtils.isToday(entity.getDatum())) {
				odprac = calculateOpracovanoHod(icp);
			} else {
				odprac = vykazPraceDAO.getOdpracovanoHodVDen(icp, entity.getDatum());
			}
			entity.setOdpracovanoHod(odprac);
		});
	}

	private BigDecimal calculateOpracovanoHod(String icp) {
		List<PrichodOdchodEntity> pos = prichodOdchodDAO.getPrichodOdchodsEmployeeToday(icp);

		if ((pos == null) || (pos.size() == 0)) {
			return BigDecimal.ZERO;
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

		return new BigDecimal(inTime);
	}

}
