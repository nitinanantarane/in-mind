package com.inmind.logic.dictionary;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hold letter map with word list.
 * 
 * @author Nitin
 *
 * Oct 29, 2016 3:17:08 PM
 */
public class DictionaryHolder {

	private Map<Character, List<String>> wordMap = new HashMap<>();
	private static final char A = 65;
	private static final char Z = 90;
	
	public DictionaryHolder() {
		setUp();
	}

	private void setUp() {
		for (char c = A; c <= Z; c++) {
			wordMap.put(new Character(c), new ArrayList<>());
		}
	}
	
	public void add(String word) {
		char key = firstLetter(word.toUpperCase());
		add(key, word);
	}

	public void add(char key, String word) {
		List<String> wordList = words(key);
		wordList.add(word);	
	}
	
	public void add(Character c, String word) {
		char key = firstLetter(word);
		
		if (c != key) {
			throw new RuntimeException("Word does not match with letter" + c + " " + word);
		}

		add(key, word);
	}
	
	public long size() {
		long wordCount = 0;
		
		for (List<String> wordList : get()) {
			wordCount += wordList.size();
		}
		
		return wordCount;
	}

	public long size(char c) {
		return words(c).size();
	}

	public List<String> words() {
		List<String> allWordList = new ArrayList<>();
		
		for (List<String> wordList : get()) {
			allWordList.addAll(wordList);
		}
		
		return allWordList;
	}
	
	public List<String> words(char c) {
		return get(c);
	}
	
	public  List<String> sorted() {
		List<String> list = words();
		Collections.sort(list);
		
		return list;
	}
	
	public  List<String> sorted(char c) {
		List<String> list = get(c);
		Collections.sort(list);
		
		return list;
	}
	
	public Map<Character, List<String>> getWordMap() {
		return wordMap;
	}

	private char firstLetter(String word) {
		return word.charAt(0);
	}
	
	private Collection<List<String>> get() {
		return wordMap.values();
	}
	
	private List<String> get(char c) {
		return wordMap.get(c);
	}

}
