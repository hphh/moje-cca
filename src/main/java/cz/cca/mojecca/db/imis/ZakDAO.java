package cz.cca.mojecca.db.imis;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.jpa.impl.JPAQuery;

import cz.cca.mojecca.db.imis.model.QZakEntity;
import cz.cca.mojecca.db.imis.model.ZakEntity;
import cz.cca.mojecca.db.imis.model.ZakEntityFilterParameters;

@Stateless
public class ZakDAO {
	
	@PersistenceContext(unitName = "imis")
	private EntityManager entityManager;

	public List<ZakEntity> getZaks(ZakEntityFilterParameters params) {
		QZakEntity qZakEntity = new QZakEntity("z");
		
		JPAQuery q = new JPAQuery(entityManager);
		q.from(qZakEntity);
		
		q.where(qZakEntity.stzodb.eq("B"));
		
		if (params.getZcPattern() != null) {
			q.where(qZakEntity.zc.like(params.getZcPattern()));
		}
		
		q.orderBy(qZakEntity.zc.asc());
		
		return q.list(qZakEntity);
	}

}
