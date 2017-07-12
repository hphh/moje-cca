package cz.cca.mojecca.service.imis.data;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.BeanUtils;

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

}
