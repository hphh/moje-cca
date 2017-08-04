package cz.cca.mojecca.service.isza.model;

import java.math.BigDecimal;

public class Krok {
	
	private Long idKrokuProjektu;
	private BigDecimal cisloKroku;
	private BigDecimal cisloRevize;
	private BigDecimal datumI;
	private BigDecimal datumU;
	private String dokument;
	private String druhKroku;
	private BigDecimal idPlanuProjektu;
	private BigDecimal idProfesnihoStrediska;
	private String kodUzivateleAkcept;
	private String kodUzivateleResitel;
	private String kodpraI;
	private String kodpraU;
	private String nazevKroku;
	private String nazevKrokuVlastni;
	private String popisKroku;
	private String popisReseni;
	private BigDecimal poradi;
	private BigDecimal pracnostPlan;
	private String priznakAnPovinny;
	private BigDecimal rokKroku;
	private String stavDokumentu;
	private String stavKroku;
	private String stavPredStornem;
	private BigDecimal terminAkceptacePlan;
	private BigDecimal terminAkceptaceSkut;
	private BigDecimal terminDoruceniPlan;
	private BigDecimal terminDoruceniSkut;
	private BigDecimal terminZahajeniPlan;
	private BigDecimal terminZahajeniSkut;
	private String zakazka;
	private String zpusobAkceptace;
	
	
	public Long getIdKrokuProjektu() {
		return idKrokuProjektu;
	}
	public void setIdKrokuProjektu(Long idKrokuProjektu) {
		this.idKrokuProjektu = idKrokuProjektu;
	}
	public BigDecimal getCisloKroku() {
		return cisloKroku;
	}
	public void setCisloKroku(BigDecimal cisloKroku) {
		this.cisloKroku = cisloKroku;
	}
	public BigDecimal getCisloRevize() {
		return cisloRevize;
	}
	public void setCisloRevize(BigDecimal cisloRevize) {
		this.cisloRevize = cisloRevize;
	}
	public BigDecimal getDatumI() {
		return datumI;
	}
	public void setDatumI(BigDecimal datumI) {
		this.datumI = datumI;
	}
	public BigDecimal getDatumU() {
		return datumU;
	}
	public void setDatumU(BigDecimal datumU) {
		this.datumU = datumU;
	}
	public String getDokument() {
		return dokument;
	}
	public void setDokument(String dokument) {
		this.dokument = dokument;
	}
	public String getDruhKroku() {
		return druhKroku;
	}
	public void setDruhKroku(String druhKroku) {
		this.druhKroku = druhKroku;
	}
	public BigDecimal getIdPlanuProjektu() {
		return idPlanuProjektu;
	}
	public void setIdPlanuProjektu(BigDecimal idPlanuProjektu) {
		this.idPlanuProjektu = idPlanuProjektu;
	}
	public BigDecimal getIdProfesnihoStrediska() {
		return idProfesnihoStrediska;
	}
	public void setIdProfesnihoStrediska(BigDecimal idProfesnihoStrediska) {
		this.idProfesnihoStrediska = idProfesnihoStrediska;
	}
	public String getKodUzivateleAkcept() {
		return kodUzivateleAkcept;
	}
	public void setKodUzivateleAkcept(String kodUzivateleAkcept) {
		this.kodUzivateleAkcept = kodUzivateleAkcept;
	}
	public String getKodUzivateleResitel() {
		return kodUzivateleResitel;
	}
	public void setKodUzivateleResitel(String kodUzivateleResitel) {
		this.kodUzivateleResitel = kodUzivateleResitel;
	}
	public String getKodpraI() {
		return kodpraI;
	}
	public void setKodpraI(String kodpraI) {
		this.kodpraI = kodpraI;
	}
	public String getKodpraU() {
		return kodpraU;
	}
	public void setKodpraU(String kodpraU) {
		this.kodpraU = kodpraU;
	}
	public String getNazevKroku() {
		return nazevKroku;
	}
	public void setNazevKroku(String nazevKroku) {
		this.nazevKroku = nazevKroku;
	}
	public String getNazevKrokuVlastni() {
		return nazevKrokuVlastni;
	}
	public void setNazevKrokuVlastni(String nazevKrokuVlastni) {
		this.nazevKrokuVlastni = nazevKrokuVlastni;
	}
	public String getPopisKroku() {
		return popisKroku;
	}
	public void setPopisKroku(String popisKroku) {
		this.popisKroku = popisKroku;
	}
	public String getPopisReseni() {
		return popisReseni;
	}
	public void setPopisReseni(String popisReseni) {
		this.popisReseni = popisReseni;
	}
	public BigDecimal getPoradi() {
		return poradi;
	}
	public void setPoradi(BigDecimal poradi) {
		this.poradi = poradi;
	}
	public BigDecimal getPracnostPlan() {
		return pracnostPlan;
	}
	public void setPracnostPlan(BigDecimal pracnostPlan) {
		this.pracnostPlan = pracnostPlan;
	}
	public String getPriznakAnPovinny() {
		return priznakAnPovinny;
	}
	public void setPriznakAnPovinny(String priznakAnPovinny) {
		this.priznakAnPovinny = priznakAnPovinny;
	}
	public BigDecimal getRokKroku() {
		return rokKroku;
	}
	public void setRokKroku(BigDecimal rokKroku) {
		this.rokKroku = rokKroku;
	}
	public String getStavDokumentu() {
		return stavDokumentu;
	}
	public void setStavDokumentu(String stavDokumentu) {
		this.stavDokumentu = stavDokumentu;
	}
	public String getStavKroku() {
		return stavKroku;
	}
	public void setStavKroku(String stavKroku) {
		this.stavKroku = stavKroku;
	}
	public String getStavPredStornem() {
		return stavPredStornem;
	}
	public void setStavPredStornem(String stavPredStornem) {
		this.stavPredStornem = stavPredStornem;
	}
	public BigDecimal getTerminAkceptacePlan() {
		return terminAkceptacePlan;
	}
	public void setTerminAkceptacePlan(BigDecimal terminAkceptacePlan) {
		this.terminAkceptacePlan = terminAkceptacePlan;
	}
	public BigDecimal getTerminAkceptaceSkut() {
		return terminAkceptaceSkut;
	}
	public void setTerminAkceptaceSkut(BigDecimal terminAkceptaceSkut) {
		this.terminAkceptaceSkut = terminAkceptaceSkut;
	}
	public BigDecimal getTerminDoruceniPlan() {
		return terminDoruceniPlan;
	}
	public void setTerminDoruceniPlan(BigDecimal terminDoruceniPlan) {
		this.terminDoruceniPlan = terminDoruceniPlan;
	}
	public BigDecimal getTerminDoruceniSkut() {
		return terminDoruceniSkut;
	}
	public void setTerminDoruceniSkut(BigDecimal terminDoruceniSkut) {
		this.terminDoruceniSkut = terminDoruceniSkut;
	}
	public BigDecimal getTerminZahajeniPlan() {
		return terminZahajeniPlan;
	}
	public void setTerminZahajeniPlan(BigDecimal terminZahajeniPlan) {
		this.terminZahajeniPlan = terminZahajeniPlan;
	}
	public BigDecimal getTerminZahajeniSkut() {
		return terminZahajeniSkut;
	}
	public void setTerminZahajeniSkut(BigDecimal terminZahajeniSkut) {
		this.terminZahajeniSkut = terminZahajeniSkut;
	}
	public String getZakazka() {
		return zakazka;
	}
	public void setZakazka(String zakazka) {
		this.zakazka = zakazka;
	}
	public String getZpusobAkceptace() {
		return zpusobAkceptace;
	}
	public void setZpusobAkceptace(String zpusobAkceptace) {
		this.zpusobAkceptace = zpusobAkceptace;
	}
	
	

}
