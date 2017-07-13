package cz.cca.mojecca.service.imis.model;

import java.math.BigDecimal;

public class VykazPrace {
	
	private long id;
	private long datum;
	private BigDecimal mnozstviOdvedenePrace;
	private String popisPrace;
	private String hlaseni;
	private String krok;
	private String ukol;
	private String zakazka;
	private long polozka;
	private long pozice;
	private String pracovnik;
	private String organizace;
	private String kodUzivatele;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getDatum() {
		return datum;
	}
	public void setDatum(long datum) {
		this.datum = datum;
	}
	public BigDecimal getMnozstviOdvedenePrace() {
		return mnozstviOdvedenePrace;
	}
	public void setMnozstviOdvedenePrace(BigDecimal mnozstviOdvedenePrace) {
		this.mnozstviOdvedenePrace = mnozstviOdvedenePrace;
	}
	public String getPopisPrace() {
		return popisPrace;
	}
	public void setPopisPrace(String popisPrace) {
		this.popisPrace = popisPrace;
	}
	public String getHlaseni() {
		return hlaseni;
	}
	public void setHlaseni(String hlaseni) {
		this.hlaseni = hlaseni;
	}
	public String getKrok() {
		return krok;
	}
	public void setKrok(String krok) {
		this.krok = krok;
	}
	public String getUkol() {
		return ukol;
	}
	public void setUkol(String ukol) {
		this.ukol = ukol;
	}
	public String getZakazka() {
		return zakazka;
	}
	public void setZakazka(String zakazka) {
		this.zakazka = zakazka;
	}
	public long getPolozka() {
		return polozka;
	}
	public void setPolozka(long polozka) {
		this.polozka = polozka;
	}
	public long getPozice() {
		return pozice;
	}
	public void setPozice(long pozice) {
		this.pozice = pozice;
	}
	public String getPracovnik() {
		return pracovnik;
	}
	public void setPracovnik(String pracovnik) {
		this.pracovnik = pracovnik;
	}
	public String getOrganizace() {
		return organizace;
	}
	public void setOrganizace(String organizace) {
		this.organizace = organizace;
	}
	public String getKodUzivatele() {
		return kodUzivatele;
	}
	public void setKodUzivatele(String kodUzivatele) {
		this.kodUzivatele = kodUzivatele;
	}
	
	


}
