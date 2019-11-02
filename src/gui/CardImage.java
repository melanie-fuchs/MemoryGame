/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;

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
	private String imagePath;
	private ImageIcon foregroundImage;// foregroundcolor of every card
	
	public CardImage(String imagePath, Color colorBack, int id) {
		this.imagePath = imagePath;
//		this.foregroundImage = colorFace;
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
//      super.paintComponent(g); //TODO might have to be active
    }
	
	@Override
	protected void switchFace() {
		if(this.isEnabled()) {
			if(faceUp) {
				this.setBackground(backgroundColor);
				this.faceUp = false;
			} else {
				try {
					foregroundImage = new ImageIcon(imagePath);
					this.setIcon(foregroundImage);
					this.faceUp = true;
				} catch (Exception e) {
					System.out.println("CardImage.switchFace: " + e.getMessage());
					System.exit(99);
				}
			}
		}
	}
}
