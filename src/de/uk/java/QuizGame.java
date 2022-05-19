package de.uk.java;

import de.uk.java.gui.GUI;
import de.uk.java.gui.UICallbacks;

public class QuizGame {

	public static void main(String[] args) {
		// Initialize the game
		new QuizGame();
	}
	
	Game game;
	
	public QuizGame() {
		UICallbacks uiCallbacks = new UICallbacks() {

			@Override
			public Game newGame() {
				game = new Game();
				return game;
			}

			@Override
			public Game checkAnswer(String userAnswer) {
				return game.checkAnswer(userAnswer);
			}
		};
		new GUI(uiCallbacks);
	}
}
