package CS116Project;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class TestCaseGenerator {
	
	static String [] orders;
	public static String [] readFile(String fileName) {
		File obj = new File(fileName);
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLine()) {
			//String eachOrder = scan.nextLine();
			for (int i = 0; i < orders.length; i++) {
				orders[i] = scan.next();
			}
		}
		return orders;
		
	}
	
	public static int getRandomOrder(String [] arr) {
		Random rand = new Random();
		return rand.nextInt(arr.length);
				
	}
	
	/*public static String toStringOrder(String newTypeOfOrder, String newCustomerID, String newProductID, Date newOrderDate, int newAmount) {
		
	}
	
	public static String toStringRepeatedOrder(String typeOfOrder, String customerID, String productID, Date orderDate, int amount, int newPeriod, Date newEndDate) {
		
	}*/
	
	
	
	
	public static void main (String [] args) {
		
		String [] arr1 = {"O", "R"};
		String [] arr2 = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		String [] arr3 = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
		String [] arr4 = null;
		String oOrR = null;
		//oOrR = 
		int typeOfOrder = getRandomOrder(arr1);
		
		arr4 = readFile("NYSEcompanylist.txt");
		int customerID = getRandomOrder(arr4);
		int productID = getRandomOrder(arr2);
		
		//Random rand = new Random();
		
		
		
	}
	
}
