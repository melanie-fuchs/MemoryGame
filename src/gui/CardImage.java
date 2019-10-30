/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * @author yume
 *
 */
public class CardImage extends JButton implements BaseCard {
	
	private int cardID;				// ID of the card. The game will use this ID to compare pairs
	public int getCardID() {		// getter for cardID
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
	}
	
	@Override
	public void switchFace() {
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
