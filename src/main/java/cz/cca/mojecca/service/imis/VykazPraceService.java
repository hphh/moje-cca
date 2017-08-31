package cz.cca.mojecca.service.imis;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.apache.commons.beanutils.BeanUtils;
import org.joda.time.Days;
import org.joda.time.LocalDate;

import cz.cca.mojecca.db.imis.PlzDAO;
import cz.cca.mojecca.db.imis.PpzDAO;
import cz.cca.mojecca.db.imis.VykazPraceDAO;
import cz.cca.mojecca.db.imis.ZakDAO;
import cz.cca.mojecca.db.imis.model.DenVykazEntity;
import cz.cca.mojecca.db.imis.model.DenVykazFilterParameters;
import cz.cca.mojecca.service.imis.data.VykazPraceDataAdapter;
import cz.cca.mojecca.service.imis.model.ConfirmVykazPracesParameters;
import cz.cca.mojecca.service.imis.model.ImisDen;
import cz.cca.mojecca.service.imis.model.ImisDensFilterParameters;
import cz.cca.mojecca.service.imis.model.MoveDayVykazPracesParameters;
import cz.cca.mojecca.service.imis.model.SplittingVykazPrace;
import cz.cca.mojecca.service.imis.model.VykazPrace;
import cz.cca.mojecca.service.imis.model.VykazPracesFilterParameters;
import cz.cca.mojecca.service.imis.model.Zakazka;
import cz.cca.mojecca.service.imis.model.ZakazkaFilterParameters;
import cz.cca.mojecca.service.imis.model.ZakazkaPolozka;
import cz.cca.mojecca.service.imis.model.ZakazkaPolozkasFilterParameters;
import cz.cca.mojecca.service.imis.model.ZakazkaPozice;
import cz.cca.mojecca.service.imis.model.ZakazkaPozicesFilterParameters;

@RequestScoped
public class VykazPraceService {
	
	@EJB
	private VykazPraceDAO vykazPraceDAO;
	
	@Inject
	private UzivatelService uzivatelService;
	
	@EJB
	private ZakDAO zakDAO;
	
	@EJB
	private PlzDAO plzDAO;
	
	@EJB
	private PpzDAO ppzDAO;
	
	@Inject 
	private ImisKalendarService imisKalendarService;
	
	public List<VykazPrace> getEmployeeVykazPraces(VykazPracesFilterParameters vykazPracesFilterParameters) {
		List<DenVykazEntity> denVykazs = vykazPraceDAO.getVykazPraces(
				VykazPraceDataAdapter.toDenVykazFilterParameters(vykazPracesFilterParameters));
		return VykazPraceDataAdapter.toVykazPraceList(denVykazs);		
	}

	public void saveOrUpdateVykazPraces(List<VykazPrace> vykazPraces) {
		if (vykazPraces == null) {
			return;
		}
		
		List<DenVykazEntity> denVykazs = vykazPraces.stream().map(entity -> {
			DenVykazEntity denVykazEntity = null;
			if (entity.getId() != null) {
				denVykazEntity = vykazPraceDAO.getDenVykaz(entity.getId());
			} else {
				denVykazEntity = new DenVykazEntity();
			}
			
			mergeDenVykazAndVykazPrace(denVykazEntity, entity);
			
			return denVykazEntity;
		}).collect(Collectors.toList());
		
		vykazPraceDAO.saveOrUpdateDenVykazs(denVykazs);
	}
	
	private void mergeDenVykazAndVykazPrace(DenVykazEntity denVykazEntity, VykazPrace entity) {
		denVykazEntity.setDatum(new Date(entity.getDatum()));
		denVykazEntity.setPoznHl(entity.getHlaseni());
		denVykazEntity.setKodpra(entity.getKodUzivatele());
		denVykazEntity.setPoznKrok(entity.getKrok());
		denVykazEntity.setMnozstviOdved(entity.getMnozstviOdvedenePrace());
		denVykazEntity.setIdFirmyZak(entity.getOrganizace());
		denVykazEntity.setCpolzak(entity.getPolozka());
		denVykazEntity.setPoznamka(entity.getPopisPrace());
		denVykazEntity.setCpozzak(entity.getPozice());
		denVykazEntity.setPrac(entity.getPracovnik());
		denVykazEntity.setPoznUkol(entity.getUkol());
		denVykazEntity.setZc(entity.getZakazka());	
		denVykazEntity.setStavV(entity.getStav());
		
		denVykazEntity.setKodpraVykaz(entity.getKodUzivatele());
		denVykazEntity.setCisloVykazu(toCisloVykazu(denVykazEntity.getDatum()));
		
		if (denVykazEntity.getStred() == null) {
			denVykazEntity.setStred(
					uzivatelService.getZamestnanec(entity.getKodUzivatele()).getStred());
		}
		
		if (denVykazEntity.getPrac() == null) {
			denVykazEntity.setPrac(uzivatelService.getPrac(entity.getKodUzivatele()));
		}
		
		if (denVykazEntity.getVyrMisto() == null) {
			denVykazEntity.setVyrMisto(entity.getKodUzivatele());
		}
		
		if (denVykazEntity.getJednotka() == null) {
			denVykazEntity.setJednotka("H");
		}
		
		if (denVykazEntity.getOdpracoval() == null) {
			denVykazEntity.setOdpracoval(uzivatelService.getIcp(entity.getKodUzivatele()));
		}
		
		if (denVykazEntity.getStavV() == null) {
			denVykazEntity.setStavV("V");
		}
		
		if (denVykazEntity.getOscislo() == null) {
			denVykazEntity.setOscislo(denVykazEntity.getOdpracoval());
		}
	}
	

