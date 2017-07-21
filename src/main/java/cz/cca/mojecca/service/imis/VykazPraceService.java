package cz.cca.mojecca.service.imis;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.apache.commons.beanutils.BeanUtils;

import cz.cca.mojecca.db.imis.VykazPraceDAO;
import cz.cca.mojecca.db.imis.model.DenVykazEntity;
import cz.cca.mojecca.service.imis.data.VykazPraceDataAdapter;
import cz.cca.mojecca.service.imis.model.SplittingVykazPrace;
import cz.cca.mojecca.service.imis.model.VykazPrace;

@RequestScoped
public class VykazPraceService {
	
	@EJB
	private VykazPraceDAO vykazPraceDAO;
	
	@Inject
	private UzivatelService uzivatelService;
	
	public List<VykazPrace> getEmployeeVykazPraces(String kodUzivatele, Date fromDate, Date toDate) {
		String icp = uzivatelService.getIcp(kodUzivatele);
		return VykazPraceDataAdapter.toVykazPraceList(vykazPraceDAO.getEmployeeVykazPraces(kodUzivatele, icp, fromDate, toDate));		
	}

	public void updateVykazPraces(List<VykazPrace> vykazPraces) {
		if (vykazPraces == null) {
			return;
		}
		
		List<DenVykazEntity> denVykazs = vykazPraces.stream().map(entity -> {
			DenVykazEntity denVykazEntity = vykazPraceDAO.getDenVykaz(entity.getId());
			VykazPraceDataAdapter.mergeDenVykazAndVykazPrace(denVykazEntity, entity);
			return denVykazEntity;
		}).collect(Collectors.toList());
		
		vykazPraceDAO.updateDenVykazs(denVykazs);
	}
	
	public void splitVykazPrace(SplittingVykazPrace splittingVykazPrace) {
		VykazPrace oldVykazPrace = splittingVykazPrace.getOldVykazPrace();
		VykazPrace newVykazPrace = splittingVykazPrace.getNewVykazPrace();
		
		DenVykazEntity oldDenVykazEntity = vykazPraceDAO.getDenVykaz(oldVykazPrace.getId());
		
		DenVykazEntity newDenVykazEntity = new DenVykazEntity();
		try {
			BeanUtils.copyProperties(newDenVykazEntity, oldDenVykazEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		newDenVykazEntity.setId(null);
		
		VykazPraceDataAdapter.mergeDenVykazAndVykazPrace(oldDenVykazEntity, oldVykazPrace);
		VykazPraceDataAdapter.mergeDenVykazAndVykazPrace(newDenVykazEntity, newVykazPrace);
		
		vykazPraceDAO.updateDenVykaz(oldDenVykazEntity);
		vykazPraceDAO.insertDenVykaz(newDenVykazEntity);
	}

}
