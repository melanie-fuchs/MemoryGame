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
	private String gameMode;		// possible values: "color" or "image"
	private int gameSize;			// possible values: 10, 16, 20, 30
	private Color[] colors = new Color[15];
	private Color colorBack = Color.DARK_GRAY;
	
	public StartMemory(int gameSize, String gameMode) {
		this.gameMode = gameMode;
		this.gameSize = gameSize;
		
		if(gameMode == "color") {
			generateColorCards();
		} else {
			generateImageCards();
		}
	}
	
	private void generateColorCards() {
		initColors();
		for(int i = 0; i < gameSize; i++) {
			cards.add(new CardColor(colors[i], colorBack, i));
		}		
	}
	
	private void generateImageCards() {
		
	}
	
	private void initColors() {
		Color darkRed = new Color(170, 11, 50);
		Color red = new Color(240, 40, 90);
		Color darkOrange = new Color(240, 100, 40);
		Color orange = new Color(240, 140, 60);
		Color darkYellow = new Color(250, 230, 100);
		Color yellow = new Color(255, 240, 130);
		Color darkGreen = new Color(45, 175, 10);
		Color green = new Color(140, 230, 20);
		Color lime = new Color(220, 255, 130);
		Color turquoise = new Color(0, 150, 100);
		Color darkBlue = new Color(0, 40, 190);
		Color blue = new Color(5, 105, 190);
		Color purple = new Color(75, 5, 190);
		Color fuchsia = new Color(135, 5, 190);
		Color pink = new Color(190, 5, 105);
		
		colors[0] = darkRed;
		colors[1] = red;
		colors[2] = darkOrange;
		colors[3] = orange;
		colors[4] = darkYellow;
		colors[5] = yellow;
		colors[6] = darkGreen;
		colors[7] = green;
		colors[8] = lime;
		colors[9] = turquoise;
		colors[10] = darkBlue;
		colors[11] = blue;
		colors[12] = purple;
		colors[13] = fuchsia;
		colors[14] = pink;
	}
}
