package cz.cca.mojecca.service.imis.data;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.BeanUtils;

import cz.cca.mojecca.db.imis.model.DenVykazEntity;
import cz.cca.mojecca.db.imis.model.DenVykazFilterParameters;
import cz.cca.mojecca.db.imis.model.ZakEntity;
import cz.cca.mojecca.db.imis.model.ZakEntityFilterParameters;
import cz.cca.mojecca.service.imis.model.VykazPrace;
import cz.cca.mojecca.service.imis.model.VykazPracesFilterParameters;
import cz.cca.mojecca.service.imis.model.Zakazka;
import cz.cca.mojecca.service.imis.model.ZakazkaFilterParameters;

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


	public static ZakEntityFilterParameters toZakEntityFilterParameters(ZakazkaFilterParameters params) {
		if (params == null) {
			return null;
		}
		
		ZakEntityFilterParameters result = new ZakEntityFilterParameters();
		
		result.setZcPattern(params.getZakazkaPattern());
		
		return result;
	}


	public static List<Zakazka> toZakazkaList(List<ZakEntity> zaks) {
		if (zaks == null) {
			return null;
		}
		
		List<Zakazka> result = zaks.stream().map(entity -> toZakazka(entity)).collect(Collectors.toList());
		
		return result;
	}


	private static Zakazka toZakazka(ZakEntity entity) {
		Zakazka result = new Zakazka();
		
		result.setGarant(entity.getGarant());
		result.setZakazka(entity.getZc());
		result.setPopis(entity.getNazzak());
		
		return result;
	}

}
