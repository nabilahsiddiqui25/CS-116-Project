package CS116Project;

import java.util.*;

import java.lang.NullPointerException;

import java.util.Scanner;

public class DateException extends Exception {
	
	public DateException() { super(); }
	
	public DateException(String message) {super(message); }
	

	public static void main(String[] args) {
		
	
			/*public class Address {

			…

			  public Address(String name, String city, String state, int zipCode) throws ZipCodeInvalidException {

			  ….

			  if (0<=zipCode && zipCode <= 99999) this.zipCode = zipCode;  // If valid, store value

			  else throw new ZipCodeInvalidException("" + zipCode);   // throw exception

			  ...

			}*/
		
		boolean inputValid = false;

		  boolean inputValid2 = false;

		  boolean inputValid3=false;

		  boolean inputValid4=false;

		  int month =0;

          int monthEnteredInt =0;

          int dayEnteredInt = 0;

          int yearEnteredInt = 0;

		  Scanner monthToEnter = new Scanner(System.in);
		  
		  do {

	        System.out.println("Please enter the month");

		   try {

			   String monthEntered = monthToEnter.next() ;

		      monthEnteredInt = Integer.parseInt(monthEntered);

		 month = monthEnteredInt ;

		 if (monthEnteredInt <= 12 && monthEnteredInt >= 1) {
				  inputValid=true; 
		}

		 else {
			 throw new NumberFormatException();
		 }

		   }

		   catch(NumberFormatException e) {

			   System.out.println("(Please enter a valid month. It should be an integer greater than 0 and less than or equal to 12.)" ); 

		   }

		   catch (InputMismatchException ime) {	  

			   System.out.println("(Please enter a valid month. It should be an integer greater than 0 and less than or equal to 12.)");

		   } 

		   catch (NullPointerException npe) {	  

			   System.out.println("(Please enter a valid month. It should be an integer greater than 0 and less than or equal to 12.)");

			   }

		  } while (!inputValid);

		  Scanner dayToEnter = new Scanner(System.in);

		  do {

	          System.out.println("Please enter the day");

		  try {

			 
			  String dayEntered = dayToEnter.next() ;

			   dayEnteredInt = Integer.parseInt(dayEntered);

			  if ((month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12) && (dayEnteredInt<=31 && dayEnteredInt>0)) {

				  inputValid2=true; }

			  else if((month==4 || month==6 || month==9 || month==11)  && (dayEnteredInt<=30  && dayEnteredInt>0)) {

				  inputValid2=true; } 

			  else if( month==2 && dayEnteredInt<=28) {

				  inputValid2=true;
			  }

			  else {

				 throw new NumberFormatException();

		  }

		  }

		  catch(NumberFormatException e) {

			   System.out.println("(Please enter a valid day.)" ); 

		   }

		   catch (InputMismatchException ime) {	  

			   System.out.println("(Please enter a valid day.)");

		   } 

		   catch (NullPointerException npe) {	  

			   System.out.println("(Please enter a valid day.)");

			   }

		 }  while (!inputValid2);

		  Scanner yearToEnter = new Scanner(System.in);

		  do {

			  System.out.println("Please enter the year");

			  try {

				  String yearEntered =  yearToEnter.next() ;

				   yearEnteredInt = Integer.parseInt(yearEntered);
			  

			  if (yearEnteredInt==2021) { 

				  inputValid3=true; 

		  }

			  else {
					 throw new NumberFormatException();

			  }

		  }

			  catch(NumberFormatException e) {

				   System.out.println("(Please enter a valid year. It should be 2021.)" ); 

			   }

			   catch (InputMismatchException ime) {	  

				   System.out.println("(Please enter a valid year. It should be 2021.)");

			   } 

			   catch (NullPointerException npe) {	  

				   System.out.println("(Please enter a valid year. It should be 2021.)");
				   }

				  } while (!inputValid3);


		  System.out.println("The date you entered is " + monthEnteredInt + "/" + dayEnteredInt + "/" + yearEnteredInt);
		  
	}

}