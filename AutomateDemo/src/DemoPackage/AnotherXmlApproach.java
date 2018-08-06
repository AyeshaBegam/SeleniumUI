package DemoPackage;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class AnotherXmlApproach {
	public static String ReadXml(String File, String Tagname, String NodeName,int item) throws ParserConfigurationException, SAXException, IOException {
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(File);
		doc.getDocumentElement().normalize();

		//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		NodeList nList1 = doc.getElementsByTagName(Tagname);
		
		NodeList nList = nList1.item(0).getChildNodes();
		//System.out.println("----------------------------");
		Node node = nList.item(item);
		 String a=null;
	    if (node.getNodeType() == Node.ELEMENT_NODE) {
	    	
	    	  a = "Node Name:"+node.getAttributes().getNamedItem(NodeName);
	    	 
		        //System.out.println(a);
		     }
	  
		return a;
		    
	    }
	public static void main(String[] args) throws Exception {
		
	
		
	String a1=AnotherXmlApproach.ReadXml("C:\\samfm\\Master\\Bin\\OrchestrationAPI\\Web.config", "issuers", "secretKey",1);
	
		String a2= AnotherXmlApproach.ReadXml("C:\\samfm\\Master\\Bin\\OauthServer\\Web.config", "clients", "Secret",1);
	
		String orchestration= a2.substring(a2.indexOf("="));
		String Oauth= a1.substring(a1.indexOf("="));
		
		assertEquals(orchestration, Oauth);
		   System.out.println(orchestration);
			System.out.println(Oauth);
			
			}
		
	}
		
	


