package cz.cca.mojecca.db.imis.model;

import java.util.Date;

public class DenVykazFilterParameters {
	
	private String kodUzivatele;
	private Date fromDate;
	private Date toDate;
	private String ukol;
	private String krok;
	private String hlaseni;
	
	
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
	public String getUkol() {
		return ukol;
	}
	public void setUkol(String ukol) {
		this.ukol = ukol;
	}
	public String getKrok() {
		return krok;
	}
	public void setKrok(String krok) {
		this.krok = krok;
	}
	public String getHlaseni() {
		return hlaseni;
	}
	public void setHlaseni(String hlaseni) {
		this.hlaseni = hlaseni;
	}
	
	
	

}
