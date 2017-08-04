package cz.cca.mojecca.db.imis;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.jpa.impl.JPAQuery;

import cz.cca.mojecca.db.imis.model.PvtEntity;
import cz.cca.mojecca.db.imis.model.QPvtEntity;

@Stateless
public class PvtDAO {

	@PersistenceContext(unitName = "imis")
	private EntityManager entityManager;

	public PvtEntity getPvt(String stredisko, String kodUzivatele) {
		QPvtEntity qPvtEntity = new QPvtEntity("p");
		
		JPAQuery q = new JPAQuery(entityManager);
		q.from(qPvtEntity);
		q.where(qPvtEntity.id.stred.eq(stredisko));
		q.where(qPvtEntity.vyrMisto.eq(kodUzivatele));
		q.where(qPvtEntity.znzrus.eq("N"));
		
		return q.singleResult(qPvtEntity);
	}
}
