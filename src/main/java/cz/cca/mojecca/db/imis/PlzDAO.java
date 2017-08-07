package cz.cca.mojecca.db.imis;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.jpa.impl.JPAQuery;

import cz.cca.mojecca.db.imis.model.PlzEntity;
import cz.cca.mojecca.db.imis.model.PlzFilterPrameters;
import cz.cca.mojecca.db.imis.model.QPlzEntity;

@Stateless
public class PlzDAO {

	@PersistenceContext(unitName = "imis")
	private EntityManager entityManager;
	
	public List<PlzEntity> getPlzs(PlzFilterPrameters params) {
		QPlzEntity e = new QPlzEntity("e");
		
		JPAQuery q = new JPAQuery(entityManager);
		q.from(e);
		
		if (params.getZc() != null) {
			q.where(e.id.zc.eq(params.getZc()));
		}
		if (params.getCpolzakPattern() != null) {
			q.where(e.id.cpolzak.like(params.getCpolzakPattern()));
		}
		
		q.orderBy(e.id.cpolzak.asc());
		
		return q.list(e);
	}

}
