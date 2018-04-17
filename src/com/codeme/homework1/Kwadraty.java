package com.codeme.homework1;

public class Kwadraty {
	
	/**
	 * Prints out:
	 * 
	 *############
	 *#          #
	 *#          #
	 *#  ######  #
	 *#  #    #  #
	 *#  #    #  #
	 *#  #    #  #
	 *#  #    #  #
	 *#  ######  #
	 *#          #
	 *#          #
	 *############
	 *
	 * Using 2 for loops
	 */
	
	
	public static void printSquareIntoSquare() {
		
		for(int y = 1; y < 13; y++) {
			for(int x = 1; x < 13; x++) {
				if (y==1 || y==12) {
					System.out.print("#");
					continue;
				}
				if (y==2 || y==3 || y==10 || y==11) {
					if (x==1 || x==12) {
						System.out.print("#");
					} else {
						System.out.print(" ");
					}
				} else { 
					if (y==4 || y==9) {
						if (x==1 || x==4 || x==5 || x==6 || x==7 || x==8 || x==9 || x==12) {
							System.out.print("#");
						} else {
							System.out.print(" ");
						}
					} else {
						if (x==1 || x==4 || x == 9 || x==12) {
							System.out.print("#");
						} else {
							System.out.print(" ");
						}
					}
				}
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		
		printSquareIntoSquare();

	}

}
