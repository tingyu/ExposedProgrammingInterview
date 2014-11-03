/*
Selection Sort

不断的找最小的并且交换
Selection sort is one of the simplest sorting algorithms. It starts with the first element 
in the array (or list) and scans through the array to find the element with the smallest key, 
which it swaps with the first element. The process is then repeated with each subsequent element until 
the last element is reached.
*/



//sort an array using a recursive selection sort
public void selectionSortRecursive(int[] data){
	selectionSortRecursive(data, 0);
}

//sort a subset of the array starting at the given index
private void selectionSortRecursive(int[] data, int start){
	if(start < data.length - 1){
		swap(data, start, findMinimunIndex(data, start));
		selectionSortRecursive(data, start + 1);
	}
}

//find the position of the minimun value starting at the given index
private int findMinimunIndex(int[] data, int start){
	int minPos = start;

	for(int i = start + 1; i < data.length; i++){
		if(data[i] < data[minPos]){
			minPos = i;
		}
	}
	return minPos;
}

//swap two elements in an array
private void swap(int[] data, int index1, int index2){
	if(index1 != index2){
		int tmp = data[index1];
		data[index1] = data[index2];
		data[index2] = tmp;
	}
}

/*
优化：
1. iterative implementation
2. inline two helper function

How efficient is selection sort? The first swap requires n – 1 comparisons, the second n – 2, the third n – 3, 
and so on. This is the series (n – 1) + (n – 2) + ... + 1, which simplifies to n(n – 1)/2. 
This means that the algorithm is O(n2) in the best, average, and worst cases — the initial order of 
the data has no effect on the number of comparisons. As you’ll see later in this chapter, 
other sorting algorithms have more efficient running times than this.

Selection sort is not difficult to analyze compared to other sorting algorithms since none of the
loops depend on the data in the array. Selecting the lowest element requires scanning all n elements 
(this takesn − 1 comparisons) and then swapping it into the first position. 
Finding the next lowest element requires scanning the remaining n − 1 elements and so on, 
for (n − 1) + (n − 2) + ... + 2 + 1 = n(n − 1) / 2 ∈ Θ(n2) comparisons. 
Each of these scans requires one swap for n − 1 elements.
http://www.java2novice.com/java-sorting-algorithms/selection-sort/


Selection sort does have the advantage that it requires at most n – 1 swaps. 
In situations in which moving data elements is more expensive than comparing them, 
selection sort may perform better than other algorithms. The efficiency of an algorithm 
depends on what you’re optimizing for.

Selection sort is an in-place algorithm. Typical implementations of selection sort, 
such as the one shown here, are not stable.
*/

public class MySelectionSort {
	public static int[] doSelectionSort(int[] arr){
		for(int i = 0; i < arr.length; i++){
			int index = i;
			for(int j = i + 1; j < arr.length; j++){
				if(arr[j] < arr[index]){
					index = j;
				}
			}
			int smallerNumber = arr[index];
			arr[index] = arr[i];
			arr[i] = smallerNumber;
		}
		return arr;
	}

	public static void main(String a[]){
         
        int[] arr1 = {10,34,2,56,7,67,88,42};
        int[] arr2 = doSelectionSort(arr1);
        for(int i:arr2){
            System.out.print(i);
            System.out.print(", ");
        }
    }
}



