package cz.cca.mojecca.service.imis.model;

import java.math.BigDecimal;

public class NahradniVolnoSumVybrat {

	BigDecimal lze;
	BigDecimal musi;
	BigDecimal musiNaDen;
	private Long pracovnichDniDoKonceMesice;
	
	
	public BigDecimal getLze() {
		return lze;
	}
	public void setLze(BigDecimal lze) {
		this.lze = lze;
	}
	public BigDecimal getMusi() {
		return musi;
	}
	public void setMusi(BigDecimal musi) {
		this.musi = musi;
	}
	public BigDecimal getMusiNaDen() {
		return musiNaDen;
	}
	public void setMusiNaDen(BigDecimal musiNaDen) {
		this.musiNaDen = musiNaDen;
	}
	public Long getPracovnichDniDoKonceMesice() {
		return pracovnichDniDoKonceMesice;
	}
	public void setPracovnichDniDoKonceMesice(Long pracovnichDniDoKonceMesice) {
		this.pracovnichDniDoKonceMesice = pracovnichDniDoKonceMesice;
	}
	
	
	
	
}
