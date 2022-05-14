package CS116Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class ReadFileMethod {

     public static String randomReading() throws FileNotFoundException {
            File file = new File("OrderList.txt");
            String result ="";
            Random rand = new Random();
            int n = 0;
            Scanner scan = new Scanner(file);
            while (scan.hasNext()) {
                n++;
                String line = scan.nextLine();
                if (rand.nextInt(n) == 0)
                    result = line;
            }
            scan.close();
            return result;
      }
     public static void main(String[] args) throws FileNotFoundException {
         System.out.println(randomReading());
      }
    }
