/**
 * 
 */
package com.mycomp.prodcons.framework.event.util;

import java.util.Random;

/**
 * @author ashok
 *
 */
public class EventUtils {

	private static final Random randomGen = new Random();

	public static Random getRandomGen() {
		return randomGen;
	}

	public static int getRandomInteger() {
		return randomGen.nextInt(10000);
	}

	public static long getRandomLong() {
		return randomGen.nextLong();
	}
}
