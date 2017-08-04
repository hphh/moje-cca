package cz.cca.mojecca.service.isza.data;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.BeanUtils;

import cz.cca.mojecca.db.isza.model.CcagHlaseni;
import cz.cca.mojecca.db.isza.model.CcagHlaseniFilterParameters;
import cz.cca.mojecca.service.isza.model.Hlaseni;
import cz.cca.mojecca.service.isza.model.HlaseniFilterParameters;

public class HlaseniDataAdapter {

	public static CcagHlaseniFilterParameters toCcagHlaseniFilterParameters(HlaseniFilterParameters params) {
		CcagHlaseniFilterParameters result = new CcagHlaseniFilterParameters();
		try {
			BeanUtils.copyProperties(result, params);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	public static List<Hlaseni> toHlasenis(List<CcagHlaseni> us) {
		if (us == null) {
			return null;
		}
		
		List<Hlaseni> result = us.stream().map(cu -> {
			Hlaseni u = new Hlaseni();
			try {
				BeanUtils.copyProperties(u, cu);
			} catch (IllegalAccessException | InvocationTargetException e) {
				throw new RuntimeException(e);
			}
			return u;
		}).collect(Collectors.toList());

		return result;
	}

}
