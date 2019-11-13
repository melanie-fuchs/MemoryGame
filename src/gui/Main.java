package gui;

import fonts.FontTitle;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The class extends <code>JFrame</code> and displays buttons to choose a
 * language.
 * 
 * @author yume
 *
 */
public class Main extends JFrame {
	private static final long serialVersionUID = -702599035722119310L;
	private JFrame thisFrame = this;
	
	/**
	 * The constructor sets the size and location of the window.
	 */
	public Main() {
		this.setSize(200, 150);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		JLabel labelMemory = new JLabel("Memory", SwingConstants.CENTER);
		labelMemory.setFont(new FontTitle(30));
		labelMemory.setBorder(new EmptyBorder(15, 10, 10, 10));
		this.add(labelMemory, BorderLayout.NORTH);

		this.add(createGUI(), BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	/**
	 * The method creates a <code>JPanel</code>, adds two buttons onto it and
	 * returns it. If a button is pressed, it's <code>ActionListener</code> will set
	 * the language by calling the static <code>setLanguage</code>-method of class
	 * Messages and then starts the memory-game.
	 * 
	 * @return a <code>JPanel</code>-object with buttons on it
	 */
	private JPanel createGUI() {
		JPanel panel = new JPanel();

		JButton buttonEnglish = new JButton();
		buttonEnglish.setIcon(new ImageIcon("icons\\en.png"));
		buttonEnglish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Messages.setLanguage("english");
				new Memory();
				thisFrame.dispose();
			}
		});

		JButton buttonGerman = new JButton();
		buttonGerman.setIcon(new ImageIcon("icons\\de.png"));
		buttonGerman.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Messages.setLanguage("german");
				new Memory();
				thisFrame.dispose();
			}
		});

		panel.add(buttonEnglish);
		panel.add(buttonGerman);

		return panel;
	}

	/**
	 * The method starts the game
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new Main();
	}
}
