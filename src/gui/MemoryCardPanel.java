package gui;

import java.awt.GridLayout;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.MemoryModel;

/**
 * The class extends <code>JPanel</code> and displays the memory-cards
 *
 * @author yume
 */
public class MemoryCardPanel extends JPanel {
	private static final long serialVersionUID = -7225763224244935931L;

	/**
	 * A <code>Vector</code>-object that contains memory-cards of type
	 * <code>BaseCard</code>
	 */
	private Vector<BaseCard> cards;

	/**
	 * The method returns the <code>Vector</code>-object 'cards'
	 * 
	 * @return <code>Vector</code> that contains memory-cards
	 */
	public Vector<BaseCard> getCards() {
		return cards;
	}

	/**
	 * A reference to another <code>JPanel</code> to update it.
	 */
	private MemoryStatsPanel foreignPanel;

	/**
	 * instance of class <code>MemoryModel</code>
	 */
	private MemoryModel model = new MemoryModel();

	/**
	 * Constructor that takes an int-value that represents the gamesize (number of
	 * cards in the game), a Vector of memory-cards and a MemoryStatsPanel. This
	 * MemoryStatsPanel will be used to connect the class with the foreign Panel to
	 * display numbers.
	 * 
	 * @param memorySize   int-value that represents the total number of cards in
	 *                     the game
	 * @param cards        a <code>Vector</code>-object that contains memory-cards
	 * @param foreignPanel a <code>MemoryStatsPanel</code> to update it's components
	 *                     from outside the class
	 */
	public MemoryCardPanel(int memorySize, Vector<BaseCard> cards, MemoryStatsPanel foreignPanel) {
		this.setBorder(new EmptyBorder(10, 10, 15, 10));
		this.foreignPanel = foreignPanel;
		this.cards = cards;
		this.setGridLayout(memorySize);
		this.fillPanel(cards);
	}

	/**
	 * The method sets a GridLayout for the JPanel regarding the amount of cards
	 * used in the game.
	 * 
	 * @param memorySize total number of cards for the game
	 */
	private void setGridLayout(int memorySize) {
		switch (memorySize) {
		case 16:
			this.setLayout(new GridLayout(4, 4, 7, 7));
			break;
		case 20:
			this.setLayout(new GridLayout(4, 5, 7, 7));
			break;
		case 30:
			this.setLayout(new GridLayout(5, 6, 7, 7));
			break;
		}
	}

	/**
	 * Method that shuffles the cards of the <code>Vector</code> 'cards' and adds
	 * them to the GridLayout.
	 * 
	 * @param cards <code>Vector</code>-object that contains memory-cards
	 */
	private void fillPanel(Vector<BaseCard> cards) {
		Collections.shuffle(cards); // shuffle cards in random order
		for (BaseCard currentCard : cards) {
			currentCard.addActionListener(new MemoryActionListener(model, foreignPanel));
			this.add(currentCard);
			model.registerCard(currentCard);
		}
	}
}
