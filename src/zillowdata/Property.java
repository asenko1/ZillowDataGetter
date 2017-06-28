package zillowdata;

public class Property {
	private Address address;
	private ZillowID id;
	private ZillowData data;
	
	public Property(String street, String CityandState, String zipcode){
		address = new Address(street, CityandState, zipcode);
		
	}
	
	private void getID(){
		id = new ZillowID();
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

