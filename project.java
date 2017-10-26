import java.io.*;
import java.util.*;


/**
 * The Project1 program implements linked lists in order to calculate the multiplication and addition
 * of numbers bigger than the limit of the machine representation. The program will read
 * two different numbers, add them and display them in correct format.
 * 
 * @author Rafael Ninalaya
 * @Date: Monday, April 3rd	
 */
public class project {

	/**
	 * Main Method
	 * @param theFile	
	 * @param inFile
	 * @param num1, num2  numbers in string format
	 * @param N1,N2  Large Numbers represented in Linked Lists
	 * @param args Unused
	 * 
	 */
	public static void main(String[] args) throws IOException {
		
		try{
			
	        FileReader theFile;
	        BufferedReader inFile;
	        String num1,num2;
	        
	            theFile = new FileReader("test.txt");//File must be in the same folder as the project
	            inFile = new BufferedReader(theFile);
	            while((num1 = inFile.readLine())!= null){
	            	//LargeNumbers linked lists
	            	LargeNumbers N1 = new LargeNumbers();
	    			LargeNumbers N2 = new LargeNumbers();
	    			LargeNumbers sum = new LargeNumbers();
	    			LargeNumbers mul = new LargeNumbers();
	                
	    			// Method used to add the string to the Linked List
	            	String number1[] = num1.split(",");
	            	N1.addLinked(number1, N1);
	            	num2 = inFile.readLine();
	            	String number2[] = num2.split(",");
	            	N2.addLinked(number2, N2);
	            	
	                System.out.println("Number 1: " + num1);
	                System.out.println("Number 2: " + num2);
	                System.out.println("Sum: " + sum.add(N1, N2).toString());//Addition
	                System.out.println("product:" + mul.multiply(N1,N2).toString()); //Subtraction
	                System.out.println();
	                inFile.readLine();// consume blank line
	                }
	        	}
	        catch (IOException e) {
	            System.out.println(e);
	        }
	}
}
