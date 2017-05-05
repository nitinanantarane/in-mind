package com.inmind.logic.dictionary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDictionary extends DictionaryHolder {

	private Map<Character, List<Word>> wordMap = new HashMap<>();
	
	public WordDictionary() {
		super();
	}

}
