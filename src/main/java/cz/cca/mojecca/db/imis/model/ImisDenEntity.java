package cz.cca.mojecca.db.imis.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ImisDenEntity {
	
	@Id
	private Date datum;
	private String druhDne;
	private String svatek;
	private String vyrobniDen;
	private String vykazano;
	private String pritomen;
	private BigDecimal vykazanoHod;
	private String potvrzeno;
	
	
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
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
	

}
