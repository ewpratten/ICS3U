/**
 * ArrayNums
 * 
 * By: Evan Pratten
 */

import java.util.Random;

public class ArrayNums {
	static Random rand = new Random();

	public static void main(String[] args) {
		/* Load an array with random data */
		int[] myArray = loadData(30);
		printArray(myArray);
		
		char luck = countArray(myArray);
		System.out.println("Luck: " + luck);
		
		int total = totalArr(myArray);
		System.out.println(total);
		
		if (total > (30*11) && luck == 'g') {
			System.out.println("you are execptionally lucky");
		}
		
	}
	
	/**
	 * Load an array with data
	 * 
	 * @param size Size of output array
	 * @return The new array with random data
	 */
	static int[] loadData(int size) {
		int[] arr = new int[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(20);
		}
		
		return arr;
	}
	
	/**
	 * Prints an array
	 * 
	 * @param arr The array to print
	 */
	static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	/**
	 * Shift an array to the left
	 * 
	 * @param arr Array to shift
	 * @returnn Shifted array
	 */
	static int[] leftShift(int[] arr) {
		int temp = arr[0];
		for (int i = 0; i < arr.length - 1; i++) {
			arr[i] = arr[i+1];
		}
		arr[arr.length- 1] = temp;
		return arr;
	}
	
	/**
	 * Turn an array into a luck
	 * 
	 * @param arr Source array
	 * @return Luck
	 */
	static char countArray(int[] arr) {
		int count7 = 0;
		int count13 = 0;
		
		for (int x : arr) {
			if (x == 13) {
				count13++;
			} else if (x == 7) {
				count7++;
			}
		}
		
		if (count13 > 0) {
			if (count13 >= 3) {
				return 'x';
			} else {
				if (count7 > count13) {
					return 'g';
				} else {
					return 'b';
				}
			}
		} else {
			return 'g';
		}
	}
	
	/**
	 * Get the total of an array
	 * 
	 * @param arr Source array
	 * @return Total sum
	 */
	static int totalArr(int[] arr) {
		int output = 0;
		for (int x : arr) {
			output += x;
		}
		
		return output;
	}
}
