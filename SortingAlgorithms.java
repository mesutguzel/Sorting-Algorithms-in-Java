

public class SortingAlgorithms extends BinaryLinearSearch {
	
	/**
	 * no-arg constructor
	 */
	public SortingAlgorithms() {
		
	}
	
	/*
	 * bubble sort algorithm
	 */
	/**
	 * bubble sort algorithm
	 */
	public static void bubbleSort() {
		System.out.println("Bubble Sort: Simple sorting algorithm  - O(n2) Complexity");
		int t = 0;
		//for loop to make a bubble sort
		for(int i = 0; i < numbers.length; i++) {
			for(int z = 1; z < (numbers.length - i); z++) {
				if(numbers[z - 1] > numbers[z]) {
					t = numbers[z - 1];
					numbers[z-1] = numbers[z];
					numbers[z] = t;
				}
			}
		}
		output();
		
	}
	/*
	 * insertion Sort algorithm
	 */
	/**
	 * insertion Sort algorithm
	 */
	public static void insertionSort() {
		System.out.println("Insertion Sort: Simple sorting algorithm  - O(n2) Complexity");
		for(int i = 1; i < numbers.length; i++) {
			int k = numbers[i];
			int z = i - 1;
			//while loop to make insertion sort
			while((z > -1) && (numbers[z] > k)) {
				numbers[z + 1] = numbers [z];
				z--;
			}
			numbers[z + 1] = k;
		}
		output();
	}
	
	/*
	 * selection sort algorithm
	 */
	/**
	 * a method for selection sort
	 */
	public static void selectionSort() {
		System.out.println("Selection Sort: Simple sorting algorithm  - O(n2) Complexity");
		int index;
		//for loop to make selection sort
		for(int i = 0; i < numbers.length - 1; i++) {
			index = i;
			for(int j = i + 1; j <numbers.length; j++) {
				if(numbers[j] < numbers[index]) {
				index = j;
			}
		}
		int smallNumber = numbers[index];
		numbers[index] = numbers[i];
		numbers[i] = smallNumber;
		}
		output();
	}

	  /*
	   * merge sort algorithm  
	   */
	/**
	 * @param numbers
	 * a method to make merge sort
	 */
	public static void mergeSort(int[] numbers) { 
        
        if(numbers == null) { 
            return; 
        } 
          if(numbers.length > 1) { 
            int mid = numbers.length / 2; //find mid of the array
   
            // left half of the array 
            int[] left = new int[mid]; 
            //for loop to make merge sort
            for(int i = 0; i < mid; i++) { 
                left[i] = numbers[i]; 
            } 
            // right half of the array 
            int[] right = new int[numbers.length - mid]; 
            for(int i = mid; i < numbers.length; i++) { 
                right[i - mid] = numbers[i]; 
            } 
            mergeSort(left);   //call merge_Sort routine for left half of the array 
            mergeSort(right);   // call merge_Sort routine for right half of the array
   
            int i = 0; 
            int j = 0; 
            int k = 0; 
              // now merge two arrays
            while(i < left.length && j < right.length) { 
                if(left[i] < right[j]) { 
                    numbers[k] = left[i]; 
                    i++; 
                } 
                else { 
                    numbers[k] = right[j]; 
                    j++; 
                } 
                k++; 
            } 
          
   // remaining elements 
            while(i < left.length) { 
                numbers[k] = left[i]; 
                i++; 
                k++; 
            } 
            while(j < right.length) { 
                numbers[k] = right[j]; 
                j++; 
                k++; 
            } 
        } 
    }
	
	/*
	 * sap method for quick sort
	 */
	/**
	 * @param arr
	 * @param i
	 * @param j
	 * a method to make swap
	 */
	static void swap(int[] arr, int i, int j)
	{
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
	 
	/*
	 * partition method for quick sort
	 */
	/**
	 * @param arr
	 * @param low
	 * @param high
	 * @return
	 * a method to make partition
	 */
	static int partition(int[] arr, int low, int high)
	{
	     
	    int pivot = arr[high];
	    int i = (low - 1);
	 
	    for(int j = low; j <= high - 1; j++)
	    {
	         
	        if (arr[j] < pivot)
	        {
	            
	            i++;
	            swap(arr, i, j);
	        }
	    }
	    swap(arr, i + 1, high);
	    return (i + 1);
	}
	 
	/*
	 * recursive quick sort
	 */
	/**
	 * @param arr
	 * @param low
	 * @param high
	 * a method to print quick sort
	 */
	static void quickSort(int[] arr, int low, int high)
	{
	    if (low < high)
	    {
	         
	        int pi = partition(arr, low, high);
	        quickSort(arr, low, pi - 1);
	        quickSort(arr, pi + 1, high);
	    }
	    
	}
	
	/*
	 * printing out sorted elements of array
	 */
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
