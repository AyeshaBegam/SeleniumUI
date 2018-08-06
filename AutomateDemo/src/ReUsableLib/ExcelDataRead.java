package ReUsableLib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataRead {
	
	/*XSSFWorkbook wb;
	XSSFSheet sheet1;
	
	public ExcelDataRead(String ExcelPath)                  //Parameterized constructor(same as class name) used to load the excel sheet everytime.Also excel path where it is located
	{
		try {                                                  //Selecting all lines of code and rightclick and surrounded with try catch method to removes exceptions occurring
			File data=new File("ExcelPath");                   //Path where the file is present with creating the object, without giving"C:\\Selenium\\TESTDATAFolder\\TESTDATA.xlsx" as it would be as hard coded thing
			FileInputStream fis = new FileInputStream(data);                  //Here it is a separate class which needs a file path so specifying "data".
			
			 wb=new XSSFWorkbook(fis);//It is method in apache poi package(For XLSX-XSSF,XLS-HSSF)
			sheet1=wb.getSheet("General");//Data to be there in the sheet specified
		
		} 
		catch (Exception e) {
			
			System.out.println(e.getMessage());//In case of exceptions comes simply print the message for user understanding.
		}
	}
	
	
	public String getdata(String sheetName,int rownum,int colnum) 
	{
	
		String data=sheet1.getRow(rownum).getCell(colnum).getStringCellValue();
		return data;
	}*/
	
	public static String readData(String filePath, int sheetNum, int row, int col) throws Exception
	{
		File data=new File(filePath);//Path where the file is present with creating the object
		FileInputStream fis=new FileInputStream(data);//Here it is a separate class which needs a file path so specifying "data".
		XSSFWorkbook wb=new XSSFWorkbook(fis);//It is method in apache poi package(For XLSX-XSSF,XLS-HSSF)
		XSSFSheet sheet1=wb.getSheetAt(sheetNum);//Data to be there in the sheet specified
		String data1 = sheet1.getRow(row).getCell(col).getStringCellValue();
		
		return data1;
	}
	
	
	
	
	
}
	


