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
		System.out.println(e.getSource());
		((BaseCard)e.getSource()).switchFace();

		//get ID of the pressed card:
		int cardID = ((BaseCard)e.getSource()).getCardID();
		model.action(cardID);

	}

}
