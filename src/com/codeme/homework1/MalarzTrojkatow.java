package com.codeme.homework1;

public class MalarzTrojkatow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int y = 1; y < 4; y++) {
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
		}
	}

}
