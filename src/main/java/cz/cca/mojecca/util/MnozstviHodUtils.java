package cz.cca.mojecca.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MnozstviHodUtils {
	
	private static final BigDecimal C60 = new BigDecimal(60);
	private static final BigDecimal C1 = new BigDecimal(1);
	
	public static int compare(BigDecimal mnozstviHodLeft, BigDecimal mnozstviHodRight) {
		if ((mnozstviHodLeft == null) || (mnozstviHodRight == null)) {
			return -1;
		}
		
		int leftMins = toMins(mnozstviHodLeft); 
		int rightMins = toMins(mnozstviHodRight);
		
		return leftMins - rightMins;
		
	}

	private static int toMins(BigDecimal n) {
		return n.setScale(0, RoundingMode.DOWN).multiply(C60).
				add(n.remainder(C1).multiply(C60).setScale(0, RoundingMode.HALF_UP)).intValue();
	}

}
