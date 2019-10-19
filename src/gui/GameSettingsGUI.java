package gui;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class GameSettingsGUI extends JPanel {
	private static final long serialVersionUID = 1L;
	
	JLabel jlbCardSize, jlbVersion, jlbLoaded;
	JRadioButton jrbTen, jrbSixteen, jrbTwenty, jrbThirty;
	JButton jbStart, jbUseColors, jbChoseFiles;
	JPanel jRadioBoxes, jpButtons;
	
	public GameSettingsGUI() {
		this.setLayout(new GridLayout(1, 2, 10, 10));
		this.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
//		this.setLayout(new GridLayout());
		this.setSize(150, 150);
		
		this.add(createCheckboxes());
		this.add(createButtons());
		
		this.setVisible(true);		
	}

	private Component createCheckboxes() {
		jRadioBoxes = new JPanel();
		jRadioBoxes.setLayout(new GridLayout(5, 0, 2, 2));
		
		// create options for number of memory cards to play with:
		jlbCardSize = new JLabel("No. of Memory-Cards:");
		jrbTen = new JRadioButton("Ten");
		jrbSixteen = new JRadioButton("Sixteen");
		jrbTwenty = new JRadioButton("Twenty");
		jrbThirty = new JRadioButton("Thirty");
		
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
		
		return jRadioBoxes;
		
	}

	private Component createButtons() {
		jpButtons = new JPanel();
		jpButtons.setLayout(new GridLayout(5, 0, 2, 2));
		
		// create buttons 
		jlbVersion = new JLabel("Chose prefered version:");
		jbUseColors = new JButton("Use preset colors");
		jbChoseFiles = new JButton("Personal Photos");
		jlbLoaded = new JLabel(""); // TODO must set text as soon as Files are loaded
		jbStart = new JButton("Start Game");
		
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
