package CS116Project;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.io.*;

public interface UserInterface  {
	public static void main (String [] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Matthew Bauer's Company! Would you like to place an order today? ('Y' = Yes, 'N' = No)");
		String order = scan.next();
		boolean validInput = false;
		int numOrders=0;
	    String [] arr = null;
	    boolean validInput1 = false;
	    int month = 0;
	    int day = 0;		
	    
	    
	   do {
	    if (order.length()==1  ) {
	    	if (Character.isLetter(order.charAt(0))&& order.toUpperCase().equals("Y")) {
				//if (order.toUpperCase().equals("N")&& order.toUpperCase().equals("Y")) {
	    		validInput1 = true;
			
				//	validInput1 = true;
				System.out.println("How many orders would you like to place today?");
				 numOrders = scan.nextInt();
				 arr = new String[numOrders];
			
				 System.out.println("Please enter your order(s) in a csv format.");
			
	
				for(int i=0; i<arr.length; i++) {
					arr[i] = scan.next();
				}
		for(int i=0; i<arr.length; i++) {
		System.out.println("Your orders number " + (i+1) + " = " + arr[i]);
		}
		System.out.println();
	
		
		
		validInput = false;
		do {
		for(int j=0; j<arr.length; j++) {
			String checkOrders = arr[j];
		try {
				String [] arrSplit = checkOrders.split(",");
				    String typeOfOrder = arrSplit[0];
					if (Character.isLetter(typeOfOrder.charAt(0))) {
				if (typeOfOrder.equals("O")||typeOfOrder.equals("R")) {
					validInput = true;
					}
				else { 
					throw new InputMismatchException();
				} 
					}
				else { 
					throw new InputMismatchException();
				}
					}
				catch (InputMismatchException ime) {
					System.out.println("This is an invalid order:" + arr[j] );
					arr[j]=null;
				} 
		}
	} while (!validInput);
	System.out.println();
	
	for(int i=0; i<arr.length; i++) {
		if (arr[i]!= null) {
		}
		else {
			ArrayList<String> list = new ArrayList<String>(Arrays.asList(arr));
			list.remove(i);
			arr = list.toArray(new String[0]);
		i--;
		}
	}
	
	validInput = false;
	do {
		for(int j=0; j<arr.length; j++) {
			String checkOrders = arr[j];
		try {
				String [] arrSplit = checkOrders.split(",");
				    String customerID = arrSplit[1];
					
				    if (customerID != null) {
				     	for (int i =0; i< customerID.length();i++) {
				        char letter = customerID.charAt(i);

				        if (!Character.isDigit(letter)) {
				        	validInput= true;
				     	}
				     	else { 
							throw new InputMismatchException();
						} 
					}
				    }
				else { 
					throw new InputMismatchException();
				} 
		}
				catch (InputMismatchException ime) {
					System.out.println("This is an invalid order:" + arr[j] );
					arr[j]=null;
				} 
		}
	} while (!validInput);
	
	for(int i=0; i<arr.length; i++) {
		if (arr[i]!= null) {
		}
		else {
			ArrayList<String> list = new ArrayList<String>(Arrays.asList(arr));
			list.remove(i);
			arr = list.toArray(new String[0]);
		i--;
		}
	}
	
	validInput = false;
	do {
		for(int j=0; j<arr.length; j++) {
			String checkOrders = arr[j];
		try {
				String [] arrSplit = checkOrders.split(",");
				    String productID = arrSplit[2];
				    char letter = productID.charAt(0); 

			    	char digit = productID.charAt(1);
				    if (productID.length()==2 && Character.isLetter(letter) && Character.isDigit(digit)) {	
				    	
				    	//char letter = productID.charAt(0); 

				    //	char digit = productID.charAt(1);

				    	//if (Character.isLetter(letter) && Character.isDigit(digit)) {
				    		validInput= true;
				     	}
				     	else { 
							throw new InputMismatchException();
						} 
					
				    
				/*else { 
					throw new InputMismatchException();
				} */
		}
				catch (InputMismatchException ime) {
					System.out.println("This is an invalid order:" + arr[j] );
					arr[j]=null;
				} 
		}
	} while (!validInput);
	
	for(int i=0; i<arr.length; i++) {
		if (arr[i]!= null) {
		}
		else {
			ArrayList<String> list = new ArrayList<String>(Arrays.asList(arr));
			list.remove(i);
			arr = list.toArray(new String[0]);
		i--;
		}
	}
	
	validInput = false;
	do {
		for(int j=0; j<arr.length; j++) {
			String checkOrders = arr[j];
		try {
				String [] arrSplit = checkOrders.split(",");
				    String orderDate = arrSplit[3];
					
				    String [] dateSplit = orderDate.split("/");
				        month = Integer.parseInt(dateSplit[0]);
			    		 day = Integer.parseInt(dateSplit[1]);
			    		int year = Integer.parseInt(dateSplit[2]);
			    		
			    		if (year == (int)year && year == 2021) {
			    		if (month == (int) month && month > 0 && month <= 12) {
			    		if ((month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12) && (day == (int)day) && (day<=31 && day>0)) {
			    			validInput = true;
			    		}
			    		else if((month==4 || month==6 || month==9 || month==11) && (day == (int)day) && (day<=30  && day>0)) {
			    			validInput = true;
			    		}
			    		 else if(month==2 && (day == (int) day) && day<=28) {
			    			 validInput = true;
			    		}
			    		 else {
			    			 throw new InputMismatchException();
			    		 }
			    		}
			    		 else {
			    			 throw new InputMismatchException();
			    		 }
			    		}
			    		 else {
			    			 throw new InputMismatchException();
			    		 
			    		}
		    }
				catch (InputMismatchException ime) {
					System.out.println("This is an invalid order:" + arr[j] );
					arr[j]=null;
				} 
		}
	} while (!validInput);
	
	for(int i=0; i<arr.length; i++) {
		if (arr[i]!= null) {
		}
		else {
			ArrayList<String> list = new ArrayList<String>(Arrays.asList(arr));
			list.remove(i);
			arr = list.toArray(new String[0]);
		i--;
		}
	}
	
	validInput = false;
	do {
		for(int j=0; j<arr.length; j++) {
			String checkOrders = arr[j];
		try {
				String [] arrSplit = checkOrders.split(",");
				   int amount = Integer.parseInt(arrSplit[4]);
					
				   
				   if (amount == (int)amount) {
				    if (amount>0 && amount<100) {
				    	validInput = true;
				  
				     	}
				     	else { 
							throw new InputMismatchException();
						}
				   }
				    else { 
						throw new InputMismatchException();
					
				    }
		}
				catch (InputMismatchException ime) {
					System.out.println("This is an invalid order:" + arr[j] );
					arr[j]=null;
				} 
		}
	} while (!validInput);
	
	for(int i=0; i<arr.length; i++) {
		if (arr[i]!= null) {
		}
		else {
			ArrayList<String> list = new ArrayList<String>(Arrays.asList(arr));
			list.remove(i);
			arr = list.toArray(new String[0]);
		i--;
		}
	}
	
	validInput = false;
	do {
		for(int j=0; j<arr.length; j++) {
			String checkOrders = arr[j];
		try {
			String [] arrSplit = checkOrders.split(",");
		    String typeOfOrder = arrSplit[0];
			
		    if (typeOfOrder.equals("R") && arrSplit[5]!=null  ) {
				   int period = Integer.parseInt(arrSplit[5]);
				   if (period == (int)period) {
				    if (period>0 && period<100) {
				    	validInput = true;
				  
				     	}
				     	else { 
							throw new InputMismatchException();
						}
				   }
				    else { 
						throw new InputMismatchException();
				    }
				    }
				   else {
					//   throw new InputMismatchException();
				   }
		         
		         }
				catch (InputMismatchException ime) {
					System.out.println("This is an invalid order:" + arr[j] );
					arr[j]=null;
				} 
		}
	} while (!validInput);
	
	for(int i=0; i<arr.length; i++) {
		if (arr[i]!= null) {
		}
		else {
			ArrayList<String> list = new ArrayList<String>(Arrays.asList(arr));
			list.remove(i);
			arr = list.toArray(new String[0]);
		i--;
		}
	}

	validInput = false;
	do {
		for(int j=0; j<arr.length; j++) {
			String checkOrders = arr[j];
		try {
			if (checkOrders!= null) {
			String [] arrSplit = checkOrders.split(",");
		    String typeOfOrder = arrSplit[0];
			
		    if (typeOfOrder.equals("R") && arrSplit[6]!=null  ) {
				    String repeatedOrderDate = arrSplit[6];
					
				    String [] dateSplit = repeatedOrderDate.split("/");
				        int endMonth = Integer.parseInt(dateSplit[0]);
			    		int endDay = Integer.parseInt(dateSplit[1]);
			    		int year = Integer.parseInt(dateSplit[2]);
			    		if (endMonth > month ) {
			    		if (year == (int)year && year == 2021) {
			    		if (month == (int) month && month > 0 && month <= 12) {
			    		if ((month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12) && (day == (int)day) && (day<=31 && day>0)) {
			    			validInput = true;
			    		}
			    		else if((month==4 || month==6 || month==9 || month==11) && (day == (int)day) && (day<=30  && day>0)) {
			    			validInput = true;
			    		}
			    		 else if(month==2 && (day == (int) day) && day<=28) {
			    			 validInput = true;
			    		}
			    		 else {
			    			 throw new InputMismatchException();
			    		 }
			    		}
			    		 else {
			    			 throw new InputMismatchException();
			    		 }
		         }
					 else {
		    			 throw new InputMismatchException();
					 }
			    		}
			    		else if (endMonth == month && day< endDay) {
			    			if (year == (int)year && year == 2021) {
					    		if (month == (int) month && month > 0 && month <= 12) {
					    		if ((month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12) && (day == (int)day) && (day<=31 && day>0)) {
					    			validInput = true;
					    		}
					    		else if((month==4 || month==6 || month==9 || month==11) && (day == (int)day) && (day<=30  && day>0)) {
					    			validInput = true;
					    		}
					    		 else if(month==2 && (day == (int) day) && day<=28) {
					    			 validInput = true;
					    		}
					    		 else {
					    			 throw new InputMismatchException();
					    		 }
					    		}
					    		 else {
					    			 throw new InputMismatchException();
					    		 }
				         }
							 else {
				    			 throw new InputMismatchException();
							 }
			    		}
			    		else {
			    			 throw new InputMismatchException();
			    		}
		         }
			}
		         }
				catch (InputMismatchException ime) {
					System.out.println("This is an invalid order:" + arr[j] );
					arr[j]=null;
				} 
		}
	} while (!validInput);
	
	for(int i=0; i<arr.length; i++) {
		if (arr[i]!= null) {
		}
		else {
			ArrayList<String> list = new ArrayList<String>(Arrays.asList(arr));
			list.remove(i);
			arr = list.toArray(new String[0]);
		i--;
	}
	}
	
	

	        }
	    		
	    	    	else if (Character.isLetter(order.charAt(0))&& order.toUpperCase().equals("N")) {
	    				System.out.println("Thank you for stopping by! Have a great day.");
	    				validInput1 = true;
	    	    	}
	    				else {
	    					System.out.println("Sorry we don't understand your input. Please try again");
	    					    order=scan.next();
	    							}
	    	    }
	    	    else {
	    			System.out.println("Sorry we don't understand your input. Please try again");
	    			    order=scan.next();
	    					}
	    	  }while(!validInput1);
     
	   
	   
	   
	  System.out.println();
		for(int i=0; i<arr.length; i++) {
			System.out.println("Your orders number " + (i+1) + " = " + arr[i]);
		}
	
	
	
	System.out.println("Hello! Would you like to delete an order? ('Y' = Yes, 'N' = No)");
	String deleteOrder = scan.next();
	
	if (deleteOrder != null) {
		if (deleteOrder.length()==1) {
			if (Character.isLetter(deleteOrder.charAt(0)) && deleteOrder.toUpperCase().equals("Y")) {
				System.out.println("Please enter the OrderID to delete your order");
				String orderIDToDelete = scan.next();
				DeleteOrderID.DeleteOrder(orderIDToDelete);
			}
			else {
				System.out.println("Please enter a valid OrderID");
				deleteOrder = scan.next();
			}
		}
		else {
			System.out.println("Please enter a valid OrderID");
			deleteOrder = scan.next();
		}
	}
	else {
		System.out.println("Please enter a valid OrderID");
		deleteOrder = scan.next();
	}
	
		System.out.println("Please specify a customerID to display your list of orders.");
		String customerID = scan.next();
		String [] arr1 = null;
		for (int i = 0; i < arr.length; i++) {
			String checkOrderID = arr[i];
			String [] arrSplit = checkOrderID.split(",");
			String checkCustomerID = arrSplit[1];
			if (customerID.equals(checkCustomerID)) {
				arr1[i] = checkOrderID;
			}
		}
		Arrays.sort(arr1);	
			
       WriterTextFile.writeTextToFile(arr);
   
    }
  }

	   /* 	else if (Character.isLetter(order.charAt(0))&& order.toUpperCase().equals("N")) {
				System.out.println("Thank you for stopping by! Have a great day.");
				validInput1 = true;
	    	}
				else {
					System.out.println("Sorry we don't understand your input. Please try again");
					    order=scan.next();
							}
	    }
	    else {
			System.out.println("Sorry we don't understand your input. Please try again");
			    order=scan.next();
					}
	  }while(!validInput1);
	   }}*/
