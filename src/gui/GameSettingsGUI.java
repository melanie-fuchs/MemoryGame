package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
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

public class GameSettingsGUI extends JPanel {
	private static final long serialVersionUID = 1L;
	

	private Font fontTitle = new Font("Arial", Font.BOLD, 24);
	private Font fontRegular = new Font("Arial", Font.PLAIN, 14);
	private Font fontBold = new Font("Arial", Font.BOLD, 14);	
	
	private JLabel jlbNumberOfCards, jlbChooseMode, jlbChosenMode;
	private JRadioButton jrbSixteen, jrbTwenty, jrbThirty;
	private JButton jbStart, jbUseColors, jbChoseFiles;
	private JPanel jRadioBoxes, jpButtons;
	private JTextField jtfStatus;
	
	/**
	 * A static variable that represents the number of memory cards to play
	 * with. Default value is 20. The value can be set by pressing one of the
	 * radiobuttons.
	 */
	private int numberOfCards = 20;
	private void setNumberOfCards(int number) {
		this.numberOfCards = number;
		}
	public int getNumberOfCards() {
		return numberOfCards;
		}
	
	/**
	 * int-value that represents a game-mode. The game-mode can be either 0
	 * (if not set yet), 1 (if mode "colors" is chosen) or 2 (if mode "photos"
	 * is chosen). 
	 */
	private int gameMode = 0;
	private void setGameMode(int gameMode) {this.gameMode = gameMode;}
	public int getGameMode() {return gameMode;}

	
	public GameSettingsGUI() {
		this.setLayout(new BorderLayout());

		this.add(title(), BorderLayout.NORTH);
		this.add(settings(), BorderLayout.CENTER);
		this.add(status(), BorderLayout.SOUTH);
		
		this.setVisible(true);		
	}
	private JLabel title() {
		JLabel jlbTitleSettings = new JLabel("Settings", SwingConstants.CENTER);
		jlbTitleSettings.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		jlbTitleSettings.setFont(fontTitle);
		
		return jlbTitleSettings;		
	}
	
	private JPanel settings() {
		JPanel settingPanel = new JPanel();
		settingPanel.setLayout(new GridLayout(1, 2, 10, 10));
		settingPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		// fill JPanel with radiobuttons and buttons;
		settingPanel.add(createRadiobuttons());
		settingPanel.add(createButtons());
		
		return settingPanel;
	}
	
	private JTextField status() {
		jtfStatus = new JTextField("");
		jtfStatus.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 10));
		jtfStatus.setEditable(false);
		jtfStatus.setForeground(Color.WHITE);
		jtfStatus.setBackground(Color.BLACK);
		
		return jtfStatus;		
	}

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
		jRadioBoxes.add(new JLabel(""));			// dummy
		
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

	private Component createButtons() {
		jpButtons = new JPanel();
		jpButtons.setLayout(new GridLayout(5, 0, 2, 2));
		
		// create buttons 
		jlbChooseMode = new JLabel("Chose prefered version:");
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
				switch(gameMode) {
				case 0:
					jlbChosenMode.setText("Game-Mode must be set!");
					jlbChosenMode.setForeground(Color.RED);
					break;
				case 1:
					jlbChosenMode.setText("");
					jlbChosenMode.setForeground(Color.BLACK);
					new StartMemory(numberOfCards, gameMode);
					break;
				case 2:
					jlbChosenMode.setText("");
					jlbChosenMode.setForeground(Color.BLACK);
					new StartMemory(numberOfCards, gameMode);
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
