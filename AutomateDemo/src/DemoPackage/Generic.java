package DemoPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.CaptureScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Generic{
	
	
	static Alert alert;//AletsPopup
	static String result;//Used under CopyWONumber 
	static String patName;
	static String chldName;
	
	public static void WindowHandles() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
	    //patName will provide you parent window
		patName = itr.next();

		//chldName will provide you child window
		 chldName = itr.next();

		//Switch to child window
		driver.switchTo().window(chldName);
		driver.manage().window().maximize();
		
	}
	
	public static void ReturnNormalWindow() {
		 driver.switchTo().window(patName);//Switching back to parent window
	     driver.switchTo().frame("titre");
	     driver.findElement(By.partialLinkText("Main Menu")).click();
	}
	public static  WebDriver driver;
	static {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\Chromedriver\\chromedriver.exe"); 
		driver=new ChromeDriver();
		
	}
	
	public static void newmethod() throws Exception{
		//System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe"); 
		 //WebDriver driver=new ChromeDriver();
//		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.addArguments("--start-maximized");
//		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://localhost:9999");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.findElement(By.id("username")).sendKeys("sam");
	    driver.findElement(By.id("password")).sendKeys("admsam");
		/*String file = "C:\\Selenium\\ExcelSheets\\TestData.xlsx";
		Generic.ReadingDataFromExcel(file, 1, 1, 1);
		Generic.ReadingDataFromExcel(file,1,1,2);*/
	    driver.findElement(By.id("validate")).click();
	   Thread.sleep(2000);
	}
	
	public static void ClickButton(String Button) {
		driver.findElement(By.partialLinkText(Button)).click();
	}
	
	
	/*public static void ExplicitWait() {
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}*/
	
	public static void AletsPopup(){
		try {
			alert = driver.switchTo().alert();
			 String alertMessage= driver.switchTo().alert().getText();	
		     System.out.println(alertMessage);
		     alert.accept();
		}
		catch(Exception e) {
			System.out.println("No alerts and close the window");
		}
	   }
	
	//Coping work order number that is created with workorder
	public static void CopyWONumber( ) {
		
		   String text= driver.findElement(By.xpath("//b[contains(text(),'Your direct')]")).getText();//Getting the details of the workorder created
		   System.out.println(text);
		   
		    String str = text;
		    result = str.substring(56,str.length());//Getting only the part of the string by removing the whole string(Only the Workorder number)
		    System.out.println(result);
		    
		    
		    
		}
	//Here this method is about generic date insertion
	public static void HandlingDateTimePicker (String PlanningDateFrom, String PlanningDateTo ) throws Exception {
		driver.findElement(By.id("lien_bloc_planing")).click();
		driver.findElement(By.id("oper_datedebutp")).sendKeys(PlanningDateFrom);
		Thread.sleep(2000);
		driver.findElement(By.id("oper_datefinp")).sendKeys(PlanningDateTo);
		Thread.sleep(2000);
	}

	
	public static void vocabulary() {
		String str = "English";
		
		try{
			driver.findElement(By.partialLinkText("English")).click();	
			
	}
		catch(Exception e) {
			
			System.out.println("Do not click as it is already in english");
		}
	}
	
	}



 





