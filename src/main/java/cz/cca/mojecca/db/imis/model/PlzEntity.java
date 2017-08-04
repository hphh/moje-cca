package cz.cca.mojecca.db.imis.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the PLZ database table.
 * 
 */
@Entity
@Table(name="PLZ")
@NamedQuery(name="PlzEntity.findAll", query="SELECT p FROM PlzEntity p")
public class PlzEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PlzEntityPK id;

	@Column(name="BEZESMLUVNI_FAKTURACE")
	private String bezesmluvniFakturace;

	@Column(name="CISLO_OBJ")
	private String cisloObj;

	@Column(name="CISLO_OBJ_POL")
	private BigDecimal cisloObjPol;

	@Column(name="CISLO_OBJEDNAVKY")
	private String cisloObjednavky;

	@Column(name="CISLO_POSL_DODATKU_SML")
	private String cisloPoslDodatkuSml;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_DODATKU")
	private Date datumDodatku;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_DODATKU_DO")
	private Date datumDodatkuDo;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_OBJEDNAVKY")
	private Date datumObjednavky;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_OBJEDNAVKY_DO")
	private Date datumObjednavkyDo;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_ZMENY")
	private Date datumZmeny;

	@Column(name="ID_FIR_VLASTNI_FIRMA")
	private String idFirVlastniFirma;

	@Column(name="ID_OBCHODNIHO_ZASTUPCE")
	private String idObchodnihoZastupce;

	@Column(name="ID_PROVOZOVATELE")
	private String idProvozovatele;

	private BigDecimal idplz;

	private BigDecimal idzak;

	private String kodpra;

	private String mj;

	private BigDecimal mnozstvi;

	private String npolzak;

	@Column(name="OZN_VYR")
	private String oznVyr;

	private String poznamka;

	@Column(name="STAV_DODATKU_SMLOUVY")
	private String stavDodatkuSmlouvy;

	@Column(name="STRED_VYROBY")
	private String stredVyroby;

	private String stzodb;

	@Temporal(TemporalType.DATE)
	private Date tpplz;

	@Temporal(TemporalType.DATE)
	@Column(name="TPPLZ_DO")
	private Date tpplzDo;

	public PlzEntity() {
	}

	public PlzEntityPK getId() {
		return this.id;
	}

	public void setId(PlzEntityPK id) {
		this.id = id;
	}

	public String getBezesmluvniFakturace() {
		return this.bezesmluvniFakturace;
	}

	public void setBezesmluvniFakturace(String bezesmluvniFakturace) {
		this.bezesmluvniFakturace = bezesmluvniFakturace;
	}

	public String getCisloObj() {
		return this.cisloObj;
	}

	public void setCisloObj(String cisloObj) {
		this.cisloObj = cisloObj;
	}

	public BigDecimal getCisloObjPol() {
		return this.cisloObjPol;
	}

	public void setCisloObjPol(BigDecimal cisloObjPol) {
		this.cisloObjPol = cisloObjPol;
	}

	public String getCisloObjednavky() {
		return this.cisloObjednavky;
	}

	public void setCisloObjednavky(String cisloObjednavky) {
		this.cisloObjednavky = cisloObjednavky;
	}

	public String getCisloPoslDodatkuSml() {
		return this.cisloPoslDodatkuSml;
	}

	public void setCisloPoslDodatkuSml(String cisloPoslDodatkuSml) {
		this.cisloPoslDodatkuSml = cisloPoslDodatkuSml;
	}

	public Date getDatumDodatku() {
		return this.datumDodatku;
	}

	public void setDatumDodatku(Date datumDodatku) {
		this.datumDodatku = datumDodatku;
	}

	public Date getDatumDodatkuDo() {
		return this.datumDodatkuDo;
	}

	public void setDatumDodatkuDo(Date datumDodatkuDo) {
		this.datumDodatkuDo = datumDodatkuDo;
	}

	public Date getDatumObjednavky() {
		return this.datumObjednavky;
	}

	public void setDatumObjednavky(Date datumObjednavky) {
		this.datumObjednavky = datumObjednavky;
	}

	public Date getDatumObjednavkyDo() {
		return this.datumObjednavkyDo;
	}

	public void setDatumObjednavkyDo(Date datumObjednavkyDo) {
		this.datumObjednavkyDo = datumObjednavkyDo;
	}

	public Date getDatumZmeny() {
		return this.datumZmeny;
	}

	public void setDatumZmeny(Date datumZmeny) {
		this.datumZmeny = datumZmeny;
	}

	public String getIdFirVlastniFirma() {
		return this.idFirVlastniFirma;
	}

	public void setIdFirVlastniFirma(String idFirVlastniFirma) {
		this.idFirVlastniFirma = idFirVlastniFirma;
	}

	public String getIdObchodnihoZastupce() {
		return this.idObchodnihoZastupce;
	}

	public void setIdObchodnihoZastupce(String idObchodnihoZastupce) {
		this.idObchodnihoZastupce = idObchodnihoZastupce;
	}

	public String getIdProvozovatele() {
		return this.idProvozovatele;
	}

	public void setIdProvozovatele(String idProvozovatele) {
		this.idProvozovatele = idProvozovatele;
	}

	public BigDecimal getIdplz() {
		return this.idplz;
	}

	public void setIdplz(BigDecimal idplz) {
		this.idplz = idplz;
	}

	public BigDecimal getIdzak() {
		return this.idzak;
	}

	public void setIdzak(BigDecimal idzak) {
		this.idzak = idzak;
	}

	public String getKodpra() {
		return this.kodpra;
	}

	public void setKodpra(String kodpra) {
		this.kodpra = kodpra;
	}

	public String getMj() {
		return this.mj;
	}

	public void setMj(String mj) {
		this.mj = mj;
	}

	public BigDecimal getMnozstvi() {
		return this.mnozstvi;
	}

	public void setMnozstvi(BigDecimal mnozstvi) {
		this.mnozstvi = mnozstvi;
	}

	public String getNpolzak() {
		return this.npolzak;
	}

	public void setNpolzak(String npolzak) {
		this.npolzak = npolzak;
	}

	public String getOznVyr() {
		return this.oznVyr;
	}

	public void setOznVyr(String oznVyr) {
		this.oznVyr = oznVyr;
	}

	public String getPoznamka() {
		return this.poznamka;
	}

	public void setPoznamka(String poznamka) {
		this.poznamka = poznamka;
	}

	public String getStavDodatkuSmlouvy() {
		return this.stavDodatkuSmlouvy;
	}

	public void setStavDodatkuSmlouvy(String stavDodatkuSmlouvy) {
		this.stavDodatkuSmlouvy = stavDodatkuSmlouvy;
	}

	public String getStredVyroby() {
		return this.stredVyroby;
	}

	public void setStredVyroby(String stredVyroby) {
		this.stredVyroby = stredVyroby;
	}

	public String getStzodb() {
		return this.stzodb;
	}

	public void setStzodb(String stzodb) {
		this.stzodb = stzodb;
	}

	public Date getTpplz() {
		return this.tpplz;
	}

	public void setTpplz(Date tpplz) {
		this.tpplz = tpplz;
	}

	public Date getTpplzDo() {
		return this.tpplzDo;
	}

	public void setTpplzDo(Date tpplzDo) {
		this.tpplzDo = tpplzDo;
	}

}