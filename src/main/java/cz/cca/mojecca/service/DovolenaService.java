package cz.cca.mojecca.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.joda.time.LocalDate;

import cz.cca.mojecca.db.imis.OsobaDAO;
import cz.cca.mojecca.db.imis.VyhodnoceniDAO;
import cz.cca.mojecca.db.imis.model.OsobaEntity;
import cz.cca.mojecca.db.imis.model.VybranoDovoleneFilterParameters;
import cz.cca.mojecca.db.imis.model.VyhodnoceniEntity;
import cz.cca.mojecca.db.isza.CcagDenniKapacitaDAO;
import cz.cca.mojecca.db.isza.model.CcagDenniKapacitaEntity;
import cz.cca.mojecca.db.isza.model.CcagDenniKapacitaFilterParameters;
import cz.cca.mojecca.service.imis.UzivatelService;
import cz.cca.mojecca.service.imis.model.Dovolena;
import cz.cca.mojecca.service.imis.model.DovolenaFilterParameters;
import cz.cca.mojecca.util.DateUtils;

@RequestScoped
public class DovolenaService {
	
	@EJB 
	private VyhodnoceniDAO vyhodnoceniDAO;
	
	@EJB
	private OsobaDAO osobaDAO;
	
	@EJB
	private CcagDenniKapacitaDAO ccagDenniKapacitaDAO;

	@Inject
	private UzivatelService uzivatelService;
	
	public Dovolena getDovolena(DovolenaFilterParameters params) {
		String icp = uzivatelService.getIcp(params.getKodUzivatele());
		
		List<VyhodnoceniEntity> vyhodnocenis = getDovoleneVyhodnocenis(params, icp);
		
		Dovolena result = new Dovolena();
		
		result.setVycerpano(getVycerpano(vyhodnocenis));
		result.setNarok(getNarok(icp));
		result.setPlanovano(getPlanovano(vyhodnocenis, params));
		
		return result;
	}

	
	private BigDecimal getPlanovano(List<VyhodnoceniEntity> vyhodnocenis, DovolenaFilterParameters dParams) {
		CcagDenniKapacitaFilterParameters cdkParams = new CcagDenniKapacitaFilterParameters();
		cdkParams.setKodUzivatele(dParams.getKodUzivatele());
		cdkParams.setDruhDne("N");
		
		Date fromDate = null;
		if (!vyhodnocenis.isEmpty()) {
			LocalDate lastDay = LocalDate.fromDateFields(vyhodnocenis.get(vyhodnocenis.size() - 1).getId().getDatum());
			fromDate = lastDay.plusDays(1).toDate();
		} else if (dParams.getYear() != null) {
			fromDate = DateUtils.firstDayOfYear(dParams.getYear().intValue());
		} else {
			fromDate = DateUtils.firstDayOfCurrentYear();
		}
		cdkParams.setFromDate(fromDate);
		
		Date toDate = null;
		if (dParams.getYear() != null) {
			toDate = DateUtils.lastDayOfYear(dParams.getYear().intValue());
		} else {
			toDate = DateUtils.lastDayOfCurrentYear();
		}
		cdkParams.setToDate(toDate);
		
		List<CcagDenniKapacitaEntity> denniKapacitas = ccagDenniKapacitaDAO.getDenniKapacitas(cdkParams);
				
		return BigDecimal.valueOf(denniKapacitas.size());
	}

	private BigDecimal getVycerpano(List<VyhodnoceniEntity> vyhodnocenis) {
		double vycerpano = vyhodnocenis.stream().mapToDouble(entity -> entity.getPocHod().doubleValue()).sum() / 8D;
		return BigDecimal.valueOf(vycerpano);
	}

	private BigDecimal getNarok(String icp) {
		OsobaEntity osobaEntity = osobaDAO.getOsoba(icp);
		if ((osobaEntity != null) && (osobaEntity.getNarokDovolene() != null)) {
			return osobaEntity.getNarokDovolene();
		} else {
			return BigDecimal.ZERO;
		}
	}

	private List<VyhodnoceniEntity> getDovoleneVyhodnocenis(DovolenaFilterParameters params, String icp) {
		VybranoDovoleneFilterParameters ps = new VybranoDovoleneFilterParameters();
		ps.setIcp(icp);
		
		Date fromDate = null;
		Date toDate = null;
		if (params.getYear() != null) {
			fromDate = DateUtils.firstDayOfYear(params.getYear().intValue());
			toDate = DateUtils.lastDayOfYear(params.getYear().intValue());
		} else {
			fromDate = DateUtils.firstDayOfCurrentYear();
			toDate = DateUtils.lastDayOfCurrentYear();
		}
		
		ps.setFromDate(fromDate);
		ps.setToDate(toDate);
		
		return vyhodnoceniDAO.getDovoleneVyhodnocenis(ps);
	}	

}
