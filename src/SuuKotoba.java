import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 */

/**
 * @author Joseph
 *
 */
public class SuuKotoba {
	
	final private static String[] NUMERALS_KANJI = new String[] {"","一","二","三","四","五","六","七","八","九","十"};
	
	private static Map<BigInteger, String> units;
	static {
		units = new LinkedHashMap<BigInteger, String>();
		units.put(new BigInteger("1000000000000"), "兆");
		units.put(new BigInteger("100000000"), "億");
		units.put(new BigInteger("10000"), "万");
		units.put(new BigInteger("1000"), "千");
		units.put(new BigInteger("100"), "百");
		units.put(new BigInteger("10"), "十");
	};
	
	public static String numToWord(String num, Boolean isRecursive) {
		String numStr = "";
		BigInteger counter = new BigInteger(num);
		for (Map.Entry<BigInteger, String> entry : units.entrySet()) {
			Object[] results = getUnitStr(entry.getKey(), entry.getValue(), counter);
			if (entry.getValue().equals("千") && !isRecursive) {
				String senVal = (String) results[0];
				if (senVal.startsWith("一千")) {
					if (numStr.isEmpty()) {
						results[0] = senVal.substring(1); 
					}
				}
			}
			numStr += (String) results[0];
			counter = (BigInteger) results[1];
		}
		
		return numStr + NUMERALS_KANJI[counter.intValue()];
	}
	
	public static String numToWord(Integer num) {
		String numStr = num.toString();
		return numToWord(numStr, false);
	}
	
	public static String numToWord(BigInteger num) {
		String numStr = num.toString();
		return numToWord(numStr, false);
	}

	public static String numToWord(BigInteger num, Boolean isRecursive) {
		String numStr = num.toString();
		return numToWord(numStr, isRecursive);
	}
	
	public static String numToWord(String num) {
		return numToWord(num, false);
	}
	
	private static Object[] getUnitStr(BigInteger unit, String unitKanji, BigInteger counter) {
		BigInteger numUnit = counter.divide(unit);
		String unitStr;
		
		// TODO: counter must be set each call of numToWord... therefore, it cannot be static
		
		if  (numUnit.intValue() > 9) {
	    	unitStr = numToWord(numUnit, true) + unitKanji;
	    } else {
	    	unitStr = NUMERALS_KANJI[numUnit.intValue()] + unitKanji;
	    }
		
		counter = counter.subtract(numUnit.multiply(unit));
		
		return new Object[] {(numUnit.intValue() == 0) ? "" : unitStr, counter};
	}	
}
