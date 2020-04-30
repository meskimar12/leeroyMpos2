package se.qa.utils;

import java.io.InputStream;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TestUtils {
	
	public static final long WAIT = 20;

	
	
	public HashMap<String,String>parseStringXML(InputStream file)throws Exception{
		HashMap<String ,String> stringMap = new HashMap<String,String>();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		//Build Document
		Document document = builder.parse(file);
		
		//Normalise the XML Structure; It's just too important !!
		document.getDocumentElement().normalize();
		
		//Here comes the root node
		Element root = document.getDocumentElement();
		//System.out.println(root.getNodeName());
		
		//Get all elements
		NodeList nodeList = document.getElementsByTagName("string");
		//System.out.println("=========");
		
		
		for(int temp = 0; temp < nodeList.getLength(); temp++) {
			
			Node node = nodeList.item(temp);
			
			if(node.getNodeType() == Node.ELEMENT_NODE) {
				
				Element eElement = (Element)node;
				
				stringMap.put(eElement.getAttribute("name"), eElement.getTextContent());
			}
		}
		
		return stringMap;
		
	}
	
}


