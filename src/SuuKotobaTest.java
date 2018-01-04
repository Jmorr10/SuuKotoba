/**
 * 
 */

/**
 * @author Joseph
 *
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
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
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
		assert SuuKotoba.numToWord(senTestStr).equals("千八百");
		assert SuuKotoba.numToWord(senTest2Str).equals("九万一千八百");
		
		assert SuuKotoba.numToWord(hyakuTestStr).equals("八百");
		
		assert SuuKotoba.numToWord(jyuuTestStr).equals("九十");

		assert SuuKotoba.numToWord("1").equals("一");
		
		System.out.println("All tests passed!");
	}

}
