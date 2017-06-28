import java.util.Scanner;

public class Main {
	
	public static void main(String[] args0){
		Scanner userInput = new Scanner(System.in);
		String streetNum;
		String CityandState;
		String zipcode;
		
		System.out.println("Enter Street Number: ");
		streetNum = userInput.nextLine();
		System.out.println("Enter City and State (e.g. Portland, OR): ");
		CityandState = userInput.nextLine();
		System.out.println("Enter zipcode: ");
		zipcode = userInput.nextLine();
		
		
	}

}
