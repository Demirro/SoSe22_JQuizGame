package de.uk.java.questions;

import javax.swing.JButton;
import javax.swing.JPanel;

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
	
	@Override
	public void definePane() {
		JPanel buttonPanel = new JPanel();
		JButton trueButton = new JButton("True");
		
		buttonPanel.add(trueButton);
		JButton falseButton = new JButton("False");
		
		buttonPanel.add(falseButton);
		
		super.definePane();
		add(buttonPanel);
		
		validate();
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

	/**
	 * Converts String to a boolean to check for correct input and compare to the stored correctAnswer
	 * Exception if the the input is not valid
	 */
	@Override
	public boolean getCorrectAnswer(String userInput) throws InvalidInputException {
		if (userInput.equalsIgnoreCase("true") || userInput.equalsIgnoreCase("false")) {
			return userInput.equalsIgnoreCase(Boolean.toString(answer));
		}
		throw new InvalidInputException("True, False");
		
	}
}
