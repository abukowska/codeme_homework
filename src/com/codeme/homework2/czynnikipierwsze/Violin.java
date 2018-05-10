package com.codeme.homework2.czynnikipierwsze;

public class Violin extends StringInstrument {

	public Violin(int heightViolin, int productionYearViolin) {
		super(heightViolin, productionYearViolin);
	}	
	
	@Override
	public void resonateWhenPlaying() {
		System.out.println("Violin resonates");		
	}

	@Override
	public int getStringsNumber() {
		return super.stringsNumber;
	}
	
	@Override
	public int getHeight() {
		return super.heightCm;
	}
	
	@Override
	public int getProductionYear() {
		return super.productionYear;
	}
	
	
}
