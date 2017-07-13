package cz.cca.mojecca.service.imis.data;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.BeanUtils;

import cz.cca.mojecca.db.imis.model.DenVykazEntity;
import cz.cca.mojecca.db.imis.model.VykazPraceEntity;
import cz.cca.mojecca.service.imis.model.VykazPrace;

public class VykazPraceDataAdapter {

	public static List<VykazPrace> toVykazPraceList(List<VykazPraceEntity> employeeVykazPraces) {
		if (employeeVykazPraces == null) {
			return null;
		}

		return employeeVykazPraces.stream().map(entity -> {
			VykazPrace result = new VykazPrace();
			try {
				BeanUtils.copyProperties(result, entity);
			} catch (IllegalAccessException | InvocationTargetException e) {
				throw new RuntimeException(e);
			}
			return result;
		}).collect(Collectors.toList());

	}

	public static List<DenVykazEntity> toDenVykazEntityList(List<VykazPrace> vykazPraces) {
		if (vykazPraces == null) {
			return null;
		}
		
		
		return vykazPraces.stream().map(entity -> {
			DenVykazEntity result = new DenVykazEntity();
			
			

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
	}

}
