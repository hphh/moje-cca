package cz.cca.mojecca.db.imis;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Types;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.hibernate.Session;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;

import cz.cca.mojecca.db.imis.model.DenVykazEntity;
import cz.cca.mojecca.db.imis.model.DenVykazFilterParameters;
import cz.cca.mojecca.db.imis.model.QDenVykazEntity;

@Stateless
public class VykazPraceDAO {

	@PersistenceContext(unitName = "imis")
	private EntityManager entityManager;

	@Resource(mappedName = "java:/imisDS")
	private DataSource datasource;

	public List<DenVykazEntity> getVykazPraces(DenVykazFilterParameters params) {
		
		QDenVykazEntity denVykaz = new QDenVykazEntity("denVykaz");
		JPQLQuery query = new JPAQuery(entityManager);
		
		query.from(denVykaz);
		
		query.where(denVykaz.jednotka.eq("H"));
		if (params.getKodUzivatele() != null) {
			query.where(denVykaz.kodpra.eq(params.getKodUzivatele()));
		}
		if (params.getFromDate() != null) {
			query.where(denVykaz.datum.goe(params.getFromDate()));
		}
		if (params.getToDate() != null) {
			query.where(denVykaz.datum.loe(params.getToDate()));
		}
		if (params.getHlaseni() != null) {
			query.where(denVykaz.poznHl.eq(params.getHlaseni()));
		}
		if (params.getUkol() != null) {
			query.where(denVykaz.poznUkol.eq(params.getUkol()));
		}
		if (params.getKrok() != null) {
			query.where(denVykaz.poznKrok.eq(params.getKrok()));
		}
		
		query.orderBy(denVykaz.datum.asc(), denVykaz.mnozstviOdved.desc());
		
		return query.list(denVykaz);
	}

	@TransactionAttribute(TransactionAttributeType.NEVER)
	public BigDecimal getOdpracovanoHodVDen(String icp, Date datum) {
		Session session = entityManager.unwrap(Session.class);
		BigDecimal result = (BigDecimal) session.doReturningWork(connection -> {
			try (CallableStatement function = connection.prepareCall("{ ? = call ccap_odpich_doba_den(?, ?, ?) }")) {
				function.registerOutParameter(1, Types.NUMERIC);
				function.registerOutParameter(4, Types.VARCHAR);
				function.setString(2, icp);
				function.setDate(3, new java.sql.Date(datum.getTime()));
				function.execute();
				return function.getBigDecimal(1);
			}
		});

		return result;
	}

	public void saveOrUpdateDenVykazs(List<DenVykazEntity> denVykazEntities) {
		if (denVykazEntities == null) {
			return;
		}

		denVykazEntities.stream().forEach(entity -> {
			if (entity.getId() == null) {
				insertDenVykaz(entity);
			} else {
				updateDenVykaz(entity);
			}
		});

	}

	public DenVykazEntity getDenVykaz(long id) {
		return entityManager.find(DenVykazEntity.class, id);
	}

	public void updateDenVykaz(DenVykazEntity denVykazEntity) {
		entityManager.merge(denVykazEntity);
	}

	public void insertDenVykaz(DenVykazEntity denVykazEntity) {
		entityManager.persist(denVykazEntity);
	}

}