/*O,Orange Inc.,A1,6/25/2004,5
O,Macrohard Inc.,C2,8/2/2004,1
R,Peak Enterprises,A2,11/18/2006,10,7,12/21/2006
R,Orange Inc.,B1,11/25/2004,4,30,12/28/2004
R,HAL Industries,B1,9/23/2009,1,7,9/24/2009
R,Peak Enterprises,C3,11/4/2006,5,7,12/28/2006
R,HAL Industries,B1,5/11/2007,1,7,6/8/2007
O,Orange Inc.,C2,1/2/2004,1
R,Peak Enterprises,A1,2/15/2002,4,7,3/25/2002
O,Macrohard Inc.,A1,6/3/2003,2
R,Orange Inc.,A2,2/20/2007,2,30,4/20/2007
R,HAL Industries,C1,8/21/2002,8,7,8/23/2002
R,Giggle Industries,A2,2/16/2008,6,1,2/24/2008
R,Giggle Industries,B1,2/3/2003,8,1,2/24/2003
R,Giggle Industries,C2,3/11/2004,6,1,4/3/2004
R,HAL Industries,C2,6/22/2003,6,7,7/29/2003
O,Macrohard Inc.,A2,3/24/2009,2
R,Giggle Industries,A2,11/9/2005,4,1,11/30/2005
R,Orange Inc.,A2,10/6/2006,6,30,11/7/2006
O,Macrohard Inc.,A1,2/15/2005,2
O,HAL Industries,C2,4/21/2005,10
R,Orange Inc.,B1,3/22/2001,6,30,4/25/2001
O,Orange Inc.,A2,10/26/2005,4
R,Peak Enterprises,C2,5/26/2003,10,7,7/24/2003
R,HAL Industries,A2,12/20/2008,1,7,2/11/2009
O,Orange Inc.,B1,11/20/2008,3
R,Giggle Industries,A1,6/11/2004,9,1,6/27/2004
O,Orange Inc.,A1,12/14/2002,4
O,HAL Industries,B1,8/6/2003,10
O,HAL Industries,A1,11/2/2002,1
O,Orange Inc.,C3,4/24/2007,7
O,Macrohard Inc.,C1,6/25/2001,6
R,Giggle Industries,A1,9/25/2002,7,1,11/22/2002
O,HAL Industries,A2,6/1/2005,6
R,Peak Enterprises,A1,1/7/2003,1,7,1/17/2003
R,Peak Enterprises,A1,11/13/2001,10,7,1/4/2002*/
			




