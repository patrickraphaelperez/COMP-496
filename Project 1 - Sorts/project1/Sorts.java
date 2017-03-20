/*
 * Patrick-Raphael Perez
 * Professor Schwartz
 * COMP 496ALG - Spring 2017
 * February 28, 2017
 * Project 1: Sorts
 */
package project1;

public class Sorts {

	/*----------Insertion Sort----------*/
	public static long insertionsort(int[] a){
        long comparisonCount = 0;
        int tmp;
        for(int i = 1; i < a.length; i++) {
            for(int j = i; j > 0; j--) {
            	int currentIndex = a[j];
            	int leftIndex = a[j-1];
            	comparisonCount++;
                if(currentIndex < leftIndex) {
                    tmp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = tmp;
                }
            }
        }
        return comparisonCount;
	}

	/*----------Merge Sort--------------
	 * merges two sorted slices a[i...j] and a[j+1...k] 
	 * for 0 <= i <= j < k < a.length
	 * i = low index
	 * j = middle index
	 * k = high index
	 * returns the number of comparisons made
	 */
	public static long merge(int[] a, int i, int j, int k){
		long comparisonCount = 0;
		int size = (k-i+1);
		
		//create temporary array
		int[] tempArray = new int[size];
		int temp = 0; //temporary position
		int left = i; //left pointer
		int right = j+1; //right pointer
		
		while(temp < size){
			if(left <= j && right <= k){
				if(a[left] <= a[right]){
					tempArray[temp] = a[left];
					temp++;
					left++;
				} else {
					tempArray[temp] = a[right];
					temp++;
					right++;
				}
				comparisonCount++;
			} else if(left <= j) {
				tempArray[temp] = a[left];
				temp++;
				left++;
			} else if(right <= k) {
				tempArray[temp] = a[right];
				temp++;
				right++;
			}
		}
        
		//Now that temporary array is sorted, move it to original array
        temp = 0;
        for(int n = i; n <= k; n++) {
            a[n] = tempArray[temp];
            temp++;
        }
        
		return comparisonCount;
	}
	
	//sorts a[i...k] for 0 <= i <= k < a.length
	private static long mergesort(int[] a, int i, int k){
		long comparisonCount = 0;
		int medianIndex = (i+k)/2;
		if ((k-i) >= 2){ 
			/* break up the original array into 2 arrays 
			 * and then sort those lists  
			 */
			comparisonCount += mergesort(a, i, medianIndex);
			comparisonCount += mergesort(a, medianIndex+1, k);
		}
		comparisonCount += merge(a, i, medianIndex, k);
		return comparisonCount;
	}
	
	//sorts the array using mergesort
	public static long mergesort(int[] a){
		int i = 0;
		int k = a.length - 1;
		return mergesort(a, i, k);
	}
	
	public static boolean isSorted(int[] a){
		for (int i=1; i<a.length; i++){
			if(a[i]<a[i-1]){
				return false;
			}
		}
		return true;
	}
}
