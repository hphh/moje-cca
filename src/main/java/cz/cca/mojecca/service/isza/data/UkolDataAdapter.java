package cz.cca.mojecca.service.isza.data;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.BeanUtils;

import cz.cca.mojecca.db.isza.model.CcagUkol;
import cz.cca.mojecca.db.isza.model.CcagUkolFilterParameters;
import cz.cca.mojecca.service.isza.model.Ukol;
import cz.cca.mojecca.service.isza.model.UkolFilterParameters;

public class UkolDataAdapter {

	public static CcagUkolFilterParameters toCcagUkolFilterParameters(UkolFilterParameters params) {
		CcagUkolFilterParameters result = new CcagUkolFilterParameters();
		try {
			BeanUtils.copyProperties(result, params);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	public static List<Ukol> toUkols(List<CcagUkol> us) {
		if (us == null) {
			return null;
		}
		
		List<Ukol> result = us.stream().map(cu -> {
			Ukol u = new Ukol();
			try {
				BeanUtils.copyProperties(u, cu);
			} catch (IllegalAccessException | InvocationTargetException e) {
				throw new RuntimeException(e);
			}
			if (u.getPracnostPlan() != null) {
				u.setPracnostPlan(u.getPracnostPlan().multiply(BigDecimal.valueOf(8)));
			}
			return u;
		}).collect(Collectors.toList());

		return result;
	}

}
