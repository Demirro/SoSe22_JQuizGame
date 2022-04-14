package de.uk.java;

public class GameManager {
	private int lives;
	private int score;
	private int wrongAnswers;
	private int questionNumber;
	
	private boolean won;
	private boolean lost;
	
	Question[] questions;
	
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
