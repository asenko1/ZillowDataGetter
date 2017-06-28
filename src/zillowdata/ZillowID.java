package zillowdata;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class ZillowID {
	private String zID;
	
	public ZillowID(Address address, String ZWSID) throws URISyntaxException{
		URI uri = new URIBuilder()
				.setScheme("http")
				.setHost("www.zillow.com")
				.setPath("/webservice/GetSearchResults.htm")
				.setParameter("zw-sid", ZWSID)
				.setParameter("address", address.getStreet())
				.setParameter("citystatezip", address.getCityandState())
				.build();

		HttpClient client = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(uri);
		try {
			HttpResponse reponse = client.execute(httpget);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}
	
	
		
	
	public String getID(){
		return zID;
	}

}
