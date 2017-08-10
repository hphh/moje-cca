package cz.cca.mojecca.db.imis;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.jpa.impl.JPAQuery;

import cz.cca.mojecca.db.imis.model.QZamMesEntity;
import cz.cca.mojecca.db.imis.model.ZamMesEntity;
import cz.cca.mojecca.db.imis.model.ZamMesFilterParameters;

@Stateless
public class ZamMesDAO {
	
	@PersistenceContext(unitName = "imis")
	private EntityManager entityManager;

	public List<ZamMesEntity> getZamMess(ZamMesFilterParameters params) {
		QZamMesEntity qZamMes = new QZamMesEntity("z");
		
		JPAQuery q = new JPAQuery(entityManager);
		
		q.from(qZamMes);
		
		q.where(qZamMes.id.icp.eq(params.getIcp()));
		
		if (params.getFromObdobi() != null) {
			q.where(qZamMes.id.obdobi.goe(params.getFromObdobi()));
		}
		
		q.orderBy(qZamMes.id.obdobi.desc());
		
		return q.list(qZamMes);		
	}

}
