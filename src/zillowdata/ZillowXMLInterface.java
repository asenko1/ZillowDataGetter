package zillowdata;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ZillowXMLInterface {
	private Document document;
	private String XMLString;
	
	public ZillowXMLInterface(String XMLString) throws ParserConfigurationException, SAXException, IOException{ //takes an XML file as a single string
		this.XMLString = XMLString;
		
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		InputSource input = new InputSource();
		input.setCharacterStream(new StringReader(XMLString));
		document = db.parse(input);
	}
	
	public String getElement(String element){ //returns string by element name
		NodeList nodes = document.getElementsByTagName(element);
		Element addressElement = (Element) nodes.item(0);
		Node node = addressElement.getFirstChild();
		CharacterData cd = (CharacterData) node;
		return cd.getData();
	}
	
	
	
}
