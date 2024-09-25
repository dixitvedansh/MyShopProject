package com.mystore.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.mystore.utility.NewExcelLibrary;


//
//
//public class DataProviders {
//	NewExcelLibrary obj = new NewExcelLibrary();
//
////Class --> LoginPageTest,HomePageTest Test Case--> loginTest, wishListTest, orderHistoryandDetailsTest
//
//	@DataProvider(name = "credentials")
//	public Object[][] getCredentials() {
//		// Totals rows count
//		int rows = obj.getRowCount("Credentials");
//		// Total Columns
//		int column = obj.getColumnCount("Credentials");
//		int actRows = rows - 1;
//
//		Object[][] data = new Object[actRows][column];
//
//		for (int i = 0; i < actRows; i++) {
//			for (int j = 0; j < column; j++) {
//				data[i][j] = obj.getCellData("Credentials", j, i + 2);
//			}
//		}
//		return data;
//	}
//}


public class DataProviders {
		@DataProvider (name = "Credentials",parallel = true)
		public Object[][] getLoginCredentials() throws IOException {
			//File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\TestData.xlsx");
			FileInputStream fi = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\TestData.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fi);
			XSSFSheet sheet = wb.getSheet("Credentials");
			int rowCount=sheet.getLastRowNum();
			XSSFRow row1 = sheet.getRow(0);
			int colCount= row1.getLastCellNum();
			System.out.println("Row Count  = "+rowCount);
			System.out.println("Column Count  = "+colCount);
			
			
			Object[][] data = new Object[rowCount][colCount];
			
			for(int i=0;i<rowCount;i++) {
				for(int j=0;j<2;j++) {
					System.out.println("Col "+i+" Row "+j+"   "+sheet.getRow(i+1).getCell(j));
					data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
					
				}
				
			}
			
			

//			XSSFRow row = sheet.getRow(1);			
//			XSSFCell unameCell = row.getCell(0);
//			String uname = unameCell.getStringCellValue();
//			System.out.println("username : "+uname);
//			XSSFCell pwCell = row.getCell(1);
//			String pw = pwCell.getStringCellValue();
//			System.out.println("password : "+pw);
//			Object[][] data = new Object[1][2];
//			data[0][0]=uname;
//			data[0][1]=pw;
			
			return data;
			
		
	}
	
}
 