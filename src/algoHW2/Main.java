package algoHW2;

public class Main {

	 final static int VERY_BIG_NUM = Integer.MAX_VALUE;
	 public static int search(int value, int[] a, int hi) {
		 //using binary search this function searches for biggest integer in array which is smaller than value (kinda maximum smaller)
		 	
		 if(value > a[hi]) {
	            return VERY_BIG_NUM;
	        }
		 
	        int lo = 0;

	        while (lo <= hi) {
	            int mid = (hi + lo) / 2;

	            if (value < a[mid]) {
	                hi = mid - 1;
	            } else if (value > a[mid]) {
	                lo = mid + 1;
	            } else {
	                return mid;
	            }
	        } 
	        	
	        if (a[lo] <= value && a[hi]> value)
	        	return lo;
	        else
	        	return hi;
	 }
	
	public static int optimal_ride_num(int[] w, int W){
		System.out.println("\n");
		//counts how many rides with containers was performed
		int ridesNum = 0;
		
		//index of the biggest not used container for each iteration(ride)
		int endIndex = w.length-1;
		
		//will contain value from w[endIndex]
		int endValue;
		
		//counts how much cells was already transfered
//		int cellsTransfered = 0;
		
		String containersTakenThisRide;
		//Check that truck is able to transfer biggest container
		if(w[endIndex]> W)
			throw new RuntimeException("Array value "+w[endIndex]+" is bigger than maximum allowed number "+W);
		
		//While endIndex bigger or equal to 0 , w[endIndex] != VERY_BIG_NUM
		while(endIndex >=0 && w[endIndex] != VERY_BIG_NUM) {
			containersTakenThisRide = "";
			int secondIndex = VERY_BIG_NUM;
			
			endValue = w[endIndex];
			
			if(endValue != W) {
				int lessOrEqualToFind = W - endValue;
				 secondIndex = search(lessOrEqualToFind, w, endIndex);
				 
					if (secondIndex != VERY_BIG_NUM && secondIndex >=0) {
						
						containersTakenThisRide = containersTakenThisRide + String.valueOf(w[secondIndex]);

						//in transfered cell we'll put very big integer so it won't be used in binary search
						w[secondIndex] = VERY_BIG_NUM;
					}
			}
			
			containersTakenThisRide ="ride number: " +ridesNum+" Containers used for this ride: "+ containersTakenThisRide +" "+ String.valueOf(w[endIndex]);
			
			//Print ride number, and which containers was used for this ride
			System.out.println(containersTakenThisRide);
			w[endIndex] = VERY_BIG_NUM;
			ridesNum++;
			endIndex--;
//			every time cell was transfered by truck cell is filled with very big integer
		}
		
		return ridesNum;
	}
	
	// Merges two subarrays of arr[]. 
    // First subarray is arr[l..m] 
    // Second subarray is arr[m+1..r] 
   public static void merge(int arr[], int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
   public static void sort(int arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            sort(arr, l, m); 
            sort(arr , m+1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    } 
    
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
	public static void main(String[] args) {

		int arr[] = {12,10, 3, 20, 15, 5, 14, 6}; 
		  
        System.out.println("Given Array"); 
        printArray(arr); 
  
        sort(arr, 0, arr.length-1); 
  
        System.out.println("\nSorted array"); 
        printArray(arr);
        
        System.out.println("\nNumber Of Rides performed for Array: " + optimal_ride_num(arr, 20));
	}

}
