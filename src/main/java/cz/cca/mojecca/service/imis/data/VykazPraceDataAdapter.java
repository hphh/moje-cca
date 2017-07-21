package cz.cca.mojecca.service.imis.data;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.BeanUtils;

import cz.cca.mojecca.db.imis.model.DenVykazEntity;
import cz.cca.mojecca.db.imis.model.DenVykazFilterParameters;
import cz.cca.mojecca.service.imis.model.VykazPrace;
import cz.cca.mojecca.service.imis.model.VykazPracesFilterParameters;

public class VykazPraceDataAdapter {

	public static List<VykazPrace> toVykazPraceList(List<DenVykazEntity> vykazPraces) {
		if (vykazPraces == null) {
			return null;
		}

		return vykazPraces.stream().map(entity -> {
			VykazPrace result = new VykazPrace();
			
			result.setDatum(entity.getDatum().getTime());
			result.setHlaseni(entity.getPoznHl());
			result.setId(entity.getId());
			result.setKodUzivatele(entity.getKodpra());
			result.setKrok(entity.getPoznKrok());
			result.setMnozstviOdvedenePrace(entity.getMnozstviOdved());
			result.setOrganizace(entity.getIdFirmyZak());
			result.setPolozka(entity.getCpolzak());
			result.setPopisPrace(entity.getPoznamka());
			result.setPozice(entity.getCpozzak());
			result.setPracovnik(entity.getPrac());
			result.setUkol(entity.getPoznUkol());
			result.setZakazka(entity.getZc());
			result.setStav(entity.getStavV());

			return result;
		}).collect(Collectors.toList());

	}

	public static void mergeDenVykazAndVykazPrace(DenVykazEntity denVykazEntity, VykazPrace entity) {
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
	}
	
	public static DenVykazFilterParameters toDenVykazFilterParameters(VykazPracesFilterParameters params) {
		DenVykazFilterParameters result = new DenVykazFilterParameters();
		
		try {
			BeanUtils.copyProperties(result, params);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}

		if (params.getFromDate() != null) {
			result.setFromDate(new Date(params.getFromDate()));
		}
		if (params.getToDate() != null) {
			result.setToDate(new Date(params.getToDate()));
		}
				
		return result;
	}

}
