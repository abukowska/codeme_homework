package com.codeme.homework1;

public class MalarzTrojkatow {
	
	/** Prints out:
	 * 
	 *     /\
	 *    /  \
	 * 	 /    \
	 * 	 ------
	 * 
	 * using 2 while loops
	 */
	public static void printTrianglesWhile() {
		
		int y = 1;
		while(y < 4) {
			int x = 1;
			while(x < 4) {
				if(x==1) {
					System.out.print("/");
				}
				if(y==1) {
					if(x==2) {
						System.out.println("\\");
					}
				} 
				else {
					if(x==2) {
						System.out.print(" ");
					} else if (x==3) {
						System.out.println("\\");
					}
				}
				x++;
			}
			y++;
		}
	}

	
	public static void main(String[] args) {
		
		printTrianglesWhile();		
		
	}

}
