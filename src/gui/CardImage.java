/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
/**
 * @author yume
 *
 */
public class CardImage extends BaseCard {
	
	private int cardID;				// ID of the card. The game will use this ID to compare pairs
	@Override
	protected int getCardID() {		// getter for cardID
		return cardID;
	}
	private boolean faceUp; 		// true if face is visible, false if card is hidden

	private Color backgroundColor;	// backgroundcolor of every card
	private BufferedImage image;	// Buffered Image of the card
	
	public CardImage(BufferedImage image, Color colorBack, int id) {
		this.image = image;
		
		this.backgroundColor = colorBack;
		this.cardID = id;
		
		this.setBackground(backgroundColor);
		this.faceUp = false;
		
		if(this.isEnabled()) {
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
    }
	
	@Override
	protected void switchFace() {
		if(this.isEnabled()) {
			if(faceUp) {
				this.setBackground(backgroundColor);
				this.faceUp = false;
			} else {
				this.setIcon(new ImageIcon(image));
				this.faceUp = true;
			}
			this.repaint();
			this.validate();
		}
	}
}
