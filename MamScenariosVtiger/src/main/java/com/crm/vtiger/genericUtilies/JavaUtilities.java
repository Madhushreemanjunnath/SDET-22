package com.crm.vtiger.genericUtilies;

import java.util.Date;
import java.util.Random;

/**
 * this method is generate random number to avoid duplicates 
 * @return
 */
public class JavaUtilities {
	public static String getRandomData()
	{
		Random random =new Random();
		int ran=random.nextInt(1000);
		return " "+ran;
		
	}
	/** @madhu
	 * this method   is used to generate currentdate
	 * @return currentDate
	 * @return
	 */
public static String getCurrentDte()
{
	Date date=new Date();
	String currentdate=date.toString();
	return currentdate;
}
}
