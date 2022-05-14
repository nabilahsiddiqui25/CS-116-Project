package CS116Project;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class OrderList {
	ArrayList <Order> order2;

	//public OrderList(String fileName) throws IOException
	//searchForOrder(int searchString)
	//public void deleteFromOrders(int searchOrderID) { // look for the searchString in the title
	
	public OrderList(String fileName) throws IOException {
		ArrayList <Order> order1 = new ArrayList<Order>( );   // instantiation

        File input = new File(fileName);
        Scanner in = new Scanner(input);
        while(in.hasNext()){
            String record=in.nextLine();
            String [] data = record.split(",");
            String orderDate = data[3];
            String [] dateSplit = orderDate.split("/");
            int month = Integer.parseInt(dateSplit[0]);
            int day = Integer.parseInt(dateSplit[1]);
            int year = Integer.parseInt(dateSplit[2]);
            Date dateObject = new Date(month, day, year);
            //order1.add(new Order(data[0], data[1], data[2], dateObject, Integer.parseInt(data[4]))); 
        }
	}
        public ArrayList<Order> searchForOrder( int searchString ) {
                ArrayList<Order> toReturn = new ArrayList<Order>();
                for ( Order currentOrder : order2) { 
                    if (Integer.toString(currentOrder.getOrderID()).indexOf(searchString) != -1) {  //found substring
                        toReturn.add(currentOrder.clone());
                    }
                }
                // Arrays.sort  for arrays only
                Collections.sort(toReturn);

                return  toReturn;
            }
	
        public void deleteFromOrders(int searchOrderID) { // look for the searchString in the title
        	for (int i = 0; i < order2.size(); i++) {
        		 if (Integer.toString(order2.get(i).getOrderID()).indexOf(searchOrderID) != -1) {
        			 order2.remove(i);
        			 i--;
        		}
        	}

        }

	//public Order (String newTypeOfOrder, String newCustomerID, String newProductID, Date newOrderDate, int newAmount) {
	
	private Order [] orders;
	private int count;
	//private int currentOrderID;
	
	//Default Constructor
	public OrderList() {
		orders = new Order[1000];
		count = 0;
	}
	
	public void addOrder(Order newOrder) {
		if (newOrder != null) {
			if (count < 1000) {
				orders[count] = new Order(newOrder);
				count++;
			}
			else {
				Order [] newArr = new Order[2 * orders.length];
				for (int i = 0; i < orders.length; i++) {
					newArr[i] = orders[i];
				}
				orders = newArr;
				orders[count] = new Order(newOrder);
				count++;
				newArr = null;
			}
		}
	}

	public void addOrder(RepeatedOrder newOrder) {
		if (newOrder != null) {
			if (count < 1000) {
				orders[count] = new RepeatedOrder(newOrder);
				count++;
			}
			else {
				Order [] newArr = new Order[2 * orders.length];
				for (int i = 0; i < orders.length; i++) {
					newArr[i] = orders[i];
				}
				orders = newArr;
				orders[count] = new RepeatedOrder(newOrder);
				count++;
			}
		}
	}

	
	public boolean deleteOrder(int orderID) {
		int indexToRemove = 0;
		boolean isOrderDeleted = false;
		for (int i = 0; i < count; i++) {
			if (orders[i].getOrderID() == orderID) {
				//orders.remove(orders.get(i));
				//i = index to remove
				indexToRemove = i;
				isOrderDeleted = true;
			}
		}
		if (indexToRemove < count) {
			for (int j = indexToRemove; j < count - 1; j++) {
				orders[j] = orders[j + 1];
			}
			orders[count - 1] = null;
			count--;
			isOrderDeleted = true;
		}
		return isOrderDeleted;
	}
	
	public ArrayList<String> getCustomerOrders(String keyCustomerID) {
		ArrayList <String> customerOrders = new ArrayList <String> ();
		if (keyCustomerID != null) {
			for (int i = 0; i < count; i++) {
				if (orders[i].getCustomerID().equals(keyCustomerID)) {
					customerOrders.add(orders[i].toString() + "\n");
				}
			}
		}
		return customerOrders;
	}
	
	public String toString() {
		String temp = "";
		for (int i = 0; i < count; i++) {
			temp = temp + orders[i] + "\n";
		}
		return temp;
	}
}
	class sortByProductID implements Comparator<Order> {
		

	public int compare(Order order1, Order order2) {
		String productID = order1.getProductID();
		char letter = productID.charAt(0); 
		char digit = productID.charAt(1);	
				
		String productID1 = order2.getProductID();
		char letter1 = productID1.charAt(0); 
		char digit1 = productID1.charAt(1);		
		
		int compareLetters = Character.compare(letter, letter1);
		if (letter > letter1) {
			return 1;
		}
		else if (letter == letter1) {
			if (order1.getOrderDate().getMonth() > order2.getOrderDate().getMonth()) {
				return 1;
			}
			else if (order1.getOrderDate().getMonth() == order2.getOrderDate().getMonth()) {
				return 0;
			}
			else {
				return -1;
			}
		}
		else {
			return -1;
		}
		
	

	/*Implements comparable or implements comparator
	implements comparator so you can sort your array
	for the inventory report Arrays.sort(theArray, the Comparator Object)
	No testing for exception classes is needed */
	}
}