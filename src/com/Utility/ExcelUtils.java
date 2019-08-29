package com.Utility;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Utility.Constant;

public class ExcelUtils {
	static ChromeDriver driver;
	static XSSFWorkbook ExcelWBook;
	static XSSFSheet ExcelWSheet;
	static XSSFCell cell;
	 public static XSSFRow Row;
	 //https://www.toolsqa.com/selenium-webdriver/data-driven-testing-excel-poi/
	
public static String getCell(int RowNum, int ColNum) {
	try {
		cell= ExcelWSheet.getRow(RowNum).getCell(ColNum);
		String cellData = cell.getStringCellValue();
		System.out.println(cellData);
		return cellData;
	}catch(Exception e) {
		e.printStackTrace();
		return "";
	}
	
}
public static String setCell(String Result,  int RowNum, int ColNum) {
	try {
		 Row  = ExcelWSheet.getRow(RowNum);
		 cell = Row.getCell(ColNum);
		 if(cell == null) {
			 cell = Row.createCell(ColNum);
			 cell.setCellValue(Result);
		 }else {
			 cell.setCellValue(Result);
			 FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);
			 
	           ExcelWBook.write(fileOut);
	 
	           fileOut.flush();
	 
	 fileOut.close();
		 }
	}catch(Exception e){
		e.printStackTrace();
	}
	
	return Result;
	
}
public static void setExcel(String path, String sheet) throws IOException {
	try {
		File src=new File(path);
		FileInputStream ExcelFile = new FileInputStream(src);
		 
		 // Access the required test data sheet
		 
		 ExcelWBook = new XSSFWorkbook(ExcelFile);
		 
		 ExcelWSheet = ExcelWBook.getSheet(sheet);
	}catch(Exception e) {
		e.printStackTrace();
	}
	int l = ExcelWSheet.getPhysicalNumberOfRows()-1; 
	System.out.println("The length of the records : " + l);
}
}