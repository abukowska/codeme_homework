package com.codeme.homework3.enigma;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Enigma {

	public static void encryptFileBasedOnSourceAndSave(String filePath) throws FileNotFoundException {
		checkIfFileExists(filePath);

		// make another file for encryption
		String copyFilePath = filePath.replace(".txt", "") + ".scr";
		File copyFile = new File(copyFilePath);
		try {
			copyFile.createNewFile();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		String encryptedContent = encryptContent(openFileAndGetContent(filePath));
		saveContentToFile(encryptedContent, copyFile);
	}

	public static void decryptFileBasedOnSourceAndSave(String filePath) throws FileNotFoundException {
		checkIfFileExists(filePath);

		// make another file for decryption
		String copyFilePath = filePath.replace(".scr", "") + ".txt";
		File copyFile = new File(copyFilePath);
		try {
			copyFile.createNewFile();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		String decryptedContent = decryptContent(openFileAndGetContent(filePath));
		saveContentToFile(decryptedContent, copyFile);
	}

	private static String openFileAndGetContent(String path) {
		StringBuilder sourceContent = new StringBuilder();
		while (true) {
			try (BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
				String line;
				while ((line = bReader.readLine()) != null) {
					sourceContent.append(line + "\n");
				}
				break;
			} catch (IOException ioe) {
				ioe.printStackTrace();
				break;
			}
		}
		return sourceContent.toString();
	}

	private static String encryptContent(String content) {
		StringBuilder sBuilder = new StringBuilder();
		String[] contentSplittedIntoLines = content.toString().split("\n");
		for (String oneLine : contentSplittedIntoLines) {
			for (char oneChar : oneLine.toCharArray()) {
				sBuilder.append(oneChar += 2);
			}
			sBuilder.append("\n");
		}
		return sBuilder.toString();
	}

	private static String decryptContent(String content) {
		StringBuilder sBuilder = new StringBuilder();
		String[] contentSplittedIntoLines = content.toString().split("\n");
		for (String oneLine : contentSplittedIntoLines) {
			for (char oneChar : oneLine.toCharArray()) {
				sBuilder.append(oneChar -= 2);
			}
			sBuilder.append("\n");
		}
		return sBuilder.toString();
	}

	private static void saveContentToFile(String content, File destinationFile) {
		try (BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(destinationFile)))) {
			writer.write(content);
			writer.flush();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	private static void checkIfFileExists(String filePath) throws FileNotFoundException {
		if (new File(filePath).exists() == false) {
			throw new FileNotFoundException(filePath);
		}
	}
	
}
