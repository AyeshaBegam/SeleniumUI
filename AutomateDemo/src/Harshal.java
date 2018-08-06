
import java.io.IOException;

import ReUsableLib.ExcelDataRead;

public class Harshal {

	public static void main(String[] args) throws Exception {
		String file = "C:\\Selenium\\TESTDATAFolder\\TESTDATA.xlsx";
		
		System.out.println(ExcelDataRead.readData(file, 0, 2,0));
		
		
		
		
		

	}

}
