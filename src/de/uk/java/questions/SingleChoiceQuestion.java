package de.uk.java.questions;

/**
 * Child of Question
 * Question type that handles question with 4 choices. Only one is valid
 * @author Théo Bouveyron
 *
 */
public class SingleChoiceQuestion extends Question {
	
	private String[] answers;
	private char correctAnswer;
	
	/**
	 * Constructor for a new SingleChoiceQuestion
	 * Calls super constructor
	 * @param prompt - String - The simple question text
	 * @param category - String - category the question should be in
	 * @param answers - String array - array containing the 4 different answer possibilities
	 * @param correctAnswer - char - Either A,B,C or D. Simple way to store the correct Answer
	 */
	public SingleChoiceQuestion(String prompt, String category, String[] answers, char correctAnswer) {
		super(prompt, category);
		this.answers = answers;
		this.correctAnswer = correctAnswer;
		
	}

	/**
	 * Converts String to a char to check for correct input and compare to the stored correctAnswer
	 * Exception if the the input is not valid
	 */
	@Override
	public boolean getCorrectAnswer(String userInput) throws InvalidInputException {
		userInput = userInput.toUpperCase();
		if (userInput.charAt(0) >= 65 && userInput.charAt(0) <= 68) {
			return userInput.charAt(0) == correctAnswer;
		} else {
			throw new InvalidInputException("A, B, C, D");
		}
	}

	/**
	 * Method to build a correct String representation of the answer array
	 * @return String representation of the answer array
	 */
	private String displayAnswers() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		for (int i = 0; i < answers.length; i++) {
			sb.append((char)(i+65));
			sb.append(": ");
			sb.append(answers[i]);
			sb.append("; ");
		}
		return sb.toString();
	}
	@Override
	public String toString() {
		return super.toString() + displayAnswers();
	}
}
