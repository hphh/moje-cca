package cz.cca.mojecca.service.imis.data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.joda.time.LocalDate;

import cz.cca.mojecca.db.imis.model.ZamMesEntity;
import cz.cca.mojecca.db.imis.model.ZamMesFilterParameters;
import cz.cca.mojecca.service.imis.model.EmployeeNahradniVolno;
import cz.cca.mojecca.service.imis.model.EmployeeNahradniVolnoFilterParameters;
import cz.cca.mojecca.service.imis.model.NahradniVolno;
import cz.cca.mojecca.service.imis.model.NahradniVolnoSumVybrat;

public class DochazkaDataAdapter {

	public static ZamMesFilterParameters toZamMesFilterParameters(EmployeeNahradniVolnoFilterParameters params, String icp) {
		ZamMesFilterParameters result = new ZamMesFilterParameters();
		result.setIcp(icp);
		
		Date fromObdobi = null;
		if (params.getFromObdobi() != null) {
			fromObdobi = new LocalDate(params.getFromObdobi()).toDate();
		} else {
			fromObdobi = new LocalDate().withDayOfMonth(1).minusMonths(2).toDate();
		}
		
		result.setFromObdobi(fromObdobi);
		
		return result;
	}

	public static EmployeeNahradniVolno toEmployeeNahradniVolno(List<ZamMesEntity> zamMess, NahradniVolnoSumVybrat sumVybrat) {
		EmployeeNahradniVolno result = new EmployeeNahradniVolno();
		
		result.setNahradniVolnos(toNahradniVolnoList(zamMess));
		result.setSumVybrat(sumVybrat);
		
		return result;
	}

	private static List<NahradniVolno> toNahradniVolnoList(List<ZamMesEntity> zamMess) {
		if (zamMess == null) {
			return null;
		}
		
		return zamMess.stream().map(entity -> toNahradniVolno(entity)).collect(Collectors.toList());
	}

	private static NahradniVolno toNahradniVolno(ZamMesEntity entity) {
		NahradniVolno result = new NahradniVolno();
		result.setMnozstvi(entity.getNahrVolno());
		result.setObdobi(entity.getId().getObdobi().getTime());
		return result;
	}

}
