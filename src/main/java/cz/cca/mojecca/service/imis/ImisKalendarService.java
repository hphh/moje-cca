package cz.cca.mojecca.service.imis;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import cz.cca.mojecca.db.imis.KalendarDAO;
import cz.cca.mojecca.db.imis.PrichodOdchodDAO;
import cz.cca.mojecca.db.imis.model.ImisDenEntity;
import cz.cca.mojecca.service.imis.data.KalendarDataAdapter;
import cz.cca.mojecca.service.imis.model.ImisDen;
import cz.cca.mojecca.service.imis.model.ImisDensFilterParameters;
import cz.cca.mojecca.util.MnozstviHodUtils;

@RequestScoped
public class ImisKalendarService {

	@EJB
	private KalendarDAO kalendarDAO;

	@EJB
	private PrichodOdchodDAO prichodOdchodDAO;
	
	@Inject
	private DochazkaService dochazkaService;

	@Inject
	private UzivatelService uzivatelService;

	public List<ImisDen> getImisDens(ImisDensFilterParameters params) {
		String icp = uzivatelService.getIcp(params.getKodUzivatele());

		List<ImisDenEntity> imisDenEntities = kalendarDAO.getImisDens(params.getFromDate(), params.getToDate(),
				params.getKodUzivatele(), icp);

		List<ImisDen> result = KalendarDataAdapter.toImisDens(imisDenEntities);

		fillCalculatedItems(result, icp);
		
		if (params.isUnsolvedDaysOnly()) {
			result = result.stream().filter(entity -> entity.isUnsolved()).collect(Collectors.toList());
		}

		return result;
	}
	
	private boolean isUnsolvedDay(ImisDen entity) {
		return (MnozstviHodUtils.compare(entity.getVykazanoHod(), entity.getOdpracovanoHod()) != 0) ||
				("A".equals(entity.getPritomen()) && "N".equals(entity.getPotvrzeno())) ||
				("A".equals(entity.getVykazano()) && "N".equals(entity.getPotvrzeno()));
	}

	private void fillCalculatedItems(List<ImisDen> result, String icp) {
		result.stream().forEach(entity -> {
			BigDecimal odprac = dochazkaService.getOdpracovano(icp, new Date(entity.getDatum()));
			entity.setOdpracovanoHod(odprac);
			entity.setUnsolved(isUnsolvedDay(entity));
		});
	}


}
