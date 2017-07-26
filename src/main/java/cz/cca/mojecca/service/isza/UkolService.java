package cz.cca.mojecca.service.isza;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import cz.cca.mojecca.db.isza.CcagUkolDAO;
import cz.cca.mojecca.db.isza.model.CcagUkol;
import cz.cca.mojecca.service.isza.data.UkolDataAdapter;
import cz.cca.mojecca.service.isza.model.Ukol;
import cz.cca.mojecca.service.isza.model.UkolFilterParameters;

@RequestScoped
public class UkolService {
	
	@EJB
	private CcagUkolDAO ccagUkolDAO;
	
	public List<Ukol> getUkols(UkolFilterParameters params) {
		List<CcagUkol> us = ccagUkolDAO.getUkols(UkolDataAdapter.toCcagUkolFilterParameters(params));
		List<Ukol> result = UkolDataAdapter.toUkols(us);
		return result;
	}

}
