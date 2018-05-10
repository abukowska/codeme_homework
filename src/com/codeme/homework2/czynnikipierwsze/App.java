package com.codeme.homework2.czynnikipierwsze;

public class App {

	public static void main(String[] args) {
		Cello cello = new Cello(180, 1890, true);
		System.out.println(cello.getHeight());
		System.out.println(cello.getProductionYear());
		System.out.println(cello.getStringsNumber());
		System.out.println(cello.isNew());
		cello.playOnStringsUsingBow();	
		cello.resonateWhenPlaying();
		
		Violin violin = new Violin(90, 1990);
		System.out.println(violin.getHeight());
		System.out.println(violin.getProductionYear());
		System.out.println(violin.getStringsNumber());
		violin.resonateWhenPlaying();
		
	}

}
