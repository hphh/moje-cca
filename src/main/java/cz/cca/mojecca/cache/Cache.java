package cz.cca.mojecca.cache;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Cache<K, V> {

	private CacheParameters parameters;

	private Map<K, CachedItem<V>> cachedItems;

	public Cache(CacheParameters params) {
		this.parameters = params;
		cachedItems = Collections
				.synchronizedMap(new LinkedHashMap<K, CachedItem<V>>(this.parameters.getMaxObjectCount()) {
					private static final long serialVersionUID = 1L;

					@Override
					protected boolean removeEldestEntry(Entry<K, CachedItem<V>> entry) {
						return size() > parameters.getMaxObjectCount();
					}
				});
	}

	public V get(K key) {
		CachedItem<V> object = cachedItems.get(key);
		if (object == null) {
			return null;
		}

		if (object.getPutTime() + this.parameters.getMaxObjectAge() < System.currentTimeMillis()) {
			cachedItems.remove(object);
			return null;
		}

		return object.getValue();
	}

	public void put(K key, V value) {
		cachedItems.put(key, new CachedItem<V>(value));
	}

	public long size() {
		return cachedItems.size();
	}
}
