package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.Timer;

import gui.BaseCard;

/**
 * Model-class for the Memory-Game. The class is used to handle the events when
 * cards are being clicked.
 * 
 * @author yume
 *
 */
public class MemoryModel implements BaseModel {

	/**
	 * The number of attempts (number of pairs revealed no matter if they matched or not)
	 */
	private int attempts = 0;
	
	/**
	 * The method returns the number (int value) of attempts
	 * 
	 * @return the number of attempts
	 */
	public int getAttempts() {
		return attempts;
	}

	/**
	 * The number of successfully revealed pairs of cards
	 */
	private int foundPairs = 0;
	
	/**
	 * The method returns the number (int value) of successfully revealed pairs
	 * 
	 * @return the number of found pairs
	 */
	public int getPairsFound() {
		return foundPairs;
	}
	
	/**
	 * Vector-Object that is used to collect two cards (type <code>BaseCard</code>)
	 * to later check them for unity.
	 */
	private Vector<BaseCard> tempCardArray;
	
	/**
	 * Vector-Object that is used to collect flipped pairs of memory-cards (type 
	 * <code>BaseCard</code>) to later check if the game is over or not by comparing it's size
	 * with the number of cards in the game.
	 */
	private Vector<BaseCard> flippedPairs;
	
	/**
	 * Hashmap-Object that contains every card of the game (type <code>BaseCard</code>)
	 */
	private HashMap<Integer, BaseCard> allMemoryCards;
	/**
	 * The method returns an int value that represents the amount of cards that are
	 * contained in the <code>HashMap</code> 'allMemoryCards'.
	 * 
	 * @return int-value that represents the number of cards that 'allMemoryCards'
	 * contains
	 */
	public int getAllMemoryCardsSize() {
		return allMemoryCards.size();
	}
		
	/**
	 * Constructor that creates instances of the card-Vectors.
	 */
	public MemoryModel() {
		tempCardArray = new Vector<BaseCard>();
		flippedPairs = new Vector<BaseCard>();
		allMemoryCards = new HashMap<Integer, BaseCard>();
	}
	
	/**
	 * The Method takes an Integer (hashCode of a <code>BaseCard</code>-object) as parameter
	 * and returns the belonging object from the <code>HashMap</code> 'allMemoryCards'.
	 * 
	 * @param hashCode hashCode of an object as <code>Integer</code>-value
	 * @return object of type BaseCard that belongs to the given hashcode
	 */
	public BaseCard getMemoryCard(Integer hashCode) {
		return allMemoryCards.get(hashCode);
	}	
	
	/**
	 * The method registers a card of type <code>BaseCard</code> in the
	 * <code>HashMap</code> 'allMemoryCards'.
	 * 
	 * @param card Card-Ooject of type <code>BaseCard</code>
	 */
	public void registerCard(BaseCard card) {
		allMemoryCards.put(card.hashCode(), card);
	}
	
	/**
	 * The Method is invoked by an <code>ActionListener</code> of a card.
	 * It handles events on the cards.
	 * 
	 * @param hashCode	int-value that represents the cashCode of an object
	 * 
	 * @see java.awt.event.ActionListener
	 */
	@Override
	public void action(int hashCode) {
		BaseCard tempCard = getMemoryCard(hashCode);
		tempCard.switchFace();
		tempCard.setEnabled(false);
		tempCardArray.add(tempCard);
		if(tempCardArray.size() == 2){
			this.checkPairs();
		}
	}
	
	/**
	 * The method compares two cards by comparing the cardID of the objects.
	 * Depending on whether the two cards are identical, different parameters are
	 * used to call the <code>handleFlippedCards()</code>-method.
	 * Every card is being set disabled to prevent the player from pushing cards
	 * while the operations are still running in the background.
	 */
	private void checkPairs() {
		for (BaseCard card : allMemoryCards.values()) {
			card.setEnabled(false);
		}
		this.attempts += 1;

		BaseCard cardA = tempCardArray.elementAt(0);
		BaseCard cardB = tempCardArray.elementAt(1);
		if (cardA.getCardID() == cardB.getCardID()) {
			foundPairs += 1;
			this.handleFlippedCards(cardA, cardB, true, 400);
		} else {
			this.handleFlippedCards(cardA, cardB, false, 1000);
		}
	}

	
	/**
	 * The method performs operations based on whether a pair was found or
	 * not. If a pair was found, it will be saved in the vector <code>flippedPairs</code>
	 * and the cards will be set disabled.  If no pair was found, all of the cards (except
	 * the ones saved in the vector for already successfully flipped pairs) will be
	 * set enabled and the two cards are covered again. The Method uses a timer to improve
	 * the feel of the game.
	 * 
	 * @param cardA <BaseCard</code>-object, the first card in the temporary flipped
	 * cards-Vector: <code>tempCardsArray</code>
	 * @param cardB <BaseCard</code>-object, the second card in the temporary flipped
	 * cards-Vector: <code>tempCardsArray</code>
	 * @param pairFound boolean value that is true, if a pair was found and false if not
	 * @param sleepMillis int-value that represents the time that the program sleeps
	 * in milliseconds
	 */
	private void handleFlippedCards(BaseCard cardA, BaseCard cardB,
			boolean pairFound, int sleepMillis) {
		Timer timer = new Timer(sleepMillis, new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
        		if (pairFound) {
        			flippedPairs.add(cardA);
        			flippedPairs.add(cardB);
        			for(BaseCard card : allMemoryCards.values()) {
        				if(!flippedPairs.contains(card)) {
        					card.setEnabled(true);
        				}
        			}
        			tempCardArray.removeAllElements();
        		} else {
        			// enable every card that is not contained in flipped pairs:
        			for(BaseCard card : allMemoryCards.values()) {
        				if(!flippedPairs.contains(card)) {
        					card.setEnabled(true);
        				}
        			}
        			cardA.switchFace();
        			cardB.switchFace();
        			tempCardArray.removeAllElements();
        		}
            }
          });
		timer.setRepeats(false);
		timer.start();		
	}
}
