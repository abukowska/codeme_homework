package com.codeme.homework1;

public class MalarzTrojkatow {
	
	/** Prints out
	 * /\
	 * / \
	 * / \
	 * using while loop
	 */
	public static void printTrianglesWhile() {
		int y = 1;
		while (y < 4) {
			for(int x = 1; x < 4; x++) {
				if (x==1) {
					System.out.print("/");
					continue;
				}
				if(y == 1) {
					if(x == 2) {
						System.out.println("\\");
					}
				} 
				else {
					if(x == 3) {
						System.out.println("\\");
					} else {
						System.out.print(" ");
					}
				}
			}
			y++;
		}
	}
	
	
	public static void main(String[] args) {
		
		printTrianglesWhile();		
		
	}

}
