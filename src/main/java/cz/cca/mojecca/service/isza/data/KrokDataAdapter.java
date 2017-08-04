package cz.cca.mojecca.service.isza.data;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.BeanUtils;

import cz.cca.mojecca.db.isza.model.CcagKrokProjektu;
import cz.cca.mojecca.db.isza.model.CcagKrokProjektuFilterParameters;
import cz.cca.mojecca.service.isza.model.Krok;
import cz.cca.mojecca.service.isza.model.KrokFilterParameters;

public class KrokDataAdapter {

	public static CcagKrokProjektuFilterParameters toCcagKrokProjektuFilterParameters(KrokFilterParameters params) {
		CcagKrokProjektuFilterParameters result = new CcagKrokProjektuFilterParameters();
		try {
			BeanUtils.copyProperties(result, params);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	public static List<Krok> toKroks(List<CcagKrokProjektu> us) {
		if (us == null) {
			return null;
		}
		
		List<Krok> result = us.stream().map(cu -> {
			Krok u = new Krok();
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
