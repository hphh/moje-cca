package cz.cca.mojecca.service.isza.model;

import java.math.BigDecimal;

public class Ukol {
	
	private long idUkolu;
	private BigDecimal cisloHlaseni;
	private Long cisloUkolu;
	private BigDecimal datumI;
	private BigDecimal datumU;
	private BigDecimal idKrokuProjektu;
	private String kodUzivateleAkcept;
	private String kodUzivateleResitel;
	private BigDecimal kodVyjadreniKUkolu;
	private String kodpraI;
	private String kodpraU;
	private String nazevUkolu;
	private String popisReseni;
	private String poznamka;
	private BigDecimal pracnostPlan;
	private String priznakAnUkolStornovan;
	private BigDecimal rokHlaseni;
	private Long rokUkolu;
	private String stavPredStornem;
	private String stavUkolu;
	private String stornoUkolKap;
	private BigDecimal terminAkceptacePlan;
	private BigDecimal terminAkceptaceSkut;
	private BigDecimal terminDoruceniPlan;
	private BigDecimal terminDoruceniSkut;
	private BigDecimal terminZahajeniPlan;
	private BigDecimal terminZahajeniSkut;
	private BigDecimal tmpCisloPozadavku;
	private BigDecimal tmpRokPozadavku;
	private String typUkolu;
	private String zadaniUkolu;
	private String zakazka;
	private String zpusobAkceptace;
	public long getIdUkolu() {
		return idUkolu;
	}
	public void setIdUkolu(long idUkolu) {
		this.idUkolu = idUkolu;
	}
	public BigDecimal getCisloHlaseni() {
		return cisloHlaseni;
	}
	public void setCisloHlaseni(BigDecimal cisloHlaseni) {
		this.cisloHlaseni = cisloHlaseni;
	}
	public Long getCisloUkolu() {
		return cisloUkolu;
	}
	public void setCisloUkolu(Long cisloUkolu) {
		this.cisloUkolu = cisloUkolu;
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
	public BigDecimal getIdKrokuProjektu() {
		return idKrokuProjektu;
	}
	public void setIdKrokuProjektu(BigDecimal idKrokuProjektu) {
		this.idKrokuProjektu = idKrokuProjektu;
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
	public BigDecimal getKodVyjadreniKUkolu() {
		return kodVyjadreniKUkolu;
	}
	public void setKodVyjadreniKUkolu(BigDecimal kodVyjadreniKUkolu) {
		this.kodVyjadreniKUkolu = kodVyjadreniKUkolu;
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
	public String getNazevUkolu() {
		return nazevUkolu;
	}
	public void setNazevUkolu(String nazevUkolu) {
		this.nazevUkolu = nazevUkolu;
	}
	public String getPopisReseni() {
		return popisReseni;
	}
	public void setPopisReseni(String popisReseni) {
		this.popisReseni = popisReseni;
	}
	public String getPoznamka() {
		return poznamka;
	}
	public void setPoznamka(String poznamka) {
		this.poznamka = poznamka;
	}
	public BigDecimal getPracnostPlan() {
		return pracnostPlan;
	}
	public void setPracnostPlan(BigDecimal pracnostPlan) {
		this.pracnostPlan = pracnostPlan;
	}
	public String getPriznakAnUkolStornovan() {
		return priznakAnUkolStornovan;
	}
	public void setPriznakAnUkolStornovan(String priznakAnUkolStornovan) {
		this.priznakAnUkolStornovan = priznakAnUkolStornovan;
	}
	public BigDecimal getRokHlaseni() {
		return rokHlaseni;
	}
	public void setRokHlaseni(BigDecimal rokHlaseni) {
		this.rokHlaseni = rokHlaseni;
	}
	public Long getRokUkolu() {
		return rokUkolu;
	}
	public void setRokUkolu(Long rokUkolu) {
		this.rokUkolu = rokUkolu;
	}
	public String getStavPredStornem() {
		return stavPredStornem;
	}
	public void setStavPredStornem(String stavPredStornem) {
		this.stavPredStornem = stavPredStornem;
	}
	public String getStavUkolu() {
		return stavUkolu;
	}
	public void setStavUkolu(String stavUkolu) {
		this.stavUkolu = stavUkolu;
	}
	public String getStornoUkolKap() {
		return stornoUkolKap;
	}
	public void setStornoUkolKap(String stornoUkolKap) {
		this.stornoUkolKap = stornoUkolKap;
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
	public BigDecimal getTmpCisloPozadavku() {
		return tmpCisloPozadavku;
	}
	public void setTmpCisloPozadavku(BigDecimal tmpCisloPozadavku) {
		this.tmpCisloPozadavku = tmpCisloPozadavku;
	}
	public BigDecimal getTmpRokPozadavku() {
		return tmpRokPozadavku;
	}
	public void setTmpRokPozadavku(BigDecimal tmpRokPozadavku) {
		this.tmpRokPozadavku = tmpRokPozadavku;
	}
	public String getTypUkolu() {
		return typUkolu;
	}
	public void setTypUkolu(String typUkolu) {
		this.typUkolu = typUkolu;
	}
	public String getZadaniUkolu() {
		return zadaniUkolu;
	}
	public void setZadaniUkolu(String zadaniUkolu) {
		this.zadaniUkolu = zadaniUkolu;
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
