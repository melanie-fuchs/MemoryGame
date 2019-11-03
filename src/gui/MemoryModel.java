package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import javax.swing.Timer;

import gui.BaseCard;

/**
 * Model-Class for the Memory-Game. The class is used to handle the events when
 * cards are being clicked.
 * 
 * @author yume
 *
 */
public class MemoryModel implements BaseModel {

	private int attempts = 0;
	/**
	 * The method returns the number (int value) of attempts.
	 * 	 */
	public int getAttempts() {
		return attempts;
	}

	/**
	 * Vector-Object that is used to collect two cards (type <code>BaseCard</code>)
	 * to later check them for unity.
	 */
	private Vector<BaseCard> tempCardArray;
	/**
	 * Vector-Object that is used to collect flipped pairs of memory-cards (type 
	 * <code>BaseCard</code> to later check if the game is over or not
	 */
	private Vector<BaseCard> flippedPairs;
	/**
	 * Hashmap-Object that contains all cards of the game (type <code>BaseCard</code>)
	 */
	private HashMap<Integer, BaseCard> allMemoryCards;
		
	/**
	 * Constructor that creates instances of the card-Vectors.
	 */
	public MemoryModel() {
		tempCardArray = new Vector<BaseCard>();
		flippedPairs = new Vector<BaseCard>();
		allMemoryCards = new HashMap<Integer, BaseCard>();
	}
	
	/**
	 * The Method takes an Integer (hashCode of a BaseCard-Object) as parameter
	 * and returns the according object from the vector <code>allMemoryCard</code>
	 * @param hashCode hashCode of an boject as <code>Integer</code>-value
	 * @return object of type BaseCard
	 */
	public BaseCard getMemoryCard(Integer hashCode) {
		return allMemoryCards.get(hashCode);
	}	
	
	/**
	 * The method that registers a card of type <code>BaseCard</code> in the
	 * HashMap of allMemoryCards.
	 * 
	 * @param card card-Object of type <code>BaseCard</code>
	 */
	public void registerCard(BaseCard card) {
		allMemoryCards.put(card.hashCode(), card);
	}
	
	//TODO find better description for method
	/**
	 * The Method takes an int-value (hashCode) and handles the card-event
	 */
	@Override
	public void action(int hashCode) {
		BaseCard tempCard = getMemoryCard(hashCode);
		tempCard.switchFace();
		tempCard.setEnabled(false);
		tempCardArray.add(tempCard);
		System.out.println("CARD IS SWITCHED: " + tempCard.hashCode());
		// the problem seems to be here somewhere:
		if(tempCardArray.size() == 2){
			for (BaseCard card : tempCardArray) {
				card.setEnabled(false);
			}
			this.checkPairs(2500);
			this.attempts += 1;
		}
	}

	//TODO find better description for method
	/**
	 * The method compares the cards in the <code>tempCardArray</code>-
	 * Vector and handles further tasks.
	 */	
	private void checkPairs(int sleepMillis) {
		System.out.println("Program is gonna sleep... wait:");

		Timer timer = new Timer(sleepMillis, new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
            	System.out.println("checkPairs() started");
        		BaseCard cardA = tempCardArray.elementAt(0);
        		BaseCard cardB = tempCardArray.elementAt(1);
        		if (cardA.getCardID() == cardB.getCardID()) {
        			System.out.println("They match");
        			flippedPairs.add(cardA);
        			flippedPairs.add(cardB);
        			cardA.setEnabled(false);
        			cardB.setEnabled(false);
        			tempCardArray.removeAllElements();
        		} else {
        			System.out.println("They do not match");
        			tempCardArray.removeAllElements();
        			switchUnfitPairs(cardA, cardB);
        			// TODO swith every card that is not contained in flipped pairs
        		}
            }
          });
		timer.setRepeats(false);
		timer.start();
		
	}

	
	/**
	 * The method calls the <code>switchFace()</code>-Method of two cards.
	 * 
	 * @param cardA
	 * @param cardB
	 */
	private void switchUnfitPairs(BaseCard cardA, BaseCard cardB) {
		cardA.switchFace();
		cardB.switchFace();		
	}
}
