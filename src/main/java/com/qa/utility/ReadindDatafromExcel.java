package com.qa.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class ReadindDatafromExcel {

	
	
public static void main(String[] args) throws IOException	
{
	
	
	
	FileInputStream fis = new FileInputStream("C:\\Users\\HP\\Java_Amazon\\AmazonTest\\src\\main\\java\\com\\qa\\data\\datasheet.xlsx");
	
	XSSFWorkbook workbook= new XSSFWorkbook(fis);   // cox this wb is present under this file
	XSSFSheet sheet = workbook.getSheet("Sheet1" ); // providing the sheet name
	
	
	
	// how to count no of rows and cols
	// rows are present under the sheet
	
	int rowcount = sheet.getLastRowNum(); //Rowcount
	//System.out.println(rowcount);
	
	// Now we need get the column count
	// column is nothing but cell :it is present in row 
	
	int columncount = sheet.getRow(0).getLastCellNum(); // no fo cells present in the row
	
	System.out.println(columncount);
	
	for(int i=1;i<rowcount;i++)
	{
		XSSFRow currentrow = sheet.getRow(i); // Focussed on current row and stored it in XSSFRow datatype
		
		for(int j=0;j<columncount;j++) // For incrementing the cells
		{
			String value = currentrow.getCell(j).getStringCellValue(); // This stat will read the value from the cell
			System.out.print(" " + value);
		}
		System.out.println();
	}
	
	//String.valueof() : convert int to string
/*	FileOutputStream fis1 = new FileOutputStream("C:\\Users\\HP\\Java_Amazon\\AmazonTest\\src\\main\\java\\com\\qa\\data\\datasheet.xlsx");

	XSSFWorkbook workbook1= new XSSFWorkbook();
	XSSFSheet sheet1 = workbook1.createSheet("Data");
	
	for(int i=0;i<5;i++)
	{
		XSSFRow row = sheet1.createRow(i);
		for(int j=0;j<3;j++)
		{
			row.createCell(j).setCellValue("XyX");
		}
		
	}
	workbook1.write(fis1);
	fis1.close();
	System.out.println("Data Completed");*/
	
}

	
}
