package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import fonts.FontBold;
import fonts.FontRegular;
import fonts.FontTitle;

/**
 * The class extends <code>JPanel</code> and displays the game-settings
 * @author yume
 *
 */
public class GameSettingsGUI extends JPanel {
	private static final long serialVersionUID = 8656127665527890300L;

	/**
	 * <code>JLabel</code>-object, that represents the total amount of cards that
	 * will be used in the game
	 */
	private JLabel jlbNumberOfCards;
	/**
	 * <code>JLabel</code>-object, that will be used to display text
	 */
	private JLabel jlbChooseMode;
	/**
	 * <code>JLabel</code>-object, that will be used to display text
	 */
	private JLabel jlbChosenMode;
	/**
	 * <code>JRadioButton</code>-object, that will be used to display a
	 * selection-option of a radio-button-group
	 */
	private JRadioButton jrbSixteen;
	/**
	 * <code>JRadioButton</code>-object, that will be used to display a
	 * selection-option of a radio-button-group
	 */
	private JRadioButton jrbTwenty;
	/**
	 * <code>JRadioButton</code>-object, that will be used to display a
	 * selection-option of a radio-button-group
	 */
	private JRadioButton jrbThirty;
	/**
	 * <code>JButton</code>-object, that will be used to start the game
	 */
	private JButton jbStart;
	/**
	 * <code>JButton</code>-object, that will be used to select the game-mode
	 */
	private JButton jbUseColors;
	/**
	 * <code>JButton</code>-object, that will be used to start the game
	 */
	private JButton jbChoseFiles;
	/**
	 * <code>JPanel</code>-object, that will be filled with RadioButtons and a Label
	 */
	private JPanel jRadioBoxes;
	/**
	 * <code>JPanel</code>-object, that will be filled with Buttons and Labels
	 */
	private JPanel jpButtons;
	/**
	 * <code>JTextField</code>-object that displays information and instructions
	 */
	private JTextField jtfStatus;

	/**
	 * <code>FontRegular</code>-object, that will be used to set the regular font
	 * 
	 * @see fonts.FontRegular
	 */
	private FontRegular fontRegular = new FontRegular(14);
	/**
	 * <code>FontRegular</code>-object, that will be used to set the bold font
	 * 
	 * @see fonts.FontRegular
	 */
	private FontBold fontBold = new FontBold(14);

	/**
	 * A static variable that represents the number of memory cards to play with.
	 * Default value is 20. The value can be set by pressing one of the
	 * radiobuttons.
	 */
	private int numberOfCards = 20;

	/**
	 * The method sets the value of the variable 'numberOfCards"
	 * 
	 * @param number int-value that represents the total amount of cards that will
	 *               be used in the game
	 */
	private void setNumberOfCards(int number) {
		this.numberOfCards = number;
	}

	/**
	 * The method returns the value of the cariable 'numberOfCards'
	 * 
	 * @return int-value that represents the total number of cards
	 */
	public int getNumberOfCards() {
		return numberOfCards;
	}

	/**
	 * int-value that represents a game-mode. The game-mode can be either 0 (if not
	 * set yet), 1 (if mode "colors" is chosen) or 2 (if mode "photos" is chosen).
	 */
	private int gameMode = 0;

	/**
	 * The method is used to set the game-mode
	 * 
	 * @param gameMode int-value that represents the game-mode
	 */
	private void setGameMode(int gameMode) {
		this.gameMode = gameMode;
	}

	/**
	 * The method returns the game-mode
	 * 
	 * @return int-value that represents the game-mode
	 */
	public int getGameMode() {
		return gameMode;
	}

	/**
	 * The constructor adds components the the panel on a borderlayout.
	 */
	public GameSettingsGUI() {
		this.setLayout(new BorderLayout());

		this.add(title(), BorderLayout.NORTH);
		this.add(settings(), BorderLayout.CENTER);
		this.add(status(), BorderLayout.SOUTH);
	}

	/**
	 * The method creates a <code>JLabel</code> and returns this label
	 * 
	 * @return a JLabel
	 */
	private JLabel title() {
		JLabel jlbTitleSettings = new JLabel("Settings", SwingConstants.CENTER);
		jlbTitleSettings.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		jlbTitleSettings.setFont(new FontTitle(28));

		return jlbTitleSettings;
	}

	/**
	 * The method creates a <code>JPanel</code> to display the gamesettings and
	 * returns it
	 * 
	 * @return a <code>JPanel</code>-object
	 */
	private JPanel settings() {
		JPanel settingPanel = new JPanel();
		settingPanel.setLayout(new GridLayout(1, 2, 10, 10));
		settingPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		// fill JPanel with radiobuttons and buttons;
		settingPanel.add(createRadiobuttons());
		settingPanel.add(createButtons());

		return settingPanel;
	}

