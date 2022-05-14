package CS116Project;

import java.util.*;

import java.util.Scanner;

import java.lang.NumberFormatException;

public class OrderException extends Exception{
	
	public OrderException() { super(); }
	
	public OrderException(String message) {super(message); }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean goodInput = false;

		int orderIDEnteredInt =0;

		String orderIDEntered = null;

		String input = null;

		boolean goodInput1 = false;

		String 	customerIDEntered = null;

		boolean goodInput2 = false;

		String productIDEntered = null;

		boolean goodInput3 = false;

		int amountEnteredInt =0;

		String amountEntered = null;

		 Scanner enterOrderID = new Scanner(System.in);

		 do {

			 System.out.println("Please enter orderID ");

	    try {

	    	  orderIDEntered = enterOrderID.next() ;

		      orderIDEnteredInt = Integer.parseInt(orderIDEntered);

	       
		    if (orderIDEnteredInt>0) {

	    	  goodInput = true;

	         }

	       else {

				 throw new NumberFormatException();

			 }

	    }
	 

	    catch (InputMismatchException ime) {

	    	System.out.println("Please Enter valid orderID "); 

	    }

	    catch (NumberFormatException e) {

	    	System.out.println("Please Enter valid orderID "); 

	    }

	    catch (NullPointerException npe) {	  

			   System.out.println("Please Enter valid orderID "); 

			   }

		 }while (!goodInput);

		 Scanner enterCustomerID = new Scanner(System.in);

		 do {

			 System.out.println("Please enter customerID ");

	    try {

	     	customerIDEntered = enterCustomerID.nextLine(); 

	     	for (int i =0; i< customerIDEntered.length();i++) {

	        char letter = customerIDEntered.charAt(i);

	        if (Character.isDigit(letter)) {

	        	throw new InputMismatchException();

	        }

	     	}

	     			goodInput1 = true;

	     	}

	    catch (InputMismatchException ime) {

	    	System.out.println("Please Enter valid CustomerID "); 

	       }

	    catch (NullPointerException npe) {

	    	System.out.println("Please Enter valid CustomerID "); 

	    }

	    }while (!goodInput1);


		 Scanner enterProductID = new Scanner(System.in);

		 do {

			 System.out.println("Enter ProductID ");

	    try {

	    	productIDEntered = enterProductID.next();

	    	if (productIDEntered.length()==2) {	
	    	

	    	char letter = productIDEntered.charAt(0); 

	    	char digit = productIDEntered.charAt(1);

	    	if (!Character.isLetter(letter) || !Character.isDigit(digit)) {

	    		throw new InputMismatchException();
	    	}

	    	else if (Character.isLetter(letter) && Character.isDigit(digit)){

	    		goodInput2 = true;

	    	}

	    	}

	    	else {

	    	  throw new InputMismatchException();

	    	}

	    }

	       catch (InputMismatchException ime) {

	    	   System.out.println("Please Enter valid ProductID "); 

	       }

	       catch (NullPointerException npe) {

	    	   System.out.println("Please Enter valid CustomerID "); 

	       }

		 }while (!goodInput2);


		 Scanner enterAmount = new Scanner(System.in);

		 do {

			 System.out.println("Enter amount ");

	    try {

	    	amountEntered = enterAmount.next();

	    	amountEnteredInt = Integer.parseInt(amountEntered);

	    	if (amountEnteredInt>0) {

	        	goodInput3 = true;

	         }

	    	else {

	    		throw new InputMismatchException();

	    	}

	    }

	       catch (InputMismatchException ime) {

	    	   System.out.println("Please Enter valid Amount "); 

	       }

	    catch (NullPointerException npe) {

	    	   System.out.println("Please Enter valid Amount "); 

	       }

		 }while (!goodInput3);

	
		 }

		 }