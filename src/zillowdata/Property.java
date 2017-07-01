package zillowdata;

import java.io.IOException;
import java.net.URISyntaxException;

public class Property {
	private Address address;
	private final String ZWSID;
	private ZillowID id;
	private ZillowData data;
	
	public Property(String street, String CityandState, String zipcode, String ZWSID){
		address = new Address(street, CityandState, zipcode);
		this.ZWSID = ZWSID;
	}

	private void getID(){
		id = new ZillowID(address, ZWSID);
	}
	
	private void getData(){
		
	}
	
}

class Address{
	String street;
	String CityandState;
	String zipcode;
	
	public Address(String street, String CityandState, String zipcode){
		this.street = street;
		this.CityandState = CityandState;
		this.zipcode = zipcode;
	}
	
	public String getStreet(){
		return street;
	}
	public String getCityandState(){
		return CityandState;
	}
	public String getZipcode(){
		return zipcode;
	}
	
}

