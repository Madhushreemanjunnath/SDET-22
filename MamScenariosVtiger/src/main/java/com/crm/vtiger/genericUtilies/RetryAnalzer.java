package com.crm.vtiger.genericUtilies;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalzer implements IRetryAnalyzer {
	int count=0;
int retrycount=3;
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		while(count<retrycount)
		{
			return true;
		}
		return false;
	}
	
	

}
