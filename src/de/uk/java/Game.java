package de.uk.java;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import de.uk.java.questions.BoolQuestion;
import de.uk.java.questions.Question;
import de.uk.java.questions.SingleChoiceQuestion;
import de.uk.java.util.QuestionFileReader;
import de.uk.java.questions.InvalidInputException;

public class Game {
	// Variables needed in a game to keep track of progress, lives, lost or won state and so on
	private int lives;
	private int score;
	private int wrongAnswers;
	private int questionNumber;
	
	private boolean won;
	private boolean lost;
	
	private Question currentQuestion;
	
	ArrayList<Question> questions;
	
	/**
	 * Basic empty constructor to initialize the game
	 * Set all the basic game variables to 0 (lives to 3)
	 * Start the game loop via nextQuestion
	 * 
	 * Temporary: also creates the first four questions and populates the question array with them
	 */
	public Game() {
		lives = 3;
		this.score = 0;
		this.wrongAnswers = 0;
		this.questionNumber = 0;
		
		questions = QuestionFileReader.readQuestions("questions.json");
		
		
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
		if (questions.isEmpty()) {
			win();
			return;
		}
		// Count up for the next iteration of the game loop
		//currentQuestion = questions[questionNumber++];
		Random r = new Random();
		currentQuestion = questions.get(r.nextInt(questions.size()));
		questions.remove(currentQuestion);
		
		// Before calling the next Question we should check the if the user still have lives
		if (lives == 0) {
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
	
	public Question getCurrentQuestion() {
		return currentQuestion;
	}

	/**
	 * @return
	 */
	public Game checkAnswer(String userAnswer) {
		if (userAnswer.equalsIgnoreCase(currentQuestion.getCorrectAnswer())) {
			score++;
		} else {
			wrongAnswers++;
			lives--;
		}
			nextQuestion();
			return this;
	}

	/**
	 * @return
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @return
	 */
	public int getLives() {
		return lives;
	}
	
}
