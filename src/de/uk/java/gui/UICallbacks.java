/**
 * 
 */
package de.uk.java.gui;

import de.uk.java.Game;

/**
 * @author Théo Bouveyron
 *
 */
public interface UICallbacks {
	
	public Game newGame();

	public Game newGameFromFile(String gameFile);
	
	public Game checkAnswer(String userAnswer);
}
