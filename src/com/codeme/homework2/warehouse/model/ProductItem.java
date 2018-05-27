package com.codeme.homework2.warehouse.model;

public class ProductItem extends Product {
	
	public ProductItem(String name, Double price, String measure) {
		super(name, price, measure);
	}

	@Override
	public String toString() {
		return String.format("%s -- %.2f per 1 %s", super.name, super.price, super.measure);
	}

	@Override
	public String getName() {
		return super.name;
	}

	@Override
	public void setName(String name) {
		super.name = name;
	}

	@Override
	public double getPrice() {
		return super.price;
	}

	@Override
	public void setPrice(double price) {
		super.price = price;		
	}

	@Override
	public String getMeasure() {
		return super.measure;
	}

	@Override
	public void setMeasure(String measure) {
		super.measure = measure;
	}

}
