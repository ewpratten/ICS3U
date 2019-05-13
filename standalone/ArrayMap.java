/**
 * ArrayMap
 * 
 * By: Evan Pratten
 */

import java.util.Arrays;

public class ArrayMap {
	
	static final int size = 10;

	public static void main(String[] args) {
		int[][] arr = gen2D(size, size, 10);
		arr[8][2] = 99;
		
		show2D(arr);

	}
	
	/**
	 * Create a 2D array with a border
	 */
	private static int[][] gen2D(int x, int y, int border){
		int[][] output = new int[x][y];
		
		// Fill edges
		fillRow(output[0], border);
		fillRow(output[output.length - 1], border);
		
		output = rotate2D(output, true);
		
		fillRow(output[0], border);
		fillRow(output[output.length - 1], border);
		
		output = rotate2D(output, false);
		
		return output;
	}
	
	/**
	 * Wraps Array.fill
	 */
	private static void fillRow(int[] row, int contents) {
		Arrays.fill(row, contents);
	}
	
	/**
	 * Rotate an array
	 */
	private static int[][] rotate2D(int[][] arr, boolean clockwise) {
		int size = arr.length;
		int[][] output = new int[size][size];
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				// Rotate correct direction
				if (clockwise) {
					output[i][j] = arr[size - j - 1][i];
				} else {
					output[i][j] = arr[j][size - i - 1];
				}
			}
		}
		
		return output;
	}
	
	/**
	 * Print an array with sensible spacing
	 */
	private static void show2D(int[][] arr) {
		for (int[] row : arr) {
			for (int x : row) {
				System.out.print(((x < 10 && x > -10)? "0"+x:x) + " ");
			}
			System.out.println("");
		}
	}

}
