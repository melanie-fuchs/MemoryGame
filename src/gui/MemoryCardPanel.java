/**
 * 
 */
package gui;

import java.awt.GridLayout;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JPanel;

/**
 * 
 * @author yume
 *
 */
public class MemoryCardPanel extends JPanel {
	
	private int memorySize;		// 16, 20 or 30 cards possible
	private void setMemorySize(int memorySize) {
		this.memorySize = memorySize;
	}
	public int getMemorySize() {
		return memorySize;
	}
	
	private Vector<BaseCard> cards;
	private void setCards(Vector<BaseCard> cards) {
		this.cards = cards;
	}
	public Vector<BaseCard> getCards() {
		return cards;
	}
	
	/**
	 * Constructor that takes an int-value that represents the gamesize
	 * (number of cards in the game) and a Vector of memory-cards.
	 * 
	 * @param memorySize
	 * @param cards
	 */
	public MemoryCardPanel(int memorySize, Vector<BaseCard> cards) {
		setMemorySize(memorySize);
		setCards(cards);
		setGridLayout(memorySize);
		fillPanel(cards);
	}
	
	/**
	 * The method sets a GridLayout for the JPanel regarding the amount
	 * of cards used in the game.
	 * 
	 * @param memorySize number of cards for the game
	 */
	private void setGridLayout(int memorySize) {
		switch (memorySize) {
		case 16:
			this.setLayout(new GridLayout(4, 4, 5, 5));
			break;
		case 20:
			this.setLayout(new GridLayout(4, 5, 5 ,5));
			break;
		case 30:
			this.setLayout(new GridLayout(5, 6, 5, 5));
			break;
		}
	}
	
	/**
	 * Method that shuffles the cards of the Vector and adds them to
	 * the GridLayout.
	 * 
	 * @param cards
	 */
	private void fillPanel(Vector<BaseCard> cards) {
		Collections.shuffle(cards);	// shuffle cards in random order
		for (int i = 0; i < cards.size(); i++) {
			this.add(cards.get(i));
		}
	}	
}
