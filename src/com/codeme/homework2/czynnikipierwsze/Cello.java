package com.codeme.homework2.czynnikipierwsze;

public class Cello extends StringInstrument implements CelloBow {
	private boolean isNew;

	public Cello(int heightCello, int productionYearCello, boolean isNew) {
		super(heightCello, productionYearCello);
		this.isNew = isNew;
	}	
	
	@Override
	public void resonateWhenPlaying() {
		System.out.println("Cello resonates");		
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

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	@Override
	public void playOnStringsUsingBow() {
		System.out.println("Playing on cello's strings with a bow");		
	}
	
}
