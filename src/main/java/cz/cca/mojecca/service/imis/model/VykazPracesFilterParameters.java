package cz.cca.mojecca.service.imis.model;

public class VykazPracesFilterParameters {
	
	private String kodUzivatele;
	private Long fromDate;
	private Long toDate;
	private String ukol;
	private String krok;
	private String hlaseni;
	
	
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
