package gui;
// Main-class of the game

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import fonts.FontRegular;
import fonts.FontTitle;

/**
 * The class extends <code>JFrame</code> and is the main class of the memory-game
 * @author yume
 *
 */
public class Memory extends JFrame {
	private static final long serialVersionUID = 7074129096697005584L;

	/**
	 * <code>JLabel</code>-object that represents the title of the game
	 */
	private JLabel jlbTitleMemory;
	/**
	 * <code>JTextArea</code>-object to display the game-instructions
	 */
	private JTextArea jtaInstructions;

	/**
	 * Constructor that sets the size, resizability and visibility of the frame and
	 * calls the method <code>createGUI()</code>
	 */
	private Memory() {
		super("Memory");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(450, 510);

		this.createGUI();

		this.setResizable(false);
		this.setVisible(true);
	}

	/**
	 * The method creates the upper part of the main memory-frame.
	 */
	private void createGUI() {
		// set title
		jlbTitleMemory = new JLabel("Memory Game", SwingConstants.CENTER);
		jlbTitleMemory.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		jlbTitleMemory.setFont(new FontTitle(36));

		// set textfield for instructions
		String instructions = "Reveal two cards and try to find pairs. If the two cards are\n"
				+ "identical, you can reveal another two cards. If you did not find\n"
				+ "a pair, the cards will be concealed again. Try to remember\n"
				+ "which card is hidden where and try to reveal the pairs with as\n" + "few tries as possible.\n\n"
				+ "You can either play the game with given different colors or\n"
				+ "by using your own photos by choosing them from your file\n" + "system.\n";
		jtaInstructions = new JTextArea(instructions);
		jtaInstructions.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		jtaInstructions.setFont(new FontRegular(14));
		jtaInstructions.setEditable(false);

		// create all the settings:
		GameSettingsGUI gameSettings = new GameSettingsGUI();

		// put all components onto contentpane of JFrame:
		this.add(jlbTitleMemory, BorderLayout.NORTH);
		this.add(jtaInstructions, BorderLayout.CENTER);
		this.add(gameSettings, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		new Memory();
	}
}
