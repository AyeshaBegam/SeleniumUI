package DemoPackage;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



/*public class XmlReader
{
	@Test
	public void ReadingXml() throws ParserConfigurationException, SAXException, IOException {
	
		//File file= new File("F:\\Web.xml");
		InputStream InputStream= getClass().getClassLoader().getResourceAsStream("Web.config.xml");
		DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder= factory.newDocumentBuilder();
		Document doc = dBuilder.parse(InputStream);
		
		NodeList nlxml= doc.getElementsByTagName("Secret");
		Element element= (Element) nlxml.item(0);
		
		Assert.assertEquals("qwertyuiopasdfghjklzxcvbnm123456", element.getTextContent());
		System.out.println();
	
		
	}
	
  }*/


public class XmlReader
{


      public static void readXml() {

    try {

	File fXmlFile = new File("C:\\samfm\\Master\\Bin\\OauthServer\\Web.config");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc1 = dBuilder.parse(fXmlFile);
			
	//optional, but recommended
	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	doc1.getDocumentElement().normalize();

	System.out.println("Root element :" + doc1.getDocumentElement().getNodeName());
	
			
	NodeList nList1 = doc1.getElementsByTagName("clients");
	
	NodeList nList = nList1.item(0).getChildNodes();
	
	
	
	System.out.println("----------------------------");
		
	//System.out.println("Length :" + nList.getLength());

	//for (int temp = 0; temp < nList.getLength(); temp++) {
		Node node = nList.item(1);
	    if (node.getNodeType() == Node.ELEMENT_NODE) {
//	        System.out.println("node name: " + node.getAttributes().getNamedItem("Secret"));
	        String a =  "node name: " + node.getAttributes().getNamedItem("Secret");
	      
	        System.out.println(a);
	       
	     
          
               }
            
	        
	        
	  //  }
	    
		
	
	
    } catch (Exception e) {
	e.printStackTrace();
    }
    
  
    
      }
   public static void main(String[] args) {
	   XmlReader.readXml();
	 
    }
  
     
   
    
  }     


