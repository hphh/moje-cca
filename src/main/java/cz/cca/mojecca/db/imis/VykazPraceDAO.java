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
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.sql.DataSource;

import org.hibernate.Session;

import cz.cca.mojecca.db.imis.model.DenVykazEntity;
import cz.cca.mojecca.db.imis.model.VykazPraceEntity;

@Stateless
public class VykazPraceDAO {

	private final String EMPLOYEE_VYKAZ_PRACES_QUERY = 
			"select t.datum datum, "
			+ "       t.mnozstvi_odved mnozstviOdvedenePrace, "
			+ "       t.poznamka popisPrace, "
			+ "       t.pozn_hl hlaseni, "
			+ "       t.pozn_krok krok, "
			+ "       t.pozn_ukol ukol, "
			+ "       t.id id,"
			+ "       t.zc zakazka," + "       t.cpolzak polozka,"
			+ "       t.cpozzak pozice,"
			+ "       t.prac pracovnik,"
			+ "       t.id_firmy_zak organizace,"
			+ "       t.kodpra kodUzivatele,"
			+ "       0 odpracovanaDobaVDen"
			+ "  from den_vykaz t"
			+ " where datum between :fromDate and :toDate"
			+ "   and kodpra = :kodpra"
			+ "   and jednotka = 'H'"
			+ " order by datum, mnozstvi_odved desc";

	@PersistenceContext(unitName = "imis")
	private EntityManager entityManager;
	
	@Resource(mappedName="java:/imisDS") 
	private DataSource datasource;

	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.NEVER)
	public List<VykazPraceEntity> getEmployeeVykazPraces(String kodUzivatele, String icp, Date fromDate, Date toDate) {
		Query q = entityManager.createNativeQuery(EMPLOYEE_VYKAZ_PRACES_QUERY, VykazPraceEntity.class);
		q.setParameter("kodpra", kodUzivatele);
		q.setParameter("fromDate", fromDate, TemporalType.DATE);
		q.setParameter("toDate", toDate, TemporalType.DATE);

		List<VykazPraceEntity> result = q.getResultList();

		Date lastDate = new Date(0);
		BigDecimal odpracovanaDobaVDen = null;
		for (VykazPraceEntity e : result) {
			if (!e.getDatum().equals(lastDate)) {
				odpracovanaDobaVDen = getOdpracovanaDobaVDen(icp, e.getDatum());
			}
			e.setOdpracovanaDobaVDen(odpracovanaDobaVDen);
			lastDate = e.getDatum();
		}

		return result;
	}

	private BigDecimal getOdpracovanaDobaVDen(String icp, Date datum) {
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

	public void updateDenVykaz(DenVykazEntity denVykazEntity) {
		entityManager.merge(denVykazEntity);
	}

	public void updateDenVykazs(List<DenVykazEntity> denVykazEntities) {
		if (denVykazEntities == null) {
			return;
		}

		denVykazEntities.stream().forEach(entity -> {
			updateDenVykaz(entity);
		});

	}

	public DenVykazEntity getDenVykaz(long id) {
		return entityManager.find(DenVykazEntity.class, id);
	}
	
	public void insertDenVykaz(DenVykazEntity denVykazEntity) {
		entityManager.persist(denVykazEntity);
	}

}
