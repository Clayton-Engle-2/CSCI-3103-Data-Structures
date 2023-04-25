package sort;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Sorting.java provides implementations of different sorting algorithms for
 * sorting arrays of ints, as well as some utilities for creating/shuffling
 * arrays.
 *
 * All sorting methods are destructive in the sense that the modify the original
 * array. Also, all methods are static. Example usage:
 *
 * <code>
 *  int[] a = Sorting.init(100); // make an array w/ values 0, 1,...,99
 *  Sorting.shuffle(a);          // randomly shuffle the values of a
 *  Sorting.insertionSort(a);    // sort a using insertion sort
 *  </code>
 *
 * @author Will Rosenbaum
 */

public class Sorting {
	
	private static final int INSERTION_SORT_THRESHOLD = 10;

	/**
	 * Swaps the elements at positions i and j in the given array.
	 *
	 * @param arr the array containing the elements to be swapped
	 * @param i   the index of the first element to be swapped
	 * @param j   the index of the second element to be swapped
	 */
	private static void swap(int[] a, int i, int j) {
		int x = a[j];
		a[j] = a[i];
		a[i] = x;
	}

	/**
	 * Sorts the given array of integers in non-descending order using the insertion
	 * sort algorithm.
	 *
	 * @param a the array of integers to be sorted
	 * @return void
	 *
	 *         Time complexity: O(n^2) in the worst case, where n is the length of
	 *         the array. The algorithm performs n-1 iterations of the outer loop,
	 *         and each iteration may require up to n-1 comparisons and swaps in the
	 *         worst case. Therefore, the total number of comparisons and swaps
	 *         performed by the algorithm is proportional to n^2 in the worst case.
	 * 
	 *         To improve the performance of insertion sort, the implementation
	 *         provided here uses a binary search to find the correct position to
	 *         insert each element, rather than using the usual linear search. This
	 *         approach takes advantage of the fact that the already-sorted part of
	 *         the array is always in ascending order, making it easier to locate
	 *         the correct position.
	 *
	 *         Memory complexity: O(1). The algorithm only requires a constant
	 *         amount of additional memory to perform the sorting, regardless of the
	 *         size of the input array.
	 */
	public static void insertionSort(int[] a) {

		for (int i = 1; i < a.length; ++i) {
			int x = a[i];
			int j = binarySearch(a, x, 0, i);

			if (j < i) {
				System.arraycopy(a, j, a, j + 1, i - j);
				a[j] = x;
			}
		}
	}

