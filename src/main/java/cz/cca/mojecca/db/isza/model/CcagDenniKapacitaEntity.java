package cz.cca.mojecca.db.isza.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the CCAG_DENNI_KAPACITA database table.
 * 
 */
@Entity
@Table(name="CCAG_DENNI_KAPACITA")
@NamedQuery(name="CcagDenniKapacitaEntity.findAll", query="SELECT c FROM CcagDenniKapacitaEntity c")
public class CcagDenniKapacitaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_DENNI_KAPACITY")
	private long idDenniKapacity;

	@Temporal(TemporalType.DATE)
	private Date datum;

	@Column(name="DISPONIBILNI_KAPACITA")
	private BigDecimal disponibilniKapacita;

	@Column(name="DRUH_DNE")
	private String druhDne;

	@Column(name="KOD_UZIVATELE")
	private String kodUzivatele;

	@Column(name="PLANOVANA_KAPACITA")
	private BigDecimal planovanaKapacita;

	@Column(name="POZADOVANA_KAPACITA")
	private BigDecimal pozadovanaKapacita;

	public CcagDenniKapacitaEntity() {
	}

	public long getIdDenniKapacity() {
		return this.idDenniKapacity;
	}

	public void setIdDenniKapacity(long idDenniKapacity) {
		this.idDenniKapacity = idDenniKapacity;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public BigDecimal getDisponibilniKapacita() {
		return this.disponibilniKapacita;
	}

	public void setDisponibilniKapacita(BigDecimal disponibilniKapacita) {
		this.disponibilniKapacita = disponibilniKapacita;
	}

	public String getDruhDne() {
		return this.druhDne;
	}

	public void setDruhDne(String druhDne) {
		this.druhDne = druhDne;
	}

	public String getKodUzivatele() {
		return this.kodUzivatele;
	}

	public void setKodUzivatele(String kodUzivatele) {
		this.kodUzivatele = kodUzivatele;
	}

	public BigDecimal getPlanovanaKapacita() {
		return this.planovanaKapacita;
	}

	public void setPlanovanaKapacita(BigDecimal planovanaKapacita) {
		this.planovanaKapacita = planovanaKapacita;
	}

	public BigDecimal getPozadovanaKapacita() {
		return this.pozadovanaKapacita;
	}

	public void setPozadovanaKapacita(BigDecimal pozadovanaKapacita) {
		this.pozadovanaKapacita = pozadovanaKapacita;
	}

}