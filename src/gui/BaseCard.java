/**
 * 
 */
package gui;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * Abstract BaseClass for memorycards (JButtons).
 * @author yume
 *
 */
public abstract class BaseCard extends JButton {
	
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
