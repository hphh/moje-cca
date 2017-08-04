package cz.cca.mojecca.db.imis.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the ZAMESTNANEC database table.
 * 
 */
@Entity(name="ZAMESTNANEC")
public class ZamestnanecEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String icp;

	@Column(name="CISLO_KARTY")
	private String cisloKarty;

	private String cizi;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_AKT")
	private Date datumAkt;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_CK2")
	private Date datumCk2;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_CK3")
	private Date datumCk3;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_KONEC_VYNETI")
	private Date datumKonecVyneti;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_NASL_HODN_PRAC")
	private Date datumNaslHodnPrac;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_VYNETI")
	private Date datumVyneti;

	@Column(name="DELKA_CK")
	private BigDecimal delkaCk;

	@Column(name="DRUH_PRACOVNIKA")
	private String druhPracovnika;

	private String funkce;

	private String heslo;

	@Column(name="ICP_SEKR")
	private String icpSekr;

	@Column(name="ICP_VED")
	private String icpVed;

	@Column(name="ICP_ZAST")
	private String icpZast;

	@Column(name="JINA_PRACOVNI_DOBA")
	private String jinaPracovniDoba;

	private String jmeno;

	private String karta;

	@Column(name="KOD_EVIDENCNIHO_STAVU")
	private String kodEvidencnihoStavu;

	@Column(name="KOD_PRUKAZU")
	private String kodPrukazu;

	@Column(name="KOD_ROZVRHU")
	private String kodRozvrhu;

	@Column(name="KODPRA_AKT")
	private String kodpraAkt;

	@Temporal(TemporalType.DATE)
	@Column(name="KONEC_PLAT_PRAC_SMLOUVY")
	private Date konecPlatPracSmlouvy;

	@Column(name="POC_H_UV")
	private BigDecimal pocHUv;

	@Temporal(TemporalType.DATE)
	@Column(name="POMER_DO")
	private Date pomerDo;

	@Temporal(TemporalType.DATE)
	@Column(name="POMER_OD")
	private Date pomerOd;

	@Column(name="PRAC_ROZ")
	private String pracRoz;

	private String pracoviste;

	@Column(name="PRIZNAK_CASOVE_KONTO")
	private String priznakCasoveKonto;

	@Column(name="PRIZNAK_LIMIT_PRESCASU")
	private String priznakLimitPrescasu;

	@Column(name="PRIZNAK_NULOVAT_HODINY_NAVIC")
	private String priznakNulovatHodinyNavic;

	@Column(name="PRIZNAK_PRODL_SMLOUVY")
	private String priznakProdlSmlouvy;

	@Column(name="PRIZNAK_SMLUVNI_MZDA")
	private String priznakSmluvniMzda;

	@Column(name="PRIZNAK_ZACLENENI_PRAC")
	private String priznakZacleneniPrac;

	@Column(name="ROD_C")
	private String rodC;

	private String stav;

	private String stred;

	private BigDecimal uvazek;

	@Column(name="ZAC_P_DOBY")
	private BigDecimal zacPDoby;

	@Temporal(TemporalType.DATE)
	@Column(name="ZAC_PLAT_PRAC_SMLOUVY")
	private Date zacPlatPracSmlouvy;

	@Column(name="ZUST_DOV")
	private BigDecimal zustDov;

	public ZamestnanecEntity() {
	}

	public String getIcp() {
		return this.icp;
	}

	public void setIcp(String icp) {
		this.icp = icp;
	}

	public String getCisloKarty() {
		return this.cisloKarty;
	}

	public void setCisloKarty(String cisloKarty) {
		this.cisloKarty = cisloKarty;
	}

	public String getCizi() {
		return this.cizi;
	}

	public void setCizi(String cizi) {
		this.cizi = cizi;
	}

	public Date getDatumAkt() {
		return this.datumAkt;
	}

	public void setDatumAkt(Date datumAkt) {
		this.datumAkt = datumAkt;
	}

	public Date getDatumCk2() {
		return this.datumCk2;
	}

	public void setDatumCk2(Date datumCk2) {
		this.datumCk2 = datumCk2;
	}

	public Date getDatumCk3() {
		return this.datumCk3;
	}

	public void setDatumCk3(Date datumCk3) {
		this.datumCk3 = datumCk3;
	}

	public Date getDatumKonecVyneti() {
		return this.datumKonecVyneti;
	}

	public void setDatumKonecVyneti(Date datumKonecVyneti) {
		this.datumKonecVyneti = datumKonecVyneti;
	}

	public Date getDatumNaslHodnPrac() {
		return this.datumNaslHodnPrac;
	}

	public void setDatumNaslHodnPrac(Date datumNaslHodnPrac) {
		this.datumNaslHodnPrac = datumNaslHodnPrac;
	}

	public Date getDatumVyneti() {
		return this.datumVyneti;
	}

	public void setDatumVyneti(Date datumVyneti) {
		this.datumVyneti = datumVyneti;
	}

	public BigDecimal getDelkaCk() {
		return this.delkaCk;
	}

	public void setDelkaCk(BigDecimal delkaCk) {
		this.delkaCk = delkaCk;
	}

	public String getDruhPracovnika() {
		return this.druhPracovnika;
	}

	public void setDruhPracovnika(String druhPracovnika) {
		this.druhPracovnika = druhPracovnika;
	}

	public String getFunkce() {
		return this.funkce;
	}

	public void setFunkce(String funkce) {
		this.funkce = funkce;
	}

	public String getHeslo() {
		return this.heslo;
	}

	public void setHeslo(String heslo) {
		this.heslo = heslo;
	}

	public String getIcpSekr() {
		return this.icpSekr;
	}

	public void setIcpSekr(String icpSekr) {
		this.icpSekr = icpSekr;
	}

	public String getIcpVed() {
		return this.icpVed;
	}

	public void setIcpVed(String icpVed) {
		this.icpVed = icpVed;
	}

	public String getIcpZast() {
		return this.icpZast;
	}

	public void setIcpZast(String icpZast) {
		this.icpZast = icpZast;
	}

	public String getJinaPracovniDoba() {
		return this.jinaPracovniDoba;
	}

	public void setJinaPracovniDoba(String jinaPracovniDoba) {
		this.jinaPracovniDoba = jinaPracovniDoba;
	}

	public String getJmeno() {
		return this.jmeno;
	}

	public void setJmeno(String jmeno) {
		this.jmeno = jmeno;
	}

	public String getKarta() {
		return this.karta;
	}

	public void setKarta(String karta) {
		this.karta = karta;
	}

	public String getKodEvidencnihoStavu() {
		return this.kodEvidencnihoStavu;
	}

	public void setKodEvidencnihoStavu(String kodEvidencnihoStavu) {
		this.kodEvidencnihoStavu = kodEvidencnihoStavu;
	}

	public String getKodPrukazu() {
		return this.kodPrukazu;
	}

	public void setKodPrukazu(String kodPrukazu) {
		this.kodPrukazu = kodPrukazu;
	}

	public String getKodRozvrhu() {
		return this.kodRozvrhu;
	}

	public void setKodRozvrhu(String kodRozvrhu) {
		this.kodRozvrhu = kodRozvrhu;
	}

	public String getKodpraAkt() {
		return this.kodpraAkt;
	}

	public void setKodpraAkt(String kodpraAkt) {
		this.kodpraAkt = kodpraAkt;
	}

	public Date getKonecPlatPracSmlouvy() {
		return this.konecPlatPracSmlouvy;
	}

	public void setKonecPlatPracSmlouvy(Date konecPlatPracSmlouvy) {
		this.konecPlatPracSmlouvy = konecPlatPracSmlouvy;
	}

	public BigDecimal getPocHUv() {
		return this.pocHUv;
	}

	public void setPocHUv(BigDecimal pocHUv) {
		this.pocHUv = pocHUv;
	}

	public Date getPomerDo() {
		return this.pomerDo;
	}

	public void setPomerDo(Date pomerDo) {
		this.pomerDo = pomerDo;
	}

	public Date getPomerOd() {
		return this.pomerOd;
	}

	public void setPomerOd(Date pomerOd) {
		this.pomerOd = pomerOd;
	}

	public String getPracRoz() {
		return this.pracRoz;
	}

	public void setPracRoz(String pracRoz) {
		this.pracRoz = pracRoz;
	}

	public String getPracoviste() {
		return this.pracoviste;
	}

	public void setPracoviste(String pracoviste) {
		this.pracoviste = pracoviste;
	}

	public String getPriznakCasoveKonto() {
		return this.priznakCasoveKonto;
	}

	public void setPriznakCasoveKonto(String priznakCasoveKonto) {
		this.priznakCasoveKonto = priznakCasoveKonto;
	}

	public String getPriznakLimitPrescasu() {
		return this.priznakLimitPrescasu;
	}

	public void setPriznakLimitPrescasu(String priznakLimitPrescasu) {
		this.priznakLimitPrescasu = priznakLimitPrescasu;
	}

	public String getPriznakNulovatHodinyNavic() {
		return this.priznakNulovatHodinyNavic;
	}

	public void setPriznakNulovatHodinyNavic(String priznakNulovatHodinyNavic) {
		this.priznakNulovatHodinyNavic = priznakNulovatHodinyNavic;
	}

	public String getPriznakProdlSmlouvy() {
		return this.priznakProdlSmlouvy;
	}

	public void setPriznakProdlSmlouvy(String priznakProdlSmlouvy) {
		this.priznakProdlSmlouvy = priznakProdlSmlouvy;
	}

	public String getPriznakSmluvniMzda() {
		return this.priznakSmluvniMzda;
	}

	public void setPriznakSmluvniMzda(String priznakSmluvniMzda) {
		this.priznakSmluvniMzda = priznakSmluvniMzda;
	}

	public String getPriznakZacleneniPrac() {
		return this.priznakZacleneniPrac;
	}

	public void setPriznakZacleneniPrac(String priznakZacleneniPrac) {
		this.priznakZacleneniPrac = priznakZacleneniPrac;
	}

	public String getRodC() {
		return this.rodC;
	}

	public void setRodC(String rodC) {
		this.rodC = rodC;
	}

	public String getStav() {
		return this.stav;
	}

	public void setStav(String stav) {
		this.stav = stav;
	}

	public String getStred() {
		return this.stred;
	}

	public void setStred(String stred) {
		this.stred = stred;
	}

	public BigDecimal getUvazek() {
		return this.uvazek;
	}

	public void setUvazek(BigDecimal uvazek) {
		this.uvazek = uvazek;
	}

	public BigDecimal getZacPDoby() {
		return this.zacPDoby;
	}

	public void setZacPDoby(BigDecimal zacPDoby) {
		this.zacPDoby = zacPDoby;
	}

	public Date getZacPlatPracSmlouvy() {
		return this.zacPlatPracSmlouvy;
	}

	public void setZacPlatPracSmlouvy(Date zacPlatPracSmlouvy) {
		this.zacPlatPracSmlouvy = zacPlatPracSmlouvy;
	}

	public BigDecimal getZustDov() {
		return this.zustDov;
	}

	public void setZustDov(BigDecimal zustDov) {
		this.zustDov = zustDov;
	}

}