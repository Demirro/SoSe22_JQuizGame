/**
 * 
 */
package de.uk.java.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.border.Border;

import de.uk.java.questions.BoolQuestion;

/**
 * @author Théo Bouveyron
 *
 */
public class GUI extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public GUI() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		setPreferredSize(new Dimension(640,480));
		setTitle("JQuizGame");
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		
		
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		JLabel testText = new JLabel("Test Text ");
		contentPane.add(testText, BorderLayout.PAGE_START);
		/*
		JButton button1 = new JButton("True");
		JButton button2 = new JButton("False");
		button1.setPreferredSize(new Dimension(100,100));
		button2.setSize(new Dimension(100,100));
		contentPane.add(button1, BorderLayout.CENTER);
		contentPane.add(button2, BorderLayout.CENTER);
		*/
		
		JPanel gameInfoPane = new JPanel();
		gameInfoPane.setLayout(new BorderLayout());
		JLabel score = new JLabel("Score: 1");
		JLabel lives = new JLabel("Lives left: 2");
		gameInfoPane.add(score, BorderLayout.LINE_START);
		gameInfoPane.add(lives, BorderLayout.LINE_END);
		contentPane.add(gameInfoPane, BorderLayout.PAGE_END);
		
		BoolQuestion question1 = new BoolQuestion("Is swing a pain in the ass", true , "Computer Science");
		question1.definePane();
		contentPane.add(question1, BorderLayout.CENTER);
		
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		setVisible(true);
		
		
	}

}
