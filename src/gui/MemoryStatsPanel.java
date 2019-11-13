package gui;

import java.awt.BorderLayout;
import java.awt.Color;
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

import fonts.FontBold;
import fonts.FontRegular;
import fonts.FontTitle;

/**
 * The class extends <code>JPanel</code> and handles the settings within a started memory-game.
 * 
 * @author yume
 *
 */
public class MemoryStatsPanel extends JPanel {
	private static final long serialVersionUID = 7254027254289317759L;

	/**
	 * String that is used to display the number of attempts
	 */
	private String attempts = "";

	/**
	 * String that is used to display the number of successfully revealed pairs
	 */
	private String pairsFound = "";

	/**
	 * String that is used to display the ratio (attempts / found pairs)
	 */
	private String ratio = "";

	/**
	 * int-value that represents the total number of cards in the game
	 */
	private int gameSize;

	/**
	 * int-value that represents the game-mode
	 */
	private int gameMode;

	/**
	 * <code>JPanel</code>-object that contains components to display the stats of
	 * the game
	 */
	private JPanel statsPanel;

	/**
	 * <code>JPanel</code>-object that contains components to display the cards of
	 * the game
	 */
	private JPanel gameOverPanel;

	/**
	 * <code>JButton</code>-object that ends the game
	 */
	private JButton jbEndGame;

	/**
	 * <code>JLabel</code>-object to display text
	 */
	private JLabel jlAttemptsText;

	/**
	 * <code>JLabel</code>-object to display the number of attempts
	 */
	private JLabel jlAttemptsCounter;

	/**
	 * <code>JLabel</code>-object to display text
	 */
	private JLabel jlPairsFoundText;

	/**
	 * <code>JLabel</code>-object to display the number of found pairs
	 */
	private JLabel jlPairsFoundCounter;

	/**
	 * <code>JLabel</code>-object to display text
	 */
	private JLabel jlRatioText;

	/**
	 * <code>JLabel</code>-object to display the number of found pairs
	 */
	private JLabel jlRatioCounter;

	/**
	 * <code>JLabel</code>-object to display a message when the game is over
	 */
	private JLabel jlGameOver;

	/**
	 * <code>JFrame</code>-object that represents the parent-frame
	 */
	private JFrame parentFrame;

	/**
	 * Method that returns the parentFrame
	 * 
	 * @return <code>JFrame</code>-object that represents the parent-frame
	 */
	public JFrame getParentFrame() {
		return parentFrame;
	}

	/**
	 * <code>FontRegular</code>-object to set regular text
	 */
	private FontRegular fontRegular = new FontRegular(14);

	/**
	 * <code>FontRegular</code>-object to set regular text
	 */
	private FontRegular fontStats = new FontRegular(20);

	/**
	 * <code>FontRegular</code>-object to set bold text
	 */
	private FontBold fontBold = new FontBold(14);

	/**
	 * The constructor sets the parentFrame, game-mode and game-size and adds
	 * components.
	 * 
	 * @param parentFrame <code>JFrame</code>-object that represents the
	 *                    parent-frame
	 * @param gameMode    int-value that represents the game-mode
	 * @param gameSize    int-value that represents the total amount of cards in the
	 *                    game
	 */
	public MemoryStatsPanel(JFrame parentFrame, int gameMode, int gameSize) {
		this.parentFrame = parentFrame;
		this.gameMode = gameMode;
		this.gameSize = gameSize;

		this.setLayout(new BorderLayout());

		this.add(createGameOverPanel(), BorderLayout.NORTH);
		this.add(createStatsPanel(), BorderLayout.CENTER);
	}

