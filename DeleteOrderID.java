package CS116Project;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class DeleteOrderID {
	public static void DeleteOrder (String keyWord) throws IOException {
		 OrderList obj = new OrderList("CSV.txt");
		  System.out.println( "Our collections  is:" );
		  System.out.println( obj.toString( ) );

		  keyWord = JOptionPane.showInputDialog( null, "Enter an orderID to search for an order." );
		  ArrayList<Order> results = obj.searchForOrder( Integer.parseInt(keyWord) );
		  System.out.println( "The search results for " + keyWord + " are:" );
		  // add code to write out the results ArrayList
		  for( Order tempOrder : results )
		        System.out.println(tempOrder);
		  	
		int x = 1;
		obj.deleteFromOrders(x);
		System.out.println(obj.toString());
		
	}
}