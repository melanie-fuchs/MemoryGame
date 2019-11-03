/**
 * 
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author yume
 *
 */
public class MemoryActionListener implements ActionListener {

	Hashtable<Integer, BaseModel> modelHashtable;
	MemoryStatsPanel passivePanel;
	
	public MemoryActionListener(BaseModel model, MemoryStatsPanel passivePanel) {
		this.passivePanel = passivePanel;
		modelHashtable = new Hashtable<Integer, BaseModel>();
		this.addModel(model);
	}
	
	public void addModel(BaseModel model) {
		Integer key = model.hashCode();
		modelHashtable.put(key, model);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//get hashCode of the pressed card and call action on it:
		int hashCode = ((BaseCard)e.getSource()).hashCode();
		
		Enumeration<Integer> enuma = modelHashtable.keys();
	    while (enuma.hasMoreElements()) {
	    	// execute method action of every model on the HashMap:
	         int key = enuma.nextElement();
	         ((BaseModel)modelHashtable.get(key)).action(hashCode);
	         
	 	    // update JLabel in MemoryStatsPanel:
	 		int attempts = ((BaseModel)modelHashtable.get(key)).getAttempts();
	 		passivePanel.setAttemptsLabel(attempts);
	 		
	 		int foundPairs = ((BaseModel)modelHashtable.get(key)).getPairsFound();
	 		passivePanel.setPairsFound(foundPairs);
	 	
	 		int totalPairs = ((BaseModel)modelHashtable.get(key)).getAllMemoryCardsSize() / 2;
	 		
	 		if(totalPairs - foundPairs == 0) {
	 			passivePanel.setGameOverLabel();
	 		}
	    }
	}
}
