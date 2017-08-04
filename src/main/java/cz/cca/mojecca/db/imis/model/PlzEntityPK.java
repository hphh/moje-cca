package cz.cca.mojecca.db.imis.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PLZ database table.
 * 
 */
@Embeddable
public class PlzEntityPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String zc;

	private long cpolzak;

	public PlzEntityPK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PlzEntityPK)) {
			return false;
		}
		PlzEntityPK castOther = (PlzEntityPK)other;
		return 
			this.zc.equals(castOther.zc)
			&& (this.cpolzak == castOther.cpolzak);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.zc.hashCode();
		hash = hash * prime + ((int) (this.cpolzak ^ (this.cpolzak >>> 32)));
		
		return hash;
	}
}