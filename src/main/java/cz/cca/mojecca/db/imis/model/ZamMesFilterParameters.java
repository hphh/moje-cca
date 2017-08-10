package cz.cca.mojecca.db.imis.model;

import java.util.Date;

public class ZamMesFilterParameters {
	
	private Date fromObdobi;
	private String icp;
	
	public Date getFromObdobi() {
		return fromObdobi;
	}
	public void setFromObdobi(Date fromObdobi) {
		this.fromObdobi = fromObdobi;
	}
	public String getIcp() {
		return icp;
	}
	public void setIcp(String icp) {
		this.icp = icp;
	}

}
