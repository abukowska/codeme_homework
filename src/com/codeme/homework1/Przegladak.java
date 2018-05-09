package com.codeme.homework1;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Przegladak {
	
	/**
	 * Counts all occurrences of a word in the given text.
	 * Finds specific words in a longer phrase (e.g. counts occurrence for 'win' in a word 'window').
	 * @param searchedWord A word searched
	 * @param content Provided text to be searched through
	 * @return a number of word occurrences
	 * @see splitTextIntoWords method from below
	 */
	public static int countSpecificWords(String searchedWord, String content) {
		String[] splittedText = splitTextIntoWords(content);
		
		Pattern pattern = Pattern.compile("\\w*" + searchedWord + "\\w*");
				
		int counter = 0;
		searchedWord = searchedWord.toLowerCase();
		for (String word : splittedText) {
			Matcher m = pattern.matcher(word);
			if (m.matches()) {
				counter += 1;
			}
		}
		return counter;
	}
	
	/**
	 * Counts all words that appear in a provided text. Does not include signs, commas.
	 * @param content
	 * @return Number of counted words
	 */
	public static int countAllWords(String content) {
		String[] splittedText = splitTextIntoWords(content);
		return splittedText.length;
	}
	
	/**
	 * Counts all words that appear in a provided text. It excludes conjunctions.
	 * Additionally, it does not include signs, commas.
	 * @param content
	 * @return Number of counted words
	 */
	public static int countWordsNoConjunction(String content) {
		String[] splittedText = splitTextIntoWords(content);
		String[] conjunction = {"a", "i", "oraz", "tudzież", "albo", "lub", "czy", "ani", "ni", "aczkolwiek",
								"ale", "jednak", "lecz", "natomiast", "zaś", "czyli", "mianowicie", "to jest",
								"dlatego", "przeto", "tedy", "więc", "zatem", "toteż", "aby", "bo", "choć", 
								"czy", "jeżeli", "ponieważ", "że"};
		List<String> conjunctionList = Arrays.asList(conjunction);
		
		int counter = 0;
		for (String word : splittedText) {
			if (conjunctionList.contains(word)) {
				continue;
			}
			counter += 1;
		}
		return counter;
	}
	
	/**
	 * It counts words that contain a specific ending.
	 * @param ending
	 * @param content
	 * @return Number of counted words
	 */
	public static int countWordsWithSpecificEnding(String ending, String content) {
		String[] splittedText = splitTextIntoWords(content);
		
		int counter = 0;
		for (String word : splittedText) {
			if (word.endsWith(ending.toLowerCase())) {
				counter += 1;
			}
		}
		return counter;
		
	}

	/**
	 * It splits, trims, and distinguishes words from a whole text.
	 * @param text The source that needs to be split
	 * @return An array of words taken from text
	 */
	public static String[] splitTextIntoWords(String text) {
		return text.toLowerCase().split("[\\s\\.\\,\\-\"]+");
	}
	
	public static String openFileAndGetText(String filePath) throws FileNotFoundException, IOException {
		StringBuffer bufferedText = new StringBuffer();
		String textFromFile;
		
		FileInputStream fis = new FileInputStream(filePath);
		BufferedReader bReader = new BufferedReader(new InputStreamReader(fis));
		
		String lineOfFile;
		while((lineOfFile = bReader.readLine()) != null) {
			bufferedText.append(lineOfFile);
		}
		
		textFromFile = bufferedText.toString();
		return textFromFile;
	}
	
	
	public static void main(String[] args) {
		
		String morze = "morze";
		String stary = "stary";
		Path filePath = Paths.get(".//src//resources//text.txt");		
		String text = "";
		
		try {
			text = openFileAndGetText(filePath.toString());
		}
		catch (FileNotFoundException fnf) {
			System.out.println("File not found.");
			fnf.printStackTrace();
		} 
		catch (IOException ioe) {
			System.out.println("Couldn't write data.");
			ioe.printStackTrace();
		}
		
		System.out.println(text);
		
		int countMorze = countSpecificWords(morze, text);
		System.out.printf("Occurences of word 'morze': %d%n", countMorze);
		
		int countStary = countSpecificWords(stary, text);
		System.out.printf("Occurences of word 'stary': %d%n", countStary);
		
		int allWordsInText = countAllWords(text);
		System.out.printf("All words in above text: %d%n", allWordsInText);
		
		int wordsWithNoConj = countWordsNoConjunction(text);
		System.out.printf("Words in text excluding any conjunction: %d%n", wordsWithNoConj);

		int wordsWithECAtTheEnd = countWordsWithSpecificEnding("ec", text);
		System.out.printf("Words in text with 'EC' ending: %d%n", wordsWithECAtTheEnd);
		
	}
	
}