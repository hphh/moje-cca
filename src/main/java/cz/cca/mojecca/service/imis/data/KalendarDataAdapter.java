package cz.cca.mojecca.service.imis.data;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import cz.cca.mojecca.db.imis.model.ImisDenEntity;
import cz.cca.mojecca.service.imis.model.ImisDen;

public class KalendarDataAdapter {

	public static List<ImisDen> toImisDens(List<ImisDenEntity> imisDenEntities) {
		if (imisDenEntities == null) {
			return null;
		}
		
		List<ImisDen> result = new ArrayList<ImisDen>();
		
		imisDenEntities.stream().forEach(entity -> {
			result.add(toImisDen(entity));
		});
		
		return result;
	}

	private static ImisDen toImisDen(ImisDenEntity entity) {
		ImisDen result = new ImisDen();
		try {
			BeanUtils.copyProperties(result, entity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		
		if (result.getVykazanoHod() == null) {
			result.setVykazanoHod(new BigDecimal(0));
		}
		if (result.getOdpracovanoHod() == null) {
			result.setOdpracovanoHod(new BigDecimal(0));
		}
		
		return result;
	}

}
