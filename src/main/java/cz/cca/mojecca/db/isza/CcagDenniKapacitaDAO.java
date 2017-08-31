package cz.cca.mojecca.db.isza;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.jpa.impl.JPAQuery;

import cz.cca.mojecca.db.isza.model.CcagDenniKapacitaEntity;
import cz.cca.mojecca.db.isza.model.CcagDenniKapacitaFilterParameters;
import cz.cca.mojecca.db.isza.model.QCcagDenniKapacitaEntity;

@Stateless
public class CcagDenniKapacitaDAO {

	@PersistenceContext(unitName = "isza")
	private EntityManager entityManager;
	
	public List<CcagDenniKapacitaEntity> getDenniKapacitas(CcagDenniKapacitaFilterParameters params) {
		QCcagDenniKapacitaEntity e = new QCcagDenniKapacitaEntity("d");
		
		JPAQuery q = new JPAQuery(entityManager);
		q.from(e);
		
		if (params.getKodUzivatele() != null) {
			q.where(e.kodUzivatele.eq(params.getKodUzivatele()));
		}
		
		if (params.getFromDate() != null) {
			q.where(e.datum.goe(params.getFromDate()));
		}

		if (params.getToDate() != null) {
			q.where(e.datum.loe(params.getToDate()));
		}
		
		if (params.getDruhDne() != null) {
			q.where(e.druhDne.eq(params.getDruhDne()));
		}
		
		q.orderBy(e.kodUzivatele.asc());
		q.orderBy(e.datum.asc());
		
		return q.list(e);
	}
	
}
