
import java.security.SecureRandom;
import java.util.Arrays;




/*
 * Binary Linear Search class
 */
public class BinaryLinearSearch {
	/*
	 * class instance variables
	 */
    protected static int[] numbers;
    protected int searchKey;
    protected int first;
    protected int last;
    protected int size;

/*
 * class constructor
 */
    /**
     * class constructor
     */
    public BinaryLinearSearch() {
        size = 1000;  //assigning size to 30
        first = 0;  //first index of array
        last = size-1;   //last index of array
        numbers = new int[size];  //creating new integer array with the given size
    }
    /*
     * Iterative Binary Search method
     */
/**
 * @param searchKey
 * @return
 * a method to make iterative binary search
 */
public int iterativeBinarySearch(int searchKey) {
    	
        int start = 0;
        int end = numbers.length - 1;
        Arrays.sort(numbers);  //sorting array

        while (start <= end) {  //while loop for iterative binary search
        	
            int middle = (start + end) / 2;
            /*
             * assigining middle for iterative binary search
             */
            if (searchKey < numbers[middle]) {
                end = middle - 1;
                continue;
            }

            else if (searchKey > numbers[middle]) {  //if entered number is bigger than array's middle index, then adding 1 to middle
                start = middle + 1;
                continue;
            }

            else if (searchKey == numbers[middle]) {  //if the entered number matches, output
            	System.out.print("\n");
            	remainingElements(start,end);
                System.out.println("Number " + searchKey + " found at index " + middle + ": Iterative Binary Search");
                return numbers[middle];

            } else {
            	remainingElements(start,end);  //if entered number is not found, output
                System.out.println("Number " + searchKey + " was not found: Iterative Binary Search");
                return -1;
            }
        }
        return 1;
    }
    /*
     * recursive binary search method, which calls itself inside of method
     */
/**
 * @param first
 * @param last
 * @param searchkey
 * @return
 * a method to make recursive binary search
 */
public int recursiveBinarySearch(int first, int last, int searchkey) {
  	 
    Arrays.sort(numbers); //sorting array entries
    
    if (first > last) {  //if first element is bigger than last element, entered number not found output
    	output();
    	remainingElements(first, last);  //showing remaining entries method
        System.out.println("Number " + searchkey + " was not found: Recursive binary Search");
        return -1;
    }
    if (searchkey == numbers[first]) {  //if entered number and array element is found at first element, output
    	output();
    	remainingElements(first, last);
        System.out.println("Number " + searchkey + " found at index " + first + ": Recursive binary Search");
        return first;
    } else if (searchkey == numbers[last]) { //if enetered number is found at last inde, output
    	output();
    	remainingElements(first, last);
        System.out.println("Number " + searchkey + " found at index " + last + ": Recursive binary Search");
        return last;
    } else {
        return recursiveBinarySearch(first + 1, last, searchkey); //if the eneterd number not found above cases, will call method itself by adding 1 to first index
    }
}
    /*
     * generating random numbers method
     */
    /**
     * @throws ArrayIndexOutOfBoundsException
     * a method to generate 1000 random numbers
     */
    public void generateRandomInts() throws ArrayIndexOutOfBoundsException {
        SecureRandom z = new SecureRandom(); //calling Secure Random method
        for (int i = 0; i < numbers.length; i++) { //for loop for assigning given random secure numbers to each element of array
            numbers[i] = 20 + z.nextInt(981); //setting secure random integer boundaries from 20 to 1000
            }
        //System.out.println(Arrays.toString(numbers)); //printing array elemets as string
        
    }
    /*
     * remaining elements method
     */
    /**
     * @param left
     * @param right
     * a method to print remaining elements
     */
    public void remainingElements(int left, int right) {
        for(int i = left; i <= right; i++) {  //for loop to find remaining elements after binary searches
            System.out.print(numbers[i]+ " ");   } 
    	System.out.println();
    	}

    	/*
    	 * iterative linear search method
    	 */
        /**
         * @param searchKey
         * @return
         * a method to make iterative linear search
         */
        public int iterativeLinearSearch(int searchKey){
     	    	
        for (int i = 0; i < numbers.length; i++){ //for loop to search for entered number one by one from indexes of array
            if (numbers[i] == searchKey) {
            	output();
            	System.out.print("\n");
                System.out.println("Number " + searchKey + " found at index " + i + ": Iterative Linear Search");
                return i;
            }
        }	
        output();
        System.out.print("\n");
        System.out.println("Number " + searchKey + " was not found: Iterative Linear Search"); //if not found output
        return -1;
        }

        /*
         * recursive linear search
         */
        /**
         * @param size
         * @param searchkey
         * @return
         * a method to make recursive linear search
         */
        public int recursiveLinearSearch ( int size, int searchkey){

            if (searchkey > numbers[size-1]) { //using if else statement to find entered number
                System.out.println("Number " + searchkey + " was not found: Recursive Linear Search");
                return -1;
            }
            if (searchkey == numbers[size-1]) {
                System.out.println("Number " + searchkey + " found at index " + size + ": Recursive Linear Search");
                return size-1;
            }
            else { //if not found decrementing size by one and call method again
            	return recursiveLinearSearch((size - 1), searchkey);
            }
            
        }
            
        
        
        /**
         * a method to print output
         */
        public static void output() {
        	
        	for(int i = 0; i < 21; i++) {
        		
        	if(i == 0) {
            	System.out.print("[" +numbers[i] + ", ");
            	continue;
            }
            if(i == 20) {
            	System.out.print(numbers[i] + "...]");
            	break;
            }
            System.out.print(numbers[i] + ", ");
        }
        }
    }

