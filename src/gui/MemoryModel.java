package gui;

import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

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
		tempCard.setEnabled(false);
		tempCardArray.add(tempCard);
		System.out.println("CARD IS SWITCHED: " + tempCard.hashCode());
		if(tempCardArray.size() == 2){
			for (BaseCard card : tempCardArray) {
				card.setEnabled(true);
			}
			this.checkPairs();
		} else {
		}
	}

	private void checkPairs() {
		System.out.println("checkPairs() started");
		BaseCard cardA = tempCardArray.elementAt(0);
		BaseCard cardB = tempCardArray.elementAt(1);
		if (cardA.getCardID() == cardB.getCardID()) {
			waitAMoment();
			System.out.println("They match");
			flippedPairs.add(cardA);
			cardA.setEnabled(false);
			cardB.setEnabled(false);
			tempCardArray.removeAllElements();
			this.attempts += 1;
			System.out.println("\tAttempts in IF: " + attempts + "\t Pairs: " + flippedPairs.size());
		} else {
			waitAMoment();
			System.out.println("They do not match");
			tempCardArray.removeAllElements();
			this.attempts += 1;
			System.out.println("\tAttempts in ELSE: " + attempts + "\t Pairs: " + flippedPairs.size());
			switchUnfitPairs(cardA, cardB);
		}
	}
		
	private void waitAMoment() {
		try {
			// wait 2 seconds before turning the cards back
			//TimeUnit.SECONDS.sleep(2);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("MemoryModel.waitAMoment(): "
					+ e.getMessage());
		}
	}
	
	private void switchUnfitPairs(BaseCard cardA, BaseCard cardB) {
		cardA.switchFace();
		cardB.switchFace();		
	}

	// TODO when ever a pair is being found:
	// attempts += 1;
}
