package com.inmind.logic.dictionary;

/**
 * A word model.
 * 
 * @author Nitin
 *
 * Nov 5, 2016 12:42:01 AM
 */
public class Word {

	private static int count = 0;
	private final int id = count++;
	private char letter;
	private String name;
	private String description;
	
	public Word(char letter, String name) {
		super();
		this.letter = letter;
		this.name = name;
	}

	public Word(char letter, String name, String description) {
		super();
		this.letter = letter;
		this.name = name;
		this.description = description;
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Word [id=" + id + ", letter=" + letter + ", name=" + name + ", description=" + description + "]";
	}
	
}
