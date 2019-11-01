package gui;

import java.util.HashMap;
import java.util.Vector;

import gui.BaseCard;

/**
 * Model-Class for the Memory-Game.
 * @author yume
 *
 */
public class MemoryModel {

	private int attempts = 0;
	public int getAttempts() {
		return attempts;
	}

	private Vector<BaseCard> tempCardArray; 	
	private Vector<BaseCard> flippedPairs;
	private HashMap<Integer, BaseCard> allMemoryCards; // TODO types not clear yet. Gotta think about that some more
	public BaseCard getMemoryCard(Integer hashCode) {
		return allMemoryCards.get(hashCode);
	}
	public MemoryModel() {
		tempCardArray = new Vector<BaseCard>();
		flippedPairs = new Vector<BaseCard>();
		allMemoryCards = new HashMap<Integer, BaseCard>();
	}
	
	public void registerCard(BaseCard card) {
		allMemoryCards.put(card.hashCode(), card);
	}
	
	public void action(int hashCode) {
		BaseCard tempCard = getMemoryCard(hashCode);
		tempCard.switchFace();
		tempCardArray.add(tempCard);
		
		if(tempCardArray.size() == 2){
			this.checkPairs();
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

	// TODO when ever a pair is being found:
	// attempts += 1;
}
