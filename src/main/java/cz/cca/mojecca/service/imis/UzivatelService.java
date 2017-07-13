package cz.cca.mojecca.service.imis;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import cz.cca.mojecca.cache.Cache;
import cz.cca.mojecca.cache.CacheParameters;
import cz.cca.mojecca.cache.CacheService;
import cz.cca.mojecca.db.imis.UzivatelDAO;

@RequestScoped
public class UzivatelService {
	
	@Inject
	private CacheService cacheService;
	
	@EJB
	private UzivatelDAO uzivatelDAO;
	
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

}
