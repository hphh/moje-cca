package cz.cca.mojecca.db.isza;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;

import cz.cca.mojecca.db.isza.model.CcagHlaseni;
import cz.cca.mojecca.db.isza.model.CcagHlaseniFilterParameters;
import cz.cca.mojecca.db.isza.model.QCcagHlaseni;

@Stateless
public class CcagHlaseniDAO {

	
	@PersistenceContext(unitName = "isza")
	private EntityManager entityManager;
	
	public List<CcagHlaseni> getHlasenis(CcagHlaseniFilterParameters params) {
		QCcagHlaseni ccagHlaseni = new QCcagHlaseni("hlaseni");
		JPQLQuery query = new JPAQuery(entityManager);
		
		query.from(ccagHlaseni);
		if (params.getCisloHlaseni() != null) {
			query.where(ccagHlaseni.id.cisloHlaseni.eq(params.getCisloHlaseni()));
		}
		if (params.getRokHlaseni() != null) {
			query.where(ccagHlaseni.id.rokHlaseni.eq(params.getRokHlaseni()));
		}
		
		query.orderBy(ccagHlaseni.id.rokHlaseni.asc(), ccagHlaseni.id.cisloHlaseni.asc());
				
		List<CcagHlaseni> result = query.list(ccagHlaseni);
		return result;
	}	
	
}
