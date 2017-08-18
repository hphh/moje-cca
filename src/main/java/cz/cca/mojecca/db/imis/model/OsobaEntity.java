package cz.cca.mojecca.db.imis.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the OSOBA database table.
 * 
 */
@Entity
@Table(name="OSOBA")
@NamedQuery(name="OsobaEntity.findAll", query="SELECT o FROM OsobaEntity o")
public class OsobaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private String cisloop;

	private String cislopasu;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_ZAKAZU_OD")
	private Date datZakazuOd;

	private String fax;

	private String jmeno;

	private String kodpra;

	private String mesto;

	@Column(name="MISTO_NAROZENI")
	private String mistoNarozeni;

	@Column(name="NAROK_DOVOLENE")
	private BigDecimal narokDovolene;

	@Column(name="OFFICE_ID")
	private String officeId;

	@Column(name="ORA_USER")
	private String oraUser;

	@Id
	private String oscislo;

	@Column(name="PREFIX_OS")
	private String prefixOs;

	private String prijmeni;

	private String psc;

	private String rodnecislo;

	private String stred;

	private String telefon;

	@Column(name="TITUL_PRED")
	private String titulPred;

	@Column(name="TITUL_ZA")
	private String titulZa;

	private String uliceacislo;

	private BigDecimal uvazek;

	public OsobaEntity() {
	}

	public String getCisloop() {
		return this.cisloop;
	}

	public void setCisloop(String cisloop) {
		this.cisloop = cisloop;
	}

	public String getCislopasu() {
		return this.cislopasu;
	}

	public void setCislopasu(String cislopasu) {
		this.cislopasu = cislopasu;
	}

	public Date getDatZakazuOd() {
		return this.datZakazuOd;
	}

	public void setDatZakazuOd(Date datZakazuOd) {
		this.datZakazuOd = datZakazuOd;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getJmeno() {
		return this.jmeno;
	}

	public void setJmeno(String jmeno) {
		this.jmeno = jmeno;
	}

	public String getKodpra() {
		return this.kodpra;
	}

	public void setKodpra(String kodpra) {
		this.kodpra = kodpra;
	}

	public String getMesto() {
		return this.mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}

	public String getMistoNarozeni() {
		return this.mistoNarozeni;
	}

	public void setMistoNarozeni(String mistoNarozeni) {
		this.mistoNarozeni = mistoNarozeni;
	}

	public BigDecimal getNarokDovolene() {
		return this.narokDovolene;
	}

	public void setNarokDovolene(BigDecimal narokDovolene) {
		this.narokDovolene = narokDovolene;
	}

	public String getOfficeId() {
		return this.officeId;
	}

	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

	public String getOraUser() {
		return this.oraUser;
	}

	public void setOraUser(String oraUser) {
		this.oraUser = oraUser;
	}

	public String getOscislo() {
		return this.oscislo;
	}

	public void setOscislo(String oscislo) {
		this.oscislo = oscislo;
	}

	public String getPrefixOs() {
		return this.prefixOs;
	}

	public void setPrefixOs(String prefixOs) {
		this.prefixOs = prefixOs;
	}

	public String getPrijmeni() {
		return this.prijmeni;
	}

	public void setPrijmeni(String prijmeni) {
		this.prijmeni = prijmeni;
	}

	public String getPsc() {
		return this.psc;
	}

	public void setPsc(String psc) {
		this.psc = psc;
	}

	public String getRodnecislo() {
		return this.rodnecislo;
	}

	public void setRodnecislo(String rodnecislo) {
		this.rodnecislo = rodnecislo;
	}

	public String getStred() {
		return this.stred;
	}

	public void setStred(String stred) {
		this.stred = stred;
	}

	public String getTelefon() {
		return this.telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getTitulPred() {
		return this.titulPred;
	}

	public void setTitulPred(String titulPred) {
		this.titulPred = titulPred;
	}

	public String getTitulZa() {
		return this.titulZa;
	}

	public void setTitulZa(String titulZa) {
		this.titulZa = titulZa;
	}

	public String getUliceacislo() {
		return this.uliceacislo;
	}

	public void setUliceacislo(String uliceacislo) {
		this.uliceacislo = uliceacislo;
	}

	public BigDecimal getUvazek() {
		return this.uvazek;
	}

	public void setUvazek(BigDecimal uvazek) {
		this.uvazek = uvazek;
	}

}