package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public static FileInputStream fis = null;
	public static Workbook wb = null;
	public static Sheet sh = null;
	
	public static String readCell (String filePath,String SheetName,int row, int col) {
		DataFormatter df= new DataFormatter();
		try {
			fis= new FileInputStream(filePath);
			wb= WorkbookFactory.create(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {	
			e.printStackTrace();
		}		
		sh= wb.getSheet(SheetName);
		Cell c= sh.getRow(row).getCell(col);
		return df.formatCellValue(c);
			
		}
	
	public static void main(String[] args) {
		String poiValue=readCell(System.getProperty("user.dir")+"/src/test/resources/TestData.xlsx", "login", 1, 0);
		String jxlValue=readCell(System.getProperty("user.dir")+"/src/test/resources/Test.xls", "login", 1, 0);
		
		System.out.println(poiValue);
		System.out.println(jxlValue);
	}
}
