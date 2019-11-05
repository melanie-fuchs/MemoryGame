/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
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
	private JPanel photoPanel, chooserPanel;

	
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
		
		this.chooserPanel = new JPanel();
		
		this.numberOfCards = numberOfCards;
		this.numberOfPhotos = numberOfCards / 2;
		
		
		createPhotoPanel();

		
		this.add(photoPanel, BorderLayout.CENTER);
		this.add(chooserPanel, BorderLayout.SOUTH);
	}
	
	
	private JPanel createPhotoPanel() {
		photoPanel = new JPanel();
		photoPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		photoPanel.setLayout(setGridLayout(numberOfPhotos));
		loadImages();
		
		return photoPanel;
	}
	
	
	private JPanel createChooserPanel() {
		chooserPanel = new JPanel();
		chooserPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		return chooserPanel;
		
	}
	/**
	 * The method sets a GridLayout for the JPanel regarding the amount
	 * of photos used in the game.
	 * 
	 * @param numberOfPhotos number of photos for the game
	 */
	private GridLayout setGridLayout(int numberOfPhotos) {
		switch (numberOfPhotos) {
		case 8:
			return new GridLayout(4, 2, 7, 7);
//			break;
		case 10:
			return new GridLayout(5, 2, 7, 7);
//			break;
		case 15:
			return new GridLayout(5, 3, 7, 7);
//			break;
		default:
			return null;
		}
	}
	
	private void loadImages() {
		
	}

}
