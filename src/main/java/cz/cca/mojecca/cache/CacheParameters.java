package cz.cca.webimis.cache;

public class CacheParameters {
	
	private long maxObjectAge;
	private int maxObjectCount;
	
	public CacheParameters(long maxObjectAge, int maxObjectCount) {
		super();
		this.maxObjectAge = maxObjectAge;
		this.maxObjectCount = maxObjectCount;
	}
	
	public long getMaxObjectAge() {
		return maxObjectAge;
	}
	public void setMaxObjectAge(long maxObjectAge) {
		this.maxObjectAge = maxObjectAge;
	}
	public int getMaxObjectCount() {
		return maxObjectCount;
	}
	public void setMaxObjectCount(int maxObjectCount) {
		this.maxObjectCount = maxObjectCount;
	}
	
	

}