/*R,GiggleIndustries,A2,11/9/2021,4,1,11/30/2021
R,GiggleIndustries,A2,11/9/2021,6,8,12/30/2021
O,MacrohardInc.,A1,2/15/2021,2
O,HALIndustries,A1,11/2/2021,5
O,HALIndustries,D2,11/2/2021,7
R,PeakEnterprises,A1,2/15/2021,4,7,3/25/2021
R,HALIndustries,C1,8/21/2021,8,7,8/23/2002
O,Macrohard1Inc.,C2,8/2/2021,1
P,MacrohardInc.,C2,8/2/2021,1
O,HALIndustries,E2,6/1/2021,67,6/25/2021*/










			
			/*String customerID = arrSplit[1];
			System.out.println(customerID);
			String productID = arrSplit[2];
			System.out.println(productID);
			String orderDate = arrSplit[3];
			System.out.println(orderDate);
			
			String [] dateSplit = orderDate.split("/");
			int month1 = Integer.parseInt(dateSplit[0]);
			int day1 = Integer.parseInt(dateSplit[1]);
			int year1 = Integer.parseInt(dateSplit[2]);
			
			Date dateObject = new Date(month1, day1, year1);
		
		//index checking and if-else statements
		
				
		int amount = Integer.parseInt(arrSplit[4]);
		System.out.println(amount);
		int period = Integer.parseInt(arrSplit[5]);
		System.out.println(period);
		String endDate = arrSplit[6];
		
		String [] endDateSplit = endDate.split("/");
		int month2 = Integer.parseInt(endDateSplit[0]);
		int day2 = Integer.parseInt(endDateSplit[1]);
		int year2 = Integer.parseInt(endDateSplit[2]);
		
		Date endDateObj = new Date(month2, day2, year2);
		
		System.out.println(endDateObj);
		
		Order obj1 = new Order(typeOfOrder, customerID, productID, dateObject, amount);
		RepeatedOrder obj2 = new RepeatedOrder(typeOfOrder, customerID, productID, dateObject, amount, period, endDateObj);
			
		}
		
		while (!(order.toUpperCase().equals("Y")) && !order.toUpperCase().equals("N")) {
			error = false;
			System.out.println("ERROR Please enter valid input.");
			System.out.println("");
			System.out.println("Would you like to place an order today?('Y' = Yes, 'N' = No)\n");
			do {
				try {
					order = scan.next();
					validInput = true;
				}
				catch (InputMismatchException ime) {
					String garbage = scan.next();
				} 
				catch (NumberFormatException nme) {
					String garbage = scan.next();
				}
			} while (!validInput);
			validInput = false;
			do {
				try {
					order = scan.next();
					validInput = true;
				}
				catch (InputMismatchException ime) {
					System.out.println("ERROR Please enter valid input.");
					String garbage = scan.next();
				} 
				catch (NumberFormatException nme) {
					System.out.println("ERROR Please enter valid input.");
					String garbage = scan.next();
				}
			} while (!validInput);
				
			
			
			
			
			
			
		}
		
		if (order.toUpperCase().equals("Y")) {
			System.out.println("Please enter your order in a csv format.");
			Scanner in = new Scanner(System.in);
			String csv = in.nextLine();
			String [] arrSplit = csv.split(",");
			String typeOfOrder = arrSplit[0];
			do {
				
			} while (!goodValue);
			
			
			if (typeOfOrder.equals("O")||typeOfOrder.equals("R")) {
				String customerID = arrSplit[1];
				if (customerID)
			}
			
			System.out.println(customerID);
			String productID = arrSplit[2];
			System.out.println(productID);
			String orderDate = arrSplit[3];
			System.out.println(orderDate);
			
			String [] dateSplit = orderDate.split("/");
			int month1 = Integer.parseInt(dateSplit[0]);
			int day1 = Integer.parseInt(dateSplit[1]);
			int year1 = Integer.parseInt(dateSplit[2]);
			
			Date dateObject = new Date(month1, day1, year1);
		
		//index checking and if-else statements
		
				
		int amount = Integer.parseInt(arrSplit[4]);
		System.out.println(amount);
		int period = Integer.parseInt(arrSplit[5]);
		System.out.println(period);
		String endDate = arrSplit[6];
		
		String [] endDateSplit = endDate.split("/");
		int month2 = Integer.parseInt(endDateSplit[0]);
		int day2 = Integer.parseInt(endDateSplit[1]);
		int year2 = Integer.parseInt(endDateSplit[2]);
		
		Date endDateObj = new Date(month2, day2, year2);
		
		System.out.println(endDateObj);
		
		Order obj1 = new Order(typeOfOrder, customerID, productID, dateObject, amount);
		RepeatedOrder obj2 = new RepeatedOrder(typeOfOrder, customerID, productID, dateObject, amount, period, endDateObj);
		
		if (typeOfOrder.equals("O")) {
			orders.add(obj1);
		}
		else if (typeOfOrder.equals("R")) {
			orders.add(obj2);
		}
			
		}
		else if (order.toUpperCase().equals("N")) {
			isOrder = false;
			System.out.println("Thank you for stopping by! Have a great day!");
		}
		
		
	}*/