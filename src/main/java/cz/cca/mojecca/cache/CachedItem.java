package cz.cca.mojecca.cache;

public class CachedItem<T> {
	
	private T value;
	private long putTime;
	
	public CachedItem(T value) {
		this.value = value;
		this.putTime = System.currentTimeMillis();
	}
	
	public long getPutTime() {
		return putTime;
	}
	
	public T getValue() {
		return value;
	}

}
