package cz.cca.mojecca.service.imis;

import java.math.BigDecimal;
import java.util.Date;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.joda.time.LocalDate;

import cz.cca.mojecca.db.imis.OsobaDAO;
import cz.cca.mojecca.db.imis.VyhodnoceniDAO;
import cz.cca.mojecca.db.imis.model.OsobaEntity;
import cz.cca.mojecca.db.imis.model.VybranoDovoleneFilterParameters;
import cz.cca.mojecca.service.imis.model.Dovolena;
import cz.cca.mojecca.service.imis.model.DovolenaFilterParameters;

@RequestScoped
public class DovolenaService {
	
	@EJB 
	private VyhodnoceniDAO vyhodnoceniDAO;
	
	@EJB
	private OsobaDAO osobaDAO;

	@Inject
	private UzivatelService uzivatelService;
	
	public Dovolena getDovolena(DovolenaFilterParameters params) {
		String icp = uzivatelService.getIcp(params.getKodUzivatele());
		
		VybranoDovoleneFilterParameters ps = new VybranoDovoleneFilterParameters();
		ps.setIcp(icp);
		
		Date fromDate = null;
		Date toDate = null;
		if (params.getYear() != null) {
			fromDate = new LocalDate().withYear(params.getYear().intValue()).withMonthOfYear(1).withDayOfMonth(1).toDate();
			toDate = new LocalDate().withYear(params.getYear().intValue()).withMonthOfYear(12).withDayOfMonth(31).toDate();
		} else {
			fromDate = new LocalDate().withMonthOfYear(1).withDayOfMonth(1).toDate();
			toDate = new LocalDate().withMonthOfYear(12).withDayOfMonth(31).toDate();
		}
		
		ps.setFromDate(fromDate);
		ps.setToDate(toDate);
		
		Dovolena result = new Dovolena();
		result.setVycerpano(vyhodnoceniDAO.getVybranoDovoleneHod(ps).divide(new BigDecimal(8)));
		
		OsobaEntity osobaEntity = osobaDAO.getOsoba(icp);
		if ((osobaEntity != null) && (osobaEntity.getNarokDovolene() != null)) {
			result.setNarok(osobaEntity.getNarokDovolene());
		} else {
			result.setNarok(BigDecimal.ZERO);
		}
		
		return result;
	}	

}
