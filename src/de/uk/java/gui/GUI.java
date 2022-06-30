/**
 * 
 */
package de.uk.java.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

import de.uk.java.Game;

/**
 * @author Théo Bouveyron
 *
 */
public class GUI extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private UICallbacks uiCallbacks;
	private JPanel questionPane;
	JLabel score;
	JLabel lives;
	
	public GUI(UICallbacks uiCallbacks) {
		this.uiCallbacks = uiCallbacks;
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
		
		initMenu();
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		
		questionPane = new JPanel();
		contentPane.add(questionPane);
		
		contentPane.add(initGameInfo(), BorderLayout.PAGE_END);
		
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		setVisible(true);
		
		
	}

	/**
	 * 
	 */
	private JPanel initGameInfo() {
		JPanel gameInfoPane = new JPanel();
		gameInfoPane.setLayout(new BorderLayout());
		score = new JLabel("Score: 1");
		lives = new JLabel("Lives left: 2");
		gameInfoPane.add(score, BorderLayout.LINE_START);
		gameInfoPane.add(lives, BorderLayout.LINE_END);
		return gameInfoPane;
	}

	/**
	 * 
	 */
	private void initMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu gameMenu = new JMenu("Game");
		JMenuItem gameFromFile = new JMenuItem("New Game from File");
		JMenuItem newGame = new JMenuItem("New Game");
		JMenuItem exitGame = new JMenuItem("Exit Game");
		
		newGame.addActionListener(this);
		gameFromFile.addActionListener(this);
		exitGame.addActionListener(this);
		
		gameMenu.add(newGame);
		gameMenu.add(gameFromFile);
		gameMenu.add(exitGame);
		menuBar.add(gameMenu);
		setJMenuBar(menuBar);
	}
	
	public void displayGame(Game game) {
		questionPane.removeAll();
		game.getCurrentQuestion().definePane(this);
		questionPane.add(game.getCurrentQuestion());
		score.setText("Score: " + Integer.toString(game.getScore()));
		lives.setText("Lives: " + Integer.toString(game.getLives()));
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
		case ("answer"):
			System.out.println("answer button pressed");
			displayGame(uiCallbacks.checkAnswer(((JButton) e.getSource()).getText()));
			break;
		case ("New Game from File"):
			System.out.println("New game from File pressed");
			displayGame(uiCallbacks.newGameFromFile(chooseFile()));
			break;
		}
		
	}

	private String chooseFile() {
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("./"));
	    chooser.setFileFilter(new FileNameExtensionFilter(
		        "Questions File (JSON)", "json"));
	    chooser.showOpenDialog(this);
	    return chooser.getSelectedFile().getAbsolutePath();
	}
}
