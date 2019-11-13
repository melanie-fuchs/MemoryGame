package model;

/**
 * <code>interface</code>-model that can be implemented by memory-models
 * @author yume
 *
 */
public interface BaseModel {
	
	/**
	 * The Method is invoked by an <code>ActionListener</code> of a card.
	 * It handles events on the cards.
	 * 
	 * @param hashCodeOfTrigger	int-value that represents the cashCode of an
	 * object that triggered the action.
	 * 
	 * @see java.awt.event.ActionListener
	 */
	void action(int hashCodeOfTrigger);
	
	/**
	 * The method returns the number (int value) of attempts
	 */
	int getAttempts();
	
	/**
	 * The method returns the number (int value) of successfully revealed pairs
	 */
	int getPairsFound();

	/**
	 * The method returns % (int value) of successfully revealed cards
	 */
	public int getRatio();

	/**
	 * The method returns an int value that represents the amount of cards that are
	 * contained in the <code>HashMap</code> 'allMemoryCards'.
	 * 
	 * @return int-value that represents the number of cards that 'allMemoryCards'
	 * contains
	 */
	int getAllMemoryCardsSize();
}
