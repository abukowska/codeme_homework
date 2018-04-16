package com.codeme.homework1;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Przegladak {
		
	public static int countWords(String searchedWord, String content) {
		String[] splitted_text = splitTextIntoWords(content);
		
		Pattern p = Pattern.compile("\\w*" + searchedWord + "\\w*");
				
		int counter = 0;
		searchedWord = searchedWord.toLowerCase();
		for (String word : splitted_text) {
			Matcher m = p.matcher(word);
			if (m.matches()) {
				counter += 1;
			}
		}
		return counter;
	}
	
	public static int countAllWords(String content) {
		String[] splitted_text = splitTextIntoWords(content);
		return splitted_text.length;
	}
	
	public static int countWordsNoConjunction(String content) {
		String[] splitted_text = splitTextIntoWords(content);
		String[] conjunction = {"a", "i", "oraz", "tudzież", "albo", "lub", "czy", "ani", "ni", "aczkolwiek",
								"ale", "jednak", "lecz", "natomiast", "zaś", "czyli", "mianowicie", "to jest",
								"dlatego", "przeto", "tedy", "więc", "zatem", "toteż", "aby", "bo", "choć", 
								"czy", "jeżeli", "ponieważ", "że"};
		List<String> conjunctionList = Arrays.asList(conjunction);
		
		int counter = 0;
		for (String word : splitted_text) {
			if (conjunctionList.contains(word)) {
				continue;
			}
			counter += 1;
		}
		return counter;
	}
	
	public static int countWordsWithSpecificEnding(String ending, String content) {
		String[] splitted_text = splitTextIntoWords(content);
		
		int counter = 0;
		for (String word : splitted_text) {
			if (word.endsWith(ending.toLowerCase())) {
				counter += 1;
			}
		}
		return counter;
		
	}

	public static String[] splitTextIntoWords(String text) {
		return text.toLowerCase().split("[\\s\\.\\,\\-\"]+");
	}
	
	public static void main(String[] args) {
		String text = "ERNEST HEMINGWAY STARY CZŁOWIEK I MORZE Był starym człowiekiem " +
                "który łowił ryby w Golfstromie pływając samotnie łodzią i oto już od osiemdziesięciu " +
                "czterech dni nie schwytał ani jednej. Przez pierwsze czterdzieści dni pływał " +
                "z nim pewien chłopiec. Ale po czterdziestu jałowych dniach rodzice oświadczyli mu, " +
                "że stary jest teraz bezwzględnie i ostatecznie salao, co jest najgorszą formą określenia " +
                "\"pechowy\" i chłopiec na ich rozkaz popłynął inną łodzią, która w pierwszym tygodniu złowiła " +
                "trzy dobre ryby. Smuciło go to, że stary co dzień wraca z pustą łodzią, więc zawsze przychodził " +
                "i pomagał mu odnosić zwoje linek albo osęk i harpun i żagiel owinięty dokoła masztu. " +
                "Żagiel był wylatany workami od mąki, a zwinięty wyglądał jak sztandar nieodmiennej klęski. " +
                "Stary był suchy i chudy, na karku miał głębokie bruzdy. Brunatne plamy po niezłośliwym raku skóry, " +
                "występującym wskutek odblasku słońca na morzach tropikalnych, widniały na jego policzkach. " +
                "Plamy te biegły po obu stronach twarzy, a ręce miał poorane głębokimi szramami od wyciągania " +
                "linką ciężkich ryb. Ale żadna z tych szram nie była świeża. Były one tak stare jak erozje " +
                "na bezrybnej pustyni. Wszystko w nim było stare prócz oczu, które miały tę samą barwę co morze " +
                "i były wesołe i niezłomne. - Santiago - powiedział do niego chłopiec, kiedy wspinali się na stromy " +
                "brzeg od miejsca, gdzie stała łódź wciągnięta na piasek. - Mógłbym znów z tobą popłynąć ";

		String morze = "morze";
		String stary = "stary";

		int countMorze = countWords(morze, text);
		System.out.printf("Occurences of word 'morze': %d%n", countMorze);
		
		int countStary = countWords(stary, text);
		System.out.printf("Occurences of word 'stary': %d%n", countStary);
		
		int allWordsInText = countAllWords(text);
		System.out.printf("All words in above text: %d%n", allWordsInText);
		
		int wordsWithNoConj = countWordsNoConjunction(text);
		System.out.printf("Words in text excluding conj: %d%n", wordsWithNoConj);

		int wordsWithECAtTheEnd = countWordsWithSpecificEnding("ec", text);
		System.out.printf("Words in text 'EC': %d%n", wordsWithECAtTheEnd);
		
	}
}