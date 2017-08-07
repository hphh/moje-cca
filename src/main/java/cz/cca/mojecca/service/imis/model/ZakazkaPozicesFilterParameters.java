package cz.cca.mojecca.service.imis.model;

public class ZakazkaPozicesFilterParameters {
	
	private String zakazka;
	private Long polozka;
	private String pozicePattern;
	
	
	public String getZakazka() {
		return zakazka;
	}
	public void setZakazka(String zakazka) {
		this.zakazka = zakazka;
	}
	public Long getPolozka() {
		return polozka;
	}
	public void setPolozka(Long polozka) {
		this.polozka = polozka;
	}
	public String getPozicePattern() {
		return pozicePattern;
	}
	public void setPozicePattern(String pozicePattern) {
		this.pozicePattern = pozicePattern;
	}
	
	

}
