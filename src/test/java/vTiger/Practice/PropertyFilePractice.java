package vTiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.interactions.Actions;

public class PropertyFilePractice {
	
	public static void main(String[] args) throws IOException {
		
		//Step 1: Load the file into Fileinputstream to make it java readable
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//Step 2: Create an Object of properties class from java.util
		Properties pObj = new Properties();
		
		//Step 3: Load the file input stream into properties
		pObj.load(fis);
		
		//Step 4: fetch the data using key
		String BROWSER = pObj.getProperty("browser");
		System.out.println(BROWSER);
		String URL = pObj.getProperty("url");
		System.out.println(URL);

		
	}

}
