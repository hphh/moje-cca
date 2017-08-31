package cz.cca.mojecca.db.isza.model;

import java.util.Date;

public class CcagDenniKapacitaFilterParameters {
	
	private String kodUzivatele;
	private Date fromDate;
	private Date toDate;
	private String druhDne;
	
	
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
	public String getDruhDne() {
		return druhDne;
	}
	public void setDruhDne(String druhDne) {
		this.druhDne = druhDne;
	}
	
	

}
