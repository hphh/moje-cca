package cz.cca.mojecca.db.imis.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the KODY_DOB database table.
 * 
 */
@Entity
@Table(name="KODY_DOB")
@NamedQuery(name="KodyDobEntity.findAll", query="SELECT k FROM KodyDobEntity k")
public class KodyDobEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="KOD_DOBY")
	private String kodDoby;

	private BigDecimal druh;

	@Column(name="KOD_UNI")
	private String kodUni;

	@Column(name="KOD_UNI2")
	private String kodUni2;

	@Column(name="ODESILAT_DO_UNICOSU")
	private String odesilatDoUnicosu;

	@Column(name="PEVNA_DOBA")
	private BigDecimal pevnaDoba;

	private String popis;

	private String priznak;

	private String typ;

	@Column(name="ZAKAZANE_POUZITI")
	private String zakazanePouziti;

	//bi-directional many-to-one association to VyhodnoceniEntity
	@OneToMany(mappedBy="kodyDob")
	private List<VyhodnoceniEntity> vyhodnocenis;

	public KodyDobEntity() {
	}

	public String getKodDoby() {
		return this.kodDoby;
	}

	public void setKodDoby(String kodDoby) {
		this.kodDoby = kodDoby;
	}

	public BigDecimal getDruh() {
		return this.druh;
	}

	public void setDruh(BigDecimal druh) {
		this.druh = druh;
	}

	public String getKodUni() {
		return this.kodUni;
	}

	public void setKodUni(String kodUni) {
		this.kodUni = kodUni;
	}

	public String getKodUni2() {
		return this.kodUni2;
	}

	public void setKodUni2(String kodUni2) {
		this.kodUni2 = kodUni2;
	}

	public String getOdesilatDoUnicosu() {
		return this.odesilatDoUnicosu;
	}

	public void setOdesilatDoUnicosu(String odesilatDoUnicosu) {
		this.odesilatDoUnicosu = odesilatDoUnicosu;
	}

	public BigDecimal getPevnaDoba() {
		return this.pevnaDoba;
	}

	public void setPevnaDoba(BigDecimal pevnaDoba) {
		this.pevnaDoba = pevnaDoba;
	}

	public String getPopis() {
		return this.popis;
	}

	public void setPopis(String popis) {
		this.popis = popis;
	}

	public String getPriznak() {
		return this.priznak;
	}

	public void setPriznak(String priznak) {
		this.priznak = priznak;
	}

	public String getTyp() {
		return this.typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public String getZakazanePouziti() {
		return this.zakazanePouziti;
	}

	public void setZakazanePouziti(String zakazanePouziti) {
		this.zakazanePouziti = zakazanePouziti;
	}

	public List<VyhodnoceniEntity> getVyhodnocenis() {
		return this.vyhodnocenis;
	}

	public void setVyhodnocenis(List<VyhodnoceniEntity> vyhodnocenis) {
		this.vyhodnocenis = vyhodnocenis;
	}

	public VyhodnoceniEntity addVyhodnoceni(VyhodnoceniEntity vyhodnoceni) {
		getVyhodnocenis().add(vyhodnoceni);
		vyhodnoceni.setKodyDob(this);

		return vyhodnoceni;
	}

	public VyhodnoceniEntity removeVyhodnoceni(VyhodnoceniEntity vyhodnoceni) {
		getVyhodnocenis().remove(vyhodnoceni);
		vyhodnoceni.setKodyDob(null);

		return vyhodnoceni;
	}

}