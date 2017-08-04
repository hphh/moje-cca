package cz.cca.mojecca.db.isza.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the CCAG_HLASENI database table.
 * 
 */
@Entity
@Table(name="CCAG_HLASENI")
@NamedQuery(name="CcagHlaseni.findAll", query="SELECT c FROM CcagHlaseni c")
public class CcagHlaseni implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CcagHlaseniPK id;

	@Column(name="CAS_ZANESENI_VADY")
	private String casZaneseniVady;

	@Column(name="CILOVA_VERZE")
	private String cilovaVerze;

	@Column(name="CISLO_HLASENI_EXTERNI")
	private String cisloHlaseniExterni;

	@Column(name="CISLO_HLASENI_VADY")
	private BigDecimal cisloHlaseniVady;

	@Column(name="CISLO_MATERSKE_HLASENI")
	private BigDecimal cisloMaterskeHlaseni;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_AKCEPTACE")
	private Date datumAkceptace;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_I")
	private Date datumI;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_INFO")
	private Date datumInfo;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_INFO_RESITELE")
	private Date datumInfoResitele;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_ODESLANI_EMAILU")
	private Date datumOdeslaniEmailu;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_U")
	private Date datumU;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_VYJADRENI_ZAKAZNIKA")
	private Date datumVyjadreniZakaznika;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_VYRIZENI_HLASENI")
	private Date datumVyrizeniHlaseni;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_VYRIZENI_HLASENI_RES")
	private Date datumVyrizeniHlaseniRes;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_VZNIKU")
	private Date datumVzniku;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_ZAPISU_VYRIZENI_NA_WWW")
	private Date datumZapisuVyrizeniNaWww;

	@Column(name="DRUH_HLASENI")
	private String druhHlaseni;

	private String dulezite;

	@Column(name="DUVOD_NEAKCEPTOVANI")
	private String duvodNeakceptovani;

	@Column(name="FAZE_NALEZU_VADY")
	private String fazeNalezuVady;

	@Column(name="ID_AKTUALNE_U")
	private String idAktualneU;

	@Column(name="ID_APLIKACE")
	private BigDecimal idAplikace;

	@Column(name="ID_FIRMY_ZAK")
	private String idFirmyZak;

	@Column(name="ID_KROKU_PROJEKTU")
	private BigDecimal idKrokuProjektu;

	@Column(name="ID_UKOLU")
	private BigDecimal idUkolu;

	@Column(name="ID_ZAKAZNIKA")
	private String idZakaznika;

	private String klisl1;

	private String klisl2;

	private String klisl3;

	@Column(name="KOD_UZIVATELE_INFO")
	private String kodUzivateleInfo;

	@Column(name="KOD_UZIVATELE_RESI")
	private String kodUzivateleResi;

	@Column(name="KOD_UZIVATELE_RESI_RES")
	private String kodUzivateleResiRes;

	@Column(name="KOD_UZIVATELE_VYRIDIL")
	private String kodUzivateleVyridil;

	@Column(name="KOD_UZIVATELE_VYRIDIL_RES")
	private String kodUzivateleVyridilRes;

	@Column(name="KODPRA_I")
	private String kodpraI;

	@Column(name="KODPRA_U")
	private String kodpraU;

	private String nazev;

	private String objednavka;

	@Column(name="ODDELENI_RESI")
	private String oddeleniResi;

	@Column(name="ODDELENI_RESI_RES")
	private String oddeleniResiRes;

	@Column(name="ODPOVEDNOST_ZA_VADU")
	private String odpovednostZaVadu;

	@Column(name="POPIS_PROC_PROSLO")
	private String popisProcProslo;

	@Column(name="POPIS_VADY")
	private String popisVady;

	private String poznamka;

	private BigDecimal pracnost;

	@Column(name="PRACNOST_DOC")
	private BigDecimal pracnostDoc;

	@Column(name="PRACNOST_PRG")
	private BigDecimal pracnostPrg;

	@Column(name="PRACNOST_PROJ")
	private BigDecimal pracnostProj;

	@Column(name="PRACNOST_TST")
	private BigDecimal pracnostTst;

	@Column(name="PRACNOST_TST_AP")
	private BigDecimal pracnostTstAp;

	@Column(name="PREDMET_VADY")
	private String predmetVady;

	private BigDecimal priorita;

	@Column(name="PRIZNAK_AN_HLAS_PRO_VSE_WWW")
	private String priznakAnHlasProVseWww;

	@Column(name="PRIZNAK_AN_SCHVALENO")
	private String priznakAnSchvaleno;

	@Column(name="PRIZNAK_AN_ZVEREJNIT_WWW")
	private String priznakAnZverejnitWww;

	@Column(name="PRIZNAK_HLASENI_ZOBRAZENO")
	private String priznakHlaseniZobrazeno;

	@Column(name="ROK_HLASENI_VADY")
	private BigDecimal rokHlaseniVady;

	@Column(name="ROK_MATERSKE_HLASENI")
	private BigDecimal rokMaterskeHlaseni;

	@Column(name="SKUPINA_ULOH")
	private String skupinaUloh;

	@Column(name="STAV_AKCEPTACE")
	private String stavAkceptace;

	@Column(name="STAV_HLASENI")
	private String stavHlaseni;

	@Column(name="\"SYSTEM\"")
	private String system;

	@Temporal(TemporalType.DATE)
	private Date termin;

	@Temporal(TemporalType.DATE)
	@Column(name="TERMIN_RES")
	private Date terminRes;

	@Column(name="TEXT_HLASENI")
	private String textHlaseni;

	@Column(name="TEXT_HLASENI_WWW")
	private String textHlaseniWww;

	@Column(name="TEXT_VYRIZENI")
	private String textVyrizeni;

	@Column(name="TEXT_VYRIZENI_WWW")
	private String textVyrizeniWww;

	private String uzavreno;

	@Column(name="VERZE_APLIKACE_NALEZU_VADY")
	private String verzeAplikaceNalezuVady;

	@Column(name="VERZE_DISTRIBUCE")
	private String verzeDistribuce;

	private String vinik;

	@Column(name="VYJADRENI_RESITELE")
	private String vyjadreniResitele;

	@Column(name="VZNIK_HLASENI")
	private String vznikHlaseni;

	private String zakazka;

	@Column(name="ZAVAZNOST_VADY")
	private BigDecimal zavaznostVady;

	@Column(name="ZDUVODNENI_ODPOVEDNOSTI")
	private String zduvodneniOdpovednosti;

	@Column(name="ZMENA_VINIKA")
	private String zmenaVinika;

	public CcagHlaseni() {
	}

	public CcagHlaseniPK getId() {
		return this.id;
	}

	public void setId(CcagHlaseniPK id) {
		this.id = id;
	}

	public String getCasZaneseniVady() {
		return this.casZaneseniVady;
	}

	public void setCasZaneseniVady(String casZaneseniVady) {
		this.casZaneseniVady = casZaneseniVady;
	}

	public String getCilovaVerze() {
		return this.cilovaVerze;
	}

	public void setCilovaVerze(String cilovaVerze) {
		this.cilovaVerze = cilovaVerze;
	}

	public String getCisloHlaseniExterni() {
		return this.cisloHlaseniExterni;
	}

	public void setCisloHlaseniExterni(String cisloHlaseniExterni) {
		this.cisloHlaseniExterni = cisloHlaseniExterni;
	}

	public BigDecimal getCisloHlaseniVady() {
		return this.cisloHlaseniVady;
	}

	public void setCisloHlaseniVady(BigDecimal cisloHlaseniVady) {
		this.cisloHlaseniVady = cisloHlaseniVady;
	}

	public BigDecimal getCisloMaterskeHlaseni() {
		return this.cisloMaterskeHlaseni;
	}

	public void setCisloMaterskeHlaseni(BigDecimal cisloMaterskeHlaseni) {
		this.cisloMaterskeHlaseni = cisloMaterskeHlaseni;
	}

	public Date getDatumAkceptace() {
		return this.datumAkceptace;
	}

	public void setDatumAkceptace(Date datumAkceptace) {
		this.datumAkceptace = datumAkceptace;
	}

	public Date getDatumI() {
		return this.datumI;
	}

	public void setDatumI(Date datumI) {
		this.datumI = datumI;
	}

	public Date getDatumInfo() {
		return this.datumInfo;
	}

	public void setDatumInfo(Date datumInfo) {
		this.datumInfo = datumInfo;
	}

	public Date getDatumInfoResitele() {
		return this.datumInfoResitele;
	}

	public void setDatumInfoResitele(Date datumInfoResitele) {
		this.datumInfoResitele = datumInfoResitele;
	}

	public Date getDatumOdeslaniEmailu() {
		return this.datumOdeslaniEmailu;
	}

	public void setDatumOdeslaniEmailu(Date datumOdeslaniEmailu) {
		this.datumOdeslaniEmailu = datumOdeslaniEmailu;
	}

	public Date getDatumU() {
		return this.datumU;
	}

	public void setDatumU(Date datumU) {
		this.datumU = datumU;
	}

	public Date getDatumVyjadreniZakaznika() {
		return this.datumVyjadreniZakaznika;
	}

	public void setDatumVyjadreniZakaznika(Date datumVyjadreniZakaznika) {
		this.datumVyjadreniZakaznika = datumVyjadreniZakaznika;
	}

	public Date getDatumVyrizeniHlaseni() {
		return this.datumVyrizeniHlaseni;
	}

	public void setDatumVyrizeniHlaseni(Date datumVyrizeniHlaseni) {
		this.datumVyrizeniHlaseni = datumVyrizeniHlaseni;
	}

	public Date getDatumVyrizeniHlaseniRes() {
		return this.datumVyrizeniHlaseniRes;
	}

	public void setDatumVyrizeniHlaseniRes(Date datumVyrizeniHlaseniRes) {
		this.datumVyrizeniHlaseniRes = datumVyrizeniHlaseniRes;
	}

	public Date getDatumVzniku() {
		return this.datumVzniku;
	}

	public void setDatumVzniku(Date datumVzniku) {
		this.datumVzniku = datumVzniku;
	}

	public Date getDatumZapisuVyrizeniNaWww() {
		return this.datumZapisuVyrizeniNaWww;
	}

	public void setDatumZapisuVyrizeniNaWww(Date datumZapisuVyrizeniNaWww) {
		this.datumZapisuVyrizeniNaWww = datumZapisuVyrizeniNaWww;
	}

	public String getDruhHlaseni() {
		return this.druhHlaseni;
	}

	public void setDruhHlaseni(String druhHlaseni) {
		this.druhHlaseni = druhHlaseni;
	}

	public String getDulezite() {
		return this.dulezite;
	}

	public void setDulezite(String dulezite) {
		this.dulezite = dulezite;
	}

	public String getDuvodNeakceptovani() {
		return this.duvodNeakceptovani;
	}

	public void setDuvodNeakceptovani(String duvodNeakceptovani) {
		this.duvodNeakceptovani = duvodNeakceptovani;
	}

	public String getFazeNalezuVady() {
		return this.fazeNalezuVady;
	}

	public void setFazeNalezuVady(String fazeNalezuVady) {
		this.fazeNalezuVady = fazeNalezuVady;
	}

	public String getIdAktualneU() {
		return this.idAktualneU;
	}

	public void setIdAktualneU(String idAktualneU) {
		this.idAktualneU = idAktualneU;
	}

	public BigDecimal getIdAplikace() {
		return this.idAplikace;
	}

	public void setIdAplikace(BigDecimal idAplikace) {
		this.idAplikace = idAplikace;
	}

	public String getIdFirmyZak() {
		return this.idFirmyZak;
	}

	public void setIdFirmyZak(String idFirmyZak) {
		this.idFirmyZak = idFirmyZak;
	}

	public BigDecimal getIdKrokuProjektu() {
		return this.idKrokuProjektu;
	}

	public void setIdKrokuProjektu(BigDecimal idKrokuProjektu) {
		this.idKrokuProjektu = idKrokuProjektu;
	}

	public BigDecimal getIdUkolu() {
		return this.idUkolu;
	}

	public void setIdUkolu(BigDecimal idUkolu) {
		this.idUkolu = idUkolu;
	}

	public String getIdZakaznika() {
		return this.idZakaznika;
	}

	public void setIdZakaznika(String idZakaznika) {
		this.idZakaznika = idZakaznika;
	}

	public String getKlisl1() {
		return this.klisl1;
	}

	public void setKlisl1(String klisl1) {
		this.klisl1 = klisl1;
	}

	public String getKlisl2() {
		return this.klisl2;
	}

	public void setKlisl2(String klisl2) {
		this.klisl2 = klisl2;
	}

	public String getKlisl3() {
		return this.klisl3;
	}

	public void setKlisl3(String klisl3) {
		this.klisl3 = klisl3;
	}

	public String getKodUzivateleInfo() {
		return this.kodUzivateleInfo;
	}

	public void setKodUzivateleInfo(String kodUzivateleInfo) {
		this.kodUzivateleInfo = kodUzivateleInfo;
	}

	public String getKodUzivateleResi() {
		return this.kodUzivateleResi;
	}

	public void setKodUzivateleResi(String kodUzivateleResi) {
		this.kodUzivateleResi = kodUzivateleResi;
	}

	public String getKodUzivateleResiRes() {
		return this.kodUzivateleResiRes;
	}

	public void setKodUzivateleResiRes(String kodUzivateleResiRes) {
		this.kodUzivateleResiRes = kodUzivateleResiRes;
	}

	public String getKodUzivateleVyridil() {
		return this.kodUzivateleVyridil;
	}

	public void setKodUzivateleVyridil(String kodUzivateleVyridil) {
		this.kodUzivateleVyridil = kodUzivateleVyridil;
	}

	public String getKodUzivateleVyridilRes() {
		return this.kodUzivateleVyridilRes;
	}

	public void setKodUzivateleVyridilRes(String kodUzivateleVyridilRes) {
		this.kodUzivateleVyridilRes = kodUzivateleVyridilRes;
	}

	public String getKodpraI() {
		return this.kodpraI;
	}

	public void setKodpraI(String kodpraI) {
		this.kodpraI = kodpraI;
	}

	public String getKodpraU() {
		return this.kodpraU;
	}

	public void setKodpraU(String kodpraU) {
		this.kodpraU = kodpraU;
	}

	public String getNazev() {
		return this.nazev;
	}

	public void setNazev(String nazev) {
		this.nazev = nazev;
	}

	public String getObjednavka() {
		return this.objednavka;
	}

	public void setObjednavka(String objednavka) {
		this.objednavka = objednavka;
	}

	public String getOddeleniResi() {
		return this.oddeleniResi;
	}

	public void setOddeleniResi(String oddeleniResi) {
		this.oddeleniResi = oddeleniResi;
	}

	public String getOddeleniResiRes() {
		return this.oddeleniResiRes;
	}

	public void setOddeleniResiRes(String oddeleniResiRes) {
		this.oddeleniResiRes = oddeleniResiRes;
	}

	public String getOdpovednostZaVadu() {
		return this.odpovednostZaVadu;
	}

	public void setOdpovednostZaVadu(String odpovednostZaVadu) {
		this.odpovednostZaVadu = odpovednostZaVadu;
	}

	public String getPopisProcProslo() {
		return this.popisProcProslo;
	}

	public void setPopisProcProslo(String popisProcProslo) {
		this.popisProcProslo = popisProcProslo;
	}

	public String getPopisVady() {
		return this.popisVady;
	}

	public void setPopisVady(String popisVady) {
		this.popisVady = popisVady;
	}

	public String getPoznamka() {
		return this.poznamka;
	}

	public void setPoznamka(String poznamka) {
		this.poznamka = poznamka;
	}

	public BigDecimal getPracnost() {
		return this.pracnost;
	}

	public void setPracnost(BigDecimal pracnost) {
		this.pracnost = pracnost;
	}

	public BigDecimal getPracnostDoc() {
		return this.pracnostDoc;
	}

	public void setPracnostDoc(BigDecimal pracnostDoc) {
		this.pracnostDoc = pracnostDoc;
	}

	public BigDecimal getPracnostPrg() {
		return this.pracnostPrg;
	}

	public void setPracnostPrg(BigDecimal pracnostPrg) {
		this.pracnostPrg = pracnostPrg;
	}

	public BigDecimal getPracnostProj() {
		return this.pracnostProj;
	}

	public void setPracnostProj(BigDecimal pracnostProj) {
		this.pracnostProj = pracnostProj;
	}

	public BigDecimal getPracnostTst() {
		return this.pracnostTst;
	}

	public void setPracnostTst(BigDecimal pracnostTst) {
		this.pracnostTst = pracnostTst;
	}

	public BigDecimal getPracnostTstAp() {
		return this.pracnostTstAp;
	}

	public void setPracnostTstAp(BigDecimal pracnostTstAp) {
		this.pracnostTstAp = pracnostTstAp;
	}

	public String getPredmetVady() {
		return this.predmetVady;
	}

	public void setPredmetVady(String predmetVady) {
		this.predmetVady = predmetVady;
	}

	public BigDecimal getPriorita() {
		return this.priorita;
	}

	public void setPriorita(BigDecimal priorita) {
		this.priorita = priorita;
	}

	public String getPriznakAnHlasProVseWww() {
		return this.priznakAnHlasProVseWww;
	}

	public void setPriznakAnHlasProVseWww(String priznakAnHlasProVseWww) {
		this.priznakAnHlasProVseWww = priznakAnHlasProVseWww;
	}

	public String getPriznakAnSchvaleno() {
		return this.priznakAnSchvaleno;
	}

	public void setPriznakAnSchvaleno(String priznakAnSchvaleno) {
		this.priznakAnSchvaleno = priznakAnSchvaleno;
	}

	public String getPriznakAnZverejnitWww() {
		return this.priznakAnZverejnitWww;
	}

	public void setPriznakAnZverejnitWww(String priznakAnZverejnitWww) {
		this.priznakAnZverejnitWww = priznakAnZverejnitWww;
	}

	public String getPriznakHlaseniZobrazeno() {
		return this.priznakHlaseniZobrazeno;
	}

	public void setPriznakHlaseniZobrazeno(String priznakHlaseniZobrazeno) {
		this.priznakHlaseniZobrazeno = priznakHlaseniZobrazeno;
	}

	public BigDecimal getRokHlaseniVady() {
		return this.rokHlaseniVady;
	}

	public void setRokHlaseniVady(BigDecimal rokHlaseniVady) {
		this.rokHlaseniVady = rokHlaseniVady;
	}

	public BigDecimal getRokMaterskeHlaseni() {
		return this.rokMaterskeHlaseni;
	}

	public void setRokMaterskeHlaseni(BigDecimal rokMaterskeHlaseni) {
		this.rokMaterskeHlaseni = rokMaterskeHlaseni;
	}

	public String getSkupinaUloh() {
		return this.skupinaUloh;
	}

	public void setSkupinaUloh(String skupinaUloh) {
		this.skupinaUloh = skupinaUloh;
	}

	public String getStavAkceptace() {
		return this.stavAkceptace;
	}

	public void setStavAkceptace(String stavAkceptace) {
		this.stavAkceptace = stavAkceptace;
	}

	public String getStavHlaseni() {
		return this.stavHlaseni;
	}

	public void setStavHlaseni(String stavHlaseni) {
		this.stavHlaseni = stavHlaseni;
	}

	public String getSystem() {
		return this.system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public Date getTermin() {
		return this.termin;
	}

	public void setTermin(Date termin) {
		this.termin = termin;
	}

	public Date getTerminRes() {
		return this.terminRes;
	}

	public void setTerminRes(Date terminRes) {
		this.terminRes = terminRes;
	}

	public String getTextHlaseni() {
		return this.textHlaseni;
	}

	public void setTextHlaseni(String textHlaseni) {
		this.textHlaseni = textHlaseni;
	}

	public String getTextHlaseniWww() {
		return this.textHlaseniWww;
	}

	public void setTextHlaseniWww(String textHlaseniWww) {
		this.textHlaseniWww = textHlaseniWww;
	}

	public String getTextVyrizeni() {
		return this.textVyrizeni;
	}

	public void setTextVyrizeni(String textVyrizeni) {
		this.textVyrizeni = textVyrizeni;
	}

	public String getTextVyrizeniWww() {
		return this.textVyrizeniWww;
	}

	public void setTextVyrizeniWww(String textVyrizeniWww) {
		this.textVyrizeniWww = textVyrizeniWww;
	}

	public String getUzavreno() {
		return this.uzavreno;
	}

	public void setUzavreno(String uzavreno) {
		this.uzavreno = uzavreno;
	}

	public String getVerzeAplikaceNalezuVady() {
		return this.verzeAplikaceNalezuVady;
	}

	public void setVerzeAplikaceNalezuVady(String verzeAplikaceNalezuVady) {
		this.verzeAplikaceNalezuVady = verzeAplikaceNalezuVady;
	}

	public String getVerzeDistribuce() {
		return this.verzeDistribuce;
	}

	public void setVerzeDistribuce(String verzeDistribuce) {
		this.verzeDistribuce = verzeDistribuce;
	}

	public String getVinik() {
		return this.vinik;
	}

	public void setVinik(String vinik) {
		this.vinik = vinik;
	}

	public String getVyjadreniResitele() {
		return this.vyjadreniResitele;
	}

	public void setVyjadreniResitele(String vyjadreniResitele) {
		this.vyjadreniResitele = vyjadreniResitele;
	}

	public String getVznikHlaseni() {
		return this.vznikHlaseni;
	}

	public void setVznikHlaseni(String vznikHlaseni) {
		this.vznikHlaseni = vznikHlaseni;
	}

	public String getZakazka() {
		return this.zakazka;
	}

	public void setZakazka(String zakazka) {
		this.zakazka = zakazka;
	}

	public BigDecimal getZavaznostVady() {
		return this.zavaznostVady;
	}

	public void setZavaznostVady(BigDecimal zavaznostVady) {
		this.zavaznostVady = zavaznostVady;
	}

	public String getZduvodneniOdpovednosti() {
		return this.zduvodneniOdpovednosti;
	}

	public void setZduvodneniOdpovednosti(String zduvodneniOdpovednosti) {
		this.zduvodneniOdpovednosti = zduvodneniOdpovednosti;
	}

	public String getZmenaVinika() {
		return this.zmenaVinika;
	}

	public void setZmenaVinika(String zmenaVinika) {
		this.zmenaVinika = zmenaVinika;
	}

}