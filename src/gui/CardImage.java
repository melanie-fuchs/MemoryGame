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
 * The class represents a memory-card that has a backgroundcolor and an image as face
 * @author yume
 *
 */
public class CardImage extends BaseCard {
	private static final long serialVersionUID = 6743078965591432160L;

	/**
	 * int-value that represents the card's ID. Every card will be genereated within
	 * a loop and the cards will receive a number in ascending order. The cardID
	 * will be used to compare cards with each others to find pairs (two cards with
	 * same cardID are a pair).
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
	 * boolean-value that describes if a card shows it's face, of if it is
	 * concealed. The value is <code>true</code> if the face is visible and
	 * <code>false</code> if the card is concealed.
	 */
	private boolean faceUp;

	/**
	 * Backgroundcolor of the card when it's concealed
	 */
	private Color backgroundColor;
	
	/**
	 * Buffered Image of the card that represents the front of the card
	 */
	private BufferedImage image;

	/**
	 * The constructor sets the backgroundcolor, the cardID and the image. The
	 * The card's faceUp-variable will be set to false so it's backgroundcolor will
	 * be up and the face will will be concealed once the game started. The cursor
	 * is being set as hand when the cursor hovers over enabled cards.
	 * 
	 * @param image     <code>BufferedImage</code>-object that will be used as the
	 *                  front side of the memory-card
	 * @param colorBack <code>Color</code>-object that represents the backgound-
	 *                  color of the memory-card
	 * @param id        int-value that represents the ID of the card
	 * 
	 * @see java.awt.Cursor
	 */
	public CardImage(BufferedImage image, Color colorBack, int id) {
		this.image = image;

		this.backgroundColor = colorBack;
		this.cardID = id;

		this.setBackground(backgroundColor);

		this.faceUp = false;

		if (this.isEnabled()) {
			this.setCursor(new Cursor(Cursor.HAND_CURSOR));

		}
	}

	/**
	 * The method calls it's parent's <code>paintComponent</code>-method and sets
	 * the color of the card to the background-color in the moment when the button
	 * is being pressed.
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
	 * The method switches the colors of the card if the card is enabled. If the
	 * face of the card was visible, the card's background will be set to the
	 * background color and vice versa. After switching the side, the variable
	 * <code>faceUp</code> will be updated accordingly.
	 */
	@Override
	protected void switchFace() {
		if (this.isEnabled()) {
			if (faceUp) {
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
