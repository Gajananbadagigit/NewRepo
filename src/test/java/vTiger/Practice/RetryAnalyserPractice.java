package vTiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice {
	
	@Test(retryAnalyzer = vTiger.GenericUtilities.RetryAnalyserImplementationClass.class)
	public void analyserPractice()
	{
		Assert.fail();
		System.out.println("Hi");
	}

}
