package lab2;

/**
 *  
 * @author Clayton Engle
 * 
 * Design decisions:
 * -----------------------------
 * Problem 1:
 * 	 For the first problem I created a recursive solution because I know the basics of how recursion works and wanted practice
 * 	 implementing the concept in code. Recursion may not be more efficient with a small, sorted data set but will surely 
 *       perform better with more data. My main idea is to increment where I begin checking for target matches, since elements 
 *	 that occur early in the array will have already been compared to other low index elements, and do not need to be checked twice.
 * 
 * Problem 2:
 *	 To solve the second problem I use various for loops to iterate through each side of the 2D array in a clockwise order. I 
 *	 used the StringBuilder class to append elements because the process of concatenation can be slow. I wrote this code with 
 *	 the spiral extra credit problem in mind. My thought was if I could navigate the perimeter of the 2D array I could 
 *	 increment the start and stop variables to repeat the process in a smaller box, starting and ending in the top left.
 * 
 * Problem 3:
 * 	 On the third problem my goal was to have the program collect elements from a full row, or column, until it was unable to, 
 *	 then  turn right, and repeat. This is a smaller task than encircling the entire array and incrementally decreasing the 
 *	 parameters. To do this I start with an if statement to check all possible cases where the "direction" of collection 
 *	 would need to turn. Then I have a switch statement which provides slightly different instructions based on the current 
 *	 "direction" of collection. Each case will recursively call the getSpiral() method with updated parameters to keep the 
 *	 current direction the same. If an index outside the bounds of the array is passed in, the catch all if statement will 
 *	 trigger and pop the method from the instruction  stack. The JVM will continue execution  from the next line of code in 
 *	 the previous method, which will change the current direction to it`s respective left, and repeat. To prevent the program 
 *	 from overlapping, or adding the same index twice, I added an equally sized 2D array of type boolean. When an index is 
 *	 added, the corresponding boolean will be set to true. When all indexes surrounding the current index are invalid moves, 
 *	 all method calls will be returned, and the program will will exit the method entirely, returning a String of the 
 *	 elements in the array in "clockwise spiral" order.
 */

public class SpecialArray {
	
	/**
	 * Original Instructions for Problem 1:
	 * ===============================================
	 * 
	 * This function is to find two different indexes of elements in an 1D sorted array with sum of the two elements equals a given target value. 
	 * If found, return the indexes of the two elements as an array (indexes start from 0). If not found, return an array as [-1,-1].
	 * @param arr - 1D array
	 * @return ret - If found, an 1D array with the two indexes [small_index, large_index]. If not found, ret = [-1,-1]
	 * Assumption: The elements are unique and sorted in ascending order.
	 * Example1:   arr = {1 3 5 6}, target = 7
	 *             ret = [0, 3]
	 *            
	 * Example2:   arr = {1 3 5 6}, target = 10
	 *             ret = [-1, -1]            
	 *            
	 *======================================================
	 *
	 *Updated JavaDoc Comments for twoIndexes()
	 *-----------------------------------------------------
	 *	 Returns the indices of the two numbers in the given array that add up to the target.
	 *	 If no such indices exist, returns {-1, -1}.
	 * 
	 *	 @param nums an array of integers
	 *	 @param target the target sum of two numbers
	 *	 @return an array of two integers representing the indices of the two numbers that add up to the target
	 */
	public static int[] twoIndexes(int[] nums, int target) {
		int[] ret = {-1, -1};    // if no match, return {-1, -1}
		ret = findIndex(nums, target, 0, ret);
		return ret; 
	}
	 	 
