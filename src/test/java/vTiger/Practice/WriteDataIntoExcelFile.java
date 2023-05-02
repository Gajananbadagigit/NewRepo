package vTiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelFile {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Step1: open the document in Java readbale format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step 2: create the workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step 3: get the control of sheet
		Sheet sh = wb.getSheet("Contact");
		
		//Step 4: Create a Row
		Row rw = sh.createRow(11);
		
		//Step 5: Create a cell
		Cell ce = rw.createCell(7);
		
		//Step 6: set the value into the cell
		ce.setCellValue("BatMan");
		
		//Step 7: open the file in writable format
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step 8: write the data into workbook
		wb.write(fos);
		
		//Step 9: close the workbook
		wb.close();
		System.out.println("Data added and Workbook closed");
		
		
	}

}
