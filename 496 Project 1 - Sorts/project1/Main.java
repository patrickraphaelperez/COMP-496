package project1;

public class Main {

	public static void main(String[] args) {
		int[] arraySizesMerge = {10, 100, 1000, 10000, 100000, 1000000, 5000000}; 
		int runs = 5;
		
		//format table
		System.out.println("Merge Sort - tested on " + runs + " different arrays of size n");
		System.out.println("---------------------------------------------------"); //51
		System.out.printf("%7s", "n"); //space of size 7 bc max number is 5 million
		System.out.printf("%1s %10s", "|", "C(n)");
		//System.out.printf("-%1s %10s", "|", "C(n)/(n*log2(n))");
		System.out.printf("%1s %10s", "|", "T(n)");
		//System.out.printf("-%1s %10s", "|", "T(n)/(n*log2(n))");
		
		//run merge sort on seven different size n's 
		for (int i = 0; i < 7; i++){
			long totalTime = 0;
			long totalComparisons = 0;
			//run merge sort on five different random arrays of the size n
			for (int j = 0; j < 5; j++){
				long startTime;
				long endTime;
				int[] randomArray = new int[arraySizesMerge[i]];
				//populate random array with random integers
				for (int n = 0; n < arraySizesMerge[i]; n++){
					randomArray[n] = (int)(Math.random() * 1000000);
				}
				//now that it's populated, run mergesort on it and calculate time it takes
				startTime = System.nanoTime();
				totalComparisons += Sorts.mergesort(randomArray);
				endTime = System.nanoTime();
				totalTime += endTime - startTime;
				if(!Sorts.isSorted(randomArray)){
					System.err.println("The array is not sorted.");
					System.exit(1);
				}
			}
			long averageTime = totalTime/5;
			long averageComparisons = totalComparisons/5;
			System.out.printf("\n%7d", arraySizesMerge[i]);
			System.out.printf("%1s %10d", "|", averageComparisons);
			System.out.printf("%1s %10d", "|", averageTime);
		}
		

		int[] arraySizesInsertion = {10, 100, 1000, 10000, 100000, 200000, 300000}; 	
		
		//format table
		System.out.println("\nInsertion Sort - tested on " + runs + " different arrays of size n");
		System.out.println("---------------------------------------------------"); //51
		System.out.printf("%7s", "n"); //space of size 7 bc max number is 5 million
		System.out.printf("%1s %10s", "|", "C(n)");
		//System.out.printf("-%1s %10s", "|", "C(n)/(n*log2(n))");
		System.out.printf("%1s %10s", "|", "T(n)");
		//System.out.printf("-%1s %10s", "|", "T(n)/(n*log2(n))");
		
		//run insertion sort on seven different size n's 
		for (int i = 0; i < 7; i++){
			long totalTime = 0;
			long totalComparisons = 0;
			//run insertion sort on five different random arrays of the size n
			for (int j = 0; j < 5; j++){
				long startTime;
				long endTime;
				int[] randomArray = new int[arraySizesInsertion[i]];
				//populate random array with random integers
				for (int n = 0; n < arraySizesInsertion[i]; n++){
					randomArray[n] = (int)(Math.random() * 1000000);
				}
				//now that it's populated, run mergesort on it and calculate time it takes
				startTime = System.nanoTime();
				totalComparisons += Sorts.insertionSort(randomArray);
				endTime = System.nanoTime();
				totalTime += endTime - startTime;
				if(!Sorts.isSorted(randomArray)){
					System.err.println("The array is not sorted.");
					System.exit(1);
				}
			}
			long averageTime = totalTime/5;
			long averageComparisons = totalComparisons/5;
			System.out.printf("\n%7d", arraySizesInsertion[i]);
			System.out.printf("%1s %10d", "|", averageComparisons);
			System.out.printf("%1s %10d", "|", averageTime);
		}
	}
}
