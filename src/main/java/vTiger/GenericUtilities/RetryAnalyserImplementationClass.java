package vTiger.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class is an implementation class for IRETRYNALYAER interface of testNG.
 * @author Chaitra M
 *
 */
public class RetryAnalyserImplementationClass implements IRetryAnalyzer{

	int count = 0;
	int retryCount = 3; // analyse manually and get the retry count
	
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		     //0<3 - 1
		     //1<3 - 2
		     //2<3 - 3
		     //3<3 - false
		while(count<retryCount)
		{
			count++;//1 2 3
			return true;
		}
		
		
		return false;
	}

}
