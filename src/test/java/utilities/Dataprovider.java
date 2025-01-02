package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataprovider {
	
	@DataProvider(name="logindata")
	public String [][] getData() throws IOException {
		
		String path=".\\testData\\testData.xlsx";
		ExcelUtility xlutil=new ExcelUtility(path);
		
		int total_rows = xlutil.getRowCount("Sheet1");
		int total_cols = xlutil.getCellCount("Sheet1", 1);
		
		String logindata[][]=new String [total_rows][total_cols];
		
		for(int r=1;r<=total_rows;r++) {
			
			for(int c=0;c<total_cols;c++) {
				logindata[r-1][c]=xlutil.getCellData("Sheet1", r, c);
				
			}
			
		}
		return logindata;
		
	}
	
	
	
	
	
	
	

}
