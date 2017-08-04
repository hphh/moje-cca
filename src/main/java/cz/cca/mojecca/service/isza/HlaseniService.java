package cz.cca.mojecca.service.isza;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import cz.cca.mojecca.db.isza.CcagHlaseniDAO;
import cz.cca.mojecca.db.isza.model.CcagHlaseni;
import cz.cca.mojecca.service.isza.data.HlaseniDataAdapter;
import cz.cca.mojecca.service.isza.model.Hlaseni;
import cz.cca.mojecca.service.isza.model.HlaseniFilterParameters;

@RequestScoped
public class HlaseniService {
	
	@EJB
	private CcagHlaseniDAO ccagHlaseniDAO;
	
	public List<Hlaseni> getHlasenis(HlaseniFilterParameters params) {
		List<CcagHlaseni> hs = ccagHlaseniDAO.getHlasenis(HlaseniDataAdapter.toCcagHlaseniFilterParameters(params));
		List<Hlaseni> result = HlaseniDataAdapter.toHlasenis(hs);
		return result;
	}

}
