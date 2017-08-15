package cz.cca.mojecca.service.model;

import cz.cca.mojecca.service.imis.model.ImisDen;
import cz.cca.mojecca.service.isza.model.IszaDen;

public class Den {
	
	private Long datum;
	private String kodUzivatele;
	private ImisDen imisDen;
	private IszaDen iszaDen;
	
	public Long getDatum() {
		return datum;
	}
	public void setDatum(Long datum) {
		this.datum = datum;
	}
	public String getKodUzivatele() {
		return kodUzivatele;
	}
	public void setKodUzivatele(String kodUzivatele) {
		this.kodUzivatele = kodUzivatele;
	}
	public ImisDen getImisDen() {
		return imisDen;
	}
	public void setImisDen(ImisDen imisDen) {
		this.imisDen = imisDen;
	}
	public IszaDen getIszaDen() {
		return iszaDen;
	}
	public void setIszaDen(IszaDen iszaDen) {
		this.iszaDen = iszaDen;
	}
	
	

}
