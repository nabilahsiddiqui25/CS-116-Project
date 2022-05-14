package CS116Project;

public class RepeatedOrder extends Order {
	//Instance Attributes
	private int period;
	private Date endDate;
	//Deep Copy of Date Arguments!
	//non-default constructor
	public RepeatedOrder(String typeOfOrder, String customerID, String productID, Date orderDate, int amount, int newPeriod, Date newEndDate) throws CustomerIDException, TypeOfOrderException, ProductIDException, DateException, AmountException, PeriodException, EndDateException {
		super(typeOfOrder, customerID, productID, orderDate, amount);
		if (newPeriod == (int)newPeriod) {
		if (newPeriod >= 1 && newPeriod <= 30) {
			this.period = newPeriod;
		}
		else {
			throw new PeriodException("Please enter a valid period. The repeatedOrderPeriods are all 1 to 30 days" + newPeriod);
		}
		}
		else {
			throw new PeriodException("Please enter a valid period. The repeatedOrderPeriods are all 1 to 30 days" + newPeriod);
		}
		if (newEndDate != null) {
    		int month = newEndDate.getMonth();
    		int day = newEndDate.getDay();
    		int year = newEndDate.getYear();
    		if (year == (int)year && year == 2021) {
	    		if (month == (int) month && month > 0 && month <= 12) {
	    		if ((month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12) && day == (int)day && (day<=31 && day>0)) {
    			this.endDate = newEndDate;
    		}
	    	else if((month==4 || month==6 || month==9 || month==11) && day == (int)day && (day<=30  && day>0)) {
    			this.endDate = newEndDate;
    		}
	    	else if(month==2 && day == (int) day && day<=28) {
    			this.endDate = newEndDate;
    		}
    		 else {
    			 throw new EndDateException("Please enter a valid day" + day);
    		 }
    		}
    		 else {
    			 throw new EndDateException("Please enter a valid month" + month);
    		 }
    		}
    		else {
    			 throw new EndDateException("Please enter a valid year" + year);
    		}
    	}
    		}
		
	
	//Copy Constructor
	public RepeatedOrder(RepeatedOrder newOrder) {
		super(newOrder);
		setPeriod(newOrder.getPeriod());
		setEndDate(newOrder.getEndDate());
	}
	
	public void setPeriod(int newPeriod) {
		if (newPeriod > 0) {
			period = newPeriod;
		}
		else {
			period = 0;
		}
	}
	
	public int getPeriod() {
		return period;
	}
	
	public Date getEndDate() {
		return new Date(endDate.getMonth(), endDate.getDay(), endDate.getYear());
	}
	
	//mutators for every attribute - basic argument validation
	//Perform deep copy!
	public void setEndDate(Date newDate) {
		if (newDate != null && (getOrderDate().equals(newDate) || getOrderDate().isLessThan(newDate))) {
			endDate = new Date(newDate.getMonth(), newDate.getDay(), newDate.getYear());
		}
		else {
			endDate = new Date(getOrderDate().getMonth(), getOrderDate().getDay(), getOrderDate().getYear());
		}
	}
	
	public String toString() {
		//endDate null testing FAILED O=3 C=HAL Industries P=A2 D=3/21/2017 A=10 Period=10 E=1/1/2000
		return super.toString() + " Period=" + period + " E=" + endDate;
	}
	
}
