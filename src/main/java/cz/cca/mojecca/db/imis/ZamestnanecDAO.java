package cz.cca.mojecca.db.imis;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.jpa.impl.JPAQuery;

import cz.cca.mojecca.db.imis.model.QZamestnanecEntity;
import cz.cca.mojecca.db.imis.model.ZamestnanecEntity;

@Stateless
public class ZamestnanecDAO {
	
	@PersistenceContext(unitName = "imis")
	private EntityManager entityManager;
	
	public ZamestnanecEntity getZamestnanec(String icp) {
		QZamestnanecEntity qZamestnanec = new QZamestnanecEntity("zam");
		
		JPAQuery q = new JPAQuery(entityManager);
		
		q.from(qZamestnanec);
		q.where(qZamestnanec.icp.eq(icp));
		
		return q.singleResult(qZamestnanec);
	}

}
