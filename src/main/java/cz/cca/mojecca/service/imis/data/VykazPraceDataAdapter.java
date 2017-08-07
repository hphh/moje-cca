package cz.cca.mojecca.service.imis.data;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.BeanUtils;

import cz.cca.mojecca.db.imis.model.DenVykazEntity;
import cz.cca.mojecca.db.imis.model.DenVykazFilterParameters;
import cz.cca.mojecca.db.imis.model.PlzEntity;
import cz.cca.mojecca.db.imis.model.PlzFilterPrameters;
import cz.cca.mojecca.db.imis.model.PpzEntity;
import cz.cca.mojecca.db.imis.model.PpzFilterPrameters;
import cz.cca.mojecca.db.imis.model.ZakEntity;
import cz.cca.mojecca.db.imis.model.ZakEntityFilterParameters;
import cz.cca.mojecca.service.imis.model.VykazPrace;
import cz.cca.mojecca.service.imis.model.VykazPracesFilterParameters;
import cz.cca.mojecca.service.imis.model.Zakazka;
import cz.cca.mojecca.service.imis.model.ZakazkaFilterParameters;
import cz.cca.mojecca.service.imis.model.ZakazkaPolozka;
import cz.cca.mojecca.service.imis.model.ZakazkaPolozkasFilterParameters;
import cz.cca.mojecca.service.imis.model.ZakazkaPozice;
import cz.cca.mojecca.service.imis.model.ZakazkaPozicesFilterParameters;

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


	public static List<ZakazkaPolozka> toZakazkaPolozkaList(List<PlzEntity> plzs) {
		if (plzs == null) {
			return null;
		}
		
		return plzs.stream().map(e -> toZakazkaPolozka(e)).collect(Collectors.toList());
	}


	private static ZakazkaPolozka toZakazkaPolozka(PlzEntity e) {
		ZakazkaPolozka result = new ZakazkaPolozka();
		result.setPolozka(e.getId().getCpolzak());
		result.setPopis(e.getNpolzak());
		return result;
	}


	public static List<ZakazkaPozice> toZakazkaPoziceList(List<PpzEntity> ppzs) {
		if (ppzs == null) {
			return null;
		}
		
		return ppzs.stream().map(e -> toZakazkaPozice(e)).collect(Collectors.toList());
	}


	private static ZakazkaPozice toZakazkaPozice(PpzEntity e) {
		ZakazkaPozice result = new ZakazkaPozice();
		result.setPozice(e.getId().getCpozzak());
		result.setPopis(e.getNazev());
		return result;
	}


	public static PlzFilterPrameters toPlzFilterParameters(ZakazkaPolozkasFilterParameters params) {
		PlzFilterPrameters result = new PlzFilterPrameters();
		result.setCpolzakPattern(params.getPolozkaPattern());
		result.setZc(params.getZakazka());
		return result;
	}


	public static PpzFilterPrameters toPpzFilterParameters(ZakazkaPozicesFilterParameters params) {
		PpzFilterPrameters result = new PpzFilterPrameters();
		result.setCpolzak(params.getPolozka());
		result.setCpozzakPattern(params.getPozicePattern());
		result.setZc(params.getZakazka());
		return result;
	}

}
