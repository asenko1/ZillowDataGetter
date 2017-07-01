package zillowdata;

import java.io.IOException;
import java.net.URISyntaxException;

public class Property {
	private Address address;
	private final String ZWSID;
	private ZillowID id;
	private ZillowData data;
	
	//Builds property by address, gets ZID for the address, and gets valuation
	public Property(String street, String CityandState, String zipcode, String ZWSID){
		address = new Address(street, CityandState, zipcode);
		this.ZWSID = ZWSID;
	}

	private void getID(){
		try{
			id = new ZillowID(address, ZWSID);
		}
		catch(Exception e){
			//TODO: placeholder
		}
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

