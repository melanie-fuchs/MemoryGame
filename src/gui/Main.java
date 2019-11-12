package gui;

import fonts.FontTitle;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Main extends JFrame {
    private JPanel panel;
    private JButton buttonEnglish, buttonGerman;
    private JLabel labelMemory;

    public Main() {
        this.setSize(200, 150);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        labelMemory = new JLabel("Memory", SwingConstants.CENTER);
        labelMemory.setFont(new FontTitle(30));
        labelMemory.setBorder(new EmptyBorder(15, 10, 10, 10));
        this.add(labelMemory, BorderLayout.NORTH);

        this.add(createGUI(), BorderLayout.CENTER);
        this.setVisible(true);
    }

    private JPanel createGUI() {
        panel = new JPanel();

        buttonEnglish = new JButton();
        buttonEnglish.setIcon(new ImageIcon("icons\\en.png"));

        buttonGerman = new JButton();
        buttonGerman.setIcon(new ImageIcon("icons\\de.png"));

        panel.add(buttonEnglish);
        panel.add(buttonGerman);

        return panel;
    }

    public static  void main(String[] args) {
        new Main();
    }
}
