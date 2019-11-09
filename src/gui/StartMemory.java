/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * @author yume
 *
 */
public class StartMemory {

	/**
	 * <code>Vector</code>-object that contains the cards for the memory-game
	 */
	private Vector<BaseCard> cards;

	/**
	 * int-value that represents the total amount of cards used in the game
	 */
	private int gameSize; // possible values: 16, 20, 30

	/**
	 * <code>Color</code>-array that has space for 15 Color-objects
	 */
	private Color[] colors = new Color[15];

	/**
	 * <code>Color</code>-object that represents the background-color of the
	 * memory-cards
	 */
	private Color colorBack = Color.DARK_GRAY;

	/**
	 * <code>Vector</code>-object that contains <code>BufferedImage</code>-objects
	 * which can be used to display the face of a memory-card
	 */
	private Vector<BufferedImage> imageVector;

	/**
	 * The constructor generates color-cards
	 * 
	 * @param gameSize int-value that represents the total amount of cards used in
	 *                 the game
	 * @param gameMode int-value that represents the game-mode
	 * 
	 * @see gui.StartMemory#generateColorCards()
	 */
	public StartMemory(int gameSize, int gameMode) {
		this.gameSize = gameSize;
		this.cards = new Vector<BaseCard>();

		if (gameMode == 1) { // 1 (color), 2 (image)
			generateColorCards();
			new MemoryFrame(gameSize, gameMode, cards);
		}
	}

	/**
	 * The constructor generates image-cards
	 * 
	 * @param gameSize    int-value that represents the total amount of cards used
	 *                    in the game
	 * @param gameMode    int-value that represents the game-mode
	 * @param imageVector <code>Vector</code>-object that contains
	 *                    <code>BufferedImage</code>-objects that will be used as
	 *                    icons for the memory-cards
	 * 
	 * @see gui.StartMemory#generateColorCards()
	 */
	public StartMemory(int gameSize, int gameMode, Vector<BufferedImage> imageVector) {
		this.gameSize = gameSize;
		this.imageVector = imageVector;
		this.cards = new Vector<BaseCard>();

		if (gameMode == 2) {
			generateImageCards();
			new MemoryFrame(gameSize, gameMode, cards);
		}
	}

	/**
	 * The method generates colors and then generates pairs of cards and adds them
	 * to the cards-Vector.
	 * 
	 * @see gui.StartMemory#initColors()
	 * @see gui.StartMemory#cards
	 * @see gui.CardColor
	 */
	private void generateColorCards() {
		initColors();
		for (int i = 0; i < (gameSize / 2); i++) {
			cards.add(new CardColor(colors[i], colorBack, i));
			cards.add(new CardColor(colors[i], colorBack, i));
		}
	}

	/**
	 * The method generates pairs of image-cards and adds them to the cards-Vector.
	 * 
	 * @see gui.StartMemory#cards
	 * @see gui.CardImage
	 */
	private void generateImageCards() {
		for (int i = 0; i < (gameSize / 2); i++) {
			cards.add(new CardImage(imageVector.elementAt(i), colorBack, i));
			cards.add(new CardImage(imageVector.elementAt(i), colorBack, i));
		}
	}

	/**
	 * The method creates 15 <code>Color</code>-objects
	 */
	private void initColors() {
		colors[0] = new Color(130, 20, 30); // darkRed
		colors[1] = new Color(240, 40, 90); // red
		colors[2] = new Color(240, 140, 60); // orange
		colors[3] = new Color(255, 240, 130); // yellow
		colors[4] = new Color(140, 230, 20); // green
		colors[5] = new Color(0, 150, 100); // turquoise
		colors[6] = new Color(5, 105, 190); // blue
		colors[7] = new Color(75, 5, 190); // purple

		colors[8] = new Color(240, 100, 40); // darkOrange2
		colors[9] = new Color(250, 200, 100); // darkYellow

		colors[10] = new Color(0, 100, 0); // darkGreen
		colors[11] = new Color(220, 255, 130); // lime
		colors[12] = new Color(0, 40, 190); // darkBlue
		colors[13] = new Color(135, 5, 190); // fuchsia
		colors[14] = new Color(255, 105, 225); // pink
	}
}
