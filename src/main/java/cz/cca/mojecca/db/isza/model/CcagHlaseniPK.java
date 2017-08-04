package cz.cca.mojecca.db.isza.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CCAG_HLASENI database table.
 * 
 */
@Embeddable
public class CcagHlaseniPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CISLO_HLASENI")
	private long cisloHlaseni;

	@Column(name="ROK_HLASENI")
	private long rokHlaseni;

	public CcagHlaseniPK() {
	}
	public long getCisloHlaseni() {
		return this.cisloHlaseni;
	}
	public void setCisloHlaseni(long cisloHlaseni) {
		this.cisloHlaseni = cisloHlaseni;
	}
	public long getRokHlaseni() {
		return this.rokHlaseni;
	}
	public void setRokHlaseni(long rokHlaseni) {
		this.rokHlaseni = rokHlaseni;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CcagHlaseniPK)) {
			return false;
		}
		CcagHlaseniPK castOther = (CcagHlaseniPK)other;
		return 
			(this.cisloHlaseni == castOther.cisloHlaseni)
			&& (this.rokHlaseni == castOther.rokHlaseni);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.cisloHlaseni ^ (this.cisloHlaseni >>> 32)));
		hash = hash * prime + ((int) (this.rokHlaseni ^ (this.rokHlaseni >>> 32)));
		
		return hash;
	}
}