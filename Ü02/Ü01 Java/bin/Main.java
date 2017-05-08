
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File; 
import java.io.FileReader;
import java.util.Scanner;
import java.io.*;

public class Main {

    /**
     * @param args
     */
    public static ArrayList<Integer> numbers = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException {
    	 System.out.print("Herzlich Willkommen bei Such-Algortihmen \n");
    	 String pathToListFile = args[0];
         int key = Integer.parseInt(args[1]);
        

       
        readInput(pathToListFile);
        System.out.println();
        System.out.println("Ergebnisse bei Eingabe des Key =" + (key));
        System.out.println("linear search : " + "Indexposition = " + linSearch(key));
        System.out.println("binary search : " + "Indexposition = " + binSearch(key));
        System.out.println("interpolation search : " + "Indexposition = " + interpolSearch(key));
       
        //Testfall 1
        System.out.println();
        System.out.println("Beispiel für Eingabe des key = 3");
        System.out.println("linear search : " + "Indexposition = " + linSearch(3));
        System.out.println("binary search : " + "Indexposition = " + binSearch(3));
        System.out.println("interpolation search : " + "Indexposition = " + interpolSearch(3));
        
      //Testfall 2
        System.out.println();
        System.out.println("Beispiel für Eingabe des key = 16");
        System.out.println("linear search : " + "Indexposition = " + linSearch(16));
        System.out.println("binary search : " + "Indexposition = " + binSearch(16));
        System.out.println("interpolation search : " + "Indexposition = " + interpolSearch(16));
    
    
        System.out.println();
        System.out.println("Beispiel für Eingabe des key = 2001");
        System.out.println("linear search : " + "Indexposition = " + linSearch(2001));
        System.out.println("binary search : " + "Indexposition = " + binSearch(2001));
        System.out.println("interpolation search : " + "Indexposition = " + interpolSearch(2001));
}
    /**
     * Parse a file containing integers and insert them into "numbers".
     * Each line contains a single integer.
     * Use the Class BufferedReader
     *
     * @param path
     * @throws IOException
     */
    public static void readInput(String path) throws IOException{
    	    
    	 BufferedReader inFile = new BufferedReader(new FileReader(path));
    	    ArrayList<String> strings = new ArrayList<String>(); //The ArrayList stores strings

    	    String inLine; //Buffer to store the current line
    	    while ((inLine = inFile.readLine()) != null) //Read line-by-line, until end of file
    	    {
    	        strings.add(inLine);
    	    }
    	    inFile.close(); 
    	        	    
            numbers = new ArrayList<Integer>(strings.size()) ; //initilase numbers with new Array Size
            for (String myInt : strings) 
            { 
              numbers.add(Integer.valueOf(myInt)); 
            }
        }   
    
public static int linSearch(int key){
	 
	            for(int i=0; i< numbers.size(); i++) {
		        if(numbers.get(i) == key) {
		        return numbers.indexOf(key);
		        }        
		        
		         }
return -1;

}
/**
 * Implementation of binary search. Return the index of key in the array list "numbers".
 * Return -1 if key is not contained in "numbers"
 * @param key
 * @return
 */
public static int binSearch(int key){
	 int start = 0;
     int end = numbers.size() - 1;

     while (start <= end) {
         int mid = (start + end) / 2;

         if (key == numbers.get(mid)) {
             return numbers.indexOf(key);
         }
         if (key < numbers.get(mid)) {
             end = mid - 1;
         } else {
             start = mid + 1;

         }

     }
     return -1;

 }		  

/**
 * Implementation of interpolation search. Return the index of key in the array list "numbers".
 * Return -1 if key is not contained in "numbers"
 * @param key
 * @return
 */ 
public static int interpolSearch(int key){
	{
        int low = 0;
        int high = numbers.size() - 1;
        int mid;
        while (numbers.get(low) <= key && numbers.get(high) >= key) 
        {
            if (numbers.get(high) - numbers.get(low) == 0)
                return (low + high)/2;
            /** out of range is possible  here **/
             mid = low + ((key - numbers.get(low)) * (high - low)) / (numbers.get(high) - numbers.get(low));  
 
             if (numbers.get(mid) < key)
                 low = mid + 1;
             else if (numbers.get(mid) > key)
                 high = mid - 1;
             else
                 return mid;
        }
      
    
            return -1;
}
}

}   