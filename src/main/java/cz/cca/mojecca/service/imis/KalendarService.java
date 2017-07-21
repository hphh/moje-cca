package cz.cca.mojecca.service.imis;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import cz.cca.mojecca.db.imis.KalendarDAO;
import cz.cca.mojecca.db.imis.VykazPraceDAO;
import cz.cca.mojecca.db.imis.model.ImisDenEntity;
import cz.cca.mojecca.service.imis.data.KalendarDataAdapter;
import cz.cca.mojecca.service.imis.model.ImisDay;
import cz.cca.mojecca.service.imis.model.ImisDaysFilterParameters;

@RequestScoped
public class KalendarService {
	
	@EJB
	private KalendarDAO kalendarDAO;
	
	@EJB
	private VykazPraceDAO vykazPraceDAO;
	
	@Inject
	private UzivatelService uzivatelService;
	
	public List<ImisDay> getImisDays(ImisDaysFilterParameters params) {
		String icp = uzivatelService.getIcp(params.getKodUzivatele());
		
		List<ImisDenEntity> imisDenEntities = kalendarDAO.getImisDens(params.getFromDate(), params.getToDate(), params.getKodUzivatele(), icp);
		
		List<ImisDay> result = KalendarDataAdapter.toImisDays(imisDenEntities);
		
		result.stream().forEach(entity -> {
			entity.setOdpracovanoHod(vykazPraceDAO.getOdpracovanoHodVDen(icp, entity.getDatum()));
		});
		
		return result;
	}

}
