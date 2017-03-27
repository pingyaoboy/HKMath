package hk.math.test;

import hk.math.HKRandom;

import org.junit.Before;
import org.junit.Test;

public class HKRandomTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testRandomBigNum() {
		HKRandom.randomBigNum();
	}

	@Test
	public void testRandomBigNumInt() {
		HKRandom.randomBigNum(5000);
	}

	@Test
	public void testRandomSingleNum() {
		HKRandom.randomSingleNum();
	}

	@Test
	public void testRandomHeadNum() {
		HKRandom.randomHeadNum();
	}

}
