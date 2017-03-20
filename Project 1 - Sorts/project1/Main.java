package project1;

public class Main {

	public static void main(String[] args) {
		int[] arraySizesMerge = {10, 100, 1000, 10000, 100000, 1000000, 5000000}; 
		int runs = 5;
		
		//format table
		System.out.println("Merge Sort - tested on " + runs + " different arrays of size n");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("%7s%1s %15s%1s %17s%1s %15s%1s %17s", "n", "|", "C(n)", "|", "C(n)/(n*(log2)n)", "|", "T(n)", "|", "T(n)/(n*(log2)n)");

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
				for (int k = 0; k < arraySizesMerge[i]; k++){
					randomArray[k] = (int)(Math.random() * 1000000);
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
			int n = arraySizesMerge[i]; //this is the current array size n 
			double comparisonLog = averageComparisons/(n*(Math.log(n)/Math.log(2))); //Math.log(n)/Math.log(2) is log base 2
			double runtimeLog = averageTime/(n*(Math.log(n)/Math.log(2)));
			System.out.printf("\n%7d%1s %15d%1s %.15f%1s %15d%1s %.15f", arraySizesMerge[i], "|", averageComparisons, "|", comparisonLog, "|", averageTime, "|", runtimeLog);
		}
		

		int[] arraySizesInsertion = {10, 100, 1000, 10000, 100000, 200000, 300000}; 	
		
		//format table
		System.out.println("\nInsertion Sort - tested on " + runs + " different arrays of size n");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("%7s%1s %15s%1s %17s%1s %15s%1s %17s", "n", "|", "C(n)", "|", "C(n)/(n*(log2)n)", "|", "T(n)", "|", "T(n)/(n*(log2)n)");
		
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
				for (int k = 0; k < arraySizesInsertion[i]; k++){
					randomArray[k] = (int)(Math.random() * 1000000);
				}
				//now that it's populated, run mergesort on it and calculate time it takes
				startTime = System.nanoTime();
				totalComparisons += Sorts.insertionsort(randomArray);
				endTime = System.nanoTime();
				totalTime += endTime - startTime;
				if(!Sorts.isSorted(randomArray)){
					System.err.println("The array is not sorted.");
					System.exit(1);
				}
			}
			long averageTime = totalTime/5;
			long averageComparisons = totalComparisons/5;
			int n = arraySizesInsertion[i];
			double comparisonLog = averageComparisons/Math.pow(n, 2);
			double runtimeLog = averageTime/Math.pow(n, 2);
			System.out.printf("\n%7d%1s %15d%1s %.15f%1s %15d%1s %.15f", arraySizesInsertion[i], "|", averageComparisons, "|", comparisonLog, "|", averageTime, "|", runtimeLog);
		}
	}
}
