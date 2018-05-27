package com.codeme.homework2.warehouse.model;

public abstract class Product {

	protected String name;
	protected double price;
	protected String measure; //kg OR l OR piece
	
	public Product(String name, double price, String measure) {
		this.name = name;
		this.price = price;
		this.measure = measure;
	}

	public abstract String getName();

	public abstract void setName(String name);
	
	public abstract double getPrice();
	
	public abstract void setPrice(double price);

	public abstract String getMeasure();

	public abstract void setMeasure(String measure);
	
	public abstract String toString();
	
}
