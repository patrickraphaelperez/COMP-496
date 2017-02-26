package project1;

public class Sorts {

	/*----------Insertion Sort----------*/
	public static long insertionSort(int[] a){
        long comparisonCount = 0;
        int currentIndex;
        for(int i = 0; i < a.length; i++) {
        	currentIndex = a[i];
            for(int j = i-1; j >= 0; j--) {
                if(currentIndex < a[j]) {
                    a[j+1] = a[j];
                    a[j] = currentIndex;
                    comparisonCount++;
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
		for (int n = i; n <= k; n++){
			tempArray[n] = a[n];
		}
		
		int temp = 0; //temporary position
		int left = i; //left pointer
		int right = j+1; //right pointer
		
		while(temp < size){
			if(left <= j && right <= k){
				if(tempArray[left] <= tempArray[right]){
					a[temp] = tempArray[left];
					i++;
					left++;
				} else {
					a[temp] = tempArray[right];
					temp++;
					right++;
				}
				comparisonCount++;
			} else if(left <= j) {
				a[temp] = tempArray[left];
				temp++;
				left++;
			} else if(right <= k) {
				a[temp] = tempArray[right];
				temp++;
				right++;
			}
		}
		return comparisonCount;
	}
	
	//sorts a[i...k] for 0 <= i <= k < a.length
	private static long mergesort(int[] a, int i, int k){
		int medianIndex = (i+k)/2;
		if (i < k){ 
			/* break up the original array into 2 arrays 
			 * and then sort those lists  
			 */
			mergesort(a, i, medianIndex);
			mergesort(a, medianIndex+1, k);
		}
		return merge(a, i, medianIndex, k);
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
