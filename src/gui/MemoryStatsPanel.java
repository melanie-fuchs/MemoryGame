/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
	
	private int gameSize;
	private int gameMode;
	
	private JPanel statsPanel, gameOverPanel;
	private JButton jbEndGame;
	private JLabel jlAttemptsText, jlAttemptsCounter, jlPairsFoundText,
		jlPairsFoundCounter, jlGameOver;
	private JFrame parentFrame;
	public JFrame getParentFrame() {
		return parentFrame;
	}
	
	public MemoryStatsPanel(JFrame parentFrame, int gameMode, int gameSize) {
		this.parentFrame = parentFrame;
		this.gameMode = gameMode;
		this.gameSize = gameSize;
		
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
				if (((JButton)e.getSource()).getText() == "End Game") {
					int close = JOptionPane.showConfirmDialog(parentFrame, "Do you want to end this round?",
							"Close Memory Window",  JOptionPane.YES_NO_OPTION,
						      JOptionPane.PLAIN_MESSAGE);
					if(close == 0) {
						parentFrame.dispose();
					}
					if(close == 1) {
						return;
					}
				} else {
					if (((JButton)e.getSource()).getText() == "Play Again") {
						new StartMemory(gameSize, gameMode);
						parentFrame.dispose();
					}
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
		gameOverPanel.setBorder(new EmptyBorder(0, 10, 0, 10));
		jlGameOver = new JLabel(" ");
		jlGameOver.setFont(new Font("Arial Narrow", Font.BOLD, 50));
		
		gameOverPanel.add(jlGameOver, SwingConstants.CENTER);
	}
	
	public void setGameOver() {
		jlGameOver.setText("Game Over");
		jlGameOver.setForeground(Color.WHITE);
		jlGameOver.setOpaque(true);
		jlGameOver.setBackground(Color.BLACK);
		gameOverPanel.setOpaque(true);
		gameOverPanel.setBackground(Color.BLACK);
		jbEndGame.setText("Play Again");
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
