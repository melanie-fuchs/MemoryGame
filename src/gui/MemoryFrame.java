/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JFrame;

/**
 * @author yume
 *
 */
public class MemoryFrame extends JFrame {
	
	private int memorySize;
	private MemoryCardPanel memoryCardPanel;
	private MemoryStatsPanel memoryStatsPanel;
	
	public MemoryFrame(int memorySize, Vector<BaseCard> cards) {
		super("Memory");
		this.memorySize = memorySize;
		if(memorySize == 16) {
			this.setSize(650, 750);
		} else {
			this.setSize(720, 700);
		}
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		memoryStatsPanel = new MemoryStatsPanel(this);
		memoryCardPanel = new MemoryCardPanel(memorySize, cards, memoryStatsPanel);
		
		this.add(memoryCardPanel, BorderLayout.CENTER);
		this.add(memoryStatsPanel, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
}
