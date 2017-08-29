package cz.cca.mojecca.service.data;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.joda.time.LocalDate;

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
		
		if (params.isUnsolvedDaysOnly()) {
			if (result.getFromDate() == null) {
				result.setFromDate(calcUnsolvedDaysFromDate());
			}
			if (result.getToDate() == null) {
				result.setToDate(calcUnsolvedDaysToDate());
			}
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
		
		if (params.isUnsolvedDaysOnly()) {
			if (result.getFromDate() == null) {
				result.setFromDate(calcUnsolvedDaysFromDate());
			}
			if (result.getToDate() == null) {
				result.setToDate(calcUnsolvedDaysToDate());
			}
		}		

		return result;
	}
	
	private static Date calcUnsolvedDaysFromDate() {
		return new LocalDate().minusDays(100).toDate();
	}

	private static Date calcUnsolvedDaysToDate() {
		return new LocalDate().plusDays(100).toDate();
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