	/**
	 * The method creates a JPanel and fills it with labels and a button. The labels
	 * display the current number of attempts and found pairs and will be updated
	 * when ever a cards is switched. The button will close the frame after the
	 * player confirmed it. Once the round is over, the button will turn into a "try
	 * again"-button that restarts the game without changing the settings.
	 * 
	 * @return <code>JPanel</code>-object that represents the stats-panel of the
	 *         game
	 */
	private JPanel createStatsPanel() {
		statsPanel = new JPanel();
		statsPanel.setLayout(new GridLayout(2, 4, 60, 5));
		statsPanel.setBorder(new EmptyBorder(10, 10, 15, 10));
		jbEndGame = new JButton(Messages.getString("MemoryStatsPanel.buttonEndGame")); //$NON-NLS-1$
		jbEndGame.setFont(fontRegular);
		jbEndGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (((JButton) e.getSource()).getText() == Messages.getString("MemoryStatsPanel.buttonEndGame")) { //$NON-NLS-1$
					int close = JOptionPane.showConfirmDialog(getParentFrame(), Messages.getString("MemoryStatsPanel.confirmDialogDoYouWantToEndThisRound"), //$NON-NLS-1$
							Messages.getString("MemoryStatsPanel.confirmDialogCloseMemoryWindow"), JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE); //$NON-NLS-1$
					if (close == 0) {
						parentFrame.dispose();
					}
					if (close == 1) {
						return;
					}
				} else {
					if (((JButton) e.getSource()).getText() == Messages.getString("MemoryStatsPanel.buttonPlayAgain")) { //$NON-NLS-1$
						if (gameMode == 1) { // if Player played with colors
							new StartMemory(gameSize, gameMode);
						} else { // if player played with images
							new PhotoChooserFrame(gameSize);
						}
						parentFrame.dispose();
					}
				}

			}
		});
		jlAttemptsText = new JLabel(Messages.getString("MemoryStatsPanel.labelAttempts"), SwingConstants.CENTER); //$NON-NLS-1$
		jlAttemptsText.setFont(fontBold);
		jlAttemptsCounter = new JLabel("0", SwingConstants.CENTER);
		jlAttemptsCounter.setFont(fontStats);
		jlPairsFoundText = new JLabel(Messages.getString("MemoryStatsPanel.labelFoundPairs"), SwingConstants.CENTER); //$NON-NLS-1$
		jlPairsFoundText.setFont(fontBold);
		jlPairsFoundCounter = new JLabel("0", SwingConstants.CENTER);
		jlPairsFoundCounter.setFont(fontStats);
		jlRatioText = new JLabel("Ratio:", SwingConstants.CENTER);
		jlRatioText.setFont(fontBold);
		jlRatioCounter = new JLabel("", SwingConstants.CENTER);
		jlRatioCounter.setFont(fontStats);

		statsPanel.add(jlAttemptsText);
		statsPanel.add(jlPairsFoundText);
		statsPanel.add(jlRatioText);
		statsPanel.add(new JLabel("")); // dummy
		statsPanel.add(jlAttemptsCounter);
		statsPanel.add(jlPairsFoundCounter);
		statsPanel.add(jlRatioCounter);
		statsPanel.add(jbEndGame);

		return statsPanel;
	}

	/**
	 * The method creates a <code>JPanel</code>-object with a single
	 * <code>JLabel</code>-object on it. This label displays a message once the game
	 * is over.
	 * 
	 * @return <code>JPanel</code>-object that displays a message once the game is
	 *         over
	 */
	private JPanel createGameOverPanel() {
		gameOverPanel = new JPanel();
		gameOverPanel.setBorder(new EmptyBorder(0, 10, 0, 10));
		jlGameOver = new JLabel(" ");
		jlGameOver.setFont(new FontTitle(50));

		gameOverPanel.add(jlGameOver, SwingConstants.CENTER);

		return gameOverPanel;
	}

	/**
	 * The method sets displays a message once the game is over and changes the 'End
	 * Game'-button to a 'Play Again'-button.
	 */
	public void setGameOver() {
		jlGameOver.setText(Messages.getString("MemoryStatsPanel.labelCongratulationsYouWon")); //$NON-NLS-1$
		jlGameOver.setForeground(Color.WHITE);
		jlGameOver.setOpaque(true);
		jlGameOver.setBackground(Color.BLACK);
		gameOverPanel.setOpaque(true);
		gameOverPanel.setBackground(Color.BLACK);
		jbEndGame.setText(Messages.getString("MemoryStatsPanel.buttonPlayAgain")); //$NON-NLS-1$
	}

	/**
	 * The method updates the text of the <code>JLabel</code>-object
	 * 'jlAttemptsCounter' and displays the current amount of attempts taken.
	 * 
	 * @param att int-value that represents the current amount of attempts
	 */
	public void setAttemptsLabel(int att) {
		attempts = String.valueOf(att);
		jlAttemptsCounter.setText(attempts);
	}

	/**
	 * The method updates the text of the <code>JLabel</code>-object
	 * 'jlPairsFoundCounter' and displays the current amount of found pairs.
	 * 
	 * @param pairs int-value that represents the current number of found pairs
	 */
	public void setPairsFound(int pairs) {
		pairsFound = String.valueOf(pairs);
		jlPairsFoundCounter.setText(pairsFound);
	}

	/**
	 * The method updates the text of the <code>JLabel</code>-object
	 * 'jlRatio' and displays the current ration of successfully revealed cards.
	 *
	 * @param r int-value that represents the current ratio
	 */
	public void setRatio(double r) {
		ratio = String.valueOf(r);
		jlRatioCounter.setText(ratio);
	}
}
