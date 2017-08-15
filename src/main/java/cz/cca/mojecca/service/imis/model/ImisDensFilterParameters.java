package cz.cca.mojecca.service.imis.model;

import java.util.Date;

public class ImisDensFilterParameters {
	
	private String kodUzivatele;
	private Date fromDate;
	private Date toDate;
	private boolean unsolvedDaysOnly;
	
	
	public String getKodUzivatele() {
		return kodUzivatele;
	}
	public void setKodUzivatele(String kodUzivatele) {
		this.kodUzivatele = kodUzivatele;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public boolean isUnsolvedDaysOnly() {
		return unsolvedDaysOnly;
	}
	public void setUnsolvedDaysOnly(boolean unsolvedDaysOnly) {
		this.unsolvedDaysOnly = unsolvedDaysOnly;
	}
	
	

}
