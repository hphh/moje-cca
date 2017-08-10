package cz.cca.mojecca.db.imis.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the ZAM_MES database table.
 * 
 */
@Entity
@Table(name="ZAM_MES")
@NamedQuery(name="ZamMesEntity.findAll", query="SELECT z FROM ZamMesEntity z")
public class ZamMesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ZamMesEntityPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_POTVRZENI")
	private Date datPotvrzeni;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_UZN")
	private Date datUzn;

	@Temporal(TemporalType.DATE)
	@Column(name="DATUM_POSLANY")
	private Date datumPoslany;

	@Column(name="KODPRA_POSLANY")
	private String kodpraPoslany;

	@Column(name="KODPRA_POTVRZENI")
	private String kodpraPotvrzeni;

	@Column(name="KODPRA_UZN")
	private String kodpraUzn;

	@Column(name="NAHR_VOLNO")
	private BigDecimal nahrVolno;

	@Column(name="NAHR_VOLNO_CK")
	private BigDecimal nahrVolnoCk;

	@Column(name="NV_1")
	private BigDecimal nv1;

	@Column(name="NV_2")
	private BigDecimal nv2;

	@Column(name="NV_3")
	private BigDecimal nv3;

	@Column(name="NV_CK_00")
	private BigDecimal nvCk00;

	@Column(name="NV_CK_01")
	private BigDecimal nvCk01;

	@Column(name="NV_CK_02")
	private BigDecimal nvCk02;

	@Column(name="NV_CK_03")
	private BigDecimal nvCk03;

	@Column(name="NV_CK_04")
	private BigDecimal nvCk04;

	@Column(name="NV_CK_05")
	private BigDecimal nvCk05;

	@Column(name="NV_CK_06")
	private BigDecimal nvCk06;

	@Column(name="NV_CK_07")
	private BigDecimal nvCk07;

	@Column(name="NV_CK_08")
	private BigDecimal nvCk08;

	@Column(name="NV_CK_09")
	private BigDecimal nvCk09;

	@Column(name="NV_CK_10")
	private BigDecimal nvCk10;

	@Column(name="NV_CK_11")
	private BigDecimal nvCk11;

	@Column(name="NV_CK_12")
	private BigDecimal nvCk12;

	private BigDecimal onv;

	@Column(name="ONV_CK")
	private BigDecimal onvCk;

	@Column(name="PCK_00")
	private BigDecimal pck00;

	@Column(name="PCK_01")
	private BigDecimal pck01;

	@Column(name="PCK_02")
	private BigDecimal pck02;

	@Column(name="PCK_03")
	private BigDecimal pck03;

	@Column(name="PCK_04")
	private BigDecimal pck04;

	@Column(name="PCK_05")
	private BigDecimal pck05;

	@Column(name="PCK_06")
	private BigDecimal pck06;

	@Column(name="PCK_07")
	private BigDecimal pck07;

	@Column(name="PCK_08")
	private BigDecimal pck08;

	@Column(name="PCK_09")
	private BigDecimal pck09;

	@Column(name="PCK_10")
	private BigDecimal pck10;

	@Column(name="PCK_11")
	private BigDecimal pck11;

	@Column(name="PCK_12")
	private BigDecimal pck12;

	@Column(name="POC_NV")
	private BigDecimal pocNv;

	private String poznamka;

	@Column(name="PPD_NAVIC")
	private BigDecimal ppdNavic;

	private BigDecimal prescas;

	@Column(name="S_POSLANY")
	private String sPoslany;

	@Column(name="S_POTVRZENY")
	private String sPotvrzeny;

	@Column(name="S_UZNANY")
	private String sUznany;

	@Column(name="S_ZMENENY")
	private String sZmeneny;

	private BigDecimal stravenky;

	private BigDecimal vnv;

	@Column(name="VNV_CK")
	private BigDecimal vnvCk;

	public ZamMesEntity() {
	}

	public ZamMesEntityPK getId() {
		return this.id;
	}

	public void setId(ZamMesEntityPK id) {
		this.id = id;
	}

	public Date getDatPotvrzeni() {
		return this.datPotvrzeni;
	}

	public void setDatPotvrzeni(Date datPotvrzeni) {
		this.datPotvrzeni = datPotvrzeni;
	}

	public Date getDatUzn() {
		return this.datUzn;
	}

	public void setDatUzn(Date datUzn) {
		this.datUzn = datUzn;
	}

	public Date getDatumPoslany() {
		return this.datumPoslany;
	}

	public void setDatumPoslany(Date datumPoslany) {
		this.datumPoslany = datumPoslany;
	}

	public String getKodpraPoslany() {
		return this.kodpraPoslany;
	}

	public void setKodpraPoslany(String kodpraPoslany) {
		this.kodpraPoslany = kodpraPoslany;
	}

	public String getKodpraPotvrzeni() {
		return this.kodpraPotvrzeni;
	}

	public void setKodpraPotvrzeni(String kodpraPotvrzeni) {
		this.kodpraPotvrzeni = kodpraPotvrzeni;
	}

	public String getKodpraUzn() {
		return this.kodpraUzn;
	}

	public void setKodpraUzn(String kodpraUzn) {
		this.kodpraUzn = kodpraUzn;
	}

	public BigDecimal getNahrVolno() {
		return this.nahrVolno;
	}

	public void setNahrVolno(BigDecimal nahrVolno) {
		this.nahrVolno = nahrVolno;
	}

	public BigDecimal getNahrVolnoCk() {
		return this.nahrVolnoCk;
	}

	public void setNahrVolnoCk(BigDecimal nahrVolnoCk) {
		this.nahrVolnoCk = nahrVolnoCk;
	}

	public BigDecimal getNv1() {
		return this.nv1;
	}

	public void setNv1(BigDecimal nv1) {
		this.nv1 = nv1;
	}

	public BigDecimal getNv2() {
		return this.nv2;
	}

	public void setNv2(BigDecimal nv2) {
		this.nv2 = nv2;
	}

	public BigDecimal getNv3() {
		return this.nv3;
	}

	public void setNv3(BigDecimal nv3) {
		this.nv3 = nv3;
	}

	public BigDecimal getNvCk00() {
		return this.nvCk00;
	}

	public void setNvCk00(BigDecimal nvCk00) {
		this.nvCk00 = nvCk00;
	}

	public BigDecimal getNvCk01() {
		return this.nvCk01;
	}

	public void setNvCk01(BigDecimal nvCk01) {
		this.nvCk01 = nvCk01;
	}

	public BigDecimal getNvCk02() {
		return this.nvCk02;
	}

	public void setNvCk02(BigDecimal nvCk02) {
		this.nvCk02 = nvCk02;
	}

	public BigDecimal getNvCk03() {
		return this.nvCk03;
	}

	public void setNvCk03(BigDecimal nvCk03) {
		this.nvCk03 = nvCk03;
	}

	public BigDecimal getNvCk04() {
		return this.nvCk04;
	}

	public void setNvCk04(BigDecimal nvCk04) {
		this.nvCk04 = nvCk04;
	}

	public BigDecimal getNvCk05() {
		return this.nvCk05;
	}

	public void setNvCk05(BigDecimal nvCk05) {
		this.nvCk05 = nvCk05;
	}

	public BigDecimal getNvCk06() {
		return this.nvCk06;
	}

	public void setNvCk06(BigDecimal nvCk06) {
		this.nvCk06 = nvCk06;
	}

	public BigDecimal getNvCk07() {
		return this.nvCk07;
	}

	public void setNvCk07(BigDecimal nvCk07) {
		this.nvCk07 = nvCk07;
	}

	public BigDecimal getNvCk08() {
		return this.nvCk08;
	}

	public void setNvCk08(BigDecimal nvCk08) {
		this.nvCk08 = nvCk08;
	}

	public BigDecimal getNvCk09() {
		return this.nvCk09;
	}

	public void setNvCk09(BigDecimal nvCk09) {
		this.nvCk09 = nvCk09;
	}

	public BigDecimal getNvCk10() {
		return this.nvCk10;
	}

	public void setNvCk10(BigDecimal nvCk10) {
		this.nvCk10 = nvCk10;
	}

	public BigDecimal getNvCk11() {
		return this.nvCk11;
	}

	public void setNvCk11(BigDecimal nvCk11) {
		this.nvCk11 = nvCk11;
	}

	public BigDecimal getNvCk12() {
		return this.nvCk12;
	}

	public void setNvCk12(BigDecimal nvCk12) {
		this.nvCk12 = nvCk12;
	}

	public BigDecimal getOnv() {
		return this.onv;
	}

	public void setOnv(BigDecimal onv) {
		this.onv = onv;
	}

	public BigDecimal getOnvCk() {
		return this.onvCk;
	}

	public void setOnvCk(BigDecimal onvCk) {
		this.onvCk = onvCk;
	}

	public BigDecimal getPck00() {
		return this.pck00;
	}

	public void setPck00(BigDecimal pck00) {
		this.pck00 = pck00;
	}

	public BigDecimal getPck01() {
		return this.pck01;
	}

	public void setPck01(BigDecimal pck01) {
		this.pck01 = pck01;
	}

	public BigDecimal getPck02() {
		return this.pck02;
	}

	public void setPck02(BigDecimal pck02) {
		this.pck02 = pck02;
	}

	public BigDecimal getPck03() {
		return this.pck03;
	}

	public void setPck03(BigDecimal pck03) {
		this.pck03 = pck03;
	}

	public BigDecimal getPck04() {
		return this.pck04;
	}

	public void setPck04(BigDecimal pck04) {
		this.pck04 = pck04;
	}

	public BigDecimal getPck05() {
		return this.pck05;
	}

	public void setPck05(BigDecimal pck05) {
		this.pck05 = pck05;
	}

	public BigDecimal getPck06() {
		return this.pck06;
	}

	public void setPck06(BigDecimal pck06) {
		this.pck06 = pck06;
	}

	public BigDecimal getPck07() {
		return this.pck07;
	}

	public void setPck07(BigDecimal pck07) {
		this.pck07 = pck07;
	}

	public BigDecimal getPck08() {
		return this.pck08;
	}

	public void setPck08(BigDecimal pck08) {
		this.pck08 = pck08;
	}

	public BigDecimal getPck09() {
		return this.pck09;
	}

	public void setPck09(BigDecimal pck09) {
		this.pck09 = pck09;
	}

	public BigDecimal getPck10() {
		return this.pck10;
	}

	public void setPck10(BigDecimal pck10) {
		this.pck10 = pck10;
	}

	public BigDecimal getPck11() {
		return this.pck11;
	}

	public void setPck11(BigDecimal pck11) {
		this.pck11 = pck11;
	}

	public BigDecimal getPck12() {
		return this.pck12;
	}

	public void setPck12(BigDecimal pck12) {
		this.pck12 = pck12;
	}

	public BigDecimal getPocNv() {
		return this.pocNv;
	}

	public void setPocNv(BigDecimal pocNv) {
		this.pocNv = pocNv;
	}

	public String getPoznamka() {
		return this.poznamka;
	}

	public void setPoznamka(String poznamka) {
		this.poznamka = poznamka;
	}

	public BigDecimal getPpdNavic() {
		return this.ppdNavic;
	}

	public void setPpdNavic(BigDecimal ppdNavic) {
		this.ppdNavic = ppdNavic;
	}

	public BigDecimal getPrescas() {
		return this.prescas;
	}

	public void setPrescas(BigDecimal prescas) {
		this.prescas = prescas;
	}

	public String getSPoslany() {
		return this.sPoslany;
	}

	public void setSPoslany(String sPoslany) {
		this.sPoslany = sPoslany;
	}

	public String getSPotvrzeny() {
		return this.sPotvrzeny;
	}

	public void setSPotvrzeny(String sPotvrzeny) {
		this.sPotvrzeny = sPotvrzeny;
	}

	public String getSUznany() {
		return this.sUznany;
	}

	public void setSUznany(String sUznany) {
		this.sUznany = sUznany;
	}

	public String getSZmeneny() {
		return this.sZmeneny;
	}

	public void setSZmeneny(String sZmeneny) {
		this.sZmeneny = sZmeneny;
	}

	public BigDecimal getStravenky() {
		return this.stravenky;
	}

	public void setStravenky(BigDecimal stravenky) {
		this.stravenky = stravenky;
	}

	public BigDecimal getVnv() {
		return this.vnv;
	}

	public void setVnv(BigDecimal vnv) {
		this.vnv = vnv;
	}

	public BigDecimal getVnvCk() {
		return this.vnvCk;
	}

	public void setVnvCk(BigDecimal vnvCk) {
		this.vnvCk = vnvCk;
	}

}