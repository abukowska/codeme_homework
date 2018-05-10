package com.codeme.homework2.czynnikipierwsze;

public abstract class StringInstrument {
	protected final Integer stringsNumber = 4;
	protected int heightCm;
	protected int productionYear;
	
	public abstract void resonateWhenPlaying();
	
	public StringInstrument(int heightCm, int productionYear) {
		this.heightCm = heightCm;
		this.productionYear = productionYear;
	}
	
	public abstract int getStringsNumber();
	
	public abstract int getHeight();
	
	public abstract int getProductionYear();
}
