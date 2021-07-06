
import java.util.InputMismatchException;
import java.util.Scanner;




public class TestSearchSort {

    /**
     * @param args
     * @throws ArrayIndexOutOfBoundsException
     * main method to compile previous classes
     */
    public static void main(String[] args ) throws ArrayIndexOutOfBoundsException{
    	/*
    	 * variables for class, and calling scanner
    	 */
        int selection;
        int first = 0;
        int last = 29;
        int size = 1000;
      //.useDelimiter("\\n");
        Scanner input = new Scanner(System.in); 
        //creating new object from the class
        BinaryLinearSearch test = new BinaryLinearSearch(); 

        do{ //do while loop for looping the menu, till the Exit selected
            System.out.print("\nSelect yout option in the menu below:\n"
                    + "1. Initialize and populate an array of 1000 random integers.\n"
                    + "2. Perform a recursive binary and linear search.\n"
                    + "3. Perform iterative binary and linear seaarch\n"
                    + "4. Sort the array\n"
                    + "5. Exit\n");
            
            try {  //try catch method to catch the input mismatch
            selection = input.nextInt();
            
          //switch statement for entered menu selection
            switch (selection){  
                case 1:
                	//if 1 selected array is initialized
                    System.out.println("Array of randomly generated integers:"); 
                  //array elements filled by generate random method
                    test.generateRandomInts(); 
                    BinaryLinearSearch.output();
                    break;
                case 2:
                    System.out.print("Please enter an integer value to search: ");
                    int searchkey = input.nextInt();
                    timingOn();
                  //calling recursive binary method
                    test.recursiveBinarySearch(first, last, searchkey); 
                    timingOff();
                  //calling recursive linear method
                    test.recursiveLinearSearch(size, searchkey); 
                    timingOff();
                    
                    break;
                case 3:
                    System.out.print("\nPlease enter an integer value to search: ");
                    int searchKey = input.nextInt();
                    timingOn();
                  //calling iterative binary search
                    test.iterativeBinarySearch(searchKey); 
                    timingOff();
                  //calling iterative linear search
                    test.iterativeLinearSearch(searchKey); 
                    timingOff();
                    break;
                case 4:
                	while(true) {
                		System.out.println("\nSelect a sorting algorithm to sort the data array"
                				+ "\n\t\tB. Bubble Sort"
                				+ "\n\t\tI. Insertion Sort"
                				+ "\n\t\tS. Selection Sort"
                				+ "\n\t\tM. Merge Sort"
                				+ "\n\t\tQ. Quick Sort"
                				+ "\n\t\tR. Return to Main Menu");
                		String menu = input.next();
                		//menu 4 sorting selections
                		if(menu.equalsIgnoreCase("b")) { //bubble Sort applied
                			timingOn();
                			SortingAlgorithms.bubbleSort();
                			timingOff();
                			
                		}else if(menu.equalsIgnoreCase("I")) { //insertion sort applied
                			timingOn();
                			SortingAlgorithms.insertionSort();
                			timingOff();
                		}else if(menu.equalsIgnoreCase("s")) { //selection sort applied
                			timingOn();
                			SortingAlgorithms.selectionSort();
                			timingOff();
                			
                		}else if(menu.equalsIgnoreCase("m")) { //merge sort applied
                			timingOn();
                			SortingAlgorithms.mergeSort(BinaryLinearSearch.numbers);
                			System.out.println("Merge Sort: Recursive Divide-And-Conquer - O(n log n) Complexity");
                			SortingAlgorithms.output();
                			timingOff();
                			
                		}else if(menu.equalsIgnoreCase("q")) { //quick sort applied
                			timingOn();
                			SortingAlgorithms.quickSort(BinaryLinearSearch.numbers, 0, 999);
                			System.out.println("Quick Sort: Recursive Divide-And-Conquer - O(n log n) Complexity");
                			SortingAlgorithms.output();
                			timingOff();
                			
                		}else if(menu.equalsIgnoreCase("R")) { //if R is selected will return to main menu
                			break;
                			
                		}else {
                			System.out.println("Please choose from menu");
                		}
                	}
                	break;
                case 5:
                    System.out.println("exiting.."); //if 4 selected program will end
                    input.close(); //closing scanner
                    System.exit(0);
                    break;
                default:  //default case for any other than 1 to 4 entered
                	System.out.println("Please choose option 1 to 5");
                	break; }
            
           }catch (InputMismatchException e1) { //catch bloc for bad inputs
				System.out.println("***Input Mismatch Exception***");
				input.next();}

                 	
            }while(true);
        
    } 
  
    static long startT;
    static long time;
    long endT;
    long endN;
    public static void timingOn() {
    	startT = System.currentTimeMillis();  //staring currenttimemilis and nanotime method
        time = System.nanoTime();
    }
    /**
     * a method for nano and mili second
     */
    public static void timingOff() {
    	long endT = System.currentTimeMillis();
        long endN = System.nanoTime();
        System.out.println("\nTime taken in nanoseconds: " + (endN - time));
        System.out.printf("Time taken in milliseconds: %d%n" , (endT - startT));
    }
}
