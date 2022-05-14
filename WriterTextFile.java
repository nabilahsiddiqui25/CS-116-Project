package CS116Project;
import java.io.*;
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

	public class WriterTextFile{
	
		
		public static void writeTextToFile (String[] arr) {
		try  {
			//create a FileWriter object to write to a file (output1.txt)
			// that already exists in the same directory as this java program
			// overwriting the current contents
			FileWriter file1 = new FileWriter("CSV.txt", true);
          
			// create a BufferedWriter object and write the sample data out to the file
			BufferedWriter buf1 = new BufferedWriter(file1);
			for (int i= 0; i<arr.length;i++) {
			
			buf1.write(arr[i]);
			}
			/////////////buf1.write( sampleInteger+ " "+  sampleDouble + " "+ sampleChar + " "+ sampleString);
			buf1.newLine();
			//buf1.write( sampleInteger+ " "+  sampleDouble + " "+ sampleChar + " "+ sampleString);			
			buf1.newLine();
			buf1.close();
		}
		catch( FileNotFoundException fnf ) {
			System.out.println( fnf);
		}
		catch( IOException ioe ) {
			ioe.printStackTrace(System.out);
		}
		}
	}	