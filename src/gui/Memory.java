package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Memory extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JLabel jlbTitleMemory, jlbTitleSettings;
	private JTextField jtfStatus;
	private JTextArea jtaInstructions;
	private Font titleFont, instructionsFont;
	private Container contentpane = this.getContentPane();
	
	
	// Constructor
	public Memory() {
		super("Memory");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(450, 500);
		
		this.createGUI();

		this.setVisible(true);
	}
	
	private void createGUI() {
		// set fonts
		titleFont = new Font("Arial", Font.BOLD, 24);
		instructionsFont = new Font("Arial", Font.PLAIN, 14);
		
		// set title		
		jlbTitleMemory = new JLabel("Memory Game", SwingConstants.CENTER);
		jlbTitleMemory.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		jlbTitleMemory.setForeground(new Color(80, 50, 50));
		jlbTitleMemory.setFont(titleFont);
		
		// set textfield for instructions
		String instructions = 
				"Reveal two cards and try to find pairs. If the two cards are\n" +
				"identical, you can reveal another two cards. If you did not find\n" +
				"a pair, the cards will be turned around again. Try to remember\n" +
				"which card is hidden where and try to reveal the pairs with as\n" +
				"few tries as possible.\n\n" +
				"You can either play the game with given different colors or\n" +
				"by using your own photos by chosing them from your file system.";
		jtaInstructions = new JTextArea(instructions);
		jtaInstructions.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		jtaInstructions.setFont(instructionsFont);
		jtaInstructions.setEditable(false);
		
		// create custom JPanel for game-settings:
		JPanel gameSettingPanel = new JPanel();
		gameSettingPanel.setLayout(new BorderLayout());
		jlbTitleSettings = new JLabel("Settings", SwingConstants.CENTER);
		jlbTitleSettings.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		jlbTitleSettings.setFont(titleFont);
		GameSettingsGUI gameSettings = new GameSettingsGUI();
		jtfStatus = new JTextField("");
		jtfStatus.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		jtfStatus.setEditable(false);
		jtfStatus.setForeground(Color.WHITE);
		jtfStatus.setBackground(Color.BLACK);
		gameSettingPanel.add(jlbTitleSettings, BorderLayout.NORTH);
		gameSettingPanel.add(gameSettings, BorderLayout.CENTER);
		gameSettingPanel.add(jtfStatus, BorderLayout.SOUTH);
		
		
		// put all components onto contentpane of JFrame:
		contentpane.add(jlbTitleMemory, BorderLayout.NORTH);
		contentpane.add(jtaInstructions, BorderLayout.CENTER);
		contentpane.add(gameSettingPanel, BorderLayout.SOUTH);
	}
	
	
	// testing
	public static void main(String[] args) {
		new Memory();
	}
}
