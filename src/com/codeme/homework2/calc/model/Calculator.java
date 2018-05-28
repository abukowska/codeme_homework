package com.codeme.homework2.calc.model;

public class Calculator {
	
	public Double add(Double a, Double b) {
		return a+b;
	}
	
	public Double subtract(Double a, Double b) {
		return a-b;
	}
	
	public Double multiple(Double a, Double b) {
		return a*b;
	}
	
	public Double divide(Double a, Double b) {
		if (b == 0) {
			throw new IllegalArgumentException("Can't divide by zero.");
		}
		return a/b;
	}
}
