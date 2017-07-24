package cz.cca.mojecca.db.imis.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the DEN_VYKAZ database table.
 * 
 */
@Entity
@Table(name="DEN_VYKAZ")
public class DenVykazEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "DenVykazEntityIdGenerator", sequenceName = "den_vykaz#id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DenVykazEntityIdGenerator")
	private Long id;

	private BigDecimal bc;

	@Column(name="C_NAB")
	private BigDecimal cNab;

	@Column(name="CIS_OPERACE")
	private BigDecimal cisOperace;

	@Column(name="CIS_VYR_DAV")
	private BigDecimal cisVyrDav;

	@Column(name="CISLO_VYKAZU")
	private BigDecimal cisloVykazu;

	private Long cpolzak;

	private Long cpozzak;

	@Temporal(TemporalType.DATE)
	private Date datum;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_SCHVALENI")
	private Date datumSchvaleni;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_ZAPISU")
	private Date datumZapisu;

	@Column(name="ID_FIRMY_ZAK")
	private String idFirmyZak;

	private BigDecimal idplz;

	private BigDecimal idppz;

	private BigDecimal idzak;

	private BigDecimal io;

	private String jednotka;

	private String kodpra;

	@Column(name="KODPRA_VYKAZ")
	private String kodpraVykaz;

	@Column(name="MNOZSTVI_ODVED")
	private BigDecimal mnozstviOdved;

	@Column(name="MNOZSTVI_SPLNENE")
	private BigDecimal mnozstviSplnene;

	@Column(name="MNOZSTVI_ZMETKOVE")
	private BigDecimal mnozstviZmetkove;

	private String odpracoval;

	private String oscislo;

	@Column(name="POZN_HL")
	private String poznHl;

	@Column(name="POZN_KROK")
	private String poznKrok;

	@Column(name="POZN_POZ")
	private String poznPoz;

	@Column(name="POZN_UKOL")
	private String poznUkol;

	private String poznamka;

	private String prac;

	@Column(name="REG_CIS")
	private String regCis;

	private BigDecimal sazba;

	@Column(name="STAV_V")
	private String stavV;

	private String stred;

	private String stredmd;

	@Column(name="VYR_MISTO")
	private String vyrMisto;

	private String zc;

	private String zmetek;

	public DenVykazEntity() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getBc() {
		return this.bc;
	}

	public void setBc(BigDecimal bc) {
		this.bc = bc;
	}

	public BigDecimal getCNab() {
		return this.cNab;
	}

	public void setCNab(BigDecimal cNab) {
		this.cNab = cNab;
	}

	public BigDecimal getCisOperace() {
		return this.cisOperace;
	}

	public void setCisOperace(BigDecimal cisOperace) {
		this.cisOperace = cisOperace;
	}

	public BigDecimal getCisVyrDav() {
		return this.cisVyrDav;
	}

	public void setCisVyrDav(BigDecimal cisVyrDav) {
		this.cisVyrDav = cisVyrDav;
	}

	public BigDecimal getCisloVykazu() {
		return this.cisloVykazu;
	}

	public void setCisloVykazu(BigDecimal cisloVykazu) {
		this.cisloVykazu = cisloVykazu;
	}

	public Long getCpolzak() {
		return this.cpolzak;
	}

	public void setCpolzak(Long cpolzak) {
		this.cpolzak = cpolzak;
	}

	public Long getCpozzak() {
		return this.cpozzak;
	}

	public void setCpozzak(Long cpozzak) {
		this.cpozzak = cpozzak;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Date getDatumSchvaleni() {
		return this.datumSchvaleni;
	}

	public void setDatumSchvaleni(Date datumSchvaleni) {
		this.datumSchvaleni = datumSchvaleni;
	}

	public Date getDatumZapisu() {
		return this.datumZapisu;
	}

	public void setDatumZapisu(Date datumZapisu) {
		this.datumZapisu = datumZapisu;
	}

	public String getIdFirmyZak() {
		return this.idFirmyZak;
	}

	public void setIdFirmyZak(String idFirmyZak) {
		this.idFirmyZak = idFirmyZak;
	}

	public BigDecimal getIdplz() {
		return this.idplz;
	}

	public void setIdplz(BigDecimal idplz) {
		this.idplz = idplz;
	}

	public BigDecimal getIdppz() {
		return this.idppz;
	}

	public void setIdppz(BigDecimal idppz) {
		this.idppz = idppz;
	}

	public BigDecimal getIdzak() {
		return this.idzak;
	}

	public void setIdzak(BigDecimal idzak) {
		this.idzak = idzak;
	}

	public BigDecimal getIo() {
		return this.io;
	}

	public void setIo(BigDecimal io) {
		this.io = io;
	}

	public String getJednotka() {
		return this.jednotka;
	}

	public void setJednotka(String jednotka) {
		this.jednotka = jednotka;
	}

	public String getKodpra() {
		return this.kodpra;
	}

	public void setKodpra(String kodpra) {
		this.kodpra = kodpra;
	}

	public String getKodpraVykaz() {
		return this.kodpraVykaz;
	}

	public void setKodpraVykaz(String kodpraVykaz) {
		this.kodpraVykaz = kodpraVykaz;
	}

	public BigDecimal getMnozstviOdved() {
		return this.mnozstviOdved;
	}

	public void setMnozstviOdved(BigDecimal mnozstviOdved) {
		this.mnozstviOdved = mnozstviOdved;
	}

	public BigDecimal getMnozstviSplnene() {
		return this.mnozstviSplnene;
	}

	public void setMnozstviSplnene(BigDecimal mnozstviSplnene) {
		this.mnozstviSplnene = mnozstviSplnene;
	}

	public BigDecimal getMnozstviZmetkove() {
		return this.mnozstviZmetkove;
	}

	public void setMnozstviZmetkove(BigDecimal mnozstviZmetkove) {
		this.mnozstviZmetkove = mnozstviZmetkove;
	}

	public String getOdpracoval() {
		return this.odpracoval;
	}

	public void setOdpracoval(String odpracoval) {
		this.odpracoval = odpracoval;
	}

	public String getOscislo() {
		return this.oscislo;
	}

	public void setOscislo(String oscislo) {
		this.oscislo = oscislo;
	}

	public String getPoznHl() {
		return this.poznHl;
	}

	public void setPoznHl(String poznHl) {
		this.poznHl = poznHl;
	}

	public String getPoznKrok() {
		return this.poznKrok;
	}

	public void setPoznKrok(String poznKrok) {
		this.poznKrok = poznKrok;
	}

	public String getPoznPoz() {
		return this.poznPoz;
	}

	public void setPoznPoz(String poznPoz) {
		this.poznPoz = poznPoz;
	}

	public String getPoznUkol() {
		return this.poznUkol;
	}

	public void setPoznUkol(String poznUkol) {
		this.poznUkol = poznUkol;
	}

	public String getPoznamka() {
		return this.poznamka;
	}

	public void setPoznamka(String poznamka) {
		this.poznamka = poznamka;
	}

	public String getPrac() {
		return this.prac;
	}

	public void setPrac(String prac) {
		this.prac = prac;
	}

	public String getRegCis() {
		return this.regCis;
	}

	public void setRegCis(String regCis) {
		this.regCis = regCis;
	}

	public BigDecimal getSazba() {
		return this.sazba;
	}

	public void setSazba(BigDecimal sazba) {
		this.sazba = sazba;
	}

	public String getStavV() {
		return this.stavV;
	}

	public void setStavV(String stavV) {
		this.stavV = stavV;
	}

	public String getStred() {
		return this.stred;
	}

	public void setStred(String stred) {
		this.stred = stred;
	}

	public String getStredmd() {
		return this.stredmd;
	}

	public void setStredmd(String stredmd) {
		this.stredmd = stredmd;
	}

	public String getVyrMisto() {
		return this.vyrMisto;
	}

	public void setVyrMisto(String vyrMisto) {
		this.vyrMisto = vyrMisto;
	}

	public String getZc() {
		return this.zc;
	}

	public void setZc(String zc) {
		this.zc = zc;
	}

	public String getZmetek() {
		return this.zmetek;
	}

	public void setZmetek(String zmetek) {
		this.zmetek = zmetek;
	}

}