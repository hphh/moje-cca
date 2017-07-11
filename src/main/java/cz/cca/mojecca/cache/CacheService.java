package cz.cca.webimis.cache;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CacheService {
	
	@SuppressWarnings("rawtypes")
	private Map<String, Cache> caches = new HashMap<>();
	
	@SuppressWarnings("rawtypes")
	public Cache getOrCreateCache(String name, CacheParameters params) {
		if (caches.containsKey(name)) {
			return caches.get(name);
		}
		Cache result = new Cache(params);
		caches.put(name, result);
		return result;
	}
	
	public CacheState getCacheState() {
		CacheState result = new CacheState();
		result.setCachesCount(caches.size());
		
		long cachedItemsCount = caches.entrySet().stream().mapToLong(entry -> entry.getValue().size()).sum();
		result.setCachedItemsCount(cachedItemsCount);
		
		return result;
	}

}
