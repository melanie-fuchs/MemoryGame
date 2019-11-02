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
	private boolean gameOver = false;
	public boolean GetGameOver() {
		return gameOver;
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
		BaseCard cardA = tempCardArray.elementAt(0);
		BaseCard cardB = tempCardArray.elementAt(1);
		if (cardA.getCardID() == cardB.getCardID()) {
			System.out.println("They match");
			flippedPairs.add(tempCardArray.elementAt(0));
			cardA.setLocked(true);
			cardB.setLocked(true);
			tempCardArray.removeAllElements();
			this.attempts += 1;
			if(flippedPairs.size() == allMemoryCards.size()) {
				this.gameOver = true;
			}
			tempCardArray.removeAllElements();
			// TODO lock revealed cards
			// TODO set cursor cannot be hand card is locked
		} else {
			System.out.println("They do not match");
			turnCardDelayed(cardA, cardB);
			tempCardArray.removeAllElements();
		}
	}
	
	private void turnCardDelayed(BaseCard cardA, BaseCard cardB) {
		try {
			// wait 2 seconds before turning the cards back
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("MemoryModel.turnCardDelayed(): "
					+ e.getMessage());
		}
		cardA.switchFace();
		cardB.switchFace();
	}
	

	// TODO when ever a pair is being found:
	// attempts += 1;
}
