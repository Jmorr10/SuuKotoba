/**
 * 
 */

/**
 * A simple class that runs various test cases using SuuKotoba
 * @author Joseph
 * @version 1.0
 */
public class SuuKotobaTest {

	final static String chouTestStr = "2486954371891";
	final static String chouTest2Str = "1000000000000";
	final static String okuTestStr = "486900000000";
	final static String okuTest2Str = "100000000";
	final static String manTestStr = "54370000";
	final static String manTest2Str = "10000";
	final static String manTest3Str = "10000000";
	final static String senTestStr = "1800";
	final static String senTest2Str = "91800";
	final static String hyakuTestStr = "800";
	final static String jyuuTestStr = "90";
	final static String jyuuTestStr2 = "1";
	
	final static String[] bigNums = new String[] {
			"10",
			"1700",
			"6540",
			"25000",
			"62001",
			"100000",
			"280000",
			"999000",
			"1000000",
			"7200000",
			"9530000",
			"6000503",
			"10000000",
			"50000000",
			"55550000",
			"100000000",
			"100000001",
			"870000000",
			"999999999"
	};
	
	final static String[] bigNumsAns = new String[] {
			"十",
			"千七百",
			"六千五百四十",
			"二万五千",
			"六万二千一",
			"十万",
			"二十八万",
			"九十九万九千",
			"百万",
			"七百二十万",
			"九百五十三万",
			"六百万五百三",
			"一千万",
			"五千万",
			"五千五百五十五万",
			"一億",
			"一億一",
			"八億七千万",
			"九億九千九百九十九万九千九百九十九"
	};
	
	/**
	 * Runs our test cases.
	 * @param	args	Not used
	 */
	public static void main(String[] args) {	
		
		assert SuuKotoba.numToWord(chouTestStr).equals("二兆四千八百六十九億五千四百三十七万一千八百九十一");
		
		// icchou (not just chou)
		assert SuuKotoba.numToWord(chouTest2Str).equals("一兆");
		
		assert SuuKotoba.numToWord(okuTestStr).equals("四千八百六十九億");
		
		// ichioku (not just oku)
		assert SuuKotoba.numToWord(okuTest2Str).equals("一億");
		
		assert SuuKotoba.numToWord(manTestStr).equals("五千四百三十七万");
		
		// ichiman (not just man)
		assert SuuKotoba.numToWord(manTest2Str).equals("一万");
		
		// TODO: senman and issenman are both acceptable
		assert SuuKotoba.numToWord(manTest3Str).equals("一千万");
		
		// This should only produce "一千" if in the context of a larger number
		assert SuuKotoba.numToWord(senTestStr).equals("千八百") : SuuKotoba.numToWord(senTestStr); 
		assert SuuKotoba.numToWord(senTest2Str).equals("九万一千八百");
		
		assert SuuKotoba.numToWord(hyakuTestStr).equals("八百");
		
		assert SuuKotoba.numToWord(jyuuTestStr).equals("九十");

		assert SuuKotoba.numToWord("1").equals("一");

		for (int i = 0; i < bigNums.length; i++) {
			String result = SuuKotoba.numToWord(bigNums[i]);
			assert result.equals(bigNumsAns[i]) : "Expected: " + bigNumsAns[i] + " | Got: " + result; 
		}
		
		System.out.println("All tests passed!");
	}

}
