package cz.cca.webimis.cache;

public class CacheState {
	
	private int cachesCount;
	private long cachedItemsCount;

	public int getCachesCount() {
		return cachesCount;
	}

	public void setCachesCount(int cachesCount) {
		this.cachesCount = cachesCount;
	}

	public long getCachedItemsCount() {
		return cachedItemsCount;
	}

	public void setCachedItemsCount(long cachedItemsCount) {
		this.cachedItemsCount = cachedItemsCount;
	}

}
