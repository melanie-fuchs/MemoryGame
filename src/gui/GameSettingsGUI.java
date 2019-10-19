package gui;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameSettingsGUI extends JPanel {
	private static final long serialVersionUID = 1L;
	
	JLabel jlbCardSize, jlbVersion, jlbLoaded;
	JCheckBox jcbTen, jcbSixteen, jcbTwenty, jcbThirty;
	JButton jbStart, jbUseColors, jbChoseFiles;
	JPanel jpCheckboxes, jpButtons;
	
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
		jpCheckboxes = new JPanel();
		jpCheckboxes.setLayout(new GridLayout(5, 0, 2, 2));
		
		// create options for number of memory cards to play with:
		jlbCardSize = new JLabel("No. of Memory-Cards:");
		jcbTen = new JCheckBox("Ten");
		jcbSixteen = new JCheckBox("Sixteen");
		jcbTwenty = new JCheckBox("Twenty");
		jcbThirty = new JCheckBox("Thirty");
		
		// put it all together onto JPanel left
		jpCheckboxes.add(jlbCardSize);
		jpCheckboxes.add(jcbTen);
		jpCheckboxes.add(jcbSixteen);
		jpCheckboxes.add(jcbTwenty);
		jpCheckboxes.add(jcbThirty);
		
		return jpCheckboxes;
		
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
