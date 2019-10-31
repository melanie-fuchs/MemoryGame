/**
 * 
 */
package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Class that handles the settings within a started memory-game.
 * @author yume
 *
 */
public class MemorySettingPanel extends JPanel {
	
	private String attempts;
	private void setAttempts(int attempts) {
		this.attempts = String.valueOf(attempts);
	}
	private JButton jbEndGame;
	private JLabel jlAttemptsText, jlAttemptsCounter;
	
	public MemorySettingPanel() {
		this.setLayout(new GridLayout(2, 3, 60, 5));
		jbEndGame = new JButton("End Game");
		jlAttemptsText= new JLabel("Attempts: ", SwingConstants.CENTER);
		jlAttemptsCounter = new JLabel(attempts, SwingConstants.CENTER);
		
		this.add(jlAttemptsText);
		this.add(new JLabel(""));	// dummy
		this.add(new JLabel(""));	// dummy
		this.add(jlAttemptsCounter);
		this.add(new JLabel(""));	// dummy
		this.add(jbEndGame);
	}

}
