package cz.cca.mojecca.db.imis.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PPZ database table.
 * 
 */
@Embeddable
public class PpzEntityPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String zc;

	@Column(insertable=false, updatable=false)
	private long cpolzak;

	private long cpozzak;

	public PpzEntityPK() {
	}
	public String getZc() {
		return this.zc;
	}
	public void setZc(String zc) {
		this.zc = zc;
	}
	public long getCpolzak() {
		return this.cpolzak;
	}
	public void setCpolzak(long cpolzak) {
		this.cpolzak = cpolzak;
	}
	public long getCpozzak() {
		return this.cpozzak;
	}
	public void setCpozzak(long cpozzak) {
		this.cpozzak = cpozzak;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PpzEntityPK)) {
			return false;
		}
		PpzEntityPK castOther = (PpzEntityPK)other;
		return 
			this.zc.equals(castOther.zc)
			&& (this.cpolzak == castOther.cpolzak)
			&& (this.cpozzak == castOther.cpozzak);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.zc.hashCode();
		hash = hash * prime + ((int) (this.cpolzak ^ (this.cpolzak >>> 32)));
		hash = hash * prime + ((int) (this.cpozzak ^ (this.cpozzak >>> 32)));
		
		return hash;
	}
}