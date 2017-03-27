package hk.math;

public class HKRandom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		for (int i = 0; i < 200000; i++) {
//			System.out.println(HKRandom.randomBigNum(130));
			HKRandom.randomBigNum(1300);
		}
		System.out.println(System.currentTimeMillis() - time);
	}
	/**
	 * 生成一个随机数
	 * @return
	 */
	public static String randomBigNum () {
//		return randomBigNum((int) Math.ceil(Math.random() * Integer.MAX_VALUE));
		return randomBigNum((int) Math.ceil(Math.random() * 10000));
	}
	
	/**
	 * 生成一个num位的随机数
	 * @param num
	 * @return
	 */
	public static String randomBigNum (int num) {
		if (num <= 0) {
			throw new IllegalArgumentException("params number must greater than zero");
		}
		StringBuilder sb = new StringBuilder(num);
		sb.append(randomHeadNum());
		for (long i = 0; i < num - 1; i++) {
			sb.append(randomSingleNum());
		}
		return sb.toString();
	}
	
	/**
	 * 随机生成一个一位的0～9的数
	 * @return
	 */
	public static int randomSingleNum() {
		// 生成一个0～9的随机数
		return (int) Math.floor(Math.random() * 10);
	}
	
	/**
	 * 随机生成一个一位的1～9的数
	 * @return
	 */
	public static int randomHeadNum() {
		// 生成1～9的随机数
		return (int)Math.ceil(Math.random() * 9);
	}

}
