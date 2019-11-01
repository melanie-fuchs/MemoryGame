/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.util.Vector;


/**
 * @author yume
 *
 */
public class CardColor extends BaseCard {
	
	private int cardID;				// ID of the card. The game will use this ID to compare pairs
	
	@Override
	protected int getCardID() {		// getter for cardID
		return cardID;
	}
	private boolean faceUp; 		// true if face is visible, false if card is hidden
	private boolean locked;			// true if card was successfully revealed as a pair, false if not
	@Override
	protected void setLocked(boolean locked) {
		this.locked = locked;		
	}
	private Color backgroundColor;	// backgroundcolor of every card
	private Color foregroundColor;	// foregroundcolor of every card
	
	public CardColor(Color colorFace, Color colorBack, int id) {
		this.foregroundColor = colorFace;
		this.backgroundColor = colorBack;
		this.cardID = id;
		
		this.setBackground(backgroundColor);
		this.faceUp = false;
		this.locked = false;		

		if(!locked) {
			this.setCursor(new Cursor(Cursor.HAND_CURSOR)); // cursor for unlocked cards
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            g.setColor(backgroundColor);
        } else {
            g.setColor(getBackground());
        }
        g.fillRect(0, 0, getWidth(), getHeight());
//      super.paintComponent(g); //TODO might have to be active
    }
	
	@Override
	protected void switchFace() {
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
