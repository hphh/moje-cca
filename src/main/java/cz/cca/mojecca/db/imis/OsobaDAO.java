package cz.cca.mojecca.db.imis;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cz.cca.mojecca.db.imis.model.OsobaEntity;

@Stateless
public class OsobaDAO {
	
	@PersistenceContext(unitName = "imis")
	private EntityManager entityManager;
	
	public OsobaEntity getOsoba(String icp) {
		return entityManager.find(OsobaEntity.class, icp);
	}

}
