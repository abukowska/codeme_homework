package com.codeme.homework2.calc.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
	
	public void calculate(String usersEquation) {
		String pattern = "^((\\-)?(\\d+)(\\.\\d++)?)(\\+|\\-|\\/|\\*)((\\-)?(\\d+)(\\.\\d++)?)$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(usersEquation);

		if (m.find()) {
			switch (m.group(5)) {
			case "+":
				System.out.println(add(Double.valueOf(m.group(1)), Double.valueOf(m.group(6))));
				break;
			case "-":
				System.out.println(subtract(Double.valueOf(m.group(1)), Double.valueOf(m.group(6))));
				break;
			case "*":
				System.out.println(multiple(Double.valueOf(m.group(1)), Double.valueOf(m.group(6))));
				break;
			case "/":
				//try {
					System.out.println(divide(Double.valueOf(m.group(1)), Double.valueOf(m.group(6))));
/*				} catch (ArithmeticException ae) {
					System.out.println("Can't divide by zero.");
				}*/
				break;
			default:
				System.out.println("");
			}
		} else {
			throw new IllegalArgumentException();
		}
	}
	
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
			throw new ArithmeticException("Can't divide by zero.");
		}
		return a/b;
	}
}
