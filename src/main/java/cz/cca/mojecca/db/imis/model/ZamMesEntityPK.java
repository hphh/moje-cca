package cz.cca.mojecca.db.imis.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ZAM_MES database table.
 * 
 */
@Embeddable
public class ZamMesEntityPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String icp;

	@Temporal(TemporalType.DATE)
	private java.util.Date obdobi;

	public ZamMesEntityPK() {
	}
	public String getIcp() {
		return this.icp;
	}
	public void setIcp(String icp) {
		this.icp = icp;
	}
	public java.util.Date getObdobi() {
		return this.obdobi;
	}
	public void setObdobi(java.util.Date obdobi) {
		this.obdobi = obdobi;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ZamMesEntityPK)) {
			return false;
		}
		ZamMesEntityPK castOther = (ZamMesEntityPK)other;
		return 
			this.icp.equals(castOther.icp)
			&& this.obdobi.equals(castOther.obdobi);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.icp.hashCode();
		hash = hash * prime + this.obdobi.hashCode();
		
		return hash;
	}
}