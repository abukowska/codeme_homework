package com.codeme.homework3.enigma;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;

public class BasicEngima {
	
	private File file;
	private File copyFile;
	StringBuilder encodedContent;

	public void copyExistingFileAndEncrypt(String absolutePath) {
		file = new File("/home/jzawadzka/text_file/textfile");
		while (true) {
			if (file.exists()) {
				copyFile = new File(absolutePath + "_copy");
				try {
					Files.copy(file.toPath(), copyFile.toPath());
					encryptCopiedFile();
					System.out.println("File safely encrypted and stored under location: " + copyFile.getAbsolutePath() + ":\n");
					break;
				} catch (FileAlreadyExistsException foe) {
					copyFile.delete();
				} catch (IOException ioe) {
					System.out.println("Problem with the souce file.");
					ioe.printStackTrace();
				}
			}
		}
	}

	private void encryptCopiedFile() throws IOException {
		encodedContent = new StringBuilder();
		while (true) {
			try (BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(copyFile)))) {
				String line;
				while ((line = bReader.readLine()) != null) {
					for (char oneCharacterInLine : line.toCharArray()) {
						encodedContent.append(oneCharacterInLine += 2);
					}
					encodedContent.append("\n");
				}
				break;
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(copyFile)))) {
			writer.write("");
			writer.write(encodedContent.toString());
			writer.flush();
		}
	}

	public void decryptPreviouslyEncryptedCopyOfFileAndOverwrite() {
		if (copyFile.exists()) {
			while (true) {
				try (BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(copyFile))); 
						BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(copyFile)))) {
					StringBuilder decodedContent = new StringBuilder();
					String[] splittedEncContentLines = encodedContent.toString().split("\n");		
					for(String oneLine : splittedEncContentLines) {
						for(char oneChar : oneLine.toCharArray()) {
							decodedContent.append(oneChar -= 2);
						}
						decodedContent.append("\n");
					}
					writer.write(decodedContent.toString());
					writer.flush();
					break;
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}		
			System.out.println("File " + copyFile.getName() + "  safely decrypted and overwritten.\n");
		}
	}
	
	
	
	public static void main(String[] args) {

		String filePath = "/home/jzawadzka/text_file/textfile";
		BasicEngima enigma = new BasicEngima();
		enigma.copyExistingFileAndEncrypt(filePath);
		enigma.decryptPreviouslyEncryptedCopyOfFileAndOverwrite();
	}

}
