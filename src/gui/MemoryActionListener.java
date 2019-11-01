/**
 * 
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author yume
 *
 */
public class MemoryActionListener implements ActionListener {

	MemoryModel model;
	
	public MemoryActionListener(MemoryModel model) {
		this.model = model;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		//get hashCode of the pressed card and call action on it:
		int hashCode = ((BaseCard)e.getSource()).hashCode();
		model.action(hashCode);
	}
}
