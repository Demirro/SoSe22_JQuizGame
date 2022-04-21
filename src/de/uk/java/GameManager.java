package de.uk.java;

import java.util.Scanner;

import de.uk.java.questions.BoolQuestion;
import de.uk.java.questions.Question;

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
	 * Start the game loop via nextQuestion
	 * 
	 * Temporary: also creates the first two questions and populates the question array with them
	 */
	public GameManager() {
		lives = 1;
		this.score = 0;
		this.wrongAnswers = 0;
		this.questionNumber = 0;
		
		questions = new Question[2];
		BoolQuestion question1 = new BoolQuestion("Ist Java toll?", true, "Computer Science");
		BoolQuestion question2 = new BoolQuestion("Ist die Stunde fast um?", true, "Lehre");
		
		questions[0] = question1;
		questions[1] = question2;
		
		nextQuestion();
		
	}
	
	/**
	 * nextQuestion handles the progress in the game loop
	 * Checks if there are questions left --> win if not (game loop stops)
	 * Checks for lives left --> none left = lost and game loop stops
	 * 
	 * Uses questionNumber as counter for progress
	 * 
	 * else show the prompt and call for the user answer before progressing to the next question
	 */
	private void nextQuestion() {
		// Check if we are at the end of the array
		if (questionNumber > questions.length-1) {
			win();
			return;
		}
		System.out.println(questions[questionNumber]);
		
		// Call for user input
		userAnswer();
		
		// Count up for the next iteration of the game loop
		questionNumber++;
		
		// Before calling the next Question we should check the if the user still have lives
		if (lives != 0) {
			nextQuestion();
		} else {
			gameOver();
		}
		
	}
	
	/**
	 * Handles the win state
	 * 
	 * Temporary: simply output that the user has won and shows the achieved score
	 */
	private void win() {
		System.out.println("Du hast alle Fragen beantwortet und somit gewonnen."
				+ "\nDein Punktestand ist: " + score);
		
	}

	/**
	 * Handles the game over state
	 * 
	 * Temporary: simply output that the user has lost and shows the achieved score
	 */
	private void gameOver() {
		System.out.println("Du hast keine Leben mehr und hast deswegen verloren. "
				+ "\nDein Punktestand war: " + score);
		
	}

	/**
	 * Handles user input in the console
	 * 
	 * Temporary: Hard coded to the questions given in the constructor. 
	 * Doesn't yet check dynamically for the answer in the Question object
	 * also it only works for boolean
	 * 
	 * Handles case sensitivity and wrong inputs
	 */
	private void userAnswer() {
		// Use Scanner and System.in to get user input from console (per line)
		Scanner userInput = new Scanner(System.in);
		
		String answer = userInput.nextLine();
		
		if (answer.equalsIgnoreCase("wahr")) {
			System.out.println("Du hast die Frage richtig beantwortet.");
			// Keep track of the score --> +1 point
			score++;
		} else if (answer.equalsIgnoreCase("falsch")) {
			System.out.println("Du hast die Frage falsch beantwortet.");
			// Live lost and wrong answer counts up
			lives--;
			wrongAnswers++;
		} else {
			// If the user input is not recognized we repeat the input (also reprint the output)
			System.out.println("Die Eingabe ist nicht gültig. Du kannst nur 'Wahr' oder 'Falsch' eingeben.");
			System.out.println(questions[questionNumber]);
			userAnswer();
		}
	}
}
