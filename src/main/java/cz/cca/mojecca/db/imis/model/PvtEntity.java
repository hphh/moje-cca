package cz.cca.mojecca.db.imis.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the PVT database table.
 * 
 */
@Entity(name="PVT")
public class PvtEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PvtEntityPK id;

	@Column(name="MIN_VYROBNI_DAVKA")
	private BigDecimal minVyrobniDavka;

	private String nazprac;

	private BigDecimal poradi;

	private BigDecimal vykon;

	@Column(name="VYR_MISTO")
	private String vyrMisto;

	private String zkrprac;

	private String zndel;

	private String znnc;

	private String znvybr;

	private String znzrus;

	public PvtEntity() {
	}

	public PvtEntityPK getId() {
		return this.id;
	}

	public void setId(PvtEntityPK id) {
		this.id = id;
	}

	public BigDecimal getMinVyrobniDavka() {
		return this.minVyrobniDavka;
	}

	public void setMinVyrobniDavka(BigDecimal minVyrobniDavka) {
		this.minVyrobniDavka = minVyrobniDavka;
	}

	public String getNazprac() {
		return this.nazprac;
	}

	public void setNazprac(String nazprac) {
		this.nazprac = nazprac;
	}

	public BigDecimal getPoradi() {
		return this.poradi;
	}

	public void setPoradi(BigDecimal poradi) {
		this.poradi = poradi;
	}

	public BigDecimal getVykon() {
		return this.vykon;
	}

	public void setVykon(BigDecimal vykon) {
		this.vykon = vykon;
	}

	public String getVyrMisto() {
		return this.vyrMisto;
	}

	public void setVyrMisto(String vyrMisto) {
		this.vyrMisto = vyrMisto;
	}

	public String getZkrprac() {
		return this.zkrprac;
	}

	public void setZkrprac(String zkrprac) {
		this.zkrprac = zkrprac;
	}

	public String getZndel() {
		return this.zndel;
	}

	public void setZndel(String zndel) {
		this.zndel = zndel;
	}

	public String getZnnc() {
		return this.znnc;
	}

	public void setZnnc(String znnc) {
		this.znnc = znnc;
	}

	public String getZnvybr() {
		return this.znvybr;
	}

	public void setZnvybr(String znvybr) {
		this.znvybr = znvybr;
	}

	public String getZnzrus() {
		return this.znzrus;
	}

	public void setZnzrus(String znzrus) {
		this.znzrus = znzrus;
	}

}