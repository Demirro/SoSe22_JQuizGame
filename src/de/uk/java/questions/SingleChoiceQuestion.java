package de.uk.java.questions;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Child of Question
 * Question type that handles question with 4 choices. Only one is valid
 * @author Théo Bouveyron
 *
 */
public class SingleChoiceQuestion extends Question {
	
	private List<String> answers;
	
	/**
	 * Constructor for a new SingleChoiceQuestion
	 * Calls super constructor
	 * @param prompt - String - The simple question text
	 * @param category - String - category the question should be in
	 * @param answers - String array - array containing the 4 different answer possibilities
	 * @param correctAnswer - char - Either A,B,C or D. Simple way to store the correct Answer
	 */
	public SingleChoiceQuestion(String prompt, String category, List<String> answers, String correctAnswer) {
		super(prompt, category, correctAnswer);
		this.answers = answers;
	}
	
	@Override
	public void definePane(ActionListener actionListener) {
			JPanel buttonPanel = new JPanel();
			buttonPanel.setLayout(new GridLayout(2, 2, 20, 20));
			JButton[] buttons = new JButton[4];
			
			//Shuffle the collection for random button placement
			Collections.shuffle(answers);
			for (int i = 0; i < buttons.length; i++) {
				buttons[i] = new JButton(answers.get(i));
				buttons[i].addActionListener(actionListener);
				buttons[i].setActionCommand("answer");
				buttonPanel.add(buttons[i]);
			}
			
			super.definePane(actionListener);
			add(buttonPanel);
			
			validate();
	}


	@Override
	public String toString() {
		return super.toString();
	}
}
