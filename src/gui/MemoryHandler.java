/**
 * 
 */
package gui;

import java.util.Vector;


/**
 * @author yume
 *
 */
public class MemoryHandler {
	
	public static int attempts;
	private Vector<BaseCard> tempCardArray; 	
	private Vector<BaseCard> flippedPairs;
	

	public MemoryHandler() {
		tempCardArray = new Vector<BaseCard>();
		flippedPairs = new Vector<BaseCard>();
	}
	
	public void cardTurned(BaseCard card) {
		tempCardArray.add(card);
		if(tempCardArray.size() == 2){
			checkPairs();
		}
	}
	
	
	private void checkPairs() {
		if (tempCardArray.elementAt(0) == tempCardArray.elementAt(1)) {
			System.out.println("They match");
			flippedPairs.add(tempCardArray.elementAt(0));
			tempCardArray.removeAllElements();
			// TODO lock revealed cards
			// TODO set cursor cannot be hand card is locked
		} else {
			System.out.println("They do not match");
			tempCardArray.removeAllElements();
		}
	}
}
