package cz.cca.mojecca.db.imis.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the VYHODNOCENI database table.
 * 
 */
@Entity
@Table(name="VYHODNOCENI")
@NamedQuery(name="VyhodnoceniEntity.findAll", query="SELECT v FROM VyhodnoceniEntity v")
public class VyhodnoceniEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private VyhodnoceniEntityPK id;

	@Column(name="POC_HOD")
	private BigDecimal pocHod;

	private String stav;

	//bi-directional many-to-one association to KodyDobEntity
	@ManyToOne
	@JoinColumn(name="KOD_DOBY", insertable = false, updatable = false)
	private KodyDobEntity kodyDob;

	public VyhodnoceniEntity() {
	}

	public VyhodnoceniEntityPK getId() {
		return this.id;
	}

	public void setId(VyhodnoceniEntityPK id) {
		this.id = id;
	}

	public BigDecimal getPocHod() {
		return this.pocHod;
	}

	public void setPocHod(BigDecimal pocHod) {
		this.pocHod = pocHod;
	}

	public String getStav() {
		return this.stav;
	}

	public void setStav(String stav) {
		this.stav = stav;
	}

	public KodyDobEntity getKodyDob() {
		return this.kodyDob;
	}

	public void setKodyDob(KodyDobEntity kodyDob) {
		this.kodyDob = kodyDob;
	}

}