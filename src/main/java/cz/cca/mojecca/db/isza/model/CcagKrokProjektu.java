package cz.cca.mojecca.db.isza.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the CCAG_KROK_PROJEKTU database table.
 * 
 */
@Entity
@Table(name="CCAG_KROK_PROJEKTU")
@NamedQuery(name="CcagKrokProjektu.findAll", query="SELECT c FROM CcagKrokProjektu c")
public class CcagKrokProjektu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_KROKU_PROJEKTU")
	private long idKrokuProjektu;

	@Column(name="CISLO_KROKU")
	private Long cisloKroku;

	@Column(name="CISLO_REVIZE")
	private BigDecimal cisloRevize;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_I")
	private Date datumI;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_U")
	private Date datumU;

	private String dokument;

	@Column(name="DRUH_KROKU")
	private String druhKroku;

	@Column(name="ID_PLANU_PROJEKTU")
	private BigDecimal idPlanuProjektu;

	@Column(name="ID_PROFESNIHO_STREDISKA")
	private BigDecimal idProfesnihoStrediska;

	@Column(name="KOD_UZIVATELE_AKCEPT")
	private String kodUzivateleAkcept;

	@Column(name="KOD_UZIVATELE_RESITEL")
	private String kodUzivateleResitel;

	@Column(name="KODPRA_I")
	private String kodpraI;

	@Column(name="KODPRA_U")
	private String kodpraU;

	@Column(name="NAZEV_KROKU")
	private String nazevKroku;

	@Column(name="NAZEV_KROKU_VLASTNI")
	private String nazevKrokuVlastni;

	@Column(name="POPIS_KROKU")
	private String popisKroku;

	@Column(name="POPIS_RESENI")
	private String popisReseni;

	private BigDecimal poradi;

	@Column(name="PRACNOST_PLAN")
	private BigDecimal pracnostPlan;

	@Column(name="PRIZNAK_AN_POVINNY")
	private String priznakAnPovinny;

	@Column(name="ROK_KROKU")
	private Long rokKroku;

	@Column(name="STAV_DOKUMENTU")
	private String stavDokumentu;

	@Column(name="STAV_KROKU")
	private String stavKroku;

	@Column(name="STAV_PRED_STORNEM")
	private String stavPredStornem;

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

	private String zakazka;

	@Column(name="ZPUSOB_AKCEPTACE")
	private String zpusobAkceptace;

	public CcagKrokProjektu() {
	}

	public long getIdKrokuProjektu() {
		return this.idKrokuProjektu;
	}

	public void setIdKrokuProjektu(long idKrokuProjektu) {
		this.idKrokuProjektu = idKrokuProjektu;
	}

	public Long getCisloKroku() {
		return this.cisloKroku;
	}

	public void setCisloKroku(Long cisloKroku) {
		this.cisloKroku = cisloKroku;
	}

	public BigDecimal getCisloRevize() {
		return this.cisloRevize;
	}

	public void setCisloRevize(BigDecimal cisloRevize) {
		this.cisloRevize = cisloRevize;
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

	public String getDokument() {
		return this.dokument;
	}

	public void setDokument(String dokument) {
		this.dokument = dokument;
	}

	public String getDruhKroku() {
		return this.druhKroku;
	}

	public void setDruhKroku(String druhKroku) {
		this.druhKroku = druhKroku;
	}

	public BigDecimal getIdPlanuProjektu() {
		return this.idPlanuProjektu;
	}

	public void setIdPlanuProjektu(BigDecimal idPlanuProjektu) {
		this.idPlanuProjektu = idPlanuProjektu;
	}

	public BigDecimal getIdProfesnihoStrediska() {
		return this.idProfesnihoStrediska;
	}

	public void setIdProfesnihoStrediska(BigDecimal idProfesnihoStrediska) {
		this.idProfesnihoStrediska = idProfesnihoStrediska;
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

	public String getNazevKroku() {
		return this.nazevKroku;
	}

	public void setNazevKroku(String nazevKroku) {
		this.nazevKroku = nazevKroku;
	}

	public String getNazevKrokuVlastni() {
		return this.nazevKrokuVlastni;
	}

	public void setNazevKrokuVlastni(String nazevKrokuVlastni) {
		this.nazevKrokuVlastni = nazevKrokuVlastni;
	}

	public String getPopisKroku() {
		return this.popisKroku;
	}

	public void setPopisKroku(String popisKroku) {
		this.popisKroku = popisKroku;
	}

	public String getPopisReseni() {
		return this.popisReseni;
	}

	public void setPopisReseni(String popisReseni) {
		this.popisReseni = popisReseni;
	}

	public BigDecimal getPoradi() {
		return this.poradi;
	}

	public void setPoradi(BigDecimal poradi) {
		this.poradi = poradi;
	}

	public BigDecimal getPracnostPlan() {
		return this.pracnostPlan;
	}

	public void setPracnostPlan(BigDecimal pracnostPlan) {
		this.pracnostPlan = pracnostPlan;
	}

	public String getPriznakAnPovinny() {
		return this.priznakAnPovinny;
	}

	public void setPriznakAnPovinny(String priznakAnPovinny) {
		this.priznakAnPovinny = priznakAnPovinny;
	}

	public Long getRokKroku() {
		return this.rokKroku;
	}

	public void setRokKroku(Long rokKroku) {
		this.rokKroku = rokKroku;
	}

	public String getStavDokumentu() {
		return this.stavDokumentu;
	}

	public void setStavDokumentu(String stavDokumentu) {
		this.stavDokumentu = stavDokumentu;
	}

	public String getStavKroku() {
		return this.stavKroku;
	}

	public void setStavKroku(String stavKroku) {
		this.stavKroku = stavKroku;
	}

	public String getStavPredStornem() {
		return this.stavPredStornem;
	}

	public void setStavPredStornem(String stavPredStornem) {
		this.stavPredStornem = stavPredStornem;
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