package cz.cca.mojecca.db.imis;

import java.math.BigDecimal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.jpa.impl.JPAQuery;

import cz.cca.mojecca.db.imis.model.QVyhodnoceniEntity;
import cz.cca.mojecca.db.imis.model.VybranoDovoleneFilterParameters;

@Stateless
public class VyhodnoceniDAO {
	
	@PersistenceContext(unitName = "imis")
	private EntityManager entityManager;

	public BigDecimal getVybranoDovoleneHod(VybranoDovoleneFilterParameters params) {
		QVyhodnoceniEntity qVyhodnoceni = new QVyhodnoceniEntity("v");
		
		JPAQuery q = new JPAQuery(entityManager);
		
		q.from(qVyhodnoceni);
		
		q.where(qVyhodnoceni.id.icp.eq(params.getIcp()));
		
		if (params.getFromDate() != null) {
			q.where(qVyhodnoceni.id.datum.goe(params.getFromDate()));
		}
		if (params.getToDate() != null) {
			q.where(qVyhodnoceni.id.datum.loe(params.getToDate()));
		}
		q.where(qVyhodnoceni.kodyDob.druh.eq(new BigDecimal(8)));
		q.where(qVyhodnoceni.id.kodDoby.ne("PCK"));
				
		BigDecimal result = q.singleResult(qVyhodnoceni.pocHod.sum());
		
		return result;
	}

}
