package hk.math;

public class HKAddString {

	// 大整数加法
	public static String add1(String num1, String num2) {
		int extra = 0;
		int index = 0;
		String longNum, shortNum;
		StringBuffer result = new StringBuffer();
		if (num1.length() > num2.length()) {
			longNum = num1;
			shortNum = num2;
		} else {
			longNum = num2;
			shortNum = num1;
		}
		char[] longChar = new StringBuffer(longNum).reverse().toString()
				.toCharArray();
		char[] shortChar = new StringBuffer(shortNum).reverse().toString()
				.toCharArray();
		for (int i = 0; i < shortChar.length; i++) {
			int c = longChar[i] + shortChar[i] - '0' - '0' + extra;
			extra = c / 10;
			c = c % 10;
			result.append(c);
		}
		index = shortChar.length;
		while (index == longChar.length) {
			int c = longChar[index] - '0' + extra;
			extra = c / 10;
			c = c % 10;
			result.append(c);
		}
		if (extra > 0) {
			result.append(extra);
		}
		return result.reverse().toString();
	}
	
	public static String add2(String num1, String num2) {
		int[] result = new int[Math.max(num1.length(), num2.length())];
		char[] s1, s2;
		// s1长
		if (num1.length() >= num2.length()) {
			s1 = new StringBuffer(num1).reverse().toString().toCharArray();
			s2 = new StringBuffer(num2).reverse().toString().toCharArray();
		} else {
			s2 = new StringBuffer(num1).reverse().toString().toCharArray();
			s1 = new StringBuffer(num2).reverse().toString().toCharArray();
		}
		
		for (int i = 0; i < result.length; i++) {
			if (i >= s2.length) {
				result[i] = s1[i] - '0';
			} else 
				result[i] = s1[i] + s2[i] - '0' - '0';
		}
		// 进位处理
		int carry = 0;
		StringBuffer s = new StringBuffer();
		for (int m = 0; m < result.length; m++) {
			carry = result[m] / 10;
			result[m] = result[m] % 10;
			s.append(result[m]);
			if (carry > 0)
				if (m + 1 == result.length) {
					s.append(carry);
				} else 
					result[m + 1] += carry;
		}
		
		return s.reverse().toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		String num1 = HKRandom.randomBigNum();
		String num2 = HKRandom.randomBigNum();
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num1 +"+"+num2+"="+HKAddString.add2(num1, num2));
		System.out.println(System.currentTimeMillis() - time);
	}

}
