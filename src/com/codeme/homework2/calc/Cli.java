package com.codeme.homework2.calc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.codeme.homework2.calc.model.Calculator;
import com.codeme.homework3.enigma.Enigma;

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

	private Integer readInt() throws IOException {
		return Integer.valueOf(reader.readLine());
	}

	private void displayMenu() throws IOException {
		println("\n--- Calculator ---");
		println("Write an equation, e.g. 2+4 OR 11-10");
		println("");
		println("//For exit: \"exit\"");
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
					String pattern = "^((\\d+)(\\.\\d++)?)(\\+|\\-)((\\d+)(\\.\\d++)?)$";
					Pattern r = Pattern.compile(pattern);
			        Matcher m = r.matcher(usersEquation);

			        if (m.find()) {
			            System.out.println("Found value: " + m.group(1));
			            System.out.println("Found value: " + m.group(4));
			            System.out.println("Found value: " + m.group(5));
			        } else {
			            System.out.println("NO MATCH");
			            continue;
			        }
			        System.out.println(calc.add(Double.valueOf(m.group(1)), Double.valueOf(m.group(5))));
					
				}
			} while (true);
			println("Thanks for choosing our calculator! ;).");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
