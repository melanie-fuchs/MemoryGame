/**
 * 
 */
package gui;

import java.awt.Color;
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
	
	public StartMemory(int gameSize, int gameMode) {
		this.gameMode = gameMode;
		this.gameSize = gameSize;
		
		if(gameMode == 1) {
			generateColorCards();
		} else {
			if (gameMode == 2) {
				generateImageCards();
			}
		}
	}
	
	private void generateColorCards() {
		initColors();
		for(int i = 0; i < gameSize; i++) {
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
		colors[0] = new Color(170, 11, 50); 	// darkRed
		colors[1] = new Color(240, 40, 90); 	// red
		colors[2] = new Color(240, 140, 60); 	// orange
		colors[3] = new Color(255, 240, 130); 	// yellow
		colors[4] = new Color(140, 230, 20); 	// green
		colors[5] = new Color(0, 150, 100); 	// turquoise
		colors[6] = new Color(5, 105, 190); 	// blue
		colors[7] = new Color(75, 5, 190); 		// purple

		colors[8] = new Color(240, 100, 40); 	// darkOrange2
		colors[9] = new Color(250, 230, 100); 	// darkYellow

		colors[10] = new Color(45, 175, 10); 	// darkGreen
		colors[11] = new Color(220, 255, 130);	 // lime
		colors[12] = new Color(0, 40, 190); 	// darkBlue
		colors[13] = new Color(135, 5, 190); 	// fuchsia
		colors[14] = new Color(190, 5, 105); 	// pink
	}
}
