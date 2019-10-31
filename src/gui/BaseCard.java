/**
 * 
 */
package gui;

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
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchFace();				
			}
		});
	}	

	/**
	 * The method switches the faces of the memory-card.
	 */
	abstract void switchFace();
}
