/**
 * 
 */
package gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author yume
 *
 */
public class PhotoPanel extends JPanel {
	
	private int numberOfCards;
	private int numberOfPhotos;
	private Vector<JLabel> photoLabelVector;

	
	public void setPhoto(int fieldNo, File photoFile) {
		try {
			BufferedImage photo = ImageIO.read(photoFile);
			(photoLabelVector.elementAt(fieldNo)).setIcon(new ImageIcon(photo));
		} catch (IOException e) {
			System.out.println("PhotoPanel.setPhoto(): loading image failed."
					+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	//TODO repaint after loading images
	
	public PhotoPanel(int numberOfCards) {
		photoLabelVector = new Vector<JLabel>();
		for(int i = 0; i < numberOfPhotos; i++) {
			photoLabelVector.add(new JLabel());
		}
		
		
		this.numberOfCards = numberOfCards;
		this.numberOfPhotos = numberOfCards / 2;
		
		this.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		fillPanel();
	}
	
	
	private void fillPanel() {
		
	}

}
