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
	
	public MemoryModel() {
		tempCardArray = new Vector<BaseCard>();
		flippedPairs = new Vector<BaseCard>();
		allMemoryCards = new HashMap<Integer, BaseCard>();
	}
	
	public void registerCard(BaseCard card) {
		allMemoryCards.put(card.getCardID(), card);
	}
	
	public void action() {
		// TODO call switchFace-method here in the 
		// card
	}
	

	// TODO when ever a pair is being found:
	// attempts += 1;
}
