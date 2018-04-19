package com.codeme.homework1;

public class TablicaMalarska {
	
	/**
	 * It prints out:
	 *   *
	 *   
	 *   * *
	 *
	 *   * *
	 *
	 *   * *
	 *   * * 
	 *
	 * using 2 for loops and multidimensional arrays
	 */
	
	public static void paint() {
		
		String[][] tablicaMalarska = new String[8][2];
		
		for(int a = 0; a < tablicaMalarska.length; a++) {
			for(int b = 0; b < tablicaMalarska[a].length; b++) {
				if (a==0 && b==1 || a==1 || a==3 || a==5) {
					tablicaMalarska[a][b] = " ";
				} else {
					tablicaMalarska[a][b] = "#";
				}
			}
		}
		
		for(String[] inside_array : tablicaMalarska) {
			for(String element : inside_array) {
				if (element == tablicaMalarska[0][1]) {
					System.out.print(" " + " ");
				} else {
					System.out.print("*" + " ");
				}
			}
			System.out.println();
		}
	}
	

	public static void main(String[] args) {
		
		paint();
		
	}

}
