package cz.cca.mojecca.service.isza.data;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import cz.cca.mojecca.db.isza.model.CcagDenniKapacitaEntity;
import cz.cca.mojecca.service.isza.model.IszaDen;

public class IszaKalendarDataAdapter {

	public static IszaDen toIszaDen(CcagDenniKapacitaEntity denniKapacitaEntity) {
		IszaDen result = new IszaDen();
		
		try {
			BeanUtils.copyProperties(result, denniKapacitaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		
		return result;
	}

}
