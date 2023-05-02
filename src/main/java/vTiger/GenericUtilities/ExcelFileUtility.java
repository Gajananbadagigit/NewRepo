package vTiger.GenericUtilities;

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

/**
 * This class consists of generic methods related to Excel file
 * @author Chaitra M
 *
 */
public class ExcelFileUtility {
	
	/**
	 * This method will read data from excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return 
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(ConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row rw = sh.getRow(rowNo);
		Cell cel = rw.getCell(cellNo);
		String value = cel.getStringCellValue();
		wb.close();
		return value;
	}
	
	/**
	 * This method will write the data into excel sheet
	 * @param sheetname
	 * @param rowNo
	 * @param celNo
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheetname, int rowNo, int celNo, String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(ConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.createSheet(sheetname);
		Row rw = sh.createRow(rowNo);
		Cell cel = rw.createCell(celNo);
		cel.setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(ConstantsUtility.excelFilePath);
		wb.write(fos);
		wb.close();
		
	}
	
	/**
	 * This method will capture all the data inside a sheet for dataprovider
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(ConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		int lastCel = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCel];
		
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCel;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
