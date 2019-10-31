/**
 * 
 */
package gui;

import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JPanel;

/**
 * A base class for memory-panels. The class sets a gridlayout
 * TODO some more
 * @author yume
 *
 */
public abstract class BaseMemoryPanel extends JPanel {
	
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
	
	public BaseMemoryPanel(int memorySize, Vector<BaseCard> cards) {
		setMemorySize(memorySize);
		setCards(cards);
		setGridLayout(memorySize);
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
	
	abstract void fillPanel();
	
}
