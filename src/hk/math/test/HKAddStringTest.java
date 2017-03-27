package hk.math.test;

import hk.math.HKAddString;
import hk.math.HKRandom;

import org.junit.Before;
import org.junit.Test;

public class HKAddStringTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAdd1() {
		HKAddString.add1(HKRandom.randomBigNum(), HKRandom.randomBigNum());
	}

	@Test
	public void testAdd2() {
		HKAddString.add2(HKRandom.randomBigNum(), HKRandom.randomBigNum());
	}

}
