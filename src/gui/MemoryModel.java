package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

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
	
	/**
	 * The Method is invoked by an <code>ActionListener</code> of a card.
	 * It handles events on the cards.
	 * 
	 * @param hashCode	int-value that represents the cashCode of an object
	 */
	@Override
	public void action(int hashCode) {
		BaseCard tempCard = getMemoryCard(hashCode);
		tempCard.switchFace();
		tempCard.setEnabled(false);
		tempCardArray.add(tempCard);
		System.out.println("CARD IS SWITCHED: " + tempCard.hashCode());
		if(tempCardArray.size() == 2){
			this.checkPairs();
		}
	}
	
	/**
	 * The method compares two cards by comparing the cardID of the objects.
	 * Depending on whether the two cards are identical, different parameters are
	 * used to call the <code>handleFlippedCards()</code>-Method.
	 * Every card is being set disabled to prevent the player from pushing cards
	 * while the operations are running in the background.
	 */
	private void checkPairs() {
		for (BaseCard card : allMemoryCards.values()) {
			card.setEnabled(false);
		}
		this.attempts += 1;

		BaseCard cardA = tempCardArray.elementAt(0);
		BaseCard cardB = tempCardArray.elementAt(1);
		if (cardA.getCardID() == cardB.getCardID()) {
			this.handleFlippedCards(cardA, cardB, true, 500);
		} else {
			this.handleFlippedCards(cardA, cardB, false, 1200);
		}
	}

	
	/**
	 * The method performs operations based on whether a pair was found or
	 * not. If a pair was found, it will be saved in the Vector <code>flippedPairs</code>
	 * and the card will be set disabled. All other cards will be set enabled. If no
	 * pair was found, all of the cards (except the ones saved in the Vector for already
	 * successfully flipped pairs) will be set enabled and the two cards are covered again.
	 * The Method uses a timer to improve the feel of the game.
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
        			System.out.println("They match");
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
        					System.out.println(card.hashCode());
        				}
        			}
        			System.out.println("They do not match");
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
