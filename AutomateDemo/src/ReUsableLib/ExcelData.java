package ReUsableLib;

import java.io.File;//Separate class import coming from java used to specify the file
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFHyperlink;                   
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	public static void main(String[] args) throws Exception {  //Instead of FileNotFoundException Using general exception to handle any type of exception
		// TODO Auto-generated method stub
      
		File data=new File("C:\\Selenium\\TESTDATAFolder\\TESTDATA.xlsx");//Path where the file is present with creating the object
		FileInputStream fis=new FileInputStream(data);//Here it is a separate class which needs a file path so specifying "data".
		XSSFWorkbook wb=new XSSFWorkbook(fis);//It is method in apache poi package(For XLSX-XSSF,XLS-HSSF)
		XSSFSheet sheet1=wb.getSheet("General");//Data to be there in the sheet specified
		
		int LastRowCount=sheet1.getLastRowNum();
		System.out.println("Data Present in Excelsheet is" + LastRowCount);
		
		for(int i=1;i<LastRowCount;i++)
		{
			String URLdata=sheet1.getRow(i).getCell(0).getStringCellValue();//As we are reading URL's
			System.out.println("Urls in each row is" + URLdata);
		}
		
		
		
		/*//String Value0=sheet1.getRow(0).getCell(0).getStringCellValue(); //data inside the cell is string so "getStringCellValue".
		XSSFHyperlink Value0=sheet1.getRow(0).getCell(0).getHyperlink();//As it is a link using hyperlink
		System.out.println("Data is collected from 1st column"+Value0);*/
		wb.close();
	}

}
