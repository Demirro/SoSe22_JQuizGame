package de.uk.java;

public class Question {
	// Basic variables for any question
	private String prompt;
	private boolean answer;
	private String category;
	
	/**
	 * Constructor for a new Question
	 * @param prompt - String - The simple question text
	 * @param answer - boolean - the value of the answer
	 * @param category - String - category the question should be in
	 */
	public Question(String prompt, boolean answer, String category) {
		this.prompt = prompt;
		this.answer = answer;
		this.category = category;
	}

	/* -- Getter and Setter -- */
	
	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public boolean isAnswer() {
		return answer;
	}

	public void setAnswer(boolean answer) {
		this.answer = answer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	/**
	 * Overide the toString method to get a logical output
	 * In this case the output is the category and prompt of the question
	 */
	@Override
	public String toString() {
		return "Category: " + getCategory() + "\nPrompt: " + getPrompt();
	}
}
