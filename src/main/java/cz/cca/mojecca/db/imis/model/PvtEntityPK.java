package cz.cca.mojecca.db.imis.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PVT database table.
 * 
 */
@Embeddable
public class PvtEntityPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String stred;

	private String prac;

	public PvtEntityPK() {
	}
	public String getStred() {
		return this.stred;
	}
	public void setStred(String stred) {
		this.stred = stred;
	}
	public String getPrac() {
		return this.prac;
	}
	public void setPrac(String prac) {
		this.prac = prac;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PvtEntityPK)) {
			return false;
		}
		PvtEntityPK castOther = (PvtEntityPK)other;
		return 
			this.stred.equals(castOther.stred)
			&& this.prac.equals(castOther.prac);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.stred.hashCode();
		hash = hash * prime + this.prac.hashCode();
		
		return hash;
	}
}