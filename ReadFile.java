package CS116Project;
import java.util.*;
import java.io.*;

public class ReadFile {
	private ArrayList<Order> orders;
	public static String [] arr;
	public static String fileName;
	
	public static String [] ReadAFile(String fileName) throws IOException{
		//ArrayList<OrderList> order1 = new ArrayList<OrderList>( );   // instantiation
		File input = new File(fileName);
		Scanner in = new Scanner(input);
		if(in.hasNext()){
			String record=in.nextLine();
			for (int i = 0; i < arr.length; i++) {
				arr[i] = record;
			}
		}
			return arr;
			
	}	
			
			/*String [] data = record.split(",");
			String orderDate = data[3];
	        String [] dateSplit = orderDate.split("/");
	        int month = Integer.parseInt(dateSplit[0]);
	        int day = Integer.parseInt(dateSplit[1]);
	        int year = Integer.parseInt(dateSplit[2]);
	        Date dateObject = new Date(month, day, year);
			//order1.add(new Order(data[0], data[1], data[2], dateObject, Integer.parseInt(data[4]))); 
		}
	}*/
	
	public String toString () {
		String temp="";
		for ( Order currentOrder : orders  ) {  
			temp = temp+currentOrder.toString()+"\n";
		}
		return temp;
		//return library.toString();
	}
	
	public ArrayList<Order> searchForOrder( int searchString ) {
        // the returned ArrayList should be sorted by Author
            // iterate over all books, on each book look for the searchString in the title
            ArrayList<Order> toReturn = new ArrayList<Order>();
            for ( Order currentOrder : orders) { 
                if (Integer.toString(currentOrder.getOrderID()).indexOf(searchString) != -1) {  //found substring
                    toReturn.add(currentOrder.clone());
                }
            }
            // Arrays.sort  for arrays only
            Collections.sort(toReturn);

            return  toReturn;
        }

    public void deleteFromOrders(int searchOrderID) { // look for the searchString in the title
    	for (int i = 0; i < orders.size(); i++) {
    		 if (Integer.toString(orders.get(i).getOrderID()).indexOf(searchOrderID) != -1) {
    			 orders.remove(i);
    			 i--;
    		}
			
		}
    }
		
		public void sortProductID() {
			Collections.sort(orders);    // uses Book compareTo
		}

		 
	
	}


