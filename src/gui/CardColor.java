/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;


/**
 * @author yume
 *
 */
public class CardColor extends BaseCard {
	
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
	 * Foregroundcolor of the card
	 */
	private Color foregroundColor;
	
	/**
	 * The constructor sets the backgroundcolor, the cardID and the image.
	 * The card's faceUp-variable will be set to false so it's backgroundcolor
	 * will be visible and the face covered once the game started. 
	 * The cursor for enabled cards will be visible as a hand.
	 * 
	 * @param colorFace <code>Color</code>-object that represents the foreground-
	 * color of the memory-card
	 * @param colorBack <code>Color</code>-object that represents the backgound-
	 * color of the memory-card
	 * @param id int-value that represents the ID of the card
	 */
	public CardColor(Color colorFace, Color colorBack, int id) {
		this.foregroundColor = colorFace;
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
	 * If the background was set to the foreground-color, it will be set
	 * to the backgroundcolor and vice versa. After switching the side,
	 * the variable <code>faceUp</code> will be updated accordingly.
	 */
	@Override
	protected void switchFace() {
		if(this.isEnabled()) {
			if(faceUp) {
				this.setBackground(backgroundColor);
	            this.faceUp = false;
			} else {
				this.setBackground(foregroundColor);
	            this.faceUp = false;
			}
		}
	}
}
