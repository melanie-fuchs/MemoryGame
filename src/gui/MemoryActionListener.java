package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Hashtable;

import model.BaseModel;

/**
 * The class implements <code>ActionListener</code> and will be used as listener of the memory-cards
 * @author yume
 *
 */
public class MemoryActionListener implements ActionListener {

	/**
	 * <code>HashTable</code>-object that contains memory-cards
	 */
	private Hashtable<Integer, BaseModel> modelHashtable;
	/**
	 * <code>MemoryStatsPanel</code>-object that represents a passive panel
	 */
	private MemoryStatsPanel passivePanel;

	/**
	 * Constructor that instantiates the <code>HashTable</code>, sets the passive
	 * panel and calls the method <code>addModel</code>.
	 * 
	 * @param model        An instance of a model of type <code>BaseModel</code>
	 * @param passivePanel An instance of <code>MemoryStatsPanel</code>
	 */
	public MemoryActionListener(BaseModel model, MemoryStatsPanel passivePanel) {
		this.passivePanel = passivePanel;
		modelHashtable = new Hashtable<Integer, BaseModel>();
		this.addModel(model);
	}

	/**
	 * The method adds the passed model into the <code>HashMap</code>
	 * 'modelHashTable'. The hashcode of the object will be used as key.
	 * 
	 * @param model An instance of a model of type <code>BaseModel</code>
	 */
	private void addModel(BaseModel model) {
		Integer key = model.hashCode();
		modelHashtable.put(key, model);
	}

	/**
	 * The method determines the object which triggered the call of the method and
	 * calls methods of this objects.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// get hashCode of the pressed card:
		int hashCode = e.getSource().hashCode();

		Enumeration<Integer> enuma = modelHashtable.keys();
		while (enuma.hasMoreElements()) {
			// execute method action of every model in the HashMap:
			int key = enuma.nextElement();
			(modelHashtable.get(key)).action(hashCode);

			// update JLabels in MemoryStatsPanel:
			int attempts = (modelHashtable.get(key)).getAttempts();
			passivePanel.setAttemptsLabel(attempts);

			int foundPairs = (modelHashtable.get(key)).getPairsFound();
			passivePanel.setPairsFound(foundPairs);

			double ratio = (modelHashtable.get(key)).getRatio();
			passivePanel.setRatio(ratio);

			int totalPairs = (modelHashtable.get(key)).getAllMemoryCardsSize() / 2;

			if (totalPairs - foundPairs == 0) {
				passivePanel.setGameOver();
			}
		}
	}
}
