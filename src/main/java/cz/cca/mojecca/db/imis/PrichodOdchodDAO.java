package cz.cca.mojecca.db.imis;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cz.cca.mojecca.db.imis.model.PrichodOdchodEntity;

@Stateless
public class PrichodOdchodDAO {
	
	private static final String PRICHODY_ODCHODY_PRACOVNIKA_AKTUALNI_DEN_QUERY = 
			"select t.icp," + 
			"       t.druh kodPrichodOdchod, " + 
			"       t.kod_po specPrichodOdchod," + 
			"       to_date(to_char(sysdate, 'dd.mm.yyyy') || ' ' || " + 
			"               substr(to_char(trunc(t.cas),'09'),2,2) || ':' ||" + 
			"               substr(to_char(round((t.cas-trunc(t.cas))*60),'09'),2,2)," + 
			"               'dd.mm.yyyy hh24:mi') datum," + 
			"       p.popis popisPrichodOdchod," + 
			"       t.poznamka," + 
			"       t.rowid, " + 
			"       t.cas " +
			"  from karta t," + 
			"       kody_po p, " + 
			"       kody_dob d" + 
			" where icp = :icp" + 
			"   and datum = :day " + 
			"   and p.kod_po = t.kod_po" + 
			"   and d.kod_doby = p.kod_doby" + 
			"   and t.druh in ('P', 'O') " +
			"   and t.typ not in ('S','F') " +
			"   and d.priznak like decode(t.druh," + 
			"                                 'P'," + 
			"                                 decode(d.priznak, 'P', 'P', '-', '-')," + 
			"                                 'O'," + 
			"                                 decode(d.priznak, 'O', 'O', 'N', 'N', '-', '-')" + 
			"                                )" + 
			" order by datum, t.cas, t.druh desc";
	
	@PersistenceContext(unitName = "imis")
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<PrichodOdchodEntity> getEmployeePrichodOdchods(String icp, Date day) {
		Query q = entityManager.createNativeQuery(
				PRICHODY_ODCHODY_PRACOVNIKA_AKTUALNI_DEN_QUERY, 
				PrichodOdchodEntity.class);
		q.setParameter("icp", icp);
		q.setParameter("day", day);
		
		return q.getResultList();
	}

}
