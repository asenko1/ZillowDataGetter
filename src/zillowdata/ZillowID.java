package zillowdata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.ws.http.HTTPException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ZillowID {
	private String zID;
	
	public ZillowID(Address address, String ZWSID) throws URISyntaxException, IOException, ParserConfigurationException, SAXException, HTTPException{
		URI uri = new URIBuilder()
				.setScheme("http")
				.setHost("www.zillow.com")
				.setPath("/webservice/GetSearchResults.htm")
				.setParameter("zw-sid", ZWSID)
				.setParameter("address", address.getStreet())
				.setParameter("citystatezip", address.getCityandState()) //TODO: reformat to correct format (maybe in constructor)
				.build();

		HttpClient client = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(uri);
		HttpResponse response = null;
		try {
			response = client.execute(httpget);
		} catch (ClientProtocolException e) {
			System.out.println("ClientProtocolException occured");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException occurred");
			e.printStackTrace();
		}
		
		if(response.getStatusLine().getStatusCode() != 200)
			throw new HTTPException(response.getStatusLine().getStatusCode());
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String readID = reader.readLine();
		ZillowXMLInterface getZID = new ZillowXMLInterface(readID);
		zID = getZID.getElement("zpid");
	}
	
	public String getID(){
		return zID;
	}

}
