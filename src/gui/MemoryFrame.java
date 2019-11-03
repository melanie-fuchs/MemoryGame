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
	
	private int memorySize, gameMode;
	private MemoryCardPanel memoryCardPanel;
	private MemoryStatsPanel memoryStatsPanel;
	
	public MemoryFrame(int memorySize, int gameMode, Vector<BaseCard> cards) {
		super("Memory");
		this.memorySize = memorySize;
		this.gameMode = gameMode;
		if(memorySize == 16) {
			this.setSize(650, 800);
		} else {
			this.setSize(720, 750);
		}
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		memoryStatsPanel = new MemoryStatsPanel(this, gameMode, memorySize);
		memoryCardPanel = new MemoryCardPanel(memorySize, cards, memoryStatsPanel);
		
		this.add(memoryCardPanel, BorderLayout.CENTER);
		this.add(memoryStatsPanel, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
}
