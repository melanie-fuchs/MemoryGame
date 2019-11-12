/**
 * 
 */
package fonts;

import java.awt.Font;

/**
 * The class extends <code>Font</code> and is used for titles.
 * 
 * @author yume
 *
 */
public class FontTitle extends Font {
	private static final long serialVersionUID = -6716296707566342665L;

	/**
	 * The constructor invokes it's parent's constructor and only takes
	 * one argument - the fontsize.
	 * The font-family is "Ink Free" and its style "BOLD" by default.
	 * 
	 * @param Fontsize int-value that represents the desired size of the font
	 * 
	 * @see java.awt.Font
	 */
	public FontTitle(int Fontsize) {
		super("Ink Free", Font.BOLD, Fontsize);
	}
}
