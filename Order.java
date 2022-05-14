package CS116Project;

import java.util.Random;

public class Order implements Comparable <Order> {
	//instance attributes
	Random rand = new Random();
	private int orderID = rand.nextInt(9);
	private String customerID;
	private String productID;
	private Date orderDate;
	private int amount;
	private static int counter = 1;
	private String typeOfOrder;
	private String fileName = null;


	public Order (String newTypeOfOrder, String newCustomerID, String newProductID, Date newOrderDate, int newAmount) throws CustomerIDException, TypeOfOrderException, ProductIDException, DateException, AmountException {
		if (newTypeOfOrder != null) {
			if (newTypeOfOrder.equals("O") || newTypeOfOrder.equals("R")) {
				this.typeOfOrder = newTypeOfOrder;
			}
			else {
				throw new TypeOfOrderException("Please enter a valid type of order" + newTypeOfOrder);
			}
		}
		
		if (newCustomerID != null) {
			
	     	for (int i =0; i< newCustomerID.length();i++) {

	        char letter = newCustomerID.charAt(i);

	        if (Character.isDigit(letter)) {
			this.customerID = newCustomerID;
		}
	     	}
		}
		else {
			throw new CustomerIDException("Please enter a valid customerID" + newCustomerID);
		}
		if (newProductID != null) {

	    	if (newProductID.length()==2) {	
	    	
	    	char letter = newProductID.charAt(0); 

	    	char digit = newProductID.charAt(1);

	    	if (Character.isLetter(letter) && Character.isDigit(digit)) {
	    		this.productID = newProductID;
	    	}
	    	else {
	    		throw new ProductIDException("Please enter a valid productID" + newProductID);
	    	}
	    	
	    	if (newOrderDate != null) {
	    		int month = newOrderDate.getMonth();
	    		int day = newOrderDate.getDay();
	    		int year = newOrderDate.getYear();
	    		if (year == (int)year && year == 2021) {
	    		if (month == (int) month && month > 0 && month <= 12) {
	    		if ((month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12) && day == (int)day && (day<=31 && day>0)) {
	    			this.orderDate = newOrderDate;
	    		}
	    		else if((month==4 || month==6 || month==9 || month==11) && day == (int)day && (day<=30  && day>0)) {
	    			this.orderDate = newOrderDate;
	    		}
	    		 else if(month==2 && day == (int) day && day<=28) {
	    			this.orderDate = newOrderDate;
	    		}
	    		 else {
	    			 throw new DateException("Please enter a valid day" + day);
	    		 }
	    		}
	    		 else {
	    			 throw new DateException("Please enter a valid month" + month);
	    		 }
	    		}
	    		else {
	    			 throw new DateException("Please enter a valid year" + year);
	    		}
	    	}
	    		}
	    	if (newAmount == (int)newAmount) {
	    		
	    	if (newAmount > 0 && newAmount < 100) {
	    		this.amount = newAmount;
	    	}
	    	else {
	    		throw new AmountException("Please enter a valid amount" + newAmount);
	    	}
	    	}
	    	else {
	    		throw new AmountException("Please enter a valid amount" + newAmount);
	    	
	    	}
	    	}
			setOrderID(counter);
			counter = counter + 1;
	    	}
		

	public Order clone() {   // just like a copy constructor  public Book(Book newBook)
		Order newOrder = null;
		try {
			newOrder = new Order(this.getTypeOfOrder(), this.getCustomerID(), this.getProductID(), this.getOrderDate(), this.getAmount());
		} catch (CustomerIDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TypeOfOrderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProductIDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AmountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newOrder;
	}

	private void settypeOfOrder(String newTypeOfOrder) {
		// TODO Auto-generated method stub
		if (newTypeOfOrder != null) {
			typeOfOrder = newTypeOfOrder;
		}
		
	}
	
	public String getTypeOfOrder() {
		return typeOfOrder;
	}

	//Copy Constructor
	public Order(Order newOrder) {
		setcustomerID(newOrder.getCustomerID());
		setproductID(newOrder.getProductID());
		setOrderDate(newOrder.getOrderDate());
		setAmount(newOrder.getAmount());
		this.orderID = newOrder.getOrderID();
		//setOrderID(counter);
		//counter++;
	}
	
	//Basic Validation: positive values, non-null objects
	public void setAmount(int newAmount) {
		// TODO Auto-generated method stub
		if (newAmount > 0) {
			amount = newAmount;
		}
		else {
			amount = 0;
		}
		
	}
	
	public void setOrderID(int newOrderID) {
		orderID = newOrderID;
	}
	
	public int getOrderID() {
		return orderID;
	}

	public void setOrderDate(Date newOrderDate) {
		// TODO Auto-generated method stub
		if (newOrderDate != null) {
			orderDate = new Date(newOrderDate.getMonth(), newOrderDate.getDay(), newOrderDate.getYear());
		}
		else {
			orderDate = new Date();
		}
	}

	public void setproductID(String newProductID) {
		// TODO Auto-generated method stub
		if (newProductID != null) {
			productID = newProductID;
		}
		else {
			productID = "DefaultProductID";
		}
	}


	public void setcustomerID(String newCustomerID) {
		// TODO Auto-generated method stub
		if (newCustomerID != null) {
			customerID = newCustomerID;
		}
		else {
			customerID = "DefaultCustomerID";
		}
	}
	
	/*public void setorderID(int newOrderID) {
		
		//generate random orderID
		if (newOrderID >= 0) {
			orderID = newOrderID;
		}
		else {
			orderID = 0;
		}
	}*/
	
	//accessors for every attribute
	public int getAmount() {
		return amount;
	}
	
	/*instead of just assigning the Date argument 
	 * variable to the Date attribute, construct 
	 * a new Date from the Date argument
	 * The Date class does all the error checking
	 */
	
	public Date getOrderDate() {
		Date newDate = new Date(orderDate.getMonth(), orderDate.getDay(), orderDate.getYear());
		return newDate;
	}
	
	public String getProductID() {
		return productID;
	}

	public String getCustomerID() {
		return customerID;
	}
	
	public int compareTo(Order that) {
		//getCustomerID() and getOrderDate()
		
			if (this.getCustomerID().equals(that.getCustomerID())) {
				if (this.getOrderDate().equals(that.getOrderDate())) {
					return 0;
				}
				else if (this.getOrderDate().isLessThan(that.getOrderDate())) {
					return -1;
				}
				else {
					return 1;
				}
			}
			else {
				return this.getCustomerID().compareTo(that.getCustomerID());
			}
		}
		
		
	
	public String toString() {
		//O=1 C=HAL Industries P=A2 D=3/21/2017 A=10 Period=10 E= 10/21/2017
		String temp = "O=" + orderID + " C=" + customerID + " P=" + productID + " D=" + orderDate + " A=" + amount;
		return temp;
	}

	
	
}