	/**
	 * The method creates a <code>JTextField</code> that represents a status-bar for
	 * the gamesettings
	 * 
	 * @return <code>JTextField</code>-object
	 */
	private JTextField status() {
		jtfStatus = new JTextField("");
		jtfStatus.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 10));
		jtfStatus.setEditable(false);
		jtfStatus.setForeground(Color.WHITE);
		jtfStatus.setBackground(Color.BLACK);

		return jtfStatus;
	}

	/**
	 * The method creates a JPanel and adds Radiobuttons on it. The radiobuttons are
	 * grouped and each of the options is connected to an ActionListener. Depending
	 * on which radiobutton was clicked, the parameter passed to the
	 * <code>setNumberOfCards</code> varies
	 * 
	 * @return <code>Component</code>-object that contains radiobuttons and a title
	 */
	private Component createRadiobuttons() {
		jRadioBoxes = new JPanel();
		jRadioBoxes.setLayout(new GridLayout(5, 0, 2, 2));

		// create options for number of memory cards to play with:
		jlbNumberOfCards = new JLabel("No. of Memory-Cards:");
		jlbNumberOfCards.setFont(fontBold);
		jrbSixteen = new JRadioButton("Sixteen");
		jrbTwenty = new JRadioButton("Twenty");
		jrbThirty = new JRadioButton("Thirty");

		// add fonts
		jrbSixteen.setFont(fontRegular);
		jrbTwenty.setFont(fontRegular);
		jrbThirty.setFont(fontRegular);

		// put it all together onto JPanel left
		jRadioBoxes.add(jlbNumberOfCards);
		jRadioBoxes.add(jrbSixteen);
		jRadioBoxes.add(jrbTwenty);
		jRadioBoxes.add(jrbThirty);
		jRadioBoxes.add(new JLabel("")); // dummy

		ButtonGroup group = new ButtonGroup();
		group.add(jrbSixteen);
		group.add(jrbTwenty);
		group.add(jrbThirty);

		jrbSixteen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setNumberOfCards(16);
			}
		});

		jrbTwenty.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setNumberOfCards(20);
			}
		});

		jrbThirty.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setNumberOfCards(30);
			}
		});

		return jRadioBoxes;

	}

	/**
	 * The method creates a JPanel and adds Buttons on it. The method handles events
	 * on the buttons. It checks if the required setting are made and informs the
	 * user if not.
	 * 
	 * @return <code>Component</code>-object that contains buttons and a title
	 */
	private Component createButtons() {
		jpButtons = new JPanel();
		jpButtons.setLayout(new GridLayout(5, 0, 2, 2));

		// create buttons
		jlbChooseMode = new JLabel("Choose preferred version:");
		jlbChooseMode.setFont(fontBold);
		jbUseColors = new JButton("Use Preset Colors");
		jbChoseFiles = new JButton("Choose Photos");
		jlbChosenMode = new JLabel("");
		jlbChosenMode.setFont(fontBold);
		jbStart = new JButton("Start Game");

		// set fonts
		jbUseColors.setFont(fontRegular);
		jbChoseFiles.setFont(fontRegular);
		jbStart.setFont(fontRegular);

		// add listeners to buttons
		jbUseColors.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setGameMode(1);
				jtfStatus.setText("");
				jbUseColors.setFont(fontBold);
				jbChoseFiles.setFont(fontRegular);
				jlbChosenMode.setForeground(Color.BLACK);
				jlbChosenMode.setText("");
			}
		});

		jbChoseFiles.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setGameMode(2);
				jbChoseFiles.setFont(fontBold);
				jbUseColors.setFont(fontRegular);
				jlbChosenMode.setForeground(Color.BLACK);
				jlbChosenMode.setText("");
				jtfStatus.setText("You will choose images from your filesystem");
			}
		});

		jbStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (gameMode) {
				case 0:
					jlbChosenMode.setText("Game-Mode must be set!");
					jlbChosenMode.setForeground(Color.RED);
					break;
				case 1:
					jlbChosenMode.setText("");
					jlbChosenMode.setForeground(Color.BLACK);
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							new StartMemory(numberOfCards, gameMode);
						}
					});
					break;
				case 2:
					jlbChosenMode.setText("");
					jlbChosenMode.setForeground(Color.BLACK);
					new PhotoChooserFrame(numberOfCards);
					break;
				}
			}
		});

		// put it all together onto JPanel
		jpButtons.add(jlbChooseMode);
		jpButtons.add(jbUseColors);
		jpButtons.add(jbChoseFiles);
		jpButtons.add(jlbChosenMode);
		jpButtons.add(jbStart);

		return jpButtons;
	}
}
