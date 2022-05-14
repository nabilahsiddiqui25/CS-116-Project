package CS116Project;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ProjectInventory {
	
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
	
	public static void main(String [] args) throws IOException {
		readFile("CSV.txt");
		//ReadFile.ReadAFile("CSV.txt");
		Arrays.sort(orders);
		//public int compare(Order order1, Order order2) {
		WriterTextFile.writeTextToFile(orders);
	
	}
}