package vTiger.Practice;

import java.io.IOException;

import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {
	
	public static void main(String[] args) throws IOException {
		
		JavaUtility jUtil = new JavaUtility();
		int value = jUtil.getRandomNumber();
		System.out.println(value);
		
		System.out.println(jUtil.getSystemDate());
		
		System.out.println(jUtil.getSystemDateinFormat());
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String value1=pUtil.readDatafromPropertyFile("browser");
		System.out.println(value1);
		
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String data = eUtil.readDataFromExcel("Organization", 1, 2);
		System.out.println(data);
		
		eUtil.writeDataIntoExcel("Hi", 5, 7, "SpiderMan");
		System.out.println("data added");
		
	}

}
