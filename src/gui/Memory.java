package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class Memory extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JLabel jlbTitle;
	private JTextArea jtaInstructions;
	private Font titleFont, instructionsFont;
	private Container contentpane = this.getContentPane();
	
	
	// Constructor
	public Memory() {
		super("Memory");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(450, 400);
		
		this.createGUI();

		this.setVisible(true);
	}
	
	private void createGUI() {
		// set fonts
		titleFont = new Font("Arial", Font.BOLD, 24);
		instructionsFont = new Font("Arial", Font.PLAIN, 14);
		
		// set title		
		jlbTitle = new JLabel("Memory Game", SwingConstants.CENTER);
		jlbTitle.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		jlbTitle.setForeground(new Color(150, 50, 50));
		jlbTitle.setFont(titleFont);
		
		// set textfield for instructions
		String instructions = 
				"Reveal two cards and try to find pairs. If the two cards are\n" +
				"identical, you can reveal another two cards. If you did not find\n" +
				"a pair, the cards will be turned around again. Try to remember\n" +
				"which card is hidden where and try to reveal the pairs with as\n" +
				"little tries as possible.\n\n" +
				"You can either play the game with given different colors or\n" +
				"by using your own photos by chosing them in your file system.";
		jtaInstructions = new JTextArea(instructions);
		jtaInstructions.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		jtaInstructions.setFont(instructionsFont);
		jtaInstructions.setEditable(false);

		
		// create custom JPanel for game-settings:
		GameSettingsGUI gameSettings = new GameSettingsGUI();

	
		// put all components onto contentpane of JFrame:
		contentpane.add(jlbTitle, BorderLayout.NORTH);
		contentpane.add(jtaInstructions, BorderLayout.CENTER);
		contentpane.add(gameSettings, BorderLayout.SOUTH);
	}
	
	
	// testing
	public static void main(String[] args) {
		new Memory();
	}
}
