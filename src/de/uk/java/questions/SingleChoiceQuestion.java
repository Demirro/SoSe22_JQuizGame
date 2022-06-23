package de.uk.java.questions;

import java.util.List;

/**
 * Child of Question
 * Question type that handles question with 4 choices. Only one is valid
 * @author Théo Bouveyron
 *
 */
public class SingleChoiceQuestion extends Question {
	
	private List<String> answers;
	
	/**
	 * Constructor for a new SingleChoiceQuestion
	 * Calls super constructor
	 * @param prompt - String - The simple question text
	 * @param category - String - category the question should be in
	 * @param answers - String array - array containing the 4 different answer possibilities
	 * @param correctAnswer - char - Either A,B,C or D. Simple way to store the correct Answer
	 */
	public SingleChoiceQuestion(String prompt, String category, List<String> answers, String correctAnswer) {
		super(prompt, category, correctAnswer);
		this.answers = answers;
	}


	/**
	 * Method to build a correct String representation of the answer array
	 * @return String representation of the answer array
	 */
	/*public String displayAnswers() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		for (int i = 0; i < answers.si; i++) {
			sb.append((char)(i+65));
			sb.append(": ");
			sb.append(answers[i]);
			sb.append("; ");
		}
		return sb.toString();
	}
	*/
	@Override
	public String toString() {
		return super.toString();
	}
}