	/**
	 * A helper function to find the indices of the two numbers in the given array that add up to the target.
	 * 
	 * @param nums an array of integers
	 * @param target the target sum of two numbers
	 * @param start the starting index to search from
	 * @param index an array to store the indexes of integers that add to target
	 * @return an array of two integers representing the indices of the two numbers that add up to the target
	 */
	private static int[] findIndex(int[] nums, int target, int start, int[] index) {
		 
		// Base case: if the start of the search has reached the end of the array, return -1 for
		// both indexes to indicate the values were not found in the array
		if(start == nums.length - 1)
			return index;
		 	 
		// Adds the "start: element to each of the remaining unchecked elements in the array
		// if two elements are found who`s sum is the target, their indexes are returned 
		for(int i = start + 1; i < nums.length; i++) {
			if(nums[start] + nums[i] == target) {
				index[0] = start;
				index[1] = i;
				return index;
			}
		}
		// If no match is found, increment the start index and recursively call the method again
		return findIndex(nums, target, start + 1, index);
	}
	 
	/**
	 * This function is to print the the outer surrounding elements of 2D n x m array in clock-wise order.
	 * @param arr - 2D array
	 * @return String - the outer surrounding elements of 2D arr in clock-wise order (numbers should be separated by single space)
	 *
	 * Example:    1   2   3  4
	 *             5   6   7  8
	 *             9   10  11 12
	 * 
	 * Return:   1 2 3 4 8 12 11 10 9 5
	 * 
	 * This method returns a string representation of the elements surrounding the perimeter of the given 2D array "arr".
	 * @param arr The input 2D array
	 * @return A string representation of the elements surrounding the perimeter of the given 2D array
	 */
	public static String printSurroundingArray(int[][] arr)
	{
		String ret = traversePerimeter(arr);
		return ret.trim(); 	
	}
	
	/**
	 * This method returns a string representation of the elements surrounding the perimeter of the given 2D array "arr".
	 * This method is called by printSurroundingArray.
	 * @param arr The input 2D array
	 * @return A string representation of the elements surrounding the perimeter of the given 2D array
	 */
	private static String traversePerimeter(int[][] arr) {
		// construct StringBuilder object, as concatenating Strings has a worse case time complexity of O(n^2), as Strings are 
		// immutable
		StringBuilder result = new StringBuilder();
		traversePerimeter(arr, 0, 0, arr.length - 1, arr[0].length - 1, result);
		return result.toString();
	}
	
	/**
	 * This method is used to traverse the perimeter of the given 2D array arr and add the elements to the StringBuilder result.
	 * This method is called by traversePerimeter.
	 * @param arr The input 2D array
	 * @param rowStart The starting row index for traversing
	 * @param colStart The starting column index for traversing
	 * @param rowEnd The ending row index for traversing
	 * @param colEnd The ending column index for traversing
	 * @param result The StringBuilder to store the result
	 */
	private static void traversePerimeter(int[][] arr, int rowStart, int colStart, int rowEnd, int colEnd, StringBuilder result) {
		
		// Add the first row to result, excluding the corners
		for (int i = colStart; i <= colEnd; i++) {
			result.append(arr[rowStart][i]).append(" ");
		}
		
		// Add the last column to result, excluding the corners
		for (int i = rowStart + 1; i <= rowEnd - 1; i++) {
			result.append(arr[i][colEnd]).append(" ");
		}
		
		// Add the last row to result, excluding the corners
		for (int i = colEnd; i >= colStart; i--) {
			if (rowStart != rowEnd) {
				result.append(arr[rowEnd][i]).append(" ");
			}
		}
		
		// Add the first column to result, excluding the corners
		for (int i = rowEnd - 1; i > rowStart; i--) {
			result.append(arr[i][colStart]).append(" ");
		}   
	}

