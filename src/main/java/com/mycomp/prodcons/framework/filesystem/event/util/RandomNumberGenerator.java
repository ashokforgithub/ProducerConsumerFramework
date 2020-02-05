/**
 * 
 */
package com.mycomp.prodcons.framework.filesystem.event.util;

import java.util.Random;

/**
 * @author Ashok
 *
 */
public class RandomNumberGenerator {
	
	private static Random random = new Random();
	
	private static int seed= 1000;
	
	/**
	 *  hiding constructor
	 */
	private RandomNumberGenerator() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param numberUpperBound
	 * @return
	 */
	public static int randomInt(int numberUpperBound)
	{
		return random.nextInt(numberUpperBound);
	}
	
	
	/**
	 * @return
	 */
	public static int randomInt()
	{
		return random.nextInt(seed);
	}

	/**
	 * @param numberUpperBound
	 * @return
	 */
	public static double randomDouble(int numberUpperBound)
	{
		return random.nextInt(numberUpperBound);
	}
	
	
	/**
	 * @return
	 */
	public static double randomDouble()
	{
		return random.nextInt(seed);
	}


}
