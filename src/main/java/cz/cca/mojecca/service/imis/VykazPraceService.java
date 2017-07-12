package cz.cca.mojecca.service.imis;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import cz.cca.mojecca.db.imis.VykazPraceDAO;
import cz.cca.mojecca.service.imis.data.VykazPraceDataAdapter;
import cz.cca.mojecca.service.imis.model.VykazPrace;

@RequestScoped
public class VykazPraceService {
	
	@EJB
	private VykazPraceDAO vykazPraceDAO;
	
	public List<VykazPrace> getEmployeeVykazPraces(String kodUzivatele, Date fromDate, Date toDate) {
		return VykazPraceDataAdapter.toVykazPraceList(vykazPraceDAO.getEmployeeVykazPraces(kodUzivatele, fromDate, toDate));		
	}

}
