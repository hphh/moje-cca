package cz.cca.mojecca.service.imis.model;

import java.util.List;

public class EmployeeNahradniVolno {
	
	private List<NahradniVolno> nahradniVolnos;
	private NahradniVolnoSumVybrat sumVybrat;

	public List<NahradniVolno> getNahradniVolnos() {
		return nahradniVolnos;
	}

	public void setNahradniVolnos(List<NahradniVolno> nahradniVolnos) {
		this.nahradniVolnos = nahradniVolnos;
	}

	public NahradniVolnoSumVybrat getSumVybrat() {
		return sumVybrat;
	}

	public void setSumVybrat(NahradniVolnoSumVybrat sumVybrat) {
		this.sumVybrat = sumVybrat;
	}


}
