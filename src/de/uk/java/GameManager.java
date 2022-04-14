package de.uk.java;

public class GameManager {
	// Variables needed in a game to keep track of progress, lives, lost or won state and so on
	private int lives;
	private int score;
	private int wrongAnswers;
	private int questionNumber;
	
	private boolean won;
	private boolean lost;
	
	Question[] questions;
	
	/**
	 * Basic empty constructor to initialize the game
	 * Set all the basic game variables to 0 (lives to 3)
	 * 
	 * Temporary: also creates the first two questions and populates the question array with them
	 */
	public GameManager() {
		lives = 3;
		this.score = 0;
		this.wrongAnswers = 0;
		this.questionNumber = 0;
		
		questions = new Question[2];
		Question question1 = new Question("Ist Java toll?", true, "Computer Science");
		Question question2 = new Question("Ist die Stunde fast um?", true, "Lehre");

		System.out.println(question1);
	}
}
