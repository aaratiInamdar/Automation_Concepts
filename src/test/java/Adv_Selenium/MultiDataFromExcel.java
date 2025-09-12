package Adv_Selenium;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class MultiDataFromExcel {
@Test
	public void getDataFromExcel() throws EncryptedDocumentException, IOException{
		FileInputStream fis=new FileInputStream("./TestData/a.xlsx");
		HashMap map=new HashMap();
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int count = sh.getLastRowNum();
		for(int i=0 ; i<=count ;i++)
		{
			 Cell key = sh.getRow(i).getCell(0);			 
			 String data = sh.getRow(i).getCell(1).getStringCellValue();
			 map.put(key, data);
		}		
		System.out.println(map);		
	}
}
