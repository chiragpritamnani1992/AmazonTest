package com.qa.utility;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.*;

public class MasterData {
	
	public static String excellocation="C:\\Users\\HP\\Java_Amazon\\AmazonTest\\src\\main\\java\\com\\qa\\data\\datasheet_1.xlsx";
	private static FileInputStream fis;
	private static XSSFSheet sheet;
	private static XSSFRow row;
	private static XSSFWorkbook workbook;
	static Map<String,String> myMap;
	public static void main(String[] args) throws Exception
	{
		System.out.println(getData(readExcelData(), "uname"));
		//System.out.println(readExcelData());
		//String val = getData(readExcelData(),"Lname");
		//System.out.println(val);
				
	}
	public static void loadExcel() throws IOException
	{
		File file= new File(excellocation);
		fis=new FileInputStream(file);
		workbook= new XSSFWorkbook(fis);
		sheet= workbook.getSheet("sheet1");
		fis.close();
	}
	
	public static List<Map<String,String>> readExcelData()  throws Exception
	{
		
		if(sheet==null)
		{
			loadExcel();
			
		}
		List<Map<String,String>> mapLists = new ArrayList<Map<String, String>>();
		
		int rows= sheet.getLastRowNum();
		row= sheet.getRow(0);
		
		for(int j=1;j<row.getLastCellNum();j++)
		{
			myMap= new HashMap<String, String>();
			
			for(int i=0;i<rows+1;i++)
			{
				Row r= CellUtil.getRow(i, sheet);
				String key= CellUtil.getCell(r, 0).getStringCellValue();
				String value= CellUtil.getCell(r, j).getStringCellValue();
	
				myMap.put(key, value);
				
			}
			mapLists.add(myMap);
		}
		
		return mapLists;
	
	}
	
	public static List<String> getData(List<Map<String,String>> readExcelData,String key) throws Exception{
		
		List<String> values = new ArrayList<String>();
		for(Map<String,String> map : readExcelData)
		{
			values.add(map.get(key));
			
			
		}
		return values;
	
	}
	//Above solution is meant to give you single value stored in key at 1 data set ONLY.
	//if u need to retrieve all values for specific  key from different sets of column, then you will have to collect them and as you loop.
	
}
