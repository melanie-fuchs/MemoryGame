/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
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
	private String pairsFound = "";

	private JPanel statsPanel, gameOverPanel;
	private JButton jbEndGame;
	private JLabel jlAttemptsText, jlAttemptsCounter, jlPairsFoundText,
		jlPairsFoundCounter, jlGameOver;
	private JFrame parentFrame;
	public JFrame getParentFrame() {
		return parentFrame;
	}
	
	public MemoryStatsPanel(JFrame parentFrame) {
		this.parentFrame = parentFrame;
		
		this.setLayout(new BorderLayout());
		
		this.createStatsPanel();
		this.createGameOverPanel();
		
		this.add(gameOverPanel, BorderLayout.NORTH);
		this.add(statsPanel, BorderLayout.CENTER);
	}
	
	private void createStatsPanel() {
		statsPanel = new JPanel();
		statsPanel.setLayout(new GridLayout(2, 4, 60, 5));
		statsPanel.setBorder(new EmptyBorder(10, 10, 15, 10));
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
		jlPairsFoundText = new JLabel("Found Pairs:", SwingConstants.CENTER);
		jlPairsFoundCounter = new JLabel("0", SwingConstants.CENTER);
		
		statsPanel.add(jlAttemptsText);
		statsPanel.add(jlPairsFoundText);
		statsPanel.add(new JLabel(""));	// dummy
		statsPanel.add(new JLabel(""));	// dummy
		statsPanel.add(jlAttemptsCounter);
		statsPanel.add(jlPairsFoundCounter);
		statsPanel.add(new JLabel(""));	// dummy
		statsPanel.add(jbEndGame);
	}
	
	private void createGameOverPanel() {
		gameOverPanel = new JPanel();
		jlGameOver = new JLabel(" ");
		jlGameOver.setFont(new Font("Arial", Font.BOLD, 40));
		
		gameOverPanel.add(jlGameOver, SwingConstants.CENTER);
	}
	
	public void setGameOverLabel() {
		jlGameOver.setText("Game Over");
		jlGameOver.setForeground(Color.WHITE);
		jlGameOver.setBackground(Color.BLACK);
	}
	
	public void setAttemptsLabel(int att) {
		attempts = String.valueOf(att);
		jlAttemptsCounter.setText(attempts);
	}
	
	public void setPairsFound(int pairs) {
		pairsFound = String.valueOf(pairs);
		jlPairsFoundCounter.setText(pairsFound);
	}
}
