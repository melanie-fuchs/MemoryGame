/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Vector;

import javax.swing.JFrame;

/**
 * @author yume
 *
 */
public class MemoryFrame extends JFrame {
	
	private int memorySize;
	private MemoryCardPanel memoryCardPanel;
	private MemorySettingPanel memorySettingPanel;
	private MemoryModel model  = new MemoryModel();
	
	public MemoryFrame(int memorySize, Vector<BaseCard> cards) {
		super("Memory");
		this.memorySize = memorySize;
		if(memorySize == 16) {
			this.setSize(650, 750);
		} else {
			this.setSize(720, 700);
		}
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		memoryCardPanel = new MemoryCardPanel(memorySize, cards, model);
		memorySettingPanel = new MemorySettingPanel(this, model);
		
		this.add(memoryCardPanel, BorderLayout.CENTER);
		this.add(memorySettingPanel, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	
	public void gameOver() {
		// TODO layeredPane, show game ended message
	}
}
