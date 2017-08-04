package cz.cca.mojecca.service.imis.data;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import cz.cca.mojecca.db.imis.model.ZamestnanecEntity;
import cz.cca.mojecca.service.imis.model.Zamestnanec;

public class ZamestnanecDataAdapter {

	public static Zamestnanec toZamestnanec(ZamestnanecEntity entity) {
		if (entity == null) {
			return null;
		}
		
		Zamestnanec result = new Zamestnanec();
		
		try {
			BeanUtils.copyProperties(result, entity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		
		return result;
	}

}
