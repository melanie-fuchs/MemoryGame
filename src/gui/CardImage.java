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
	
	/**
	 * ID of the card. The game will use this ID to compare cards and find pairs
	 */
	private int cardID;
	/**
	 * returns the cardID
	 */
	@Override
	protected int getCardID() {
		return cardID;
	}
	/**
	 * boolean-value: true if face is visible, false if card is covered
	 */
	private boolean faceUp;

	/**
	 * Backgroundcolor of the card
	 */
	private Color backgroundColor;
	/**
	 * Buffered Image of the card (represents the front of the card)
	 */
	private BufferedImage image;
	
	/**
	 * The constructor sets the backgroundcolor, the cardID and the image.
	 * The card's faceUp-variable will be set to false so it's backgroundcolor
	 * will be visible and the face covered once the game started. 
	 * The cursor for enabled cards will be visible as a hand.
	 * 
	 * @param image <code>BufferedImage</code>-object that will be used as the
	 * front side of the memorycard
	 * @param colorBack <code>Color</code>-object that represents the backgound-
	 * color of the memory-card
	 * @param id int-value that represents the ID of the card
	 */
	public CardImage(BufferedImage image, Color colorBack, int id) {
		this.image = image;
		
		this.backgroundColor = colorBack;
		this.cardID = id;
		
		this.setBackground(backgroundColor);

		this.faceUp = false;
		
		if(this.isEnabled()) {
			this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		}
	}
	
	/**
	 * The method calls it's parent's <code>paintComponent</code>-method
	 * and sets the color of the card to background-color in the moment
	 * when the button is clicked. 
	 */
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
	
	/**
	 * The method switches the colors of the card if the card is enabled.
	 * If the face of the card was visible, the card's background will be
	 * set to the background color and vice versa. After switching the side,
	 * the variable <code>faceUp</code> will be updated accordingly.
	 */
	@Override
	protected void switchFace() {
		if(this.isEnabled()) {
			if(faceUp) {
				this.setIcon(null);
				this.setDisabledIcon(null);
				this.setBackground(backgroundColor);
				this.faceUp = false;
			} else {
				this.setBackground(getBackground());
				this.setIcon(new ImageIcon(image));
				this.setDisabledIcon(new ImageIcon(image));
				
				this.faceUp = true;
			}
		}
	}
}
