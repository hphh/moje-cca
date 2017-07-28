package cz.cca.mojecca.db.imis.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PrichodOdchodEntity {

	@Id
	private String rowid;
	private String icp;
	private LocalDateTime datum;
	private String kodPrichodOdchod;
	private String specPrichodOdchod;
	private String popisPrichodOdchod;
	private String poznamka;
	private double cas;
	
	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}

	public String getIcp() {
		return icp;
	}

	public void setIcp(String icp) {
		this.icp = icp;
	}

	public LocalDateTime getDatum() {
		return datum;
	}

	public void setDatum(LocalDateTime datum) {
		this.datum = datum;
	}

	public String getKodPrichodOdchod() {
		return kodPrichodOdchod;
	}

	public void setKodPrichodOdchod(String kodPrichodOdchod) {
		this.kodPrichodOdchod = kodPrichodOdchod;
	}

	public String getSpecPrichodOdchod() {
		return specPrichodOdchod;
	}

	public void setSpecPrichodOdchod(String specPrichodOdchod) {
		this.specPrichodOdchod = specPrichodOdchod;
	}

	public String getPopisPrichodOdchod() {
		return popisPrichodOdchod;
	}

	public void setPopisPrichodOdchod(String popisPrichodOdchod) {
		this.popisPrichodOdchod = popisPrichodOdchod;
	}

	public String getPoznamka() {
		return poznamka;
	}

	public void setPoznamka(String poznamka) {
		this.poznamka = poznamka;
	}
	
	public boolean isPrichod() {
		return "P".equals(getKodPrichodOdchod());
	}

	public double getCas() {
		return cas;
	}

	public void setCas(double cas) {
		this.cas = cas;
	}
	
	
	
}
