package cz.cca.mojecca.service.imis.model;

import java.math.BigDecimal;

public class ImisDen {
	
	private Long datum;
	private String druhDne;
	private String svatek;
	private String vyrobniDen;
	private String vykazano;
	private String pritomen;
	private BigDecimal odpracovanoHod;
	private BigDecimal vykazanoHod;
	private String potvrzeno;
	private boolean unsolved;
	
	
	public Long getDatum() {
		return datum;
	}
	public void setDatum(Long datum) {
		this.datum = datum;
	}
	public String getDruhDne() {
		return druhDne;
	}
	public void setDruhDne(String druhDne) {
		this.druhDne = druhDne;
	}
	public String getSvatek() {
		return svatek;
	}
	public void setSvatek(String svatek) {
		this.svatek = svatek;
	}
	public String getVyrobniDen() {
		return vyrobniDen;
	}
	public void setVyrobniDen(String vyrobniDen) {
		this.vyrobniDen = vyrobniDen;
	}
	public String getVykazano() {
		return vykazano;
	}
	public void setVykazano(String vykazano) {
		this.vykazano = vykazano;
	}
	public String getPritomen() {
		return pritomen;
	}
	public void setPritomen(String pritomen) {
		this.pritomen = pritomen;
	}
	public BigDecimal getOdpracovanoHod() {
		return odpracovanoHod;
	}
	public void setOdpracovanoHod(BigDecimal odpracovanoHod) {
		this.odpracovanoHod = odpracovanoHod;
	}
	public BigDecimal getVykazanoHod() {
		return vykazanoHod;
	}
	public void setVykazanoHod(BigDecimal vykazanoHod) {
		this.vykazanoHod = vykazanoHod;
	}
	public String getPotvrzeno() {
		return potvrzeno;
	}
	public void setPotvrzeno(String potvrzeno) {
		this.potvrzeno = potvrzeno;
	}
	public boolean isUnsolved() {
		return unsolved;
	}
	public void setUnsolved(boolean unsolved) {
		this.unsolved = unsolved;
	}	
	
	
}
