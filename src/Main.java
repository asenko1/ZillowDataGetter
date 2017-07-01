import java.util.Scanner;

import zillowdata.Property;

public class Main {
	
	public static void main(String[] args0){
		Scanner userInput = new Scanner(System.in);
		Property myProperty;
		String streetNum;
		String CityandState;
		String zipcode;
		final String ZWSID = ""; //add later, not in public repo
		
		System.out.println("Enter Street Number: ");
		streetNum = userInput.nextLine();
		System.out.println("Enter City and State (e.g. Portland, OR): ");
		CityandState = userInput.nextLine();
		System.out.println("Enter zipcode: ");
		zipcode = userInput.nextLine();
		
		myProperty = new Property(streetNum, CityandState, zipcode, ZWSID);
		
		System.out.println("Your house valuation result is: ");
		System.out.println(myProperty.toString());
		
	}

}
