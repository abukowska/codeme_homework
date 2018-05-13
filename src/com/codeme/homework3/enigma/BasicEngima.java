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

	public void copyExistingFileAndEncrypt(String absolutePath) {
		file = new File("/home/jzawadzka/text_file/textfile");
		while (true) {
			if (file.exists()) {
				copyFile = new File(absolutePath + "_copy");
				try {
					Files.copy(file.toPath(), copyFile.toPath());
					codeCopiedFile();
					break;
				} catch (FileAlreadyExistsException foe) {
					copyFile.delete();
				} catch (IOException ioe) {
					System.out.println("Problem with the souce file.");
					ioe.printStackTrace();
				}
			}
		}
		// codeCopiedFile();
	}

	private void codeCopiedFile() throws IOException {
		StringBuilder sb = new StringBuilder();
		while (true) {
			try (BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(copyFile)))) {
				String line;

				while ((line = bReader.readLine()) != null) {
					for (char oneCharacterInLine : line.toCharArray()) {
						sb.append(oneCharacterInLine += 2);
					}
					sb.append("\n");
				}
				break;

			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

		try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(copyFile)))) {
			writer.write("");
			writer.write(sb.toString());
			writer.flush();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath = "/home/jzawadzka/text_file/textfile";
		BasicEngima enigma = new BasicEngima();
		enigma.copyExistingFileAndEncrypt(filePath);

	}

}
