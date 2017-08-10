package cz.cca.mojecca.service.imis.model;

import java.math.BigDecimal;

public class NahradniVolno {
	
	private long obdobi;
	private BigDecimal mnozstvi;
	
	public long getObdobi() {
		return obdobi;
	}
	public void setObdobi(long obdobi) {
		this.obdobi = obdobi;
	}
	public BigDecimal getMnozstvi() {
		return mnozstvi;
	}
	public void setMnozstvi(BigDecimal mnozstvi) {
		this.mnozstvi = mnozstvi;
	}
	

}
