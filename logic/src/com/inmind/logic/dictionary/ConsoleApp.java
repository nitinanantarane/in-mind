package com.inmind.logic.dictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

/**
 * Console client of dictionary.
 * 
 * @author Nitin
 *
 * Oct 29, 2016 4:43:35 PM
 */
public class ConsoleApp {

	private final static String TERMINATION_WORD = "exit-app";
	private static DictionaryHolder dicHolder = new DictionaryHolder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word = null;
		while ((word = br.readLine()) != null && !word.equalsIgnoreCase(TERMINATION_WORD)) {
			InputEnum inputEnum = InputEnum.fromInput(word);
			
			if (inputEnum != null) {
				queryFor(inputEnum);
			} else {
				dicHolder.add(word);
			}
			
		}
		
	}

	private static void queryFor(InputEnum inputEnum) {
		switch (inputEnum) {
			case WORDS: log(dicHolder.words()); break;
			case LETTER: log(dicHolder.words(inputEnum.getLetter())); break;
			case WORDS_SIZE: log(dicHolder.size()); break;
			case LETTER_SIZE: log(dicHolder.size(inputEnum.getLetter())); break;
			case SORTED_WORDS: log(dicHolder.sorted()); break;
			case SORTED_LETTER: log(dicHolder.sorted(inputEnum.getLetter())); break;
			default: log(dicHolder.getWordMap()); break;
		}
	}

	private static void log(Map<Character, List<String>> wordMap) {
		System.out.println(wordMap);
	}

	private static void log(long size) {
		System.out.println(size);
	}

	private static void log(List<String> list) {
		System.out.println(list);
	}

}

enum InputEnum {
	WORDS("W-"),
	LETTER("L-"),
	WORDS_SIZE("W-S"),
	LETTER_SIZE("L-S"),
	SORTED_WORDS("S-W"),
	SORTED_LETTER("S-L"),
	KEY_VALUE("K-V");
	
	private String code;
	private char letter;
	
	
	private InputEnum(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public static InputEnum fromCode(String code) {
		InputEnum inputEnum = null;
		
		for(InputEnum ie : InputEnum.values()) {
			if (ie.getCode().equalsIgnoreCase(code)) {
				inputEnum = ie;
				break;
			}
		}
		
		return inputEnum;
	}
	
	public static InputEnum fromInput(String input) {
		String[] split = input.split(" ");
		String localCode = split[0];
		
		InputEnum inputEnum = fromCode(localCode);
		
		if (split.length > 1) {
			inputEnum.setLetter(split[1].charAt(0));
		}
		
		return inputEnum;
	}
}
