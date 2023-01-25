package com.crm.Actitime.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.stream.FileCacheImageInputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.support.PageFactory;

public class Readdatafromxlsx {
	
	public String readDatafromExcel(String sheetname,int row, int cell) throws EncryptedDocumentException, IOException {
		
		FileInputStream file=new FileInputStream("./TestData/TestData.xlsx.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		String exl = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		return exl;
		
	}	
}
