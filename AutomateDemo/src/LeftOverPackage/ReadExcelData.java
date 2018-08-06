package LeftOverPackage;

import ReUsableLib.ExcelDataRead;

public class ReadExcelData {

	public static void main(String[] args) {
		
		ExcelDataRead excel=new ExcelDataRead("C:\\Selenium\\TESTDATAFolder\\TESTDATA.xlsx");
		System.out.println(excel.getdata("General", 4, 1));

	}

}
