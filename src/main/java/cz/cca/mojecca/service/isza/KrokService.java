package cz.cca.mojecca.service.isza;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import cz.cca.mojecca.db.isza.CcagKrokProjektuDAO;
import cz.cca.mojecca.db.isza.model.CcagKrokProjektu;
import cz.cca.mojecca.service.isza.data.KrokDataAdapter;
import cz.cca.mojecca.service.isza.model.Krok;
import cz.cca.mojecca.service.isza.model.KrokFilterParameters;

@RequestScoped
public class KrokService {
	
	@EJB
	private CcagKrokProjektuDAO ccagKrokProjektuDAO;
	
	public List<Krok> getKroks(KrokFilterParameters params) {
		List<CcagKrokProjektu> ks = ccagKrokProjektuDAO.getKroks(KrokDataAdapter.toCcagKrokProjektuFilterParameters(params));
		List<Krok> result = KrokDataAdapter.toKroks(ks);
		return result;
	}

}
