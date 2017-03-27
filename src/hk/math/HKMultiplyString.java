package hk.math;


/**
 * 大数相乘类
 * 
 * @author pyboy
 * 
 */
public class HKMultiplyString {

	/**
	 * 两个大数相乘，large1、large2必须为0-9的字符串
	 * @param large1
	 * @param large2
	 * @return 大数相乘结果
	 */
	public static String hkMultiply(String large1, String large2) {
		HKMultiplyString hkMultiplyString = new HKMultiplyString();
		if (hkMultiplyString.verify(large1) && hkMultiplyString.verify(large2)) 
			return hkMultiplyString.multiply(large1, large2);
		throw new IllegalArgumentException("params string only contain 0~9");
	}
	
	private HKMultiplyString(){}
	
	/**
	 * 验证入参是否为数字字符串
	 * @param large1
	 * @return true：全部为数字，false：其他
	 */
	private boolean verify (String large1) {
		char[] nums = large1.toCharArray();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= '0' || nums[i] <= '9') {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
	
	

	/**
	 * 
	 * @param num1 大数1
	 * @param num2 大数2
	 * @return
	 */
	private String multiply(String num1, String num2) {

		int len1 = num1.length();
		int len2 = num2.length();

//		char[] s1 = num1.toCharArray();
//		char[] s2 = num2.toCharArray();

		// 高低位对调
//		covertdata(s1, len1);
//		covertdata(s2, len2);

		char[] s1 = new StringBuffer(num1).reverse().toString().toCharArray();
		char[] s2 = new StringBuffer(num2).reverse().toString().toCharArray();

		return multiply(s1, len1, s2, len2);

	}

	/**
	 * 高低位对换
	 * @param data
	 * @param len
	 */
//	private void covertdata(char data[], int len) {
//		// 高低位对调
//		for (int i = 0; i < len / 2; i++) {
//			data[i] += data[len - 1 - i];
//			data[len - 1 - i] = (char) (data[i] - data[len - 1 - i]);
//			data[i] = (char) (data[i] - data[len - 1 - i]);
//		}
//	}

	/**
	 * 大整数相乘
	 * @param a
	 * @param alen
	 * @param b
	 * @param blen
	 * @return
	 */
	private String multiply(char a[], int alen, char b[], int blen) {
		// 两数乘积位数不会超过乘数位数和+ 3位
		int csize = alen + blen + 3;
		// 开辟乘积数组
		int[] c = new int[csize];
		// 乘积数组填充0
		for (int ii = 0; ii < csize; ii++) {
			c[ii] = 0;
		}
		// 对齐逐位相乘
		for (int j = 0; j < blen; j++) {
			for (int i = 0; i < alen; i++) {
//            	c[i + j] +=  Integer.parseInt(String.valueOf(a[i]))* Integer.parseInt(String.valueOf(b[j]));
				c[i + j] += (a[i] - '0') * (b[j] - '0');
			}
		}
		int m = 0;
		// 进位处理
		for (m = 0; m < csize; m++) {
			int carry = c[m] / 10;
			c[m] = c[m] % 10;
			if (carry > 0)
				c[m + 1] += carry;
		}
		// 找到最高位
		for (m = csize - 1; m >= 0;) {
			if (c[m] > 0)
				break;
			m--;
		}
		// 由最高位开始打印乘积
		StringBuffer sBuffer = new StringBuffer();
		for (int n = 0; n <= m; n++) {
			sBuffer.append(c[m - n]);
		}
		if (sBuffer.length() == 0) {
			sBuffer.append(0);
		}
		return sBuffer.toString();
	}
	
	public static void main(String[] args) {
		long current = System.currentTimeMillis();
		String num1 = HKRandom.randomBigNum();
		String num2 = HKRandom.randomBigNum();
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num1 +"*"+num2+"="+HKMultiplyString.hkMultiply(num1, num2));
		System.out.println("耗时:"+(System.currentTimeMillis() - current));
		
	}
}
