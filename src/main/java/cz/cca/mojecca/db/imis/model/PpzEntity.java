package cz.cca.mojecca.db.imis.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the PPZ database table.
 * 
 */
@Entity
@Table(name="PPZ")
@NamedQuery(name="PpzEntity.findAll", query="SELECT p FROM PpzEntity p")
public class PpzEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PpzEntityPK id;

	private BigDecimal baleni;

	@Column(name="CENA_POZ")
	private BigDecimal cenaPoz;

	private BigDecimal cenappz;

	@Column(name="CERPANI_CELEHO_CREDITU")
	private String cerpaniCelehoCreditu;

	@Column(name="CISDOKL_PROVIZE")
	private BigDecimal cisdoklProvize;

	@Column(name="CISLO_DODATKU_SMLOUVY")
	private String cisloDodatkuSmlouvy;

	@Column(name="CISLO_OBJ")
	private String cisloObj;

	@Column(name="CISLO_OBJ_POL")
	private BigDecimal cisloObjPol;

	@Column(name="CISLO_OBJ_POZ")
	private BigDecimal cisloObjPoz;

	@Column(name="CISLO_POZ")
	private BigDecimal cisloPoz;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_IU")
	private Date datumIu;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_PLATNOSTI_CENY")
	private Date datumPlatnostiCeny;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_POCATKU_FAKTURACE")
	private Date datumPocatkuFakturace;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_PROVIZE")
	private Date datumProvize;

	@Column(name="DEFINICE_KLASIFIKACE")
	private String definiceKlasifikace;

	@Column(name="DEN_FAKTURACE_V_MESICI")
	private BigDecimal denFakturaceVMesici;

	private BigDecimal dopravne;

	@Temporal(TemporalType.DATE)
	private Date dpppz;

	private String drpoh;

	@Column(name="DRUH_CENY")
	private String druhCeny;

	private String garant;

	@Column(name="ID_OBCHODNIHO_ZASTUPCE")
	private String idObchodnihoZastupce;

	@Column(name="ID_PROVOZOVATELE")
	private String idProvozovatele;

	@Column(name="ID_ZAS_VYR")
	private BigDecimal idZasVyr;

	private BigDecimal idplz;

	private BigDecimal idppz;

	private BigDecimal idzak;

	private BigDecimal io;

	@Column(name="KOD_SKYNET")
	private BigDecimal kodSkynet;

	private String kodpra;

	@Column(name="KODPRA_IU")
	private String kodpraIu;

	private String mj;

	private BigDecimal mnpoz;

	private String mnskl;

	private BigDecimal mnvyr;

	private String nazev;

	@Column(name="ODBERNI_MISTO")
	private String odberniMisto;

	@Column(name="OZN_VYR")
	private String oznVyr;

	@Column(name="PERIODA_FAKTURACE")
	private BigDecimal periodaFakturace;

	@Temporal(TemporalType.DATE)
	@Column(name="PLATNOST_PROVIZE_DO")
	private Date platnostProvizeDo;

	@Temporal(TemporalType.DATE)
	@Column(name="PLATNOST_PROVIZE_OD")
	private Date platnostProvizeOd;

	@Column(name="POCET_DNU_BEZPLATNEHO_PRIPOJ")
	private BigDecimal pocetDnuBezplatnehoPripoj;

	@Column(name="POCET_UHRAD_PRED_IMISEM")
	private BigDecimal pocetUhradPredImisem;

	private String popis;

	@Column(name="POZAD_KLASIF_TRIDA")
	private BigDecimal pozadKlasifTrida;

	private String poznamka;

	@Column(name="PRIZNAK_FAKTUROVAT_ZALOHOVE")
	private String priznakFakturovatZalohove;

	@Column(name="PRIZNAK_MILNIK")
	private String priznakMilnik;

	@Column(name="PRIZNAK_VYPOCTU_PROVIZE")
	private String priznakVypoctuProvize;

	@Column(name="PRIZNAK_ZMENY_PROGRAMU")
	private String priznakZmenyProgramu;

	private String procedura;

	@Column(name="ROK_DOKLADU_PROVIZE")
	private BigDecimal rokDokladuProvize;

	@Column(name="ROK_POZ")
	private BigDecimal rokPoz;

	@Column(name="SKLAD_POZ_NA_VYD")
	private String skladPozNaVyd;

	private BigDecimal sleva;

	@Column(name="SLUZBA_JE_ZAHRNUTA_VE_VYP_ODM")
	private String sluzbaJeZahrnutaVeVypOdm;

	@Column(name="SLUZBA_JE_ZAHRNUTA_VE_VYP_PROV")
	private String sluzbaJeZahrnutaVeVypProv;

	@Column(name="SLUZBA_JE_ZPOPLATNOVANA")
	private String sluzbaJeZpoplatnovana;

	private String stav;

	private String stpzexp;

	private String stpzfakt;

	private String stpzmtz;

	private String stpzodb;

	private String stpzskl;

	private String stpzvyr;

	@Column(name="STRED_VYDEJ")
	private String stredVydej;

	@Column(name="STRED_VYROBY")
	private String stredVyroby;

	@Column(name="TARIFIKOVANE_MNOZSTVI")
	private BigDecimal tarifikovaneMnozstvi;

	@Temporal(TemporalType.DATE)
	@Column(name="TERMIN_PLNENI_DO")
	private Date terminPlneniDo;

	@Temporal(TemporalType.DATE)
	@Column(name="TERMIN_PLNENI_OD")
	private Date terminPlneniOd;

	@Column(name="TYP_BALENI")
	private String typBaleni;

	@Column(name="ZNDOKL_PROVIZE")
	private String zndoklProvize;

	private String znspoj;

	@Column(name="ZOBRAZ_V_POROVNANI")
	private String zobrazVPorovnani;

	public PpzEntity() {
	}

	public PpzEntityPK getId() {
		return this.id;
	}

	public void setId(PpzEntityPK id) {
		this.id = id;
	}

	public BigDecimal getBaleni() {
		return this.baleni;
	}

	public void setBaleni(BigDecimal baleni) {
		this.baleni = baleni;
	}

	public BigDecimal getCenaPoz() {
		return this.cenaPoz;
	}

	public void setCenaPoz(BigDecimal cenaPoz) {
		this.cenaPoz = cenaPoz;
	}

	public BigDecimal getCenappz() {
		return this.cenappz;
	}

	public void setCenappz(BigDecimal cenappz) {
		this.cenappz = cenappz;
	}

	public String getCerpaniCelehoCreditu() {
		return this.cerpaniCelehoCreditu;
	}

	public void setCerpaniCelehoCreditu(String cerpaniCelehoCreditu) {
		this.cerpaniCelehoCreditu = cerpaniCelehoCreditu;
	}

	public BigDecimal getCisdoklProvize() {
		return this.cisdoklProvize;
	}

	public void setCisdoklProvize(BigDecimal cisdoklProvize) {
		this.cisdoklProvize = cisdoklProvize;
	}

	public String getCisloDodatkuSmlouvy() {
		return this.cisloDodatkuSmlouvy;
	}

	public void setCisloDodatkuSmlouvy(String cisloDodatkuSmlouvy) {
		this.cisloDodatkuSmlouvy = cisloDodatkuSmlouvy;
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

	public BigDecimal getCisloObjPoz() {
		return this.cisloObjPoz;
	}

	public void setCisloObjPoz(BigDecimal cisloObjPoz) {
		this.cisloObjPoz = cisloObjPoz;
	}

	public BigDecimal getCisloPoz() {
		return this.cisloPoz;
	}

	public void setCisloPoz(BigDecimal cisloPoz) {
		this.cisloPoz = cisloPoz;
	}

	public Date getDatumIu() {
		return this.datumIu;
	}

	public void setDatumIu(Date datumIu) {
		this.datumIu = datumIu;
	}

	public Date getDatumPlatnostiCeny() {
		return this.datumPlatnostiCeny;
	}

	public void setDatumPlatnostiCeny(Date datumPlatnostiCeny) {
		this.datumPlatnostiCeny = datumPlatnostiCeny;
	}

	public Date getDatumPocatkuFakturace() {
		return this.datumPocatkuFakturace;
	}

	public void setDatumPocatkuFakturace(Date datumPocatkuFakturace) {
		this.datumPocatkuFakturace = datumPocatkuFakturace;
	}

	public Date getDatumProvize() {
		return this.datumProvize;
	}

	public void setDatumProvize(Date datumProvize) {
		this.datumProvize = datumProvize;
	}

	public String getDefiniceKlasifikace() {
		return this.definiceKlasifikace;
	}

	public void setDefiniceKlasifikace(String definiceKlasifikace) {
		this.definiceKlasifikace = definiceKlasifikace;
	}

	public BigDecimal getDenFakturaceVMesici() {
		return this.denFakturaceVMesici;
	}

	public void setDenFakturaceVMesici(BigDecimal denFakturaceVMesici) {
		this.denFakturaceVMesici = denFakturaceVMesici;
	}

	public BigDecimal getDopravne() {
		return this.dopravne;
	}

	public void setDopravne(BigDecimal dopravne) {
		this.dopravne = dopravne;
	}

	public Date getDpppz() {
		return this.dpppz;
	}

	public void setDpppz(Date dpppz) {
		this.dpppz = dpppz;
	}

	public String getDrpoh() {
		return this.drpoh;
	}

	public void setDrpoh(String drpoh) {
		this.drpoh = drpoh;
	}

	public String getDruhCeny() {
		return this.druhCeny;
	}

	public void setDruhCeny(String druhCeny) {
		this.druhCeny = druhCeny;
	}

	public String getGarant() {
		return this.garant;
	}

	public void setGarant(String garant) {
		this.garant = garant;
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

	public BigDecimal getIdZasVyr() {
		return this.idZasVyr;
	}

	public void setIdZasVyr(BigDecimal idZasVyr) {
		this.idZasVyr = idZasVyr;
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

	public BigDecimal getKodSkynet() {
		return this.kodSkynet;
	}

	public void setKodSkynet(BigDecimal kodSkynet) {
		this.kodSkynet = kodSkynet;
	}

	public String getKodpra() {
		return this.kodpra;
	}

	public void setKodpra(String kodpra) {
		this.kodpra = kodpra;
	}

	public String getKodpraIu() {
		return this.kodpraIu;
	}

	public void setKodpraIu(String kodpraIu) {
		this.kodpraIu = kodpraIu;
	}

	public String getMj() {
		return this.mj;
	}

	public void setMj(String mj) {
		this.mj = mj;
	}

	public BigDecimal getMnpoz() {
		return this.mnpoz;
	}

	public void setMnpoz(BigDecimal mnpoz) {
		this.mnpoz = mnpoz;
	}

	public String getMnskl() {
		return this.mnskl;
	}

	public void setMnskl(String mnskl) {
		this.mnskl = mnskl;
	}

	public BigDecimal getMnvyr() {
		return this.mnvyr;
	}

	public void setMnvyr(BigDecimal mnvyr) {
		this.mnvyr = mnvyr;
	}

	public String getNazev() {
		return this.nazev;
	}

	public void setNazev(String nazev) {
		this.nazev = nazev;
	}

	public String getOdberniMisto() {
		return this.odberniMisto;
	}

	public void setOdberniMisto(String odberniMisto) {
		this.odberniMisto = odberniMisto;
	}

	public String getOznVyr() {
		return this.oznVyr;
	}

	public void setOznVyr(String oznVyr) {
		this.oznVyr = oznVyr;
	}

	public BigDecimal getPeriodaFakturace() {
		return this.periodaFakturace;
	}

	public void setPeriodaFakturace(BigDecimal periodaFakturace) {
		this.periodaFakturace = periodaFakturace;
	}

	public Date getPlatnostProvizeDo() {
		return this.platnostProvizeDo;
	}

	public void setPlatnostProvizeDo(Date platnostProvizeDo) {
		this.platnostProvizeDo = platnostProvizeDo;
	}

	public Date getPlatnostProvizeOd() {
		return this.platnostProvizeOd;
	}

	public void setPlatnostProvizeOd(Date platnostProvizeOd) {
		this.platnostProvizeOd = platnostProvizeOd;
	}

	public BigDecimal getPocetDnuBezplatnehoPripoj() {
		return this.pocetDnuBezplatnehoPripoj;
	}

	public void setPocetDnuBezplatnehoPripoj(BigDecimal pocetDnuBezplatnehoPripoj) {
		this.pocetDnuBezplatnehoPripoj = pocetDnuBezplatnehoPripoj;
	}

	public BigDecimal getPocetUhradPredImisem() {
		return this.pocetUhradPredImisem;
	}

	public void setPocetUhradPredImisem(BigDecimal pocetUhradPredImisem) {
		this.pocetUhradPredImisem = pocetUhradPredImisem;
	}

	public String getPopis() {
		return this.popis;
	}

	public void setPopis(String popis) {
		this.popis = popis;
	}

	public BigDecimal getPozadKlasifTrida() {
		return this.pozadKlasifTrida;
	}

	public void setPozadKlasifTrida(BigDecimal pozadKlasifTrida) {
		this.pozadKlasifTrida = pozadKlasifTrida;
	}

	public String getPoznamka() {
		return this.poznamka;
	}

	public void setPoznamka(String poznamka) {
		this.poznamka = poznamka;
	}

	public String getPriznakFakturovatZalohove() {
		return this.priznakFakturovatZalohove;
	}

	public void setPriznakFakturovatZalohove(String priznakFakturovatZalohove) {
		this.priznakFakturovatZalohove = priznakFakturovatZalohove;
	}

	public String getPriznakMilnik() {
		return this.priznakMilnik;
	}

	public void setPriznakMilnik(String priznakMilnik) {
		this.priznakMilnik = priznakMilnik;
	}

	public String getPriznakVypoctuProvize() {
		return this.priznakVypoctuProvize;
	}

	public void setPriznakVypoctuProvize(String priznakVypoctuProvize) {
		this.priznakVypoctuProvize = priznakVypoctuProvize;
	}

	public String getPriznakZmenyProgramu() {
		return this.priznakZmenyProgramu;
	}

	public void setPriznakZmenyProgramu(String priznakZmenyProgramu) {
		this.priznakZmenyProgramu = priznakZmenyProgramu;
	}

	public String getProcedura() {
		return this.procedura;
	}

	public void setProcedura(String procedura) {
		this.procedura = procedura;
	}

	public BigDecimal getRokDokladuProvize() {
		return this.rokDokladuProvize;
	}

	public void setRokDokladuProvize(BigDecimal rokDokladuProvize) {
		this.rokDokladuProvize = rokDokladuProvize;
	}

	public BigDecimal getRokPoz() {
		return this.rokPoz;
	}

	public void setRokPoz(BigDecimal rokPoz) {
		this.rokPoz = rokPoz;
	}

	public String getSkladPozNaVyd() {
		return this.skladPozNaVyd;
	}

	public void setSkladPozNaVyd(String skladPozNaVyd) {
		this.skladPozNaVyd = skladPozNaVyd;
	}

	public BigDecimal getSleva() {
		return this.sleva;
	}

	public void setSleva(BigDecimal sleva) {
		this.sleva = sleva;
	}

	public String getSluzbaJeZahrnutaVeVypOdm() {
		return this.sluzbaJeZahrnutaVeVypOdm;
	}

	public void setSluzbaJeZahrnutaVeVypOdm(String sluzbaJeZahrnutaVeVypOdm) {
		this.sluzbaJeZahrnutaVeVypOdm = sluzbaJeZahrnutaVeVypOdm;
	}

	public String getSluzbaJeZahrnutaVeVypProv() {
		return this.sluzbaJeZahrnutaVeVypProv;
	}

	public void setSluzbaJeZahrnutaVeVypProv(String sluzbaJeZahrnutaVeVypProv) {
		this.sluzbaJeZahrnutaVeVypProv = sluzbaJeZahrnutaVeVypProv;
	}

	public String getSluzbaJeZpoplatnovana() {
		return this.sluzbaJeZpoplatnovana;
	}

	public void setSluzbaJeZpoplatnovana(String sluzbaJeZpoplatnovana) {
		this.sluzbaJeZpoplatnovana = sluzbaJeZpoplatnovana;
	}

	public String getStav() {
		return this.stav;
	}

	public void setStav(String stav) {
		this.stav = stav;
	}

	public String getStpzexp() {
		return this.stpzexp;
	}

	public void setStpzexp(String stpzexp) {
		this.stpzexp = stpzexp;
	}

	public String getStpzfakt() {
		return this.stpzfakt;
	}

	public void setStpzfakt(String stpzfakt) {
		this.stpzfakt = stpzfakt;
	}

	public String getStpzmtz() {
		return this.stpzmtz;
	}

	public void setStpzmtz(String stpzmtz) {
		this.stpzmtz = stpzmtz;
	}

	public String getStpzodb() {
		return this.stpzodb;
	}

	public void setStpzodb(String stpzodb) {
		this.stpzodb = stpzodb;
	}

	public String getStpzskl() {
		return this.stpzskl;
	}

	public void setStpzskl(String stpzskl) {
		this.stpzskl = stpzskl;
	}

	public String getStpzvyr() {
		return this.stpzvyr;
	}

	public void setStpzvyr(String stpzvyr) {
		this.stpzvyr = stpzvyr;
	}

	public String getStredVydej() {
		return this.stredVydej;
	}

	public void setStredVydej(String stredVydej) {
		this.stredVydej = stredVydej;
	}

	public String getStredVyroby() {
		return this.stredVyroby;
	}

	public void setStredVyroby(String stredVyroby) {
		this.stredVyroby = stredVyroby;
	}

	public BigDecimal getTarifikovaneMnozstvi() {
		return this.tarifikovaneMnozstvi;
	}

	public void setTarifikovaneMnozstvi(BigDecimal tarifikovaneMnozstvi) {
		this.tarifikovaneMnozstvi = tarifikovaneMnozstvi;
	}

	public Date getTerminPlneniDo() {
		return this.terminPlneniDo;
	}

	public void setTerminPlneniDo(Date terminPlneniDo) {
		this.terminPlneniDo = terminPlneniDo;
	}

	public Date getTerminPlneniOd() {
		return this.terminPlneniOd;
	}

	public void setTerminPlneniOd(Date terminPlneniOd) {
		this.terminPlneniOd = terminPlneniOd;
	}

	public String getTypBaleni() {
		return this.typBaleni;
	}

	public void setTypBaleni(String typBaleni) {
		this.typBaleni = typBaleni;
	}

	public String getZndoklProvize() {
		return this.zndoklProvize;
	}

	public void setZndoklProvize(String zndoklProvize) {
		this.zndoklProvize = zndoklProvize;
	}

	public String getZnspoj() {
		return this.znspoj;
	}

	public void setZnspoj(String znspoj) {
		this.znspoj = znspoj;
	}

	public String getZobrazVPorovnani() {
		return this.zobrazVPorovnani;
	}

	public void setZobrazVPorovnani(String zobrazVPorovnani) {
		this.zobrazVPorovnani = zobrazVPorovnani;
	}

}