package gui;

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

public class GameSettingsGUI extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Font font = new Font("Arial", Font.PLAIN, 14);
	
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
	
	
	JLabel jlbCardSize, jlbVersion, jlbLoaded;
	JRadioButton jrbTen, jrbSixteen, jrbTwenty, jrbThirty;
	JButton jbStart, jbUseColors, jbChoseFiles;
	JPanel jRadioBoxes, jpButtons;
	
	public GameSettingsGUI() {
		this.setLayout(new GridLayout(1, 2, 10, 10));
		this.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
//		this.setLayout(new GridLayout());
		this.setSize(150, 150);
		
		this.add(createRadiobuttons());
		this.add(createButtons());
		
		this.setVisible(true);		
	}

	private Component createRadiobuttons() {
		jRadioBoxes = new JPanel();
		jRadioBoxes.setLayout(new GridLayout(5, 0, 2, 2));
		
		// create options for number of memory cards to play with:
		jlbCardSize = new JLabel("No. of Memory-Cards:");
		jrbTen = new JRadioButton("Ten");
		jrbSixteen = new JRadioButton("Sixteen");
		jrbTwenty = new JRadioButton("Twenty");
		jrbThirty = new JRadioButton("Thirty");
		
		// add fonts
		jrbTen.setFont(font);
		jrbSixteen.setFont(font);
		jrbTwenty.setFont(font);
		jrbThirty.setFont(font);
		
		// put it all together onto JPanel left
		jRadioBoxes.add(jlbCardSize);
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
		jlbVersion = new JLabel("Chose prefered version:");
		jbUseColors = new JButton("Use preset colors");
		jbChoseFiles = new JButton("Choose Photos");
		jlbLoaded = new JLabel(""); // TODO must set text as soon as Files are loaded
		jbStart = new JButton("Start Game");
		
		// set fonts
		jbUseColors.setFont(font);
		jbChoseFiles.setFont(font);
		jbStart.setFont(font);
		
		// add listeners to buttons
		jbUseColors.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("\"Use Colors\" chosen");
				setGameMode(1);
				jlbLoaded.setText("Mode \"Colors\" chosen");
				// TODO implement colors and stuff
			}
		});
		
		jbChoseFiles.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("\"Choose Files\" chosen");
				setGameMode(2);
				jlbLoaded.setText("Mode \"Photos\" chosen");
				// TODO implement Logic and JFileChooser here
			}
		});
		
		jbStart.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("\"Start\" pressed");
				switch(gameMode) {
				case 0:
					jlbLoaded.setText("Game-Mode must be set!");
				case 1:
					jlbLoaded.setText("Game-Mode");
					// TODO start game in COLORS mode
				case 2:
					jlbLoaded.setText("HELLO FROM THE OTheR sidE");
					// TODO start game in PHOTOS mode
				}
			}
		});
		
		// put it all together onto JPanel right
		jpButtons.add(jlbVersion);
		jpButtons.add(jbUseColors);
		jpButtons.add(jbChoseFiles);
		jpButtons.add(jlbLoaded);
		jpButtons.add(jbStart);	
		
		return jpButtons;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GameSettingsGUI();

	}

}
