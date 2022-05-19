/**
 * 
 */
package de.uk.java.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

import de.uk.java.Game;
import de.uk.java.questions.BoolQuestion;

/**
 * @author Théo Bouveyron
 *
 */
public class GUI extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private UICallbacks uiCallbacks;
	private JPanel contentPane;
	
	public GUI(UICallbacks uiCallbacks) {
		this.uiCallbacks = uiCallbacks;
		initMenu();
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
		
		
		contentPane = new JPanel();
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
		
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		setVisible(true);
		
		
	}

	/**
	 * 
	 */
	private void initMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu gameMenu = new JMenu("Game");
		JMenuItem newGame = new JMenuItem("New Game");
		JMenuItem exitGame = new JMenuItem("Exit Game");
		
		newGame.addActionListener(this);
		exitGame.addActionListener(this);
		
		gameMenu.add(newGame);
		gameMenu.add(exitGame);
		menuBar.add(gameMenu);
		setJMenuBar(menuBar);
	}
	
	public void displayGame(Game game) {
		game.getCurrentQuestion().definePane();
		contentPane.add(game.getCurrentQuestion());
		revalidate();
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case ("New Game"):
			System.out.println("new game button pressed");
			displayGame(uiCallbacks.newGame());
			break;
		case ("Exit Game"):
			System.out.println("exit game button pressed");
			break;
		case ("Answer"):
			displayGame(uiCallbacks.checkAnswer("Test"));
		}
		
	}

}
