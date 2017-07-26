package cz.cca.mojecca.db.isza;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;

import cz.cca.mojecca.db.isza.model.CcagUkol;
import cz.cca.mojecca.db.isza.model.CcagUkolFilterParameters;
import cz.cca.mojecca.db.isza.model.QCcagUkol;

@Stateless
public class CcagUkolDAO {
	
	@PersistenceContext(unitName = "isza")
	private EntityManager entityManager;
	
	public List<CcagUkol> getUkols(CcagUkolFilterParameters params) {
		QCcagUkol ccagUkol = new QCcagUkol("ukol");
		JPQLQuery query = new JPAQuery(entityManager);
		
		query.from(ccagUkol);
		if (params.getCisloUkolu() != null) {
			query.where(ccagUkol.cisloUkolu.eq(params.getCisloUkolu()));
		}
		if (params.getRokUkolu() != null) {
			query.where(ccagUkol.rokUkolu.eq(params.getRokUkolu()));
		}
		
		query.orderBy(ccagUkol.idUkolu.asc());
				
		List<CcagUkol> result = query.list(ccagUkol);
		return result;
	}

}
