package DemoPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Fullflow extends DomainCreation{

	
	public static void main(String[] args) throws Exception {
		UpdateXml.UpdatingAnXml();
		DomainCreation.newmethod();
		DomainCreation.DataManagement();
		DomainCreation.NewWorkOrder();
		
		
		DomainCreation.CopyWONumber();
		DomainCreation.ListOfInterventions();
		
	
	

	
	
			
		
	}
}
