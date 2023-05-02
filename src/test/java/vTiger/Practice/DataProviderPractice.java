package vTiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	@Test(dataProvider = "getData")
	public void sampleTest(String PhoneName, int price)
	{
		System.out.println(PhoneName+" ---> "+price);
	}
	
	@DataProvider
	public Object[][] getData()
	{                              //row //cel
		Object[][] data = new Object[3][2];
		
		data[0][0] = "Samsung";
		data[0][1] = 10000;
		
		data[1][0] = "Iphone";
		data[1][1] = 5000;
		
		data[2][0] = "Nokia";
		data[2][1] = 8000;
		
		return data;
	}
	

}
