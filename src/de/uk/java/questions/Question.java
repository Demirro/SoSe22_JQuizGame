package de.uk.java.questions;

import de.uk.java.gui.utils.RoundedBorder;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.border.*;

/**
 * Abstract class for questions. All Question types inherit from this abstract class
 * Handles the prompts, the category and common methods like toString or more to come
 * @author Théo Bouveyron
 *
 */
public abstract class Question extends JPanel {
	// Basic variables for any question
	private String prompt;
	private String category;
	private String correctAnswer;
	
	/**
	 * Constructor for a new Question
	 * @param prompt - String - The simple question text
	 * @param correctAnswer - boolean - the value of the answer
	 * @param category - String - category the question should be in
	 */
	public Question(String prompt, String category, String correctAnswer) {
		this.prompt = prompt;
		this.category = category;
		this.correctAnswer = correctAnswer;
	}

	public void definePane(ActionListener actionListener) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JPanel questionHeader = new JPanel();
		questionHeader.setLayout(new GridBagLayout());
		JLabel category = new JLabel(getCategory());
		JLabel prompt = new JLabel(getPrompt());

		GridBagConstraints categoryConstraint = new GridBagConstraints();
		categoryConstraint.gridx = 2;
		categoryConstraint.gridy = 0;
		categoryConstraint.fill = GridBagConstraints.HORIZONTAL;
		categoryConstraint.weightx = 1;
		categoryConstraint.weighty = 1;
		GridBagConstraints promptConstraints = new GridBagConstraints();
		promptConstraints.weightx = 1;
		promptConstraints.weighty = 1;
		promptConstraints.gridx = 1;
		promptConstraints.gridy = 1;
		promptConstraints.gridwidth = 0;
		promptConstraints.fill = GridBagConstraints.BOTH;
		promptConstraints.anchor = GridBagConstraints.CENTER;
		prompt.setHorizontalAlignment(SwingConstants.CENTER);


		questionHeader.setBorder(BorderFactory.createCompoundBorder(new RoundedBorder(20),new EmptyBorder(5,5,5,5)));
		//questionHeader.setBorder(new BevelBorder(1, Color.BLACK, Color.GRAY));

		category.setBorder(new EmptyBorder(0,0,10,0));
		questionHeader.add(category, categoryConstraint);
		questionHeader.add(prompt, promptConstraints);
		
		add(questionHeader);
		validate();
	}
	/* -- Getter and Setter -- */
	
	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	/**
	 * Abstract method to check userInput for valid inputs and correct answer.
	 * @param  - String from the command-line given by the user. This is the answer to be checked
	 * @returns boolean - true if the user answer was correct; false if the answer is wrong
	 * @throws InvalidInputException - custom Exception which handles invalid inputs by the user. Message contains valid input choices
	 */
	public String getCorrectAnswer() {
		return correctAnswer;
	}

	/**
	 * Overide the toString method to get a logical output
	 * In this case the output is the category and prompt of the question
	 */
	@Override
	public String toString() {
		return "Category: " + getCategory() + "\nPrompt: " + getPrompt();
	}
}
