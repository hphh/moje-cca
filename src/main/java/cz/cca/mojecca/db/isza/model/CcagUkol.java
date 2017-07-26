package cz.cca.mojecca.db.isza.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the CCAG_UKOL database table.
 * 
 */
@Entity
@Table(name="CCAG_UKOL")
@NamedQuery(name="CcagUkol.findAll", query="SELECT c FROM CcagUkol c")
public class CcagUkol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_UKOLU")
	private long idUkolu;

	@Column(name="CISLO_HLASENI")
	private BigDecimal cisloHlaseni;

	@Column(name="CISLO_UKOLU")
	private Long cisloUkolu;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_I")
	private Date datumI;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_U")
	private Date datumU;

	@Column(name="ID_KROKU_PROJEKTU")
	private BigDecimal idKrokuProjektu;

	@Column(name="KOD_UZIVATELE_AKCEPT")
	private String kodUzivateleAkcept;

	@Column(name="KOD_UZIVATELE_RESITEL")
	private String kodUzivateleResitel;

	@Column(name="KOD_VYJADRENI_K_UKOLU")
	private BigDecimal kodVyjadreniKUkolu;

	@Column(name="KODPRA_I")
	private String kodpraI;

	@Column(name="KODPRA_U")
	private String kodpraU;

	@Column(name="NAZEV_UKOLU")
	private String nazevUkolu;

	@Column(name="POPIS_RESENI")
	private String popisReseni;

	private String poznamka;

	@Column(name="PRACNOST_PLAN")
	private BigDecimal pracnostPlan;

	@Column(name="PRIZNAK_AN_UKOL_STORNOVAN")
	private String priznakAnUkolStornovan;

	@Column(name="ROK_HLASENI")
	private BigDecimal rokHlaseni;

	@Column(name="ROK_UKOLU")
	private Long rokUkolu;

	@Column(name="STAV_PRED_STORNEM")
	private String stavPredStornem;

	@Column(name="STAV_UKOLU")
	private String stavUkolu;

	@Column(name="STORNO_UKOL_KAP")
	private String stornoUkolKap;

	@Temporal(TemporalType.DATE)
	@Column(name="TERMIN_AKCEPTACE_PLAN")
	private Date terminAkceptacePlan;

	@Temporal(TemporalType.DATE)
	@Column(name="TERMIN_AKCEPTACE_SKUT")
	private Date terminAkceptaceSkut;

	@Temporal(TemporalType.DATE)
	@Column(name="TERMIN_DORUCENI_PLAN")
	private Date terminDoruceniPlan;

	@Temporal(TemporalType.DATE)
	@Column(name="TERMIN_DORUCENI_SKUT")
	private Date terminDoruceniSkut;

	@Temporal(TemporalType.DATE)
	@Column(name="TERMIN_ZAHAJENI_PLAN")
	private Date terminZahajeniPlan;

	@Temporal(TemporalType.DATE)
	@Column(name="TERMIN_ZAHAJENI_SKUT")
	private Date terminZahajeniSkut;

	@Column(name="TMP_CISLO_POZADAVKU")
	private BigDecimal tmpCisloPozadavku;

	@Column(name="TMP_ROK_POZADAVKU")
	private BigDecimal tmpRokPozadavku;

	@Column(name="TYP_UKOLU")
	private String typUkolu;

	@Column(name="ZADANI_UKOLU")
	private String zadaniUkolu;

	private String zakazka;

	@Column(name="ZPUSOB_AKCEPTACE")
	private String zpusobAkceptace;

	public CcagUkol() {
	}

	public long getIdUkolu() {
		return this.idUkolu;
	}

	public void setIdUkolu(long idUkolu) {
		this.idUkolu = idUkolu;
	}

	public BigDecimal getCisloHlaseni() {
		return this.cisloHlaseni;
	}

	public void setCisloHlaseni(BigDecimal cisloHlaseni) {
		this.cisloHlaseni = cisloHlaseni;
	}

	public Long getCisloUkolu() {
		return this.cisloUkolu;
	}

	public void setCisloUkolu(Long cisloUkolu) {
		this.cisloUkolu = cisloUkolu;
	}

	public Date getDatumI() {
		return this.datumI;
	}

	public void setDatumI(Date datumI) {
		this.datumI = datumI;
	}

	public Date getDatumU() {
		return this.datumU;
	}

	public void setDatumU(Date datumU) {
		this.datumU = datumU;
	}

	public BigDecimal getIdKrokuProjektu() {
		return this.idKrokuProjektu;
	}

	public void setIdKrokuProjektu(BigDecimal idKrokuProjektu) {
		this.idKrokuProjektu = idKrokuProjektu;
	}

	public String getKodUzivateleAkcept() {
		return this.kodUzivateleAkcept;
	}

	public void setKodUzivateleAkcept(String kodUzivateleAkcept) {
		this.kodUzivateleAkcept = kodUzivateleAkcept;
	}

	public String getKodUzivateleResitel() {
		return this.kodUzivateleResitel;
	}

	public void setKodUzivateleResitel(String kodUzivateleResitel) {
		this.kodUzivateleResitel = kodUzivateleResitel;
	}

	public BigDecimal getKodVyjadreniKUkolu() {
		return this.kodVyjadreniKUkolu;
	}

	public void setKodVyjadreniKUkolu(BigDecimal kodVyjadreniKUkolu) {
		this.kodVyjadreniKUkolu = kodVyjadreniKUkolu;
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

	public String getNazevUkolu() {
		return this.nazevUkolu;
	}

	public void setNazevUkolu(String nazevUkolu) {
		this.nazevUkolu = nazevUkolu;
	}

	public String getPopisReseni() {
		return this.popisReseni;
	}

	public void setPopisReseni(String popisReseni) {
		this.popisReseni = popisReseni;
	}

	public String getPoznamka() {
		return this.poznamka;
	}

	public void setPoznamka(String poznamka) {
		this.poznamka = poznamka;
	}

	public BigDecimal getPracnostPlan() {
		return this.pracnostPlan;
	}

	public void setPracnostPlan(BigDecimal pracnostPlan) {
		this.pracnostPlan = pracnostPlan;
	}

	public String getPriznakAnUkolStornovan() {
		return this.priznakAnUkolStornovan;
	}

	public void setPriznakAnUkolStornovan(String priznakAnUkolStornovan) {
		this.priznakAnUkolStornovan = priznakAnUkolStornovan;
	}

	public BigDecimal getRokHlaseni() {
		return this.rokHlaseni;
	}

	public void setRokHlaseni(BigDecimal rokHlaseni) {
		this.rokHlaseni = rokHlaseni;
	}

	public Long getRokUkolu() {
		return this.rokUkolu;
	}

	public void setRokUkolu(Long rokUkolu) {
		this.rokUkolu = rokUkolu;
	}

	public String getStavPredStornem() {
		return this.stavPredStornem;
	}

	public void setStavPredStornem(String stavPredStornem) {
		this.stavPredStornem = stavPredStornem;
	}

	public String getStavUkolu() {
		return this.stavUkolu;
	}

	public void setStavUkolu(String stavUkolu) {
		this.stavUkolu = stavUkolu;
	}

	public String getStornoUkolKap() {
		return this.stornoUkolKap;
	}

	public void setStornoUkolKap(String stornoUkolKap) {
		this.stornoUkolKap = stornoUkolKap;
	}

	public Date getTerminAkceptacePlan() {
		return this.terminAkceptacePlan;
	}

	public void setTerminAkceptacePlan(Date terminAkceptacePlan) {
		this.terminAkceptacePlan = terminAkceptacePlan;
	}

	public Date getTerminAkceptaceSkut() {
		return this.terminAkceptaceSkut;
	}

	public void setTerminAkceptaceSkut(Date terminAkceptaceSkut) {
		this.terminAkceptaceSkut = terminAkceptaceSkut;
	}

	public Date getTerminDoruceniPlan() {
		return this.terminDoruceniPlan;
	}

	public void setTerminDoruceniPlan(Date terminDoruceniPlan) {
		this.terminDoruceniPlan = terminDoruceniPlan;
	}

	public Date getTerminDoruceniSkut() {
		return this.terminDoruceniSkut;
	}

	public void setTerminDoruceniSkut(Date terminDoruceniSkut) {
		this.terminDoruceniSkut = terminDoruceniSkut;
	}

	public Date getTerminZahajeniPlan() {
		return this.terminZahajeniPlan;
	}

	public void setTerminZahajeniPlan(Date terminZahajeniPlan) {
		this.terminZahajeniPlan = terminZahajeniPlan;
	}

	public Date getTerminZahajeniSkut() {
		return this.terminZahajeniSkut;
	}

	public void setTerminZahajeniSkut(Date terminZahajeniSkut) {
		this.terminZahajeniSkut = terminZahajeniSkut;
	}

	public BigDecimal getTmpCisloPozadavku() {
		return this.tmpCisloPozadavku;
	}

	public void setTmpCisloPozadavku(BigDecimal tmpCisloPozadavku) {
		this.tmpCisloPozadavku = tmpCisloPozadavku;
	}

	public BigDecimal getTmpRokPozadavku() {
		return this.tmpRokPozadavku;
	}

	public void setTmpRokPozadavku(BigDecimal tmpRokPozadavku) {
		this.tmpRokPozadavku = tmpRokPozadavku;
	}

	public String getTypUkolu() {
		return this.typUkolu;
	}

	public void setTypUkolu(String typUkolu) {
		this.typUkolu = typUkolu;
	}

	public String getZadaniUkolu() {
		return this.zadaniUkolu;
	}

	public void setZadaniUkolu(String zadaniUkolu) {
		this.zadaniUkolu = zadaniUkolu;
	}

	public String getZakazka() {
		return this.zakazka;
	}

	public void setZakazka(String zakazka) {
		this.zakazka = zakazka;
	}

	public String getZpusobAkceptace() {
		return this.zpusobAkceptace;
	}

	public void setZpusobAkceptace(String zpusobAkceptace) {
		this.zpusobAkceptace = zpusobAkceptace;
	}

}