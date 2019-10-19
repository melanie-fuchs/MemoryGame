package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
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

public class GameSettingsGUI extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Font fontRegular = new Font("Arial", Font.PLAIN, 14);
	private Font fontBold = new Font("Arial", Font.BOLD, 14);	
	
	private JLabel jlbNumberOfCards, jlbChooseMode, jlbChosenMode;
	private JRadioButton jrbTen, jrbSixteen, jrbTwenty, jrbThirty;
	private JButton jbStart, jbUseColors, jbChoseFiles;
	private JPanel jRadioBoxes, jpButtons;
	
	/**
	 * A static variable that represents the number of memory cards to play
	 * with. Default value is 0. The value can be set by pressing one of the
	 * radiobuttons.
	 */
	private int numberOfCards = 0;
	private void setNumberOfCards(int number) {this.numberOfCards = number;}
	public int getNumberOfCards() {return numberOfCards;}
	
	/**
	 * int -value that represents a game-mode. The game-mode can be either 0
	 * (if not set yet), 1 (if mode "colors" is chosen) or 2 (if mode "photos"
	 * is chosen). 
	 */
	private int gameMode = 0;
	private void setGameMode(int gameMode) {this.gameMode = gameMode;}
	public int getGameMode() {return gameMode;}

	
	public GameSettingsGUI() {
		this.setLayout(new GridLayout(1, 2, 10, 10));
		this.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
//		this.setSize(150, 150);
		
		this.add(createRadiobuttons());
		this.add(createButtons());
		
		this.setVisible(true);		
	}

	private Component createRadiobuttons() {
		jRadioBoxes = new JPanel();
		jRadioBoxes.setLayout(new GridLayout(5, 0, 2, 2));
		
		// create options for number of memory cards to play with:
		jlbNumberOfCards = new JLabel("No. of Memory-Cards:");
		jlbNumberOfCards.setFont(fontBold);
		jrbTen = new JRadioButton("Ten");
		jrbSixteen = new JRadioButton("Sixteen");
		jrbTwenty = new JRadioButton("Twenty");
		jrbThirty = new JRadioButton("Thirty");
		
		// add fonts
		jrbTen.setFont(fontRegular);
		jrbSixteen.setFont(fontRegular);
		jrbTwenty.setFont(fontRegular);
		jrbThirty.setFont(fontRegular);
		
		// put it all together onto JPanel left
		jRadioBoxes.add(jlbNumberOfCards);
		jRadioBoxes.add(jrbTen);
		jRadioBoxes.add(jrbSixteen);
		jRadioBoxes.add(jrbTwenty);
		jRadioBoxes.add(jrbThirty);
		
		ButtonGroup group = new ButtonGroup();
		group.add(jrbTen);
		group.add(jrbSixteen);
		group.add(jrbTwenty);
		group.add(jrbThirty);
		
		// add ActionListeners to RadioButtons
		jrbTen.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				setNumberOfCards(10);
			}
		});
		
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
				jbUseColors.setFont(fontBold);
				jbChoseFiles.setFont(fontRegular);
				jlbChosenMode.setForeground(Color.BLACK);
				jlbChosenMode.setText("");
				// TODO implement colors and stuff
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
				// TODO implement Logic and JFileChooser here
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
					break;
					// TODO start game in COLORS mode
				case 2:
					jlbChosenMode.setText("");
					jlbChosenMode.setForeground(Color.BLACK);
					break;
					// TODO start game in PHOTOS mode
				}
			}
		});
		
		// put it all together onto JPanel right
		jpButtons.add(jlbChooseMode);
		jpButtons.add(jbUseColors);
		jpButtons.add(jbChoseFiles);
		jpButtons.add(jlbChosenMode);
		jpButtons.add(jbStart);	
		
		return jpButtons;		
	}
}
