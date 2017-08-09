package cz.cca.mojecca.service.imis.data;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import cz.cca.mojecca.db.imis.model.PrichodOdchodEntity;

public class PresentDataAdapter {
	
	private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
	
	private PresentDataAdapter() {
		//Statická třída
	}

	public static String toTodayPresentsString(List<PrichodOdchodEntity> prichodOdchods) {
		if (prichodOdchods == null) {
			return null;
		}
		
		StringBuilder sb = new StringBuilder();
		
		
		PrichodOdchodEntity last = null;
		for (PrichodOdchodEntity p : prichodOdchods) {
			String timeString = p.getDatum().format(TIME_FORMATTER);
			
			if (p.isPrichod()) {
				if (sb.length() > 0) {
					sb.append(", ");
				}
				sb.append(timeString);
				sb.append(" - ");
			} else {
				sb.append(timeString);
			}
			
			last = p;
		}
		
		if ((last != null) && (!last.isPrichod())) {
			sb.append(" (" + ("Normální pracovní doba".equals(last.getPopisPrichodOdchod())? "std. odchod": last.getPopisPrichodOdchod()));
			if (StringUtils.isNotEmpty(last.getPoznamka())) {
				sb.append("; " + last.getPoznamka());
			}
			sb.append(")");
		}
		
		return sb.toString();
	}

}
