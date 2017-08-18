package cz.cca.mojecca.db.imis.model;

import java.util.Date;

public class VybranoDovoleneFilterParameters {

	
	private String icp; 
	private Date fromDate; 
	private Date toDate;
	
	
	public String getIcp() {
		return icp;
	}
	public void setIcp(String icp) {
		this.icp = icp;
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
	
	
}
