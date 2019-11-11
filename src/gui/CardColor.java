package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;

/**
 * The class represents a memory-card that has a background- and a foreground-color
 *
 * @author yume
 *
 */
public class CardColor extends BaseCard {
	private static final long serialVersionUID = 263636766241084074L;

	/**
	 * int-value that represents the card's ID. Every card will be generated within
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
	 * Background-color of the card when it's concealed
	 */
	private Color backgroundColor;

	/**
	 * Foreground-color of the card when the face is up
	 */
	private Color foregroundColor;

	/**
	 * The constructor sets the background-color, the cardID and the foreground-color.
	 * The card's faceUp-variable will be set to false so it's background-color will
	 * be up and the face will will be concealed once the game started. The cursor
	 * is being set as hand when the cursor hovers over enabled cards.
	 * 
	 * @param colorFace <code>Color</code>-object that represents the foreground-
	 *                  color of the memory-card
	 * @param colorBack <code>Color</code>-object that represents the backgound-
	 *                  color of the memory-card
	 * @param id        int-value that represents the ID of the card
	 * 
	 * @see java.awt.Cursor
	 */
	public CardColor(Color colorFace, Color colorBack, int id) {
		this.foregroundColor = colorFace;
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
	 * the color of the card to the background-color in the moment when the button is
	 * being pressed.
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
	 * background was set to the foreground-color, it will be set to the
	 * backgroundcolor and vice versa. After switching the side, the variable
	 * <code>faceUp</code> will be updated accordingly.
	 */
	@Override
	protected void switchFace() {
		if (this.isEnabled()) {
			if (faceUp) {
				this.setBackground(backgroundColor);
				this.faceUp = false;
			} else {
				this.setBackground(foregroundColor);
				this.faceUp = true;
			}
		}
	}
}
