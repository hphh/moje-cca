package cz.cca.mojecca.service.imis;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import cz.cca.mojecca.cache.Cache;
import cz.cca.mojecca.cache.CacheParameters;
import cz.cca.mojecca.cache.CacheService;
import cz.cca.mojecca.db.imis.PvtDAO;
import cz.cca.mojecca.db.imis.UzivatelDAO;
import cz.cca.mojecca.db.imis.ZamestnanecDAO;
import cz.cca.mojecca.db.imis.model.PvtEntity;
import cz.cca.mojecca.service.imis.data.ZamestnanecDataAdapter;
import cz.cca.mojecca.service.imis.model.Zamestnanec;

@RequestScoped
public class UzivatelService {
	
	@Inject
	private CacheService cacheService;
	
	@EJB
	private UzivatelDAO uzivatelDAO;
	
	@EJB 
	private ZamestnanecDAO zamestnanecDAO;
	
	@EJB
	private PvtDAO pvtDAO;
	
	public String getIcp(String kodUzivatele) {
		CacheParameters cp = new CacheParameters(Long.MAX_VALUE, 100);
		@SuppressWarnings("unchecked")
		Cache<String, String> cache = cacheService.getOrCreateCache("icps", cp);
		
		String result = cache.get(kodUzivatele);
		if (result == null) {
			result = uzivatelDAO.getIcp(kodUzivatele);
			cache.put(kodUzivatele, result);
		}
		
		return result;
	}
	
	public Zamestnanec getZamestnanec(String kodUzivatele) {
		CacheParameters cp = new CacheParameters(1000L * 60L * 60L, 100);
		@SuppressWarnings("unchecked")
		Cache<String, Zamestnanec> cache = cacheService.getOrCreateCache("zamestnanecs", cp);
		
		Zamestnanec result = cache.get(kodUzivatele);
		if (result == null) {
			String icp = getIcp(kodUzivatele);
			result = ZamestnanecDataAdapter.toZamestnanec(zamestnanecDAO.getZamestnanec(icp));
			cache.put(kodUzivatele, result);
		}
		
		return result;
	}
	
	public String getPrac(String kodUzivatele) {
		PvtEntity pvt = getPvt(kodUzivatele);
		if (pvt == null) {
			return null;
		}
		
		return pvt.getId().getPrac();
	}
	
	private PvtEntity getPvt(String kodUzivatele) {
		CacheParameters cp = new CacheParameters(1000L * 60L * 60L, 100);
		@SuppressWarnings("unchecked")
		Cache<String, PvtEntity> cache = cacheService.getOrCreateCache("pvts", cp);
		
		PvtEntity result = cache.get(kodUzivatele);
		if (result == null) {
			String stredisko = getZamestnanec(kodUzivatele).getStred();
			result = pvtDAO.getPvt(stredisko, kodUzivatele);
			if (result == null) {
				return null;
			}
			cache.put(kodUzivatele, result);
		}
		
		return result;
		
	}

}
