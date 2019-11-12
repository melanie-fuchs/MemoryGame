/**
 * 
 */
package fonts;

import java.awt.Font;

/**
 * The class extends <code>Font</code> and is used for bold text.
 * 
 * @author yume
 *
 */
public class FontBold extends Font {
	private static final long serialVersionUID = -4372357378837449600L;

	/**
	 * The constructor invokes it's parent's constructor and only takes
	 * one argument - the fontsize.
	 * The font-family is "Arial" and its style "BOLD" by default.
	 * 
	 * @param Fontsize int-value that represents the desired size of the font
	 * 
	 * @see java.awt.Font
	 */
	public FontBold(int Fontsize) {
		super("Arial", Font.BOLD, Fontsize);
	}
}
