package cz.cca.mojecca.service.model;

public class DensFilterParameters {
	
	private String kodUzivatele;
	private Long fromDate;
	private Long toDate;
	private boolean unsolvedDaysOnly;

	
	public String getKodUzivatele() {
		return kodUzivatele;
	}
	public void setKodUzivatele(String kodUzivatele) {
		this.kodUzivatele = kodUzivatele;
	}
	public Long getFromDate() {
		return fromDate;
	}
	public void setFromDate(Long fromDate) {
		this.fromDate = fromDate;
	}
	public Long getToDate() {
		return toDate;
	}
	public void setToDate(Long toDate) {
		this.toDate = toDate;
	}
	public boolean isUnsolvedDaysOnly() {
		return unsolvedDaysOnly;
	}
	public void setUnsolvedDaysOnly(boolean unsolvedDaysOnly) {
		this.unsolvedDaysOnly = unsolvedDaysOnly;
	}	
	

}
