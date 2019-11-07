/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;



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
	private BaseCard thisCard = this;
	
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
        super.paintComponent(g);
    }
	
	@Override
	protected void switchFace() {
		if(this.isEnabled()) {
			if(faceUp) {
				//now the card will be grey
				this.setOpaque(true);
				this.setIcon(null);
				this.setDisabledIcon(null);
				this.setBackground(backgroundColor);
				this.faceUp = false;
				System.out.println(this.hashCode() + "\tID: " + this.getCardID() + "\t---switched to BACKGROUNDCOLOR---");
			} else {
				// now the card will show the face
				this.setOpaque(true);
				this.setBackground(getBackground());
				this.setIcon(new ImageIcon(image));
				this.setDisabledIcon(new ImageIcon(image));
				
				this.faceUp = true;
				System.out.println(this.hashCode() + "\tID: " + this.getCardID() + "\t---switched to FOREGROUNDCOLOR---");
			}
			this.repaint();
			this.validate();
		}
	}
}
