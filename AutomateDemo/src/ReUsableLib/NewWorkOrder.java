package ReUsableLib;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.GetElementText;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DemoPackage.DomainCreation;

public class NewWorkOrder extends DomainCreation {

	

		
		/*System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe"); 
		WebDriver driver=new ChromeDriver();
		//ChromeOptions chromeOptions = new ChromeOptions();
		//chromeOptions.addArguments("--start-maximized");
		//driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:72");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.findElement(By.id("username")).sendKeys("sam");
	driver.findElement(By.id("password")).sendKeys("admsam");
	driver.findElement(By.id("validate")).click();
	Thread.sleep(2000);*/
	
	public static void WorkOrder() throws Exception {
		
		
		WebDriver driver=newmethod();
	driver.findElement(By.xpath("//a[contains(text(),'Intervention management')]")).click();
	Thread.sleep(1000);
	//Now handling the frame as all the list is inside the frame
	driver.switchTo().frame("titre");
	//Clicking the web Element required
	driver.findElement(By.id("New operation")).click();
	//navigate to domain selection by getting to that default frame
	Thread.sleep(1000);
	driver.switchTo().defaultContent();
	driver.switchTo().frame("menu");//switching back to required frame
	driver.findElement(By.xpath("//a[contains(text(),'Direct report')]")).click();
    /*List<WebElement> h=	driver.findElements(By.tagName("frameset"));//To get the details of the frames exists
    System.out.println(h.size());*/
	Thread.sleep(1000);
    driver.switchTo().defaultContent();
    driver.switchTo().frame("corps");
    WebElement DME=driver.findElement(By.id("acDomaine_input"));//Domain is an Autocomplete so selecting the domain name present
    Thread.sleep(2000);
    DME.sendKeys("Domain");
    Thread.sleep(5000);
    DME.sendKeys(Keys.ENTER);
    Thread.sleep(2000);
    driver.findElement(By.id("acDomLibelle_input")).sendKeys("BIO");
    Thread.sleep(3000);
    driver.findElement(By.id("acTypeOp_input")).sendKeys("CO");
    Thread.sleep(3000);
    
    driver.findElement(By.id("validazione_lnk")).click(); 
    Thread.sleep(2000);
    
   String text= driver.findElement(By.xpath("//b[contains(text(),'Your direct')]")).getText();
   System.out.println(text);
  
				}
	/*//Script to understand the data from PassingData method
	@DataProvider(name="SamFmAutomation")
	
	//Creating Two dimensional with returntype Object array by giving arrayName
	public Object[][] PassingData()
	{
	  Object[][] data=new Object[3][2];    //creating array in java with object type(Taking object as returntype is because it suffice both numbers and String data
	  data[0][0]="sam";
	  data[0][1]="admsam";                //Above is declaration and this is Initialization
	  
	  data[1][0]="ayesha";
	  data[1][1]="admsam";
	  
	  data[2][0]="sam1";
	  data[2][1]="admsam1";
	
	  return data;*/
	
	public static void Intervention() throws Exception {
		
		  
		   driver.switchTo().frame("titre");
		   driver.findElement(By.xpath("//a(contains[text(),'List of interventions'])")).click();
	}
	
	  
	  
	}

