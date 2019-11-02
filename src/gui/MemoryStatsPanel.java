/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * Class that handles the settings within a started memory-game.
 * @author yume
 *
 */
public class MemoryStatsPanel extends JPanel {
	
	private String attempts = "";

	private JButton jbEndGame;
	private JLabel jlAttemptsText, jlAttemptsCounter;
	private JFrame parentFrame;
	
	
	public MemoryStatsPanel(JFrame parentFrame) {
		this.parentFrame = parentFrame;
		this.setLayout(new GridLayout(2, 3, 60, 5));
		this.setBorder(new EmptyBorder(10, 10, 15, 10));
		jbEndGame = new JButton("End Game");
		jbEndGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int close = JOptionPane.showConfirmDialog(parentFrame, "Do you want to end this round?",
						"Close Memory Window",  JOptionPane.YES_NO_OPTION,
					      JOptionPane.PLAIN_MESSAGE);
				if(close == 0) {
					parentFrame.dispose();
				}
				if(close == 1) {
					return;
				}
			}
		});
		jlAttemptsText= new JLabel("Attempts: ", SwingConstants.CENTER);
		jlAttemptsCounter = new JLabel("0", SwingConstants.CENTER);
		
		this.add(jlAttemptsText);
		this.add(new JLabel(""));	// dummy
		this.add(new JLabel(""));	// dummy
		this.add(jlAttemptsCounter);
		this.add(new JLabel(""));	// dummy
		this.add(jbEndGame);
	}
	
	public void setAttemptsLabel(int att) {
		attempts = String.valueOf(att);
		jlAttemptsCounter.setText(attempts);
	}
}
