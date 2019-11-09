/**
 * 
 */
package fonts;

import java.awt.Font;

/**
 * @author yume
 *
 */
public class FontRegular extends Font {
	private static final long serialVersionUID = -2641348282084762278L;

	/**
	 * The constructor invokes it's parent's constructor and only takes
	 * one argument - the fontsize.
	 * The font-family is "Arial" and its style "PLAIN" by default.
	 * 
	 * @param Fontsize int-value that represents the desired size of the font
	 * 
	 * @see java.awt.Font
	 */
	public FontRegular(int Fontsize) {
		super("Arial", Font.PLAIN, Fontsize);
	}
}
