/**
 * 
 */
package gui;

import java.awt.Color;
import java.util.Vector;


/**
 * @author yume
 *
 */
public class CardColor extends BaseCard {
	
	private int cardID;				// ID of the card. The game will use this ID to compare pairs
	public int getCardID() {		// getter for cardID
		return cardID;
	}
	private boolean faceUp; 		// true if face is visible, false if card is hidden
	private boolean locked;			// true if card was successfully revealed as a pair, false if not
	private Color backgroundColor;	// backgroundcolor of every card
	private Color foregroundColor;	// foregroundcolor of every card
	
	public CardColor(Color colorFace, Color colorBack, int id) {
		this.foregroundColor = colorFace;
		this.backgroundColor = colorBack;
		this.cardID = id;
		
		this.setBackground(backgroundColor);
		this.faceUp = false;
		this.locked = false;
	}
	
	@Override
	public void switchFace() {
		if(!locked) {
			if(faceUp) {
				this.setBackground(backgroundColor);
				this.faceUp = false;
			} else {
				this.setBackground(foregroundColor);
				this.faceUp = true;
			}
		}
	}
}
