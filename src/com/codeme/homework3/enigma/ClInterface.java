package com.codeme.homework3.enigma;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ClInterface {
	private BufferedWriter writer;
	// odczytywanie z konsoli:
	private BufferedReader reader;

	public ClInterface() {
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
		return reader.readLine();
	}

	private Integer readInt() throws IOException {
		return Integer.valueOf(reader.readLine());
	}

	private void displayMenu() throws IOException {
		println("\n--- File EN/DE-cryptor ---");
		println("Choose option, 1 OR 2:");
		println("(1) ENcrypt given txt file and protect the content.");
		println("(2) DEcrypt given scr file and read the hidden content.");
		println("");
		println("//For exit: \"exit\"");
	}

	public void start() {
		try {
			do {
				displayMenu();
				String option = read();
				if (option.toLowerCase().trim().equals("1")) {
					while (true) {
						println("Please provide an absolute path to the *.txt file & press Enter:");
						String userPath = read().trim();
						if (userPath.endsWith(".txt")) {
							try {
								Enigma.encryptFileBasedOnSourceAndSave(userPath);
								println(">>File encrypted and saved under the very same name & location with *.scr extention.");
								break;
							} catch (FileNotFoundException fnf) {
								println("!Sorry, there's no such file.");
							}
						} else if (userPath.toLowerCase().equals("exit")) {
							break;
						} else {
							println("!Not a proper path to the file or invalid file.");
						}
					}
				} else if (option.toLowerCase().trim().equals("2")) {
					while (true) {
						println("Please provide an absolute path to the *.scr file & press Enter:");
						String userPath = read().trim();
						if (userPath.endsWith(".scr")) {
							try {
								Enigma.decryptFileBasedOnSourceAndSave(userPath);
								println(">>File decrypted and saved under the very same name & location with *.txt extention.");
								break;
							} catch (FileNotFoundException fnf) {
								println("!Sorry, there's no such file.");
							}
						} else if (userPath.toLowerCase().equals("exit")) {
							break;
						} else {
							println("!Not a proper path to the file or invalid file.");
						}
					}
				} else if (option.toLowerCase().trim().equals("exit")) {
					break;
				} else {
					println("Please choose option 1, 2 OR exit.");
				}
			} while (true);
			println("Thanks for choosing.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
