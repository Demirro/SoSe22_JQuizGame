/**
 * 
 */
package de.uk.java.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		gameInfoPane.setBorder(new EmptyBorder(new Insets(0, 10, 10, 10)));
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
		JMenuItem newGame = new JMenuItem("New Game");
		JMenuItem newGameFromFile = new JMenuItem("New Game from File...");
		JMenuItem exitGame = new JMenuItem("Exit Game");

		newGameFromFile.addActionListener(this);
		newGame.addActionListener(this);
		exitGame.addActionListener(this);

		gameMenu.add(newGame);
		gameMenu.add(newGameFromFile);
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
		case ("New Game from File..."):
			System.out.println("new game from file");
			displayGame(uiCallbacks.newGameFromFile(chooseFile()));
			break;
		case ("Exit Game"):
			System.out.println("exit game button pressed");
			System.exit(0);
			break;
		case ("answer"):
			System.out.println("answer button pressed");
			displayGame(uiCallbacks.checkAnswer(((JButton) e.getSource()).getText()));
			break;
		}
		
	}

	private String chooseFile() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File("./"));
		fileChooser.setFileFilter(new FileNameExtensionFilter("Questions File (JSON)", "json"));
		fileChooser.showDialog(null, "Open Game File");
		return fileChooser.getSelectedFile().getAbsolutePath();
	}

}
