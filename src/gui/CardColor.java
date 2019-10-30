/**
 * 
 */
package gui;

import java.awt.Color;

import javax.swing.JButton;

/**
 * @author yume
 *
 */
public class CardColor extends JButton implements BaseCard {
	
	private int cardID;				// ID of the card. The game will use this ID to compare pairs
	public int getCardID() {		// getter for cardID
		return cardID;
	}
	private boolean faceUp; 		// true if face is visible, false if card is hidden
	private Color backgroundColor;	// backgroundcolor of every card
	private Color foregroundColor;	// foregroundcolor of every card
	
	public CardColor(Color colorFace, Color colorBack, int id) {
		this.foregroundColor = colorFace;
		this.backgroundColor = colorBack;
		this.cardID = id;
		
		this.setBackground(backgroundColor);
		this.faceUp = false;
	}
	
	@Override
	public void switchFace() {
		if(faceUp) {
			this.setBackground(backgroundColor);
			this.faceUp = false;
		} else {
			this.setBackground(foregroundColor);
			this.faceUp = true;
		}
	}
}
