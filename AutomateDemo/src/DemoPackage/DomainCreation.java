package DemoPackage;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DomainCreation extends Generic {
	

	 
	 public static void DataManagement() throws Exception {
	Generic.vocabulary();
	driver.findElement(By.xpath("//a[contains(text(),'Data management')]")).click();
   Thread.sleep(2000);
	driver.switchTo().frame("titre");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.id("Asset data")).click();
	Thread.sleep(2000);
	driver.switchTo().defaultContent();
	driver.switchTo().frame("menu");
	driver.findElement(By.partialLinkText("Domains")).click();
	Thread.sleep(2000);
	driver.switchTo().defaultContent();
	driver.switchTo().frame("corps");
	driver.findElement(By.partialLinkText("Insert")).click();
	Thread.sleep(2000);
	//Handling Window from WindowHandles Method
	Generic.WindowHandles();
	//Doing normal selenium code for performing action in child window

     driver.switchTo().frame("gda_corps");
    
     driver.findElement(By.xpath("//input[@name='dom_code']")).sendKeys("Domain");//Domain code
     Thread.sleep(1000);
     driver.findElement(By.xpath("//input[@name='dom_libelle']")).sendKeys("AutoTesting");//Label 
     Thread.sleep(1000);
     Generic.ClickButton("Validate");//Validate Button
     Thread.sleep(2000);
     // Capturing alert message.    
     Generic.AletsPopup();                                                                                                                                                                                                                                                                                                                                                                                                                                  
    
    
     driver.close();
    Generic.ReturnNormalWindow();
     
	}
	
public static void NewWorkOrder() throws Exception{
	Generic.vocabulary();
	Thread.sleep(5000);
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
    Thread.sleep(5000);
    driver.findElement(By.id("acDomLibelle_input")).sendKeys("BIO");
    Thread.sleep(3000);
    driver.findElement(By.id("acTypeOp_input")).sendKeys("CO");
    Thread.sleep(3000);
    Generic.HandlingDateTimePicker("01/04/18", "01/04/18");//Planned date entered
	driver.findElement(By.id("lien_bloc_affectationPatrimoine")).click();
    WebElement site= driver.findElement(By.id("acLocSite_input"));
    
    site.sendKeys("paris");
    
    Thread.sleep(3000);
    driver.findElement(By.id("validazione_lnk")).click(); 
    Thread.sleep(2000);
    Generic.CopyWONumber();
}

   
 public static void ListOfInterventions() throws Exception {
    	
	driver.switchTo().defaultContent();
	driver.switchTo().frame("titre");
    driver.findElement(By.partialLinkText("List of interventions")).click();//Going to List of Interventions
    driver.switchTo().defaultContent();
    driver.switchTo().frame("corps");
    Thread.sleep(2000);
    //As Organize my Filters is a dropdown so using select class for that
    WebElement OrgMyFilters=driver.findElement(By.id("pglf_seq"));
    Select Filter=new Select(OrgMyFilters);
    Filter.selectByVisibleText("Testing");
    Thread.sleep(2000);;
    driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(result,Keys.ENTER);
    Thread.sleep(2000);
    driver.findElement(By.id("select_all")).click();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.findElement(By.partialLinkText("Report")).click();//Clicking on report button
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    Generic.WindowHandles();//Handling Parent and child Window
    //Working with Radio button
    WebElement InProgressRadioBtn = driver.findElement(By.id("oper_termine_0"));
    WebElement Completed = driver.findElement(By.id("oper_termine_1"));
    Thread.sleep(2000);
    Completed.click();
    Thread.sleep(2000);
    Generic.ClickButton("Validate");
    Generic.ClickButton("Supervise");
    Thread.sleep(2000);
    Generic.AletsPopup();
    alert.accept();
    
}
}