	/************   This is an 10 points -  Extra Credit Question  *****************************
	 * This function is to print a 2D n x n square array in Spiral oder
	 * @param arr - 2D array
	 * @return String - the spiral order of arr (numbers should be separated by single space)
	 * Example:    1   2   3
	 *             4   5   6
	 *             7   8   9
	 * 
	 * Return:   1  2  3 6 9 8 7 4 5
	 */
	/**
	 * Returns a string representation of the elements of a 2-dimensional array in a spiral order.
	 * @param arr 2-dimensional array to be spiraled
	 * @return string representation of elements in spiral order
	 */
	public static String printSprialArray(int[][] arr)
	{
		String ret =  getSpiral(arr);
		return ret.trim();	  	
	}
	/**
	 * The idea here is that the spiral can be composed of 
	 * 		------>
	 * which represent the moving through the 2D array and adding elements to the return String
	 * The "X" marks show where the last valid index in a row or column is.
	 * When an index meets criteria for X status, the program makes a "right turn"
	 * This process repeats until it can not turn or move forward, at which point the spiral is complete
	 * 
	 * Diagram:
	 * 		--------------->X
	 * 		X----------->X  |
	 * 		^  X------X  |  |
	 *              |  | X--X |  |  |
	 * 		|  | |    |  |  |  
	 * 		|  | X----X  |  |
	 * 		|  X---------X  V
	 * 		X<--------------X
	 * 
	 * Helper method to get a string representation of the elements of a 2-dimensional array in a spiral order.
	 * @param arr 2-dimensional array to be spiraled
	 * @param row the current row being processed
	 * @param col the current column being processed
	 * @param visited 2-dimensional boolean array to track if a cell has been processed
	 * @param result StringBuilder object to hold the result string
	 * @param direction the direction the traversal should move in (0: right, 1: down, 2: left, 3: up)
	 * @return string representation of elements in spiral order
	 */
	private static String getSpiral(int[][] arr, int row, int col, boolean[][] visited, StringBuilder result, int direction) {
		
		// if the next index in line is either out of bounds or has already been added, return from recursive loop
		if (row < 0 || row >= arr.length || col < 0 || col >= arr[0].length || visited[row][col]) {
			return result.toString().trim();
		}
		
		// set current index to "visited"
		visited[row][col] = true;
		// adds value of current index to to string
		result.append(arr[row][col]).append(" ");
		  
		// switch statement will call getSpiral again with updated parameters, using an arbitrary "direction" indicator 
		// to determine which index is next in line
		switch (direction) {
		
		// next index to the left (col + 1)
		// if next left index is invalid, set direction to down (1)
		// then move down (row + 1)
		case 0:
			getSpiral(arr, row, col + 1, visited, result, 0);
		    getSpiral(arr, row + 1, col, visited, result, 1);
		    break;
		    
		 // next index below (row + 1)
		// if next index is invalid, set direction to right (2)
		// then move right (col - 1)
		case 1:
			getSpiral(arr, row + 1, col, visited, result, 1);
		    getSpiral(arr, row, col - 1, visited, result, 2);
		    break;
		    
		 // next index to the right (col- 1)
		// if next right index is invalid, set direction to up (3)
		// then move up (row - 1)
		case 2:
			getSpiral(arr, row, col - 1, visited, result, 2);
		    getSpiral(arr, row - 1, col, visited, result, 3);
		    break;
		    
		 // next index above (row - 1)
		// if next index is invalid, set direction to left (0)
		// then move left (col + 1)
		case 3:
			getSpiral(arr, row - 1, col, visited, result, 3);
		    getSpiral(arr, row, col + 1, visited, result, 0);
		    break;
		}
		// returns spiral String, will return only when none of the previous function calls are valid, 
		// indicating the spiral is at it`s center
		return result.toString().trim();
	}
	/**
	 * Returns a string representation of the elements of a 2-dimensional array in a spiral order.
	 *
	 * @param arr 2-dimensional array to be spiraled
	 * @return string representation of elements in spiral order
	 */
	private static String getSpiral(int[][] arr) {
		StringBuilder result = new StringBuilder();
		
		// Initialize a 2-dimensional boolean array to track if a cell has been processed
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		
		//call recursive helper method and pass in starting values
		getSpiral(arr, 0, 0, visited, result, 0);
		return result.toString().trim();
	}
}

