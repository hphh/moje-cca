package cz.cca.mojecca.db.imis.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the ZAK database table.
 * 
 */
@Entity
@Table(name="ZAK")
public class ZakEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private String akce;

	private String bankucet;

	@Column(name="BANKUCET_NAS")
	private String bankucetNas;

	@Column(name="C_NAB")
	private BigDecimal cNab;

	@Column(name="CENA_ZAK")
	private BigDecimal cenaZak;

	@Column(name="CISLO_OBJ")
	private String cisloObj;

	private String cisobj;

	private String cnab;

	@Column(name="CPOL_UCT")
	private BigDecimal cpolUct;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_OBJ")
	private Date datObj;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_PLATN_SML")
	private Date datPlatnSml;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_POTVR_OBJ")
	private Date datPotvrObj;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_POTVRZ")
	private Date datPotvrz;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_SML")
	private Date datSml;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_ZAC_VYR")
	private Date datZacVyr;

	@Temporal(TemporalType.DATE)
	private Date datspl;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_DP")
	private Date datumDp;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_IU")
	private Date datumIu;

	@Column(name="DOD_PODM")
	private String dodPodm;

	@Column(name="DOTACNI_PROJEKT")
	private String dotacniProjekt;

	@Temporal(TemporalType.DATE)
	private Date dpzak;

	@Column(name="DRUH_CENY")
	private String druhCeny;

	private String duvod;

	@Column(name="EKON_ZNAK")
	private String ekonZnak;

	@Column(name="ELEKTRONICKE_FAKTURY")
	private String elektronickeFaktury;

	@Column(name="ELEKTRONICKE_ZALOHOVE_FAKTURY")
	private String elektronickeZalohoveFaktury;

	private String garant;

	private String garant2;

	@Column(name="HR_ZISK")
	private BigDecimal hrZisk;

	@Column(name="ID_FIR_BSP")
	private String idFirBsp;

	@Column(name="ID_FIR_PL")
	private String idFirPl;

	@Column(name="ID_FIR_ZAK")
	private String idFirZak;

	@Column(name="ID_OBCHODNIHO_ZASTUPCE")
	private String idObchodnihoZastupce;

	@Column(name="ID_POZNAMKY")
	private String idPoznamky;

	private BigDecimal idadr;

	private BigDecimal idadrpl;

	private BigDecimal idfy;

	private BigDecimal idzak;

	private String incoterms;

	@Column(name="INSPEKCNI_ORGAN")
	private String inspekcniOrgan;

	@Column(name="KOD_DOPRAVA_INTRASTAT")
	private String kodDopravaIntrastat;

	@Column(name="KOD_TRANSAKCE_INTRASTAT")
	private String kodTransakceIntrastat;

	@Column(name="KOD_ZAK")
	private String kodZak;

	private String kodbank;

	@Column(name="KODBANK_NAS")
	private String kodbankNas;

	private String kodpra;

	@Column(name="KODPRA_IU")
	private String kodpraIu;

	private BigDecimal koef;

	private String konstrukter;

	private BigDecimal kurs;

	@Column(name="KURS_MNOZSTVI")
	private BigDecimal kursMnozstvi;

	private BigDecimal kurz1;

	private BigDecimal kurz2;

	@Column(name="MANAZER_KVALITY")
	private String manazerKvality;

	private String mena;

	@Column(name="MENA_DP")
	private String menaDp;

	@Column(name="MISTO_DODANI")
	private String mistoDodani;

	private String nakupci;

	private String nazzak;

	@Column(name="NORMA_JAK")
	private String normaJak;

	private String obor;

	private BigDecimal planzn;

	private BigDecimal popl;

	private String pozzak;

	@Column(name="PRIORITA_DODAVKY")
	private BigDecimal prioritaDodavky;

	@Column(name="PRIZNAK_EXPEDOVAT_PO_CASTECH")
	private String priznakExpedovatPoCastech;

	@Column(name="PRIZNAK_FAKTUROVAT_SAMOSTATNE")
	private String priznakFakturovatSamostatne;

	private String prodejce;

	private String regcis;

	@Column(name="REV_ZAK")
	private BigDecimal revZak;

	private String schvaluje;

	private String skp;

	private String smlouva;

	@Column(name="SPECIFIKACE_OBJEDNAVKY")
	private String specifikaceObjednavky;

	private BigDecimal splatnost;

	@Column(name="STAV_CENY")
	private String stavCeny;

	@Column(name="STAV_SMLOUVY")
	private String stavSmlouvy;

	private String stred;

	@Column(name="STRED_REALIZACNI")
	private String stredRealizacni;

	@Column(name="STRED_VYDEJ")
	private String stredVydej;

	private String stzdil;

	private String stzexp;

	private String stzfakt;

	private String stzmtz;

	private String stzodb;

	private String stzskl;

	private String stzvyr;

	private String subsegment;

	@Column(name="TEXT_OBJEDNAVKA")
	private String textObjednavka;

	@Temporal(TemporalType.DATE)
	private Date tpzak;

	@Temporal(TemporalType.DATE)
	@Column(name="TPZAK_DO")
	private Date tpzakDo;

	@Column(name="TYP_ZAKAZKY")
	private String typZakazky;

	private String typzak;

	private BigDecimal verze;

	@Column(name="VJ_KODPRA")
	private String vjKodpra;

	@Column(name="VJ_POZNAMKA")
	private String vjPoznamka;

	@Column(name="VJ_PRIZNAK")
	private String vjPriznak;

	@Column(name="VYSE_DP")
	private BigDecimal vyseDp;

	@Id
	private String zc;

	@Column(name="ZC_UCT")
	private String zcUct;

	@Column(name="ZEME_URC")
	private String zemeUrc;

	@Column(name="ZPUSOB_PLATBY")
	private String zpusobPlatby;

	public ZakEntity() {
	}

	public String getAkce() {
		return this.akce;
	}

	public void setAkce(String akce) {
		this.akce = akce;
	}

	public String getBankucet() {
		return this.bankucet;
	}

	public void setBankucet(String bankucet) {
		this.bankucet = bankucet;
	}

	public String getBankucetNas() {
		return this.bankucetNas;
	}

	public void setBankucetNas(String bankucetNas) {
		this.bankucetNas = bankucetNas;
	}

	public BigDecimal getCNab() {
		return this.cNab;
	}

	public void setCNab(BigDecimal cNab) {
		this.cNab = cNab;
	}

	public BigDecimal getCenaZak() {
		return this.cenaZak;
	}

	public void setCenaZak(BigDecimal cenaZak) {
		this.cenaZak = cenaZak;
	}

	public String getCisloObj() {
		return this.cisloObj;
	}

	public void setCisloObj(String cisloObj) {
		this.cisloObj = cisloObj;
	}

	public String getCisobj() {
		return this.cisobj;
	}

	public void setCisobj(String cisobj) {
		this.cisobj = cisobj;
	}

	public String getCnab() {
		return this.cnab;
	}

	public void setCnab(String cnab) {
		this.cnab = cnab;
	}

	public BigDecimal getCpolUct() {
		return this.cpolUct;
	}

	public void setCpolUct(BigDecimal cpolUct) {
		this.cpolUct = cpolUct;
	}

	public Date getDatObj() {
		return this.datObj;
	}

	public void setDatObj(Date datObj) {
		this.datObj = datObj;
	}

	public Date getDatPlatnSml() {
		return this.datPlatnSml;
	}

	public void setDatPlatnSml(Date datPlatnSml) {
		this.datPlatnSml = datPlatnSml;
	}

	public Date getDatPotvrObj() {
		return this.datPotvrObj;
	}

	public void setDatPotvrObj(Date datPotvrObj) {
		this.datPotvrObj = datPotvrObj;
	}

	public Date getDatPotvrz() {
		return this.datPotvrz;
	}

	public void setDatPotvrz(Date datPotvrz) {
		this.datPotvrz = datPotvrz;
	}

	public Date getDatSml() {
		return this.datSml;
	}

	public void setDatSml(Date datSml) {
		this.datSml = datSml;
	}

	public Date getDatZacVyr() {
		return this.datZacVyr;
	}

	public void setDatZacVyr(Date datZacVyr) {
		this.datZacVyr = datZacVyr;
	}

	public Date getDatspl() {
		return this.datspl;
	}

	public void setDatspl(Date datspl) {
		this.datspl = datspl;
	}

	public Date getDatumDp() {
		return this.datumDp;
	}

	public void setDatumDp(Date datumDp) {
		this.datumDp = datumDp;
	}

	public Date getDatumIu() {
		return this.datumIu;
	}

	public void setDatumIu(Date datumIu) {
		this.datumIu = datumIu;
	}

	public String getDodPodm() {
		return this.dodPodm;
	}

	public void setDodPodm(String dodPodm) {
		this.dodPodm = dodPodm;
	}

	public String getDotacniProjekt() {
		return this.dotacniProjekt;
	}

	public void setDotacniProjekt(String dotacniProjekt) {
		this.dotacniProjekt = dotacniProjekt;
	}

	public Date getDpzak() {
		return this.dpzak;
	}

	public void setDpzak(Date dpzak) {
		this.dpzak = dpzak;
	}

	public String getDruhCeny() {
		return this.druhCeny;
	}

	public void setDruhCeny(String druhCeny) {
		this.druhCeny = druhCeny;
	}

	public String getDuvod() {
		return this.duvod;
	}

	public void setDuvod(String duvod) {
		this.duvod = duvod;
	}

	public String getEkonZnak() {
		return this.ekonZnak;
	}

	public void setEkonZnak(String ekonZnak) {
		this.ekonZnak = ekonZnak;
	}

	public String getElektronickeFaktury() {
		return this.elektronickeFaktury;
	}

	public void setElektronickeFaktury(String elektronickeFaktury) {
		this.elektronickeFaktury = elektronickeFaktury;
	}

	public String getElektronickeZalohoveFaktury() {
		return this.elektronickeZalohoveFaktury;
	}

	public void setElektronickeZalohoveFaktury(String elektronickeZalohoveFaktury) {
		this.elektronickeZalohoveFaktury = elektronickeZalohoveFaktury;
	}

	public String getGarant() {
		return this.garant;
	}

	public void setGarant(String garant) {
		this.garant = garant;
	}

	public String getGarant2() {
		return this.garant2;
	}

	public void setGarant2(String garant2) {
		this.garant2 = garant2;
	}

	public BigDecimal getHrZisk() {
		return this.hrZisk;
	}

	public void setHrZisk(BigDecimal hrZisk) {
		this.hrZisk = hrZisk;
	}

	public String getIdFirBsp() {
		return this.idFirBsp;
	}

	public void setIdFirBsp(String idFirBsp) {
		this.idFirBsp = idFirBsp;
	}

	public String getIdFirPl() {
		return this.idFirPl;
	}

	public void setIdFirPl(String idFirPl) {
		this.idFirPl = idFirPl;
	}

	public String getIdFirZak() {
		return this.idFirZak;
	}

	public void setIdFirZak(String idFirZak) {
		this.idFirZak = idFirZak;
	}

	public String getIdObchodnihoZastupce() {
		return this.idObchodnihoZastupce;
	}

	public void setIdObchodnihoZastupce(String idObchodnihoZastupce) {
		this.idObchodnihoZastupce = idObchodnihoZastupce;
	}

	public String getIdPoznamky() {
		return this.idPoznamky;
	}

	public void setIdPoznamky(String idPoznamky) {
		this.idPoznamky = idPoznamky;
	}

	public BigDecimal getIdadr() {
		return this.idadr;
	}

	public void setIdadr(BigDecimal idadr) {
		this.idadr = idadr;
	}

	public BigDecimal getIdadrpl() {
		return this.idadrpl;
	}

	public void setIdadrpl(BigDecimal idadrpl) {
		this.idadrpl = idadrpl;
	}

	public BigDecimal getIdfy() {
		return this.idfy;
	}

	public void setIdfy(BigDecimal idfy) {
		this.idfy = idfy;
	}

	public BigDecimal getIdzak() {
		return this.idzak;
	}

	public void setIdzak(BigDecimal idzak) {
		this.idzak = idzak;
	}

	public String getIncoterms() {
		return this.incoterms;
	}

	public void setIncoterms(String incoterms) {
		this.incoterms = incoterms;
	}

	public String getInspekcniOrgan() {
		return this.inspekcniOrgan;
	}

	public void setInspekcniOrgan(String inspekcniOrgan) {
		this.inspekcniOrgan = inspekcniOrgan;
	}

	public String getKodDopravaIntrastat() {
		return this.kodDopravaIntrastat;
	}

	public void setKodDopravaIntrastat(String kodDopravaIntrastat) {
		this.kodDopravaIntrastat = kodDopravaIntrastat;
	}

	public String getKodTransakceIntrastat() {
		return this.kodTransakceIntrastat;
	}

	public void setKodTransakceIntrastat(String kodTransakceIntrastat) {
		this.kodTransakceIntrastat = kodTransakceIntrastat;
	}

	public String getKodZak() {
		return this.kodZak;
	}

	public void setKodZak(String kodZak) {
		this.kodZak = kodZak;
	}

	public String getKodbank() {
		return this.kodbank;
	}

	public void setKodbank(String kodbank) {
		this.kodbank = kodbank;
	}

	public String getKodbankNas() {
		return this.kodbankNas;
	}

	public void setKodbankNas(String kodbankNas) {
		this.kodbankNas = kodbankNas;
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

	public BigDecimal getKoef() {
		return this.koef;
	}

	public void setKoef(BigDecimal koef) {
		this.koef = koef;
	}

	public String getKonstrukter() {
		return this.konstrukter;
	}

	public void setKonstrukter(String konstrukter) {
		this.konstrukter = konstrukter;
	}

	public BigDecimal getKurs() {
		return this.kurs;
	}

	public void setKurs(BigDecimal kurs) {
		this.kurs = kurs;
	}

	public BigDecimal getKursMnozstvi() {
		return this.kursMnozstvi;
	}

	public void setKursMnozstvi(BigDecimal kursMnozstvi) {
		this.kursMnozstvi = kursMnozstvi;
	}

	public BigDecimal getKurz1() {
		return this.kurz1;
	}

	public void setKurz1(BigDecimal kurz1) {
		this.kurz1 = kurz1;
	}

	public BigDecimal getKurz2() {
		return this.kurz2;
	}

	public void setKurz2(BigDecimal kurz2) {
		this.kurz2 = kurz2;
	}

	public String getManazerKvality() {
		return this.manazerKvality;
	}

	public void setManazerKvality(String manazerKvality) {
		this.manazerKvality = manazerKvality;
	}

	public String getMena() {
		return this.mena;
	}

	public void setMena(String mena) {
		this.mena = mena;
	}

	public String getMenaDp() {
		return this.menaDp;
	}

	public void setMenaDp(String menaDp) {
		this.menaDp = menaDp;
	}

	public String getMistoDodani() {
		return this.mistoDodani;
	}

	public void setMistoDodani(String mistoDodani) {
		this.mistoDodani = mistoDodani;
	}

	public String getNakupci() {
		return this.nakupci;
	}

	public void setNakupci(String nakupci) {
		this.nakupci = nakupci;
	}

	public String getNazzak() {
		return this.nazzak;
	}

	public void setNazzak(String nazzak) {
		this.nazzak = nazzak;
	}

	public String getNormaJak() {
		return this.normaJak;
	}

	public void setNormaJak(String normaJak) {
		this.normaJak = normaJak;
	}

	public String getObor() {
		return this.obor;
	}

	public void setObor(String obor) {
		this.obor = obor;
	}

	public BigDecimal getPlanzn() {
		return this.planzn;
	}

	public void setPlanzn(BigDecimal planzn) {
		this.planzn = planzn;
	}

	public BigDecimal getPopl() {
		return this.popl;
	}

	public void setPopl(BigDecimal popl) {
		this.popl = popl;
	}

	public String getPozzak() {
		return this.pozzak;
	}

	public void setPozzak(String pozzak) {
		this.pozzak = pozzak;
	}

	public BigDecimal getPrioritaDodavky() {
		return this.prioritaDodavky;
	}

	public void setPrioritaDodavky(BigDecimal prioritaDodavky) {
		this.prioritaDodavky = prioritaDodavky;
	}

	public String getPriznakExpedovatPoCastech() {
		return this.priznakExpedovatPoCastech;
	}

	public void setPriznakExpedovatPoCastech(String priznakExpedovatPoCastech) {
		this.priznakExpedovatPoCastech = priznakExpedovatPoCastech;
	}

	public String getPriznakFakturovatSamostatne() {
		return this.priznakFakturovatSamostatne;
	}

	public void setPriznakFakturovatSamostatne(String priznakFakturovatSamostatne) {
		this.priznakFakturovatSamostatne = priznakFakturovatSamostatne;
	}

	public String getProdejce() {
		return this.prodejce;
	}

	public void setProdejce(String prodejce) {
		this.prodejce = prodejce;
	}

	public String getRegcis() {
		return this.regcis;
	}

	public void setRegcis(String regcis) {
		this.regcis = regcis;
	}

	public BigDecimal getRevZak() {
		return this.revZak;
	}

	public void setRevZak(BigDecimal revZak) {
		this.revZak = revZak;
	}

	public String getSchvaluje() {
		return this.schvaluje;
	}

	public void setSchvaluje(String schvaluje) {
		this.schvaluje = schvaluje;
	}

	public String getSkp() {
		return this.skp;
	}

	public void setSkp(String skp) {
		this.skp = skp;
	}

	public String getSmlouva() {
		return this.smlouva;
	}

	public void setSmlouva(String smlouva) {
		this.smlouva = smlouva;
	}

	public String getSpecifikaceObjednavky() {
		return this.specifikaceObjednavky;
	}

	public void setSpecifikaceObjednavky(String specifikaceObjednavky) {
		this.specifikaceObjednavky = specifikaceObjednavky;
	}

	public BigDecimal getSplatnost() {
		return this.splatnost;
	}

	public void setSplatnost(BigDecimal splatnost) {
		this.splatnost = splatnost;
	}

	public String getStavCeny() {
		return this.stavCeny;
	}

	public void setStavCeny(String stavCeny) {
		this.stavCeny = stavCeny;
	}

	public String getStavSmlouvy() {
		return this.stavSmlouvy;
	}

	public void setStavSmlouvy(String stavSmlouvy) {
		this.stavSmlouvy = stavSmlouvy;
	}

	public String getStred() {
		return this.stred;
	}

	public void setStred(String stred) {
		this.stred = stred;
	}

	public String getStredRealizacni() {
		return this.stredRealizacni;
	}

	public void setStredRealizacni(String stredRealizacni) {
		this.stredRealizacni = stredRealizacni;
	}

	public String getStredVydej() {
		return this.stredVydej;
	}

	public void setStredVydej(String stredVydej) {
		this.stredVydej = stredVydej;
	}

	public String getStzdil() {
		return this.stzdil;
	}

	public void setStzdil(String stzdil) {
		this.stzdil = stzdil;
	}

	public String getStzexp() {
		return this.stzexp;
	}

	public void setStzexp(String stzexp) {
		this.stzexp = stzexp;
	}

	public String getStzfakt() {
		return this.stzfakt;
	}

	public void setStzfakt(String stzfakt) {
		this.stzfakt = stzfakt;
	}

	public String getStzmtz() {
		return this.stzmtz;
	}

	public void setStzmtz(String stzmtz) {
		this.stzmtz = stzmtz;
	}

	public String getStzodb() {
		return this.stzodb;
	}

	public void setStzodb(String stzodb) {
		this.stzodb = stzodb;
	}

	public String getStzskl() {
		return this.stzskl;
	}

	public void setStzskl(String stzskl) {
		this.stzskl = stzskl;
	}

	public String getStzvyr() {
		return this.stzvyr;
	}

	public void setStzvyr(String stzvyr) {
		this.stzvyr = stzvyr;
	}

	public String getSubsegment() {
		return this.subsegment;
	}

	public void setSubsegment(String subsegment) {
		this.subsegment = subsegment;
	}

	public String getTextObjednavka() {
		return this.textObjednavka;
	}

	public void setTextObjednavka(String textObjednavka) {
		this.textObjednavka = textObjednavka;
	}

	public Date getTpzak() {
		return this.tpzak;
	}

	public void setTpzak(Date tpzak) {
		this.tpzak = tpzak;
	}

	public Date getTpzakDo() {
		return this.tpzakDo;
	}

	public void setTpzakDo(Date tpzakDo) {
		this.tpzakDo = tpzakDo;
	}

	public String getTypZakazky() {
		return this.typZakazky;
	}

	public void setTypZakazky(String typZakazky) {
		this.typZakazky = typZakazky;
	}

	public String getTypzak() {
		return this.typzak;
	}

	public void setTypzak(String typzak) {
		this.typzak = typzak;
	}

	public BigDecimal getVerze() {
		return this.verze;
	}

	public void setVerze(BigDecimal verze) {
		this.verze = verze;
	}

	public String getVjKodpra() {
		return this.vjKodpra;
	}

	public void setVjKodpra(String vjKodpra) {
		this.vjKodpra = vjKodpra;
	}

	public String getVjPoznamka() {
		return this.vjPoznamka;
	}

	public void setVjPoznamka(String vjPoznamka) {
		this.vjPoznamka = vjPoznamka;
	}

	public String getVjPriznak() {
		return this.vjPriznak;
	}

	public void setVjPriznak(String vjPriznak) {
		this.vjPriznak = vjPriznak;
	}

	public BigDecimal getVyseDp() {
		return this.vyseDp;
	}

	public void setVyseDp(BigDecimal vyseDp) {
		this.vyseDp = vyseDp;
	}

	public String getZc() {
		return this.zc;
	}

	public void setZc(String zc) {
		this.zc = zc;
	}

	public String getZcUct() {
		return this.zcUct;
	}

	public void setZcUct(String zcUct) {
		this.zcUct = zcUct;
	}

	public String getZemeUrc() {
		return this.zemeUrc;
	}

	public void setZemeUrc(String zemeUrc) {
		this.zemeUrc = zemeUrc;
	}

	public String getZpusobPlatby() {
		return this.zpusobPlatby;
	}

	public void setZpusobPlatby(String zpusobPlatby) {
		this.zpusobPlatby = zpusobPlatby;
	}

}