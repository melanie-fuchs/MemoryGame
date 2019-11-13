package gui;
// Main-class of the game

import java.awt.*;

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
	 * Constructor that sets the size, resizability and visibility of the frame and
	 * calls the method <code>createGUI()</code>
	 */
	public Memory() {
		super(Messages.getString("Memory.gameTitleFrame")); //$NON-NLS-1$
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(450, 510);
		
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 5 * 4);

		this.createGUI();

		this.setResizable(false);
		this.setVisible(true);
	}

	/**
	 * The method creates the upper part of the main memory-frame.
	 */
	private void createGUI() {
		// set title
		JLabel jlbTitleMemory = new JLabel(Messages.getString("Memory.gameTitleInGame"), SwingConstants.CENTER); //$NON-NLS-1$
		jlbTitleMemory.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		jlbTitleMemory.setFont(new FontTitle(36));

		// set textfield for instructions
		String instructions = Messages.getString("Memory.gameInstructions1") //$NON-NLS-1$
				+ Messages.getString("Memory.gameInstructions2") //$NON-NLS-1$
				+ Messages.getString("Memory.gameInstructions3") //$NON-NLS-1$
				+ Messages.getString("Memory.gameInstructions4") + Messages.getString("Memory.gameInstructions5") //$NON-NLS-1$ //$NON-NLS-2$
				+ Messages.getString("Memory.gameInstructions6") //$NON-NLS-1$
				+ Messages.getString("Memory.gameInstructions7") + Messages.getString("Memory.gameInstructions8"); //$NON-NLS-1$ //$NON-NLS-2$
		JTextArea jtaInstructions = new JTextArea(instructions);
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
}
