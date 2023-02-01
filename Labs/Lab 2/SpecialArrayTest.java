package lab2;

/**
 *  This is the test file for SpecialArray Class
 */
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Zheng
 *
 */
public class SpecialArrayTest {

	@Test
	public void testtwoIndexes1() {
		int[] arr = {1, 3, 5, 6};	
		int target = 8;
		int[] ret = {1, 2};		
		assertArrayEquals("twoIndexes function is wrong !", ret, SpecialArray.twoIndexes(arr, target));
		
	}
	
	@Test
	public void testtwoIndexes2() {
		int[] arr = {1, 3, 4, 6};	
		int target = 6;
		int[] ret = {-1, -1};		
		assertArrayEquals("twoIndexes function is wrong !", ret, SpecialArray.twoIndexes(arr, target));
	}
	
	
	
	@Test
	public void testPrintOuter1() {
		int[][] arr = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12},{13,14,15,16}};	
		String str = "1 2 3 4 8 12 16 15 14 13 9 5";		
		assertEquals("printSurroundingArray function is wrong !", str, SpecialArray.printSurroundingArray(arr));
		
	}
	
	@Test
	public void testPrintOuter2() {
		int[][] arr = {{1,2,3}, {4, 5,6}, {7,8,9}};	
		String str = "1 2 3 6 9 8 7 4";
		assertEquals("printSprialArray function is wrong !", str, SpecialArray.printSurroundingArray(arr));
	}
	
	@Test
	public void testPrintOuter3() {
		int[][] arr = {{1,2,3}};	
		String str = "1 2 3";
		assertEquals("printSprialArray function is wrong !", str, SpecialArray.printSurroundingArray(arr));
	}
	
	@Test
	public void testPrintOuter4() {
		int[][] arr = {{1}};	
		String str = "1";
		assertEquals("printSprialArray function is wrong !", str, SpecialArray.printSurroundingArray(arr));
	}	
	
	@Test
	public void testPrintSpiral1() {
		int[][] arr = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12},{13,14,15,16}};	
		String str = "1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10";		
		assertEquals("SpiralArrayPrint function is wrong !", str, SpecialArray.printSprialArray(arr));
		
	}
	
	@Test
	public void testPrintSpiral2() {
		int[][] arr = {{1,2,3}, {4, 5,6}, {7,8,9}};	
		String str = "1 2 3 6 9 8 7 4 5";
		assertEquals("SpiralArrayPrint function is wrong !", str, SpecialArray.printSprialArray(arr));
	}
	
	@Test
	public void testPrintSpiral3() {
		int[][] arr = {{1,2,3}};	
		String str = "1 2 3";
		assertEquals("printSprialArray function is wrong !", str, SpecialArray.printSprialArray(arr));
	}
	
	@Test
	public void testPrintSpiral4() {
		int[][] arr = {{1}};	
		String str = "1";
		assertEquals("printSprialArray function is wrong !", str, SpecialArray.printSprialArray(arr));
	}

}
