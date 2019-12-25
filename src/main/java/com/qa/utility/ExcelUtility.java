package com.qa.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	static Cell valueCell;
	static String value;
	// Excel is a file : Workbook > Sheets > Rows > Cells
	// Apache provies some classes to read this
	
	// To open the File in Input Mode: File Input Stream
	// To Write : File Output Stream
	// XSSFWorkbook : To read data from wb
	// XSSFSheet : To ..sheet
	// XSSFRows
	// XSSFCell
	public static Map<String, Map<String, String>> setMapData() throws IOException
	{
		
		FileInputStream fis = new FileInputStream("C:\\Users\\HP\\Java_Amazon\\AmazonTest\\src\\main\\java\\com\\qa\\data\\datasheet.xlsx");
		
		Workbook wb = new XSSFWorkbook(fis);
		
		Sheet sheet= wb.getSheet("Data");
		
		int lastRow= sheet.getLastRowNum();
		
		
		int columncount = sheet.getRow(0).getLastCellNum();
		
		Map<String, Map<String, String>> excelFileMap = new HashMap<String, Map<String,String>>();
		
		Map<String, String> dataMap = new HashMap<String, String>();
		
		for(int i=0;i<=lastRow;i++)
		{
			Row  row =sheet.getRow(i);
			
			
	
			Cell keyCell = row.getCell(0);
			System.out.println(keyCell);
			String key = keyCell.getStringCellValue().trim();
			
			int columncount1 = row.getLastCellNum();
			for(int j=1;j<columncount1;j++)
			{
				valueCell = row.getCell(j);
				value = valueCell.getStringCellValue().trim();
				System.out.print(" " +value);
				dataMap.put(key, value);
			}
			System.out.println();
			
			
			
			//String value = valueCell.getStringCellValue().trim();
			
			//Putting key & value in dataMap
			
			excelFileMap.put("DataSheet", dataMap);
			
		}
		 //Returning excelFileMap
			return excelFileMap;
		
	}
	
		//Method to retrieve value
		public static String getMapData(String key) throws IOException{
	 
		    Map<String, String> m = setMapData().get("DataSheet");
			String value = m.get(key);
			System.out.println(value);
			return value;
			
		}
		public static void main(String[] args) throws IOException {
			ExcelUtility r = new ExcelUtility();
			
			String val = r.getMapData("Fname");
			
			System.out.println("Value of the keyword (search) is- "+val);
			
	 
		}
	
}
