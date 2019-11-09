/**
 * 
 */
package gui;

import java.awt.Graphics;

import javax.swing.JButton;

/**
 * Abstract BaseClass that extends JButton to represent a memorycard.
 * 
 * @author yume
 *
 */
public abstract class BaseCard extends JButton {
	private static final long serialVersionUID = -3051338794543519002L;

	/**
	 * Constructor that calls the constructor of it's parent and
	 * sets the <code>ContentAreaFilled</code> to false.
	 * 
	 * @see javax.swing.AbstractButton#setContentAreaFilled(boolean)
	 */
	public BaseCard() {
		super();
		super.setContentAreaFilled(false);
	}	

	/**
	 * returns the cardID
	 */
	protected abstract int getCardID();
	
	
	/**
	 * The method calls it's parent's method <code>paintComponent</code>
	 * 
	 * @see javax.swing.JComponent#paintComponents(Graphics)
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
	/**
	 * The method switches the faces of the memory-card.
	 */
	protected abstract void switchFace();
}
