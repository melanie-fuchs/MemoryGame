/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author yume
 *
 */
public class PhotoChooserFrame extends JFrame {
	
	private int numberOfCards;
	private int numberOfPhotos;
	private Vector<JLabel> photoLabelVector;
	private JPanel photoPanel, chooserPanel;
	private JButton jbtLoadImages, jbtStartGame;
	private JFileChooser photoChooser;
	private JFrame thisFrame = this;
	private Vector<File> chosenFiles;

	
	
	public PhotoChooserFrame(int numberOfCards) {
		this.numberOfCards = numberOfCards;
		this.numberOfPhotos = numberOfCards / 2;
		
		this.photoLabelVector = new Vector<JLabel>();
		for(int i = 0; i < numberOfPhotos; i++) {
			photoLabelVector.add(new JLabel());
		}

		this.setSize(720, 400);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		
		createPhotoPanel();
		createChooserPanel();
		
		this.add(photoPanel, BorderLayout.CENTER);
		this.add(chooserPanel, BorderLayout.SOUTH);
		
		this.setVisible(true);
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

		photoChooser = new JFileChooser();
		
		jbtLoadImages = new JButton("Load Images");
		jbtLoadImages.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				photoChooser.showOpenDialog(thisFrame);
			}
		});
		chooserPanel.add(jbtLoadImages);
	
		jbtStartGame = new JButton("Start Game");
		jbtStartGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jbtStartGame.setEnabled(false);
		chooserPanel.add(jbtStartGame);
		
		FileNameExtensionFilter extensionFiler = new
				FileNameExtensionFilter("images",  "jpg", "png", "gif", "jpeg");
		photoChooser.setFileFilter(extensionFiler);
		chosenFiles = new Vector<File>();
		// TODO fill 
		
		return chooserPanel;		
	}
	
	public void setPhoto(int fieldNo, File photoFile) {
		try {
			BufferedImage photo = ImageIO.read(photoFile);
			(photoLabelVector.elementAt(fieldNo)).setIcon(new ImageIcon(photo));
			(photoLabelVector.elementAt(fieldNo)).setHorizontalAlignment(JLabel.CENTER);
			(photoLabelVector.elementAt(fieldNo)).setVerticalAlignment(JLabel.CENTER);
		} catch (IOException e) {
			System.out.println("PhotoChooserFrame.setPhoto(): loading image failed."
					+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	//TODO repaint after loading images
	
	
	
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
	
	private void fillPhotoPanel() {
		for(int i = 0; i < numberOfPhotos; i++) {
			setPhoto(i, chosenFiles.elementAt(i));
		}
	}

	public static void main(String[] args) {
		new PhotoChooserFrame(16);
	}
}
