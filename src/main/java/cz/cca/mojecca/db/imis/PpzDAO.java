package cz.cca.mojecca.db.imis;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.jpa.impl.JPAQuery;

import cz.cca.mojecca.db.imis.model.PpzEntity;
import cz.cca.mojecca.db.imis.model.PpzFilterPrameters;
import cz.cca.mojecca.db.imis.model.QPpzEntity;

@Stateless
public class PpzDAO {

	@PersistenceContext(unitName = "imis")
	private EntityManager entityManager;
	
	public List<PpzEntity> getPpzs(PpzFilterPrameters params) {
		QPpzEntity e = new QPpzEntity("e");
		
		JPAQuery q = new JPAQuery(entityManager);
		q.from(e);
		
		if (params.getZc() != null) {
			q.where(e.id.zc.eq(params.getZc()));
		}
		if (params.getCpolzak() != null) {
			q.where(e.id.cpolzak.eq(params.getCpolzak()));
		}
		if (params.getCpozzakPattern() != null) {
			q.where(e.id.cpozzak.like(params.getCpozzakPattern()));
		}
		
		q.orderBy(e.id.cpozzak.asc());
		
		return q.list(e);
	}
	
}
