package vTiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Step 1: Open the document in Java readable format using fileinputStream
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step 2: Create A workbook using workbook factory
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step 3: get the control of Sheet
		Sheet sh = wb.getSheet("Organization");
		
		//Step 4: get the control of Row
		Row rw = sh.getRow(1);
		
		//Step 5: get the control of cell
	    Cell ce = rw.getCell(2);
		
		//Step 6: read the data inside the cell
	    String value = ce.getStringCellValue();
	    System.out.println(value);
		
		//Step 7: close the workbook
	    wb.close();
	}

}
