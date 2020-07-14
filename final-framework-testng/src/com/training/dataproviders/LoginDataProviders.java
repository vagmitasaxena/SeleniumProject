package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.bean.FilterProductBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

//		List<LoginBean> list = new ELearningDAO().getLogins();
		List<FilterProductBean> list = new ELearningDAO().getFilterProducts();
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(FilterProductBean temp : list){
			Object[]  obj = new Object[6]; 
			obj[0] = temp.getProductName();
			obj[1] = temp.getPrice();
			obj[2] = temp.getStatus();
			obj[3] = temp.getModel();
			obj[4] = temp.getQuantity();
			obj[5] = temp.getImage();
						
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs1")
	public Object[][] getExcelData1(){
		String fileName ="C:\\Users\\SaritaKumari\\Desktop\\Saritha\\IBM_SARITA_Personal\\SELENIUM_API\\Selenium\\PROJECT\\TestData\\TestDataInput.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName, "Sheet1"); 
	}
	
	@DataProvider(name = "excel-inputs2")
	public Object[][] getExcelData2(){
		String fileName ="C:\\Users\\SaritaKumari\\Desktop\\Saritha\\IBM_SARITA_Personal\\SELENIUM_API\\Selenium\\PROJECT\\TestData\\TestDataInput.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName, "Sheet2"); 
	}
	
	@DataProvider(name = "excel-inputs3")
	public Object[][] getExcelData3(){
		String fileName ="C:\\Users\\SaritaKumari\\Desktop\\Saritha\\IBM_SARITA_Personal\\SELENIUM_API\\Selenium\\PROJECT\\TestData\\TestDataInput.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName, "Sheet3"); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
}
