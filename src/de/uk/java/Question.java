package de.uk.java;

public class Question {
	private String prompt;
	private boolean answer;
	private String category;
	
	public Question(String prompt, boolean answer, String category) {
		this.prompt = prompt;
		this.answer = answer;
		this.category = category;
	}

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
	
	@Override
	public String toString() {
		return "Category: " + getCategory() + "\nPrompt: " + getPrompt();
	}
}
