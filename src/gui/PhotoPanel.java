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
	private JLabel 	photo0,
					photo1,
					photo2,
					photo3,
					photo4,
					photo5,
					photo6,
					photo7,
					photo8,
					photo9,
					photo10,
					photo11,
					photo12,
					photo13,
					photo14;
	
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
		photoLabelVector.add(photo0 = new JLabel());
		photoLabelVector.add(photo1 = new JLabel());
		photoLabelVector.add(photo2 = new JLabel());
		photoLabelVector.add(photo3 = new JLabel());
		photoLabelVector.add(photo4 = new JLabel());
		photoLabelVector.add(photo5 = new JLabel());
		photoLabelVector.add(photo6 = new JLabel());
		photoLabelVector.add(photo7 = new JLabel());
		photoLabelVector.add(photo8 = new JLabel());
		photoLabelVector.add(photo9 = new JLabel());
		photoLabelVector.add(photo10 = new JLabel());
		photoLabelVector.add(photo11 = new JLabel());
		photoLabelVector.add(photo12 = new JLabel());
		photoLabelVector.add(photo13 = new JLabel());
		photoLabelVector.add(photo14 = new JLabel());
		
		this.numberOfCards = numberOfCards;
		this.numberOfPhotos = numberOfCards / 2;
		
		this.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		fillPanel();
	}
	
	
	private void fillPanel() {
		
	}

}
