package cz.cca.mojecca.service.imis.model;

public class MoveDayVykazPracesParameters {
	
	private String kodUzivatele;
	private long oldDate;
	private long newDate;
	private boolean allNextDays;
	
	public long getOldDate() {
		return oldDate;
	}
	public void setOldDate(long oldDate) {
		this.oldDate = oldDate;
	}
	public long getNewDate() {
		return newDate;
	}
	public void setNewDate(long newDate) {
		this.newDate = newDate;
	}
	public boolean isAllNextDays() {
		return allNextDays;
	}
	public void setAllNextDays(boolean allNextDays) {
		this.allNextDays = allNextDays;
	}
	public String getKodUzivatele() {
		return kodUzivatele;
	}
	public void setKodUzivatele(String kodUzivatele) {
		this.kodUzivatele = kodUzivatele;
	}
	
	

}