	/**
	 * Searches for the index where the specified element should be inserted in a
	 * sorted array using binary search.
	 *
	 * @param a  the sorted array to search
	 * @param x  the element to search for
	 * @param lo the lower bound of the search range (inclusive)
	 * @param hi the upper bound of the search range (exclusive)
	 * @return the index where the element should be inserted
	 */
	private static int binarySearch(int[] a, int x, int lo, int hi) {

		while (lo < hi) {
			int mid = (lo + hi) >>> 1;

			if (x < a[mid]) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		return lo;
	}

	/**
	 * Sorts the given array of integers in non-descending order using the selection
	 * sort algorithm.
	 *
	 * @param a the array of integers to be sorted
	 * @return void
	 *
	 *         Time complexity: O(n^2) in the worst case, where n is the length of
	 *         the array. The algorithm performs n-1 iterations of the outer loop,
	 *         and each iteration may require up to n-1 comparisons in the worst
	 *         case to find the minimum value in the unsorted portion of the array.
	 *         Therefore, the total number of comparisons performed by the algorithm
	 *         is proportional to n^2 in the worst case.
	 *
	 *         Memory complexity: O(1). The algorithm only requires a constant
	 *         amount of additional memory to perform the sorting, regardless of the
	 *         size of the input array.
	 */
	public static void selectionSort(int[] a) {

		for (int i = 0; i < a.length - 1; ++i) {
			int minIndex = i;
			boolean swapped = false;

			for (int j = i + 1; j < a.length; ++j) {
				if (a[j] < a[minIndex]) {
					minIndex = j;
					swapped = true;
				}
			}

			if (swapped) {
				int tmp = a[i];
				a[i] = a[minIndex];
				a[minIndex] = tmp;
			} else {
				break;
			}
		}
	}

	/**
	 * Sorts the given array of integers in non-descending order using the bubble
	 * sort algorithm.
	 *
	 * @param a the array of integers to be sorted
	 * @return void
	 *
	 *         Time complexity: O(n^2) in the worst case, where n is the length of
	 *         the array. The algorithm performs n-1 iterations of the outer loop,
	 *         and each iteration may require up to n-1 comparisons and swaps in the
	 *         worst case to move the largest unsorted value to its final position.
	 *         Therefore, the total number of comparisons and swaps performed by the
	 *         algorithm is proportional to n^2 in the worst case.
	 * 
	 *         I tried to reduce the number of comparisons in the inner loop: The
	 *         inner loop currently compares adjacent elements and swaps them if
	 *         they are out of order. However, each swap only guarantees that the
	 *         maximum element in the unsorted part of the array is moved to its
	 *         correct position, and we need to repeat this process multiple times
	 *         to sort the entire array. To reduce the number of comparisons, we can
	 *         keep track of the last index where a swap occurred in the previous
	 *         iteration and only perform comparisons up to that index in the
	 *         current iteration.
	 *
	 *         Memory complexity: O(1). The algorithm only requires a constant
	 *         amount of additional memory to perform the sorting, regardless of the
	 *         size of the input array.
	 */
	public static void bubbleSort(int[] a) {
		int lastSwapIndex = a.length - 1;

		while (lastSwapIndex > 0) {
			int newLastSwapIndex = 0;

			for (int i = 0; i < lastSwapIndex; ++i) {
				if (a[i] > a[i + 1]) {
					int j = i + 1;

					while (j > 0 && a[j] < a[j - 1]) {
						int tmp = a[j];
						a[j] = a[j - 1];
						a[j - 1] = tmp;
						--j;
					}
					newLastSwapIndex = i;
				}
			}
			if (newLastSwapIndex == 0) {
				break;
			}
			lastSwapIndex = newLastSwapIndex;
		}
	}

	/**
	 * Sorts the given array of integers in non-descending order using the merge
	 * sort algorithm.
	 *
	 * @param a the array of integers to be sorted
	 * @return void
	 *
	 *         Time complexity: O(n*log(n)) in the worst case, where n is the length
	 *         of the array. The algorithm recursively divides the input array in
	 *         half until the subarrays have length 1 or 0, and then merges the
	 *         sorted subarrays in O(n) time at each level of the recursion. The
	 *         total number of levels in the recursion tree is O(log(n)), since the
	 *         input array is divided in half at each level. Therefore, the total
	 *         number of comparisons and swaps performed by the algorithm is
	 *         proportional to n*log(n) in the worst case.
	 *
	 *         Memory complexity: O(n). The algorithm requires an auxiliary array of
	 *         length n to store the merged subarrays during the merging process.
	 */
	public static void mergeSort(int[] a) {
		mergeSort(a, 0, a.length);
	}

	/**
	 * Sorts the portion of the given array between indices i and j in
	 * non-descending order using the merge sort algorithm.
	 *
	 * @param a the array of integers to be sorted
	 * @param i the starting index of the subarray to be sorted
	 * @param j the ending index of the subarray to be sorted
	 * @return void
	 */
	private static void mergeSort(int[] a, int i, int j) {
		if (j - i < INSERTION_SORT_THRESHOLD) {
			// Use insertion sort for small subarrays
			insertionSort(a, i, j);
		} else {
			int mid = (i + j) / 2;
			mergeSort(a, i, mid);
			mergeSort(a, mid, j);
			merge(a, i, mid, j);
		}
	}

	/**
	 * Merges the two sorted subarrays of the given array between indices i and mid,
	 * and between indices mid+1 and j, into a single sorted array between indices i
	 * and j.
	 *
	 * @param a   the array containing the subarrays to be merged
	 * @param i   the starting index of the first subarray to be merged
	 * @param mid the ending index of the first subarray to be merged
	 * @param j   the ending index of the second subarray to be merged
	 * @return void
	 *
	 *         Time complexity: O(n), where n is the total length of the subarrays
	 *         to be merged. The algorithm compares each element of the two
	 *         subarrays exactly once, and copies each element of the merged
	 *         subarray exactly once. Therefore, the total number of comparisons and
	 *         copies performed by the algorithm is proportional to n in the worst
	 *         case.
	 *
	 *         Memory complexity: O(n). The algorithm requires an auxiliary array of
	 *         length n to store the merged subarrays during the merging process.
	 */
	private static void merge(int[] a, int i, int mid, int j) {
		int[] temp = new int[j - i];
		int left = i;
		int right = mid;
		int k = 0;

		while (left < mid && right < j) {
			if (a[left] <= a[right]) {
				temp[k++] = a[left++];
			} else {
				temp[k++] = a[right++];
			}
		}

		while (left < mid) {
			temp[k++] = a[left++];
		}
		while (right < j) {
			temp[k++] = a[right++];
		}

		System.arraycopy(temp, 0, a, i, j - i);
	}

	/**
	 * Shuffles the values of an array in-place using the Fisher-Yates shuffle
	 * algorithm with reverse loop. This implementation optimizes run time by
	 * avoiding unnecessary swaps, resulting in a more efficient shuffling process.
	 * 
	 * The `shuffleOld` method shuffles an array of integers in-place using the
	 * Fisher-Yates shuffle algorithm with a reverse loop. The optimization that
	 * this implementation uses to reduce run time is to avoid unnecessary swaps by
	 * checking whether the indices being swapped are equal before performing the
	 * swap operation.
	 * 
	 * The Fisher-Yates shuffle algorithm works by iterating over an array in
	 * reverse order and swapping each element with a randomly-selected element
	 * before it. This algorithm ensures that each permutation of the array is
	 * equally likely to occur, making it ideal for shuffling purposes.
	 * 
	 * To generate random indices for the swaps, this implementation uses a
	 * ThreadLocalRandom object, which is a class that provides thread-local random
	 * number generation.
	 * 
	 * By iterating over the array in reverse order, this implementation ensures
	 * that each element has an equal chance of being selected for swapping,
	 * regardless of its position in the array. This approach is more efficient than
	 * iterating over the array in forward order, as it reduces the number of
	 * unnecessary swaps.
	 * 
	 * To further optimize the shuffling process, this implementation checks whether
	 * the indices being swapped are equal before performing the swap operation. If
	 * the indices are equal, the swap is skipped to avoid unnecessary operations.
	 *
	 * @param arr the array to be shuffled
	 */
	public static void shuffle(int[] arr) {

		int n = arr.length;
		ThreadLocalRandom rand = ThreadLocalRandom.current();

		for (int i = n - 1; i > 0; i--) {
			int j = rand.nextInt(i + 1);

			if (i != j) {
				swap(arr, i, j);
			}
		}
	}
	
	/**
	 * Sorts the subarray of an array using the insertion sort algorithm.
	 * 
	 * @param arr the array to be sorted
	 * @param left the left index of the subarray
	 * @param right the right index of the subarray
	 */
	private static void insertionSort(int[] arr, int left, int right) {
	    for (int i = left + 1; i <= right; i++) {
	        int key = arr[i];
	        int j = i - 1;
	        while (j >= left && arr[j] > key) {
	            arr[j + 1] = arr[j];
	            j--;
	        }
	        arr[j + 1] = key;
	    }
	}

	/**
	 * Returns a new array that is a copy of the specified array. The new array has
	 * the same length and contains the same elements as the original array.
	 * Modifying the new array does not affect the original array.
	 *
	 * @param a the array to copy
	 * @return a new array that is a copy of the specified array
	 */
	public static int[] copyOf(int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; ++i) {
			b[i] = a[i];
		}

		return b;
	}

	/**
	 * Returns a new array of size n that contains integers from 0 to n-1 in
	 * ascending order.
	 *
	 * @param n the size of the array to create
	 * @return a new array of size n containing integers from 0 to n-1
	 */
	public static int[] init(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = i;
		}

		return a;
	}
}
