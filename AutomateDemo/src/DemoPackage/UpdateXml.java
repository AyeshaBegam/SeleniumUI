package DemoPackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class UpdateXml extends Generic {
	
	
	public static void UpdatingAnXml() {
	     try {
		//File Path
		String filePath = "C:\\samfm\\master2.3\\Bin\\OauthServer\\Web.config";
			
		//Read XML file.
		File inputFile = new File(filePath);
			
		//Create DocumentBuilderFactory object.
		DocumentBuilderFactory dbFactory = 
                                  DocumentBuilderFactory.newInstance();
			
		//Get DocumentBuilder object.
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			
		//Parse XML file.
		Document document = dBuilder.parse(inputFile);
			
		//Get element by tag name.
		Node clients = 
                    document.getElementsByTagName("add").item(0);

		//Update students attribute.
		NamedNodeMap attr = clients.getAttributes();
		Node nodeAttr = attr.getNamedItem("Secret");
		nodeAttr.setTextContent("qwertyuiopasdfghjklzxcvbnm123456");
			
		//Get student element list.
		NodeList list = clients.getChildNodes();
			
		
			
			
		//Save changes into XML file.
		TransformerFactory transformerFactory = 
			          TransformerFactory.newInstance();
		Transformer transformer=
                              transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result=new StreamResult(new File(filePath));
		transformer.transform(source, result);
			
		//For console Output.
		StreamResult consoleResult = new StreamResult(System.out);
		transformer.transform(source, consoleResult);	
	      } catch (Exception e) {
		   e.printStackTrace();
	   }
	}
	
}
	
	
	 

	 

	
	