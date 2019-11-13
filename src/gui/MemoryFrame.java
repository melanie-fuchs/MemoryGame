package gui;

import java.awt.*;
import java.util.Vector;

import javax.swing.JFrame;

/**
 * The class extends <code>JFrame</code> and is used to display the cards and
 * the settings once the game has started
 * 
 * @author yume
 */
public class MemoryFrame extends JFrame {
	private static final long serialVersionUID = 1615254294394375523L;

	/**
	 * The constructor that sets the title for the frame, its size - depending on
	 * the total amount of cards used in the game - sets the location of the frame
	 * and adds the components.
	 * 
	 * @param memorySize int-value that represents the total number of cards in the
	 *                   game
	 * @param gameMode   int-value that represents the game-mode
	 * @param cards      <code>Vector</code>-object that contains the memory-cards
	 *                   for the game
	 */
	public MemoryFrame(int memorySize, int gameMode, Vector<BaseCard> cards) {
		super("Memory");
		if (memorySize == 16) {
			this.setSize(650, 800);
		} else {
			this.setSize(720, 750);
		}

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());

		MemorySettingsPanel memoryStatsPanel = new MemorySettingsPanel(this, gameMode, memorySize);
		MemoryCardPanel memoryCardPanel = new MemoryCardPanel(memorySize, cards, memoryStatsPanel);

		this.add(memoryCardPanel, BorderLayout.CENTER);
		this.add(memoryStatsPanel, BorderLayout.SOUTH);

		this.setResizable(false);
		this.setVisible(true);
	}
}
