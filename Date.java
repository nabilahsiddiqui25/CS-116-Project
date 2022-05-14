package CS116Project;

import java.util.Comparator;

public class Date {
	  private int month;
	  private int day;
	  private int year;
	  
	  private static final int [] validDays = {0,31,29,31,30,31,30,31,31,30,31,30,31};  
	  private static final int DEFAULT_DAY=1, DEFAULT_MONTH=1, DEFAULT_YEAR=2000;

	  public Date( )  {
	    setDate(DEFAULT_MONTH, DEFAULT_DAY, DEFAULT_YEAR);
	  }

	  public Date( int mm, int dd, int yyyy ) {
	    setDate( mm, dd, yyyy );
	  }

	  int getMonth( ) { return month; }
	  int getDay( )   { return day; }
	  int getYear( )  { return year; }

	  private void setMonth( int mm ) {
	    month = ( mm >= 1 && mm <= 12 ? mm : DEFAULT_MONTH );
	  }

	  private void setDay( int dd ) {
		int maxDays=validDays[month];
		if (leapYear() && month==2) {
			maxDays=28;
		}
	    day = ( dd >= 1 && dd <= maxDays ? dd : DEFAULT_DAY );
	  }

	  private void setYear( int yyyy ) {
	    year = yyyy;
	  }

	  public void setDate( int mm, int dd, int yyyy ) {
	    setYear(yyyy);
	    setMonth( mm );
	    setDay( dd );
	  }

	  public String toString( ) {
	    return month + "/" + day + "/" + year;
	  }

	  public boolean equals( Date d ) {
	    if ( month == d.month
	         && day == d.day
	         && year == d.year )
	      return true;
	    else
	      return false;
	  }

	  public boolean leapYear() {
		if (!((year%4==0) && 
			((year%100!=0)||(year%400==0))))
			return false;
		else return true;
	  }
	  
	  public boolean isLessThan(Date newDate) {
	    boolean isLessThan = false;
	    if (newDate.year > year) {
	        isLessThan = true;
	    }
	    else if ((newDate.year == year) && (newDate.month > month)) {
	        isLessThan = true;
	    }
	    else if ((newDate.year == year) && (newDate.month == month) && (newDate.day > day)) {
	        isLessThan = true;
	    }
	    else {
	        isLessThan = false;
	    }
	    return isLessThan;
	  }
	
	public int compareTo( Date that) {
		  // Returns a negative integer, zero, or a positive integer as this
		 //   object is less than, equal to, or greater than the specified object.
		 // this > that  return positive
		 // this == that return 0
		 // this < that return negative
		 if (that!=null) {
			 if (this.equals(that)) return 0;
			 else {
				 if (this.year>that.year) return 1;
				 else if (this.year<that.year) return -1;
				 else {  // years must be equal, check the month
					if (this.month>that.month) return 1;
					else if (this.month<that.month) return -1;
					else {  // MONTHS must be equal, check the day
						if (this.day>that.day) return 1;
						else return -1;
					}
				 }
			 }
		 }
		 else return 1;

		 }
	
	}
