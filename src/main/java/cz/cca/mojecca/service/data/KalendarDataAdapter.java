package cz.cca.mojecca.service.data;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import cz.cca.mojecca.db.isza.model.CcagDenniKapacitaEntity;
import cz.cca.mojecca.db.isza.model.CcagDenniKapacitaFilterParameters;
import cz.cca.mojecca.service.imis.model.ImisDen;
import cz.cca.mojecca.service.imis.model.ImisDensFilterParameters;
import cz.cca.mojecca.service.isza.data.IszaKalendarDataAdapter;
import cz.cca.mojecca.service.model.Den;
import cz.cca.mojecca.service.model.DensFilterParameters;

public class KalendarDataAdapter {

	public static ImisDensFilterParameters toImisDensFilterParameters(DensFilterParameters params) {
		ImisDensFilterParameters result = new ImisDensFilterParameters();
		
		try {
			BeanUtils.copyProperties(result, params);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		
		return result;
	}

	public static CcagDenniKapacitaFilterParameters toCcagDenniKapacitaFilterParameters(DensFilterParameters params) {
		CcagDenniKapacitaFilterParameters result = new CcagDenniKapacitaFilterParameters();

		try {
			BeanUtils.copyProperties(result, params);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}

		return result;
	}

	public static Den toDen(ImisDen imisDen, CcagDenniKapacitaEntity denniKapacitaEntity, String kodUzivatele) {
		Den result = new Den();
		
		result.setDatum(imisDen.getDatum());
		result.setKodUzivatele(kodUzivatele);
		result.setImisDen(imisDen);
		result.setIszaDen(IszaKalendarDataAdapter.toIszaDen(denniKapacitaEntity));
		
		return result;
	}

}
