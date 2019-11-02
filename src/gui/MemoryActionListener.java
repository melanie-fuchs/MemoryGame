/**
 * 
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JLabel;

/**
 * @author yume
 *
 */
public class MemoryActionListener implements ActionListener {

	Hashtable<Integer, BaseModel> modelHashtable;
	
	public MemoryActionListener(BaseModel model) {
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
	         int key = enuma.nextElement();
	         ((BaseModel)modelHashtable.get(key)).action(hashCode);
	    }
	}
}
