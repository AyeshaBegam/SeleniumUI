package DemoPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFunctions {

	//	//Generic Excel Data Method from where the data is read(Apache POI jars need to be added)
	
	public static void ReadingDataFromExcel(String filePath,String SheetName,int RowNum,int ColNum) throws Exception {
		try { 
			
		File Data= new File(filePath);
		 FileInputStream file=new FileInputStream(Data);
		 XSSFWorkbook wb = new XSSFWorkbook(file);//File should always be Xlsx for this code
		 XSSFSheet sh= wb.getSheet(SheetName);
		 String get = sh.getRow(RowNum).getCell(ColNum).getStringCellValue();
		
		if(get.equalsIgnoreCase("YES"))
		{
			for(int RowNum1=1; RowNum1<=sh.getLastRowNum();RowNum1++){
				System.out.println("Running the data of the required script");	
			}
		}
		else {
			
		}
		}
		
		 catch(Exception e) {
			
		}
		}
	
	 public static void WritingDataInExcel(String filePath,String SheetName,int RowNum,int ColNum,String Result) {
		 try {
			 File Data= new File(filePath);
			 FileOutputStream fos= new FileOutputStream(Data);
			 XSSFWorkbook wb= new XSSFWorkbook();
			 wb.write(fos);
			 XSSFSheet sh= wb.getSheet(SheetName);
			 XSSFCell Create=sh.createRow(RowNum).createCell(ColNum);
			 Create.setCellValue(Result);
			 
		 }
		 catch(Exception e) {
			 
		 }
		 
		}
	 public static void main(String[] args) throws Exception {
		 ExcelFunctions.ReadingDataFromExcel("C:\\Selenium\\ExcelSheets\\TestData.xlsx", "LoginDetails", 1, 4 );
	 }
	 
	
}
