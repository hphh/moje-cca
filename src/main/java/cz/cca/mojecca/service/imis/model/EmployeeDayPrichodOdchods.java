package cz.cca.mojecca.service.imis.model;

import java.math.BigDecimal;

public class EmployeeDayPrichodOdchods {
	
	private String prichodOdchodsText;
	private BigDecimal odpracovano;
	private BigDecimal odchodPlan;

	public String getPrichodOdchodsText() {
		return prichodOdchodsText;
	}

	public void setPrichodOdchodsText(String prichodOdchodsText) {
		this.prichodOdchodsText = prichodOdchodsText;
	}

	public BigDecimal getOdpracovano() {
		return odpracovano;
	}

	public void setOdpracovano(BigDecimal odpracovano) {
		this.odpracovano = odpracovano;
	}

	public BigDecimal getOdchodPlan() {
		return odchodPlan;
	}

	public void setOdchodPlan(BigDecimal odchodPlan) {
		this.odchodPlan = odchodPlan;
	}

}