	private static BigDecimal toCisloVykazu(Date datum) {
		Calendar c = Calendar.getInstance();
		c.setTime(datum);
		return BigDecimal.valueOf(c.get(Calendar.MONTH) + 1 + c.get(Calendar.DAY_OF_MONTH) / 100d);
	}	

	public void splitVykazPrace(SplittingVykazPrace splittingVykazPrace) {
		VykazPrace oldVykazPrace = splittingVykazPrace.getOldVykazPrace();
		VykazPrace newVykazPrace = splittingVykazPrace.getNewVykazPrace();
		
		DenVykazEntity oldDenVykazEntity = vykazPraceDAO.getDenVykaz(oldVykazPrace.getId());
		
		DenVykazEntity newDenVykazEntity = new DenVykazEntity();
		try {
			BeanUtils.copyProperties(newDenVykazEntity, oldDenVykazEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		newDenVykazEntity.setId(null);
		
		mergeDenVykazAndVykazPrace(oldDenVykazEntity, oldVykazPrace);
		mergeDenVykazAndVykazPrace(newDenVykazEntity, newVykazPrace);
		
		vykazPraceDAO.updateDenVykaz(oldDenVykazEntity);
		vykazPraceDAO.insertDenVykaz(newDenVykazEntity);
	}
	
	public void confirmVykazPraces(ConfirmVykazPracesParameters params) {
		DenVykazFilterParameters pars = new DenVykazFilterParameters();
		pars.setFromDate(new Date(params.getFromDate()));
		pars.setToDate(new Date(params.getToDate()));
		pars.setKodUzivatele(params.getKodUzivatele());
		
		List<DenVykazEntity> denVykazEntities = vykazPraceDAO.getVykazPraces(pars);
		
		if (denVykazEntities == null) {
			return;
		}
		
		denVykazEntities.forEach(entity -> {
			if (!"V".equals(entity.getStavV())) {
				return;
			}
			entity.setStavV("P");
		});
		
		vykazPraceDAO.saveOrUpdateDenVykazs(denVykazEntities);			
	}
	
	public List<Zakazka> getZakazkas(ZakazkaFilterParameters params) {
		return VykazPraceDataAdapter.toZakazkaList(zakDAO.getZaks(VykazPraceDataAdapter.toZakEntityFilterParameters(params)));
	}
	
	public List<ZakazkaPolozka> getZakazkaPolozkas(ZakazkaPolozkasFilterParameters params) {
		return VykazPraceDataAdapter.toZakazkaPolozkaList(plzDAO.getPlzs(VykazPraceDataAdapter.toPlzFilterParameters(params)));
	}
	
	public List<ZakazkaPozice> getZakazkaPozices(ZakazkaPozicesFilterParameters params) {
		return VykazPraceDataAdapter.toZakazkaPoziceList(ppzDAO.getPpzs(VykazPraceDataAdapter.toPpzFilterParameters(params)));
	}
	
	public void moveDayVykazPraces(MoveDayVykazPracesParameters params) {
		DenVykazFilterParameters denVykazParams = new DenVykazFilterParameters();
		denVykazParams.setKodUzivatele(params.getKodUzivatele());
		denVykazParams.setFromDate(new Date(params.getOldDate()));
		if (!params.isAllNextDays()) {
			denVykazParams.setToDate(denVykazParams.getFromDate());
		}
		List<DenVykazEntity> vykazs = vykazPraceDAO.getVykazPraces(denVykazParams);
		
		if ((vykazs == null) || (vykazs.isEmpty())) {
			return;
		}
		
		int shift = calculateShift(params.getOldDate(), params.getNewDate());
		
		if (shift == 0) {
			return;
		}

		vykazs.stream().forEach(entity -> {
			Calendar c = Calendar.getInstance();
			c.setTime(entity.getDatum());
			c.add(Calendar.DATE, shift);
			entity.setDatum(c.getTime());
		});
		
		
		vykazPraceDAO.saveOrUpdateDenVykazs(vykazs);
	}

	private int calculateShift(long oldDate, long newDate) {
		Calendar oldC = Calendar.getInstance();
		oldC.setTimeInMillis(oldDate);
		
		Calendar newC = Calendar.getInstance();
		newC.setTimeInMillis(newDate);
		
		LocalDate oldD = new LocalDate(oldDate);
		LocalDate newD = new LocalDate(newDate);
		
		return Days.daysBetween(oldD, newD).getDays();
	}

	public void deleteVykazPraces(List<VykazPrace> vykazPraces) {
		List<Long> ids = vykazPraces.stream().map(VykazPrace::getId).collect(Collectors.toList());
		vykazPraceDAO.deleteDenVykazs(ids);
	}

	public BigDecimal napracovanoHodin(String kodUzivatele) {
		ImisDensFilterParameters params = new ImisDensFilterParameters();
		params.setKodUzivatele(kodUzivatele);
		params.setFromDate(new LocalDate().toDate());
		params.setToDate(new LocalDate().plusDays(100).toDate());
		List<ImisDen> dens = imisKalendarService.getImisDens(params);
		
		if (dens.isEmpty()) {
			return BigDecimal.ZERO;
		}
		
		double result = dens.stream()
				.map(entity -> entity.getVykazanoHod().subtract(entity.getOdpracovanoHod()))
				.mapToDouble(BigDecimal::doubleValue)
				.sum();
		
		return BigDecimal.valueOf(result);
	}

}
