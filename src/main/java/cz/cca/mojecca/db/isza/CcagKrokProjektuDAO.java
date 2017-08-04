package cz.cca.mojecca.db.isza;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;

import cz.cca.mojecca.db.isza.model.CcagKrokProjektu;
import cz.cca.mojecca.db.isza.model.CcagKrokProjektuFilterParameters;
import cz.cca.mojecca.db.isza.model.QCcagKrokProjektu;

@Stateless
public class CcagKrokProjektuDAO {

	@PersistenceContext(unitName = "isza")
	private EntityManager entityManager;
	
	public List<CcagKrokProjektu> getKroks(CcagKrokProjektuFilterParameters params) {
		QCcagKrokProjektu ccagKrok = new QCcagKrokProjektu("krok");
		JPQLQuery query = new JPAQuery(entityManager);
		
		query.from(ccagKrok);
		if (params.getCisloKroku() != null) {
			query.where(ccagKrok.cisloKroku.eq(params.getCisloKroku()));
		}
		if (params.getRokKroku() != null) {
			query.where(ccagKrok.rokKroku.eq(params.getRokKroku()));
		}
		
		query.orderBy(ccagKrok.idKrokuProjektu.asc());
				
		List<CcagKrokProjektu> result = query.list(ccagKrok);
		return result;
	}	
}
