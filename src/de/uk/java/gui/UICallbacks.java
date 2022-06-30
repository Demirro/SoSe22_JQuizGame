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
	
	public Game checkAnswer(String userAnswer);
	
	public Game newGameFromFile(String filePath);
}
