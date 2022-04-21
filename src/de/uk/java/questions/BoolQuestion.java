package de.uk.java.questions;

/**
 * Child of Question
 * Question type that handles boolean question/answers
 * @author Théo Bouveyron
 *
 */
public class BoolQuestion extends Question {
	// correct answer for the question
	private boolean answer;

	/**
	 * Constructor for a new BoolQuestion
	 * Calls super constructor
	 * @param prompt - String - The simple question text
	 * @param answer - boolean - the value of the answer
	 * @param category - String - category the question should be in
	 */
	public BoolQuestion(String prompt, boolean answer, String category) {
		super(prompt, category);
		this.answer = answer;
	}

	public boolean isAnswer() {
		return answer;
	}

	public void setAnswer(boolean answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
