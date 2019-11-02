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
	 * Constructor that adds an ActionListener to the JButton. The
	 * ActionListener calls the method <code>switchFace()</code>.
	 */
	public BaseCard() {
		super();
		super.setContentAreaFilled(false);
	}	

	protected abstract int getCardID();
	protected abstract void paintComponent(Graphics g);
	
	/**
	 * The method switches the faces of the memory-card.
	 */
	protected abstract void switchFace();
}
