/**
 * 
 */
package gui;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author yume
 *
 */
public class PhotoChooserFrame extends JFrame {
    private int gameSize;
    private JPanel photoPanel, chooserPanel;
    
    public PhotoChooserFrame(int gameSize) {
	this.gameSize = gameSize;
	
	this.setSize(720, 750);
	this.setLocation(400, 0);
	
	createPhotoPanel(gameSize);
	createChooserPanel();
	
	this.setVisible(true);
    }

    
    private void createPhotoPanel(int gameSize) {
	photoPanel = new JPanel();
	photoPanel.setLayout(new GridLayout());
	photoPanel.setBorder(new EmptyBorder(10, 10, 15, 10));
	photoPanel.setLayout(new GridLayout(5, 6, 7, 7));
	for(int i = 0; i < gameSize; i++) {
	    photoPanel.add(comp)
	}
    }
    
    private void createChooserPanel() {
	chooserPanel = new JPanel();	
    }
}
