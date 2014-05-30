/**
Binary Search
PROBLEM: Implement a function to perform a binary search on a sorted array
of integers to find the index of a given integer. Comment on the efficiency of this
search, and compare it with other search methods.
*/

int binarySearch(int[] array, int target) throws BSException{
	return binarySearch(array, target, 0, array.length-1);
}

int binarySearch(int[] array, int target, int lower, int upper) throws BSException{
	int center, range;

	range = upper - lower;
	if(range < 0){
		throws new BSException("Limits reversed");
	} else if(range ==0 && array[lower] != target){
		throws new BSException("Element not in array");
	}

	if(array[lower] > array[upper]){
		throws new BSException("Array not sorted");
	}
	center = ((range)/2) + lower;
	if(target == array[center]){
		return center;
	} else if (target < array[center]){
		return binarySearch(array, target, lower, center - 1);
	} else{
		return binarySearch(array, target, center +1, upper);
	}

}


/*If you analyze the recursion in the previous solution, you can see that each recursive call serves only
to change the search limits. There’s no reason why you can’t change the limits on each iteration of
a loop and avoid the overhead of recursion. (When compiled with tail call elimination, the preceding
recursive implementation would likely produce machine code indistinguishable from an iterative
implementation.) The method that follows is a more efficient, iterative analog of the recursive binary
search:
*/

int iterBinarySearch(int[] array, int target) throws BSException {
	int lower = 0, upper = array.length-1;
	int center, range;

	if(lower > upper){
		throws new BSException("Limits reversed");
	}
	while(true) {
		range = upper - lower;
	}
	if(range == 0 && array[lower] != target){
		throws new BSException("Element not in array");
	}
	if(array[lower] > array[upper]){
		throws new BSException("Array not sorted");
	}
	center = ((range)/2) + lower;
	if(target == array[center]){
		return center;
	} else if(target < array[center]){
		upper = center -1;
	} else{
		lower = center +1;
	}
}