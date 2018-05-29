package com.codeme.homework2.calc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.codeme.homework2.calc.model.Calculator;

public class Cli {
	private BufferedWriter writer;
	// odczytywanie z konsoli:
	private BufferedReader reader;

	public Cli() {
		writer = new BufferedWriter(new OutputStreamWriter(System.out)); // stworzenie obiektu do wypisywania,
																			// złączonego z konsolą
		reader = new BufferedReader(new InputStreamReader(System.in)); // stworzenie obiektu do odczytywania, złączonego
																		// z konsolą
	}

	private void print(String text) throws IOException {
		writer.write(text); // wrzucenie tekstu do bufora
		writer.flush(); // wysłanie tekstu z bufora na konsolę
	}

	private void println(String text) throws IOException {
		print(text + "\r\n");
	}

	private String read() throws IOException {
		return reader.readLine().trim();
	}

	private void displayMenu() throws IOException {
		println("\n--- Calculator ---");
		println("Write an equation, e.g. 2+4 OR 11+-1");
		println("//For exit: \"exit\"");
		println(">> ");
	}

	public void start() {
		try {
			Calculator calc = new Calculator();
			do {
				displayMenu();
				String usersEquation = read();
				if (usersEquation.toLowerCase().equals("exit")) {
					break;
				} else {
					try {
						calc.calculate(usersEquation);
					} catch (IllegalArgumentException iae) {
						System.out.println("Invalid input. Please try again.");
					} catch (ArithmeticException ae) {
						System.out.println("Can't divide by zero.");
					}
				}
			} while (true);
			println("Thanks for choosing our calculator! ;).");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
