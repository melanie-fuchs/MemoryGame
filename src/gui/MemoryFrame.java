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
		
		memoryCardPanel = new MemoryCardPanel(memorySize, cards);
		memorySettingPanel = new MemorySettingPanel();
		
		this.add(memoryCardPanel, BorderLayout.CENTER);
		this.add(memorySettingPanel, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	
	//TODO for test purposes only 
	public static void main(String[] args) {
		Vector<BaseCard> cards = new Vector<BaseCard>();
		for(int i = 0; i < 16; i++) {
			cards.add(new CardColor(Color.GREEN, Color.BLACK, i));
		}
		
		new MemoryFrame(16, cards);
	}
}
