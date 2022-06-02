package de.uk.java.questions;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Child of Question
 * Question type that handles boolean question/answers
 * @author Théo Bouveyron
 *
 */
public class BoolQuestion extends Question {
	// correct answer for the question

	/**
	 * Constructor for a new BoolQuestion
	 * Calls super constructor
	 * @param prompt - String - The simple question text
	 * @param answer - boolean - the value of the answer
	 * @param category - String - category the question should be in
	 */
	public BoolQuestion(String prompt, String correctAnswer, String category) {
		super(prompt, category, correctAnswer);
	}
	
	@Override
	public void definePane(ActionListener actionListener) {
		JPanel buttonPanel = new JPanel();
		JButton trueButton = new JButton("True");
		JButton falseButton = new JButton("False");
		trueButton.addActionListener(actionListener);
		falseButton.addActionListener(actionListener);
		trueButton.setActionCommand("answer");
		falseButton.setActionCommand("answer");
		buttonPanel.add(trueButton);
		buttonPanel.add(falseButton);
		
		super.definePane(actionListener);
		add(buttonPanel);
		
		validate();
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
