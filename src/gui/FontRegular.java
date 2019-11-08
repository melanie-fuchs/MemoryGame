/**
 * 
 */
package gui;

import java.awt.Font;

/**
 * @author yume
 *
 */
public class FontRegular extends Font {
	
	/**
	 * The constructor invokes it's parent's constructor and only takes
	 * one argument - the fontsize.
	 * 
	 * @param Fontsize
	 */
	public FontRegular(int Fontsize) {
		super("Arial", Font.PLAIN, Fontsize);
	}
}
