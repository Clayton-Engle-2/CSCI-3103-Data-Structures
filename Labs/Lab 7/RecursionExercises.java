package Lab 7;

public class RecursionExercises {
	/**
	 * Given an integer n, find the sum of the series 1^1 + 2^2 + 3^3 + ¡­.. + n^n 
	 * using recursion.
	 * @param n 
	 * @return the sum of the series 1^1 + 2^2 + 3^3 + ¡­.. + n^n 
	 */
	public static double sum(int n)
	{
		// Base case: if n is 1, then the sum is 1^1 = 1
	    if (n == 1) {
	        return 1;
	    }
	    
	    // Recursive case: add n^n to the sum of the series for n-1
	    return exponent(n) + sum(n - 1);
		
	}
	
	/**
	 * This method is an implementation of the pow() method from the Math class
	 * in the Java standard library. Here, a number is multiplied by itself n number
	 * of times to calculate a number raised to the same number exponent
	 * 
	 * @param n, the number for which we will perform n^n
	 * @return
	 */
	public static double exponent(int n)
	{
		// If n is 0, return 1 since 0^0 = 1.
		if(n == 0){
			return 1.0;
		}
/*
 * Initialize a double to hold the return value, then multiply
 * the number by the original value of n n-1 times, since the
 * first loop is like having n^2.
 */
		double answer = n;
		for(int i = n; i > 1; i--) {
			answer *= n;
		}		
		
		//return the value of n^n
		return answer;
	}
	
	
	/**
	 * Climbing stairs Problem: @restriction: Each time can climb 1, 2 or 3 steps.
	 * @param n - total number of steps
	 * @return the number of distinct ways from bottom to top
	 */
	public static long climbStairs(int n)
	{			
		// Base cases: if the number of steps is 0, 1, or 2, there is only one way to climb the staircase
	    if (n == 0 || n == 1) {
	        return 1;
	    }
	    if (n == 2) {
	        return 2;
	    }
	    
	    // Recursive case: the number of distinct ways to climb n steps is the sum of the number of distinct
	    // ways to climb n-1, n-2, and n-3 steps
	    return climbStairs(n-1) + climbStairs(n-2) + climbStairs(n-3);
	}
	

	/**
	 * The method uses binary search to find the index of the given target value in a sorted array of integers. 
	 * The method takes in four parameters: the array to search (arr), the target value to search for (target), 
	 * and the starting and ending indices of the search range (start and end).
	 * 
	 * The method starts with a base case: if start is greater than end, the target value is not in the array, and 
	 * we return false. Otherwise, we compute the middle index of the search range using integer division and compare 
	 * the middle element to the target. If the middle element is equal to the target, we've found it and return 
	 * true. If the middle element is greater than the target, we recursively search the left half of the array by 
	 * calling binSearchTarget with start and mid - 1 as the new search range. If the middle element is less than the 
	 * target, we recursively search the right half of the array by calling binSearchTarget with mid + 1 and end as 
	 * the new search range.
	 * 
	 * The binary search algorithm reduces the size of the search range by half with each recursive call, resulting in 
	 * a time complexity of O(log n), where n is the size of the input array.
	 * 
	 * Find the index of the given target in sorted array (assume no duplicated elements)
	 * Example: (arr = [1 2 4 7 9], target = 7, start = 0, end = 4)  return true
	 * @param arr
	 * @param target
	 * @param start - starting index
	 * @param end - ending index
	 * @return true the given target in sorted array or false if not found
	 */
	public static boolean  binSearchTarget(int[] arr, int target, int start, int end)
	{
		// Base case: if the start index is greater than the end index, the target is not in the array
	    if (start > end) {
	        return false;
	    }
	    
	    // Compute the middle index of the search range
	    int mid = start + (end - start) / 2;
	    
	    // If the middle element is equal to the target, we've found it!
	    if (arr[mid] == target) {
	        return true;
	    }
	    
	    // If the middle element is greater than the target, search the left half of the array
	    if (arr[mid] > target) {
	        return binSearchTarget(arr, target, start, mid - 1);
	    }
	    
	    // Otherwise, search the right half of the array
	    return binSearchTarget(arr, target, mid + 1, end);
		
	}
	

	
//	==============================  5%  Extra Credit ==================================
	/**
	 * The method is similar to the binSearchTarget method, but it allows for duplicates in the sorted array. 
	 * The method takes in four parameters: the array to search (arr), the target value to search for (target), 
	 * and the starting and ending indices of the search range (start and end).
	 * 
	 * Find the index of first occurrence of given target in sorted array (allow duplicated elements)
	 * Example: (arr = [1 1 1 2 4], target = 1, start = 0, end = 4)  return 0
	 * @param arr
	 * @param target
	 * @param start - starting index
	 * @param end - ending index
	 * 
	 * @return the index of first occurrence of the given target in sorted array or -1 if not found
	 */
    // Please also add at least two J-unit test cases in the test file.
	public static int  binSearchTargetDup(int[] arr, int target, int start, int end)
	{	
/*
 * The method starts with a base case: if start is greater than end, the target value is not in the array, 
 * and we return -1. 
 * 
 *      Base case: if the start index is greater than the end index, the target is not in the array */
	    if (start > end) {
	        return -1;
	    }
/*
 * Otherwise, we compute the middle index of the search range using integer division and 
 * compare the middle element to the target. If the middle element is equal to the target, 
 * we need to check if it's the first occurrence. 
 * 
 *      Compute the middle index of the search range */    
	    int mid = start + (end - start) / 2;
	    
	    // If the middle element is equal to the target, we need to check if it's the first occurrence
	    if (arr[mid] == target) {
	        // If the middle element is the first element or the previous element is less than the target,
	        // we've found the first occurrence
	        if (mid == 0 || arr[mid-1] < target) {
	            return mid;
	        }
/*
 * If it's not, we search the left half of the array for the first occurrence by recursively calling 
 * binSearchTargetDup with start and mid - 1 as the new search range. If the middle element is greater 
 * than the target, we recursively search the left half of the array. If the middle element is less 
 * than the target, we recursively search the right half of the array. */
	        return binSearchTargetDup(arr, target, start, mid - 1);
	    }
	    
	    // If the middle element is greater than the target, search the left half of the array
	    if (arr[mid] > target) {
	        return binSearchTargetDup(arr, target, start, mid - 1);
	    }
	    
	    // Otherwise, search the right half of the array
	    return binSearchTargetDup(arr, target, mid + 1, end);
	}
	

}
