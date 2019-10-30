/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * @author yume
 *
 */
public abstract class BaseCard extends JButton {
	abstract void switchFace();
	
	public BaseCard() {
		super();
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchFace();				
			}
		});
	}	
}
