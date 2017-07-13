package cz.cca.mojecca.db.imis;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UzivatelDAO {
	
	private static final String ICP_UZIVATELE_QUERY = "select oscislo from ccap_uzivatel_b where kodpra = :kodpra"; 

	@PersistenceContext(unitName = "imis")
	private EntityManager entityManager;

	public String getIcp(String kodUzivatele) {
		Query q = entityManager.createNativeQuery(ICP_UZIVATELE_QUERY);
		q.setParameter("kodpra", kodUzivatele);
		
		return (String) q.getSingleResult();
	}
}
