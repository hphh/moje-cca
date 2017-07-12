package cz.cca.mojecca.db.imis;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import cz.cca.mojecca.db.imis.model.VykazPraceEntity;

@Stateless
public class VykazPraceDAO {
	
	private final String EMPLOYEE_VYKAZ_PRACES_QUERY = 
			"select t.datum datum, " + 
			"       t.mnozstvi_odved mnozstviOdvedenePrace, " + 
			"       t.poznamka popisPrace, " + 
			"       t.pozn_hl hlaseni, " + 
			"       t.pozn_krok krok, " + 
			"       t.pozn_ukol ukol, " + 
			"       t.rowid id," + 
			"       t.zc zakazka," + 
			"       t.cpolzak polozka," + 
			"       t.cpozzak pozice," + 
			"       t.prac pracovnik," + 
			"       t.id_firmy_zak organizace," + 
			"       t.kodpra kodUzivatele" + 
			"  from den_vykaz t" + 
			" where datum between :fromDate and :toDate" + 
			"   and kodpra = :kodpra" + 
			"   and jednotka = 'H'" + 
			" order by datum";
	
	@PersistenceContext(unitName = "imis")
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<VykazPraceEntity> getEmployeeVykazPraces(String kodUzivatele, Date fromDate, Date toDate) {
		Query q = entityManager.createNativeQuery(EMPLOYEE_VYKAZ_PRACES_QUERY, VykazPraceEntity.class);
		q.setParameter("kodpra", kodUzivatele);
		q.setParameter("fromDate", fromDate, TemporalType.DATE);
		q.setParameter("toDate", toDate, TemporalType.DATE);
		
		return q.getResultList();
	}

}
