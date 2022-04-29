/**
 * 
 */
package de.uk.java.questions;

/**
 * @author Théo Bouveyron
 *
 */
public class InvalidInputException extends Exception {

	private static final long serialVersionUID = 1L;
	private String correctInput;
	
	/**
	 * Constructor - when the Excpetion is thrown, the valid input choices have to be given according to the question type
	 * @param validInput String - valid input choices so the user knows which input to type in 
	 */
	public InvalidInputException(String validInput) {
		this.correctInput = validInput;
	}
	
	/**
	 * construct a message to display to inform the user of the valid input
	 */
	@Override
	public String getMessage() {
		return "Ungültige Eingabe\nGültige Eingabemöglichkeiten: " + correctInput;
	}
}
