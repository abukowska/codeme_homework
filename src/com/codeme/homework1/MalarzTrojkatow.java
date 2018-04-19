package com.codeme.homework1;

public class MalarzTrojkatow {
	
	/** Prints out:
	 * 
	 *     /\
	 *    /  \
	 *  /    \
	 * ------
	 * 
	 * using 2 while loops
	 */
	public static void printTrianglesWhile() {
		
		int y = 1;
		while(y <= 4) {
			int x = 1;
			while(x <= 7) {
				if(y==1) {
					if(x==3) {
						System.out.print("/");
					} else if (x==4) {
						System.out.print("\\");
					} else {
						System.out.print(" ");
					}
				} else if (y==2) {
					if(x==1) {
						System.out.println("");
						System.out.print(" ");
					} else if (x==2) {
						System.out.print("/");
					} else if (x==5) {
						System.out.print("\\");
					} else {
						System.out.print(" ");
					}
				} else if (y==3) {
					if(x==1) {
						System.out.println("");
						System.out.print("/");
					} else if (x==6) {
						System.out.print("\\");
					} else {
						System.out.print(" ");
					}
				} else {
					if (x==1) {
						System.out.println("");
					} else {
						System.out.print("-");
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
