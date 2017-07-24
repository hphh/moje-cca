package cz.cca.mojecca.db.imis;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cz.cca.mojecca.db.imis.model.ImisDenEntity;

@Stateless
public class KalendarDAO {
	
	private static final String KALENDAR_QUERY = 
			"select datum," + 
			"       druh_dne druhDne," + 
			"       svatek," + 
			"       vyrobni_den vyrobniDen," + 
			"       (nvl((select 'A'" + 
			"               from den_vykaz v" + 
			"              where v.datum = k.datum " + 
			"                and v.kodpra = :kodUzivatele" +
			"                and v.jednotka = 'H'" +
			"                and rownum = 1), 'N')) vykazano," + 
			"       (nvl((select 'A' " + 
			"               from karta_vie d" + 
			"              where d.datum = k.datum" + 
			"                and icp = :icp" + 
			"                and typ not in ('S', 'F')" + 
			"                and rownum = 1), 'N')) pritomen, " +
			"       (nvl((select 'N'" + 
			"               from den_vykaz v" + 
			"              where v.datum = k.datum" + 
			"                and v.kodpra = :kodUzivatele" + 
			"                and v.stav_v = 'V'" + 
			"                and rownum = 1), 'A')) potvrzeno," + 
			"       (select sum(v.mnozstvi_odved)" + 
			"          from den_vykaz v" + 
			"         where v.datum = k.datum" + 
			"           and v.kodpra = :kodUzivatele" + 
			"           and v.jednotka = 'H') vykazanoHod" +
			"  from ccas_kalendar k" + 
			" where datum >= trunc(:datumOd) " +
			"   and datum <= trunc(:datumDo) " +
			" order by datum";
	
	@PersistenceContext(unitName = "imis")
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<ImisDenEntity> getImisDens(Date fromDate, Date toDate, String kodUzivatele, String icp) {
		Query q = entityManager.createNativeQuery(KALENDAR_QUERY, ImisDenEntity.class);
		q.setParameter("datumOd", fromDate);
		q.setParameter("datumDo", toDate);
		q.setParameter("kodUzivatele", kodUzivatele);
		q.setParameter("icp", icp);
		
		List<ImisDenEntity> result = q.getResultList();
		return result;

	}

}
