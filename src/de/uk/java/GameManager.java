package de.uk.java;

import java.util.Scanner;

import de.uk.java.questions.BoolQuestion;
import de.uk.java.questions.Question;
import de.uk.java.questions.SingleChoiceQuestion;
import de.uk.java.questions.InvalidInputException;

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
	 * Temporary: also creates the first four questions and populates the question array with them
	 */
	public GameManager() {
		lives = 3;
		this.score = 0;
		this.wrongAnswers = 0;
		this.questionNumber = 0;
		
		questions = new Question[4];
		BoolQuestion question1 = new BoolQuestion("Ist Java toll?", true, "Computer Science");
		BoolQuestion question2 = new BoolQuestion("Ist die Stunde fast um?", true, "Lehre");
		SingleChoiceQuestion question3 = new SingleChoiceQuestion("Seit wann existiert die Universität zu Köln?", "History", new String[]{"1111", "1388", "1565", "1945"}, 'B');
		SingleChoiceQuestion question4 = new SingleChoiceQuestion("Was ist die Hauptstadt von Kambodscha?", "Geography", new String[]{"Kuala Lumpur", "Kampong Cham", "Phnom Penh", "Bangkok"}, 'C');
		
		questions[0] = question1;
		questions[1] = question2;
		questions[2] = question3;
		questions[3] = question4;
		
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
	 * UserInput checks and checks for the correct answer are dynamically checked 
	 * by calling the inherited method getCorrectAnswer implemented in each Question type
	 * 
	 * Wrong Inputs are checked in the same methods using a custom exceptions, which gives back valid inputs
	 */
	private void userAnswer() {
		// Use Scanner and System.in to get user input from console (per line)
		Scanner userInput = new Scanner(System.in);
		
		String answer = userInput.nextLine();

		try {
			if (questions[questionNumber].getCorrectAnswer(answer)) {
				System.out.println("Du hast die Frage richtig beantwortet");
				score++;
				System.out.println("Dein Punktestand ist jetzt " + score);
			} else {
				System.out.println("Du hast die Frage falsch beantwortet und verlierst ein Leben.");
				lives--;
				wrongAnswers++;
				System.out.println("Du hast noch " + lives + " Leben");
			}
		} catch (InvalidInputException e) {
			System.err.println(e.getMessage());
			userAnswer();
		}
			
			}
	}
