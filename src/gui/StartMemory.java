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
	
	private Vector<BaseCard> cards;
	private int gameMode;			// possible values: 1 (color), 2 (image)
	private int gameSize;			// possible values: 16, 20, 30
	private Color[] colors = new Color[15];
	private Color colorBack = Color.DARK_GRAY;
	private Vector<BufferedImage> imageVector;
	
	public StartMemory(int gameSize, int gameMode) {
		this.gameMode = gameMode;
		this.gameSize = gameSize;
		this.cards = new Vector<BaseCard>();
		
		if(gameMode == 1) {
			generateColorCards();
			new MemoryFrame(gameSize, gameMode, cards);
		} else {
			if (gameMode == 2) {
				generateImageCards();
			}
		}
	}
	
	public StartMemory(int gameSize, int gameMode, Vector<BufferedImage> imageVector) {
		this.gameMode = gameMode;
		this.gameSize = gameSize;
		this.imageVector = imageVector;
		this.cards = new Vector<BaseCard>();
		
		if(gameMode == 1) {
			generateColorCards();
			new MemoryFrame(gameSize, gameMode, cards);
		} else {
			if (gameMode == 2) {
				generateImageCards();
			}
		}
	}
	
	/**
	 * The method generates pairs of cards and adds them to the
	 * cards-Vector.
	 */
	private void generateColorCards() {
		initColors();
		for(int i = 0; i < (gameSize / 2); i++) {
			cards.add(new CardColor(colors[i], colorBack, i));
			cards.add(new CardColor(colors[i], colorBack, i));					
		}
	}
	
	private void generateImageCards() {
//		TODO load images
//		private void openFileChooser() {		
//			PhotoChooser chooser = new PhotoChooser();
//			chooser.showOpenDialog(this);
//		}
	}
	
	private void initColors() {		
		colors[0] = new Color(130, 20, 30); 	// darkRed
		colors[1] = new Color(240, 40, 90); 	// red
		colors[2] = new Color(240, 140, 60); 	// orange
		colors[3] = new Color(255, 240, 130); 	// yellow
		colors[4] = new Color(140, 230, 20); 	// green
		colors[5] = new Color(0, 150, 100); 	// turquoise
		colors[6] = new Color(5, 105, 190); 	// blue
		colors[7] = new Color(75, 5, 190); 		// purple

		colors[8] = new Color(240, 100, 40); 	// darkOrange2
		colors[9] = new Color(250, 200, 100); 	// darkYellow

		colors[10] = new Color(0, 100, 0);	 	// darkGreen
		colors[11] = new Color(220, 255, 130);	// lime
		colors[12] = new Color(0, 40, 190); 	// darkBlue
		colors[13] = new Color(135, 5, 190); 	// fuchsia
		colors[14] = new Color(255, 105, 225); 	// pink
	}
}
