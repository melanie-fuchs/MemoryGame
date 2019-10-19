package gui;
// testGithub2 Hello

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Memory extends JFrame {
	JLabel jlbTitle;
	JTextArea jtaInstructions;
	JButton jbStart, jbcUseColors, jbChoseFiles, jbClose;
	JCheckBox jbcTen, jcbSixteen, jcbTwenty, jbcThirty;
	Font titleFont, instructionsFont;
	
	
	// Constructor
	public Memory() {
		super("Memory");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(500, 500);
		this.setVisible(true);
		
		this.createGUI();
	}
	
	private void createGUI() {
		// set fonts
		titleFont = new Font("Arial", Font.BOLD, 24);
		instructionsFont = new Font("Arial", Font.PLAIN, 14);
		
		// set title		
		jlbTitle = new JLabel("Memory", SwingConstants.CENTER);
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
		jtaInstructions.setFont(instructionsFont);
		
		
		
		// put it all onto JFrame
		this.add(jlbTitle, BorderLayout.NORTH);
		this.add(jtaInstructions, BorderLayout.CENTER);
	}
	
	
	// testing
	public static void main(String[] args) {
		new Memory();
	}
}
