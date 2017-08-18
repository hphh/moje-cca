package cz.cca.mojecca.db.imis.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the VYHODNOCENI database table.
 * 
 */
@Embeddable
public class VyhodnoceniEntityPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String icp;

	@Temporal(TemporalType.DATE)
	@Column(insertable=false, updatable=false)
	private java.util.Date datum;

	@Column(name="KOD_DOBY", insertable=false, updatable=false)
	private String kodDoby;

	public VyhodnoceniEntityPK() {
	}
	public String getIcp() {
		return this.icp;
	}
	public void setIcp(String icp) {
		this.icp = icp;
	}
	public java.util.Date getDatum() {
		return this.datum;
	}
	public void setDatum(java.util.Date datum) {
		this.datum = datum;
	}
	public String getKodDoby() {
		return this.kodDoby;
	}
	public void setKodDoby(String kodDoby) {
		this.kodDoby = kodDoby;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof VyhodnoceniEntityPK)) {
			return false;
		}
		VyhodnoceniEntityPK castOther = (VyhodnoceniEntityPK)other;
		return 
			this.icp.equals(castOther.icp)
			&& this.datum.equals(castOther.datum)
			&& this.kodDoby.equals(castOther.kodDoby);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.icp.hashCode();
		hash = hash * prime + this.datum.hashCode();
		hash = hash * prime + this.kodDoby.hashCode();
		
		return hash;
	}
}