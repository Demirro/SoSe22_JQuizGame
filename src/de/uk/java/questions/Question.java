package de.uk.java.questions;

import java.util.Iterator;

/**
 * Abstract class for questions. All Question types inherit from this abstract class
 * Handles the prompts, the category and common methods like toString or more to come
 * @author Théo Bouveyron
 *
 */
public abstract class Question {
	// Basic variables for any question
	private String prompt;
	private String category;
	
	/**
	 * Constructor for a new Question
	 * @param prompt - String - The simple question text
	 * @param answer - boolean - the value of the answer
	 * @param category - String - category the question should be in
	 */
	public Question(String prompt, String category) {
		this.prompt = prompt;
		this.category = category;
	}

	/* -- Getter and Setter -- */
	
	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	/**
	 * Abstract method to check userInput for valid inputs and correct answer.
	 * @param userInput - String from the command-line given by the user. This is the answer to be checked
	 * @returns boolean - true if the user answer was correct; false if the answer is wrong
	 * @throws InvalidInputException - custom Exception which handles invalid inputs by the user. Message contains valid input choices
	 */
	public abstract boolean getCorrectAnswer(String userInput) throws InvalidInputException;
	
	/**
	 * Overide the toString method to get a logical output
	 * In this case the output is the category and prompt of the question
	 */
	@Override
	public String toString() {
		return "Category: " + getCategory() + "\nPrompt: " + getPrompt();
	}
}
