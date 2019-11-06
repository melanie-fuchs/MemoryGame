/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
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

	private int numberOfCards, numberOfPhotos, thumbSize;
	private Vector<JLabel> photoLabelVector;
	private JPanel photoPanel, chooserPanel, chooserPanelTop, chooserPanelBottom;
	private JButton jbtLoadImages, jbtStartGame;
	private JFileChooser photoChooser;
	private JFrame thisFrame = this;
	private Vector<File> chosenFiles;
	private Vector<BufferedImage> memoryCardPhotos;
	private JLabel jlMessage;

	public PhotoChooserFrame(int numberOfCards) {
		this.numberOfCards = numberOfCards;
		this.numberOfPhotos = numberOfCards / 2;

		this.memoryCardPhotos = new Vector<BufferedImage>();
		this.photoLabelVector = new Vector<JLabel>();
		for (int i = 0; i < numberOfPhotos; i++) {
			photoLabelVector.add(new JLabel());
		}

		this.setSize(720, 500);
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

		return photoPanel;
	}

	private void addFileToVector(File[] filesToAdd) {
		if (filesToAdd != null && filesToAdd.length > 0) {
			for (File file : filesToAdd) {
				if (!chosenFiles.contains(file)) {
					chosenFiles.add(file);
					System.out.println(file.hashCode() + " added");
				}
			}
		}
	}

	private JPanel createChooserPanel() {
		chooserPanel = new JPanel();
		chooserPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		chooserPanel.setLayout(new BorderLayout());

		chooserPanel.add(getChooserPanelTop(), BorderLayout.CENTER);
		chooserPanel.add(getChooserPanelBottom(), BorderLayout.SOUTH);

		return chooserPanel;
	}

	private JPanel getChooserPanelTop() {
		chooserPanelTop = new JPanel();

		// creating the button to load images (opens JFileChooser)
		jbtLoadImages = new JButton("Load Images");
		jbtLoadImages.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (photoChooser.showOpenDialog(thisFrame) == JFileChooser.APPROVE_OPTION) {
					addFileToVector(photoChooser.getSelectedFiles());
					// clearing selection
					photoChooser.setSelectedFile(new File(""));
					photoChooser.setSelectedFiles(new File[] { new File("") });

					handleLoadedFiles();
				}
			}
		});
		chooserPanelTop.add(jbtLoadImages);

		// creating the button to start the game. Will be set disabled while
		// required numbers of photos is not loaded.
		jbtStartGame = new JButton("Start Game");
		jbtStartGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Start the game
				// resize every item of memoryCardPhotos to memoryCard-size
				Vector<BufferedImage> resizedImages = new Vector<BufferedImage>();
				for(BufferedImage photo : memoryCardPhotos) {
					resizedImages.add(resizePhoto(photo, 200));
				}
				System.out.println("Game should start now");
				new StartMemory(numberOfCards, 2, resizedImages);
			}
		});
		jbtStartGame.setEnabled(false); // TODO enable once all photos are set
		chooserPanelTop.add(jbtStartGame);

		// creating and setting the JFileChooser
		photoChooser = new JFileChooser("C:\\Users\\yume\\Pictures\\javatests"); // TODO remove directory
		FileNameExtensionFilter extensionFiler = new FileNameExtensionFilter("images", "jpg", "png", "gif", "jpeg");
		photoChooser.setAcceptAllFileFilterUsed(false);
		photoChooser.setMultiSelectionEnabled(true);
		photoChooser.setFileFilter(extensionFiler);
		chosenFiles = new Vector<File>();

		return chooserPanelTop;
	}

	private JPanel getChooserPanelBottom() {
		chooserPanelBottom = new JPanel();

		// creating message with instructions
		jlMessage = new JLabel("Please choose " + numberOfPhotos + " unique photos form your file system");
		chooserPanelBottom.add(jlMessage);

		return chooserPanelBottom;
	}

	public void setPhoto(int fieldNo, File photoFile) {
		try {
			BufferedImage photo = ImageIO.read(photoFile);
			BufferedImage croppedPhoto = cropPhoto(photo);
			memoryCardPhotos.add(croppedPhoto); // adding the cropped version into vector
			BufferedImage resizedPhoto = resizePhoto(croppedPhoto, thumbSize);
			JLabel tempLabel = photoLabelVector.elementAt(fieldNo);
			tempLabel.setIcon(new ImageIcon(resizedPhoto));
			tempLabel.setHorizontalAlignment(JLabel.CENTER);
			tempLabel.setVerticalAlignment(JLabel.CENTER);
			photoPanel.add(tempLabel);
		} catch (IOException e) {
			System.out.println("PhotoChooserFrame.setPhoto(): loading image failed." + e.getMessage());
			e.printStackTrace();
		}
	}

	private BufferedImage cropPhoto(BufferedImage originalPhoto) {
		int photoWidth = originalPhoto.getWidth();
		int photoHeight = originalPhoto.getHeight();
		BufferedImage croppedImage;
		if (photoHeight == photoWidth) {
			croppedImage = originalPhoto;
			return croppedImage;
		} else {
			if (photoHeight > photoWidth) {
				// cropping the photo, set square in the top half of the image
				int cropY = (photoHeight - photoWidth) / 4;
				croppedImage = originalPhoto.getSubimage(0, cropY, photoWidth, photoWidth);
				return croppedImage;
			} else {
				if (photoHeight < photoWidth) {
					// cropping the photo centered, full height
					int cropX = (photoWidth - photoHeight) / 2;
					croppedImage = originalPhoto.getSubimage(cropX, 0, photoHeight, photoHeight);
					return croppedImage;
				}
			}
		}
		return null;
	}

	private BufferedImage resizePhoto(BufferedImage originalPhoto, int thumbSize) {
		this.thumbSize = thumbSize;
		if (originalPhoto != null) {
			BufferedImage resizedImage = new BufferedImage(thumbSize, thumbSize, originalPhoto.getType());
			Graphics2D graphic = resizedImage.createGraphics();
			graphic.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			graphic.drawImage(originalPhoto, 0, 0, thumbSize, thumbSize, 0, 0, originalPhoto.getWidth(),
					originalPhoto.getHeight(), null);
			graphic.dispose();
			return resizedImage;
		}
		return null;

	}

	private void handleLoadedFiles() {
		if (chosenFiles.size() == numberOfPhotos) {
			jlMessage.setText("Your cards are now set. You can start the game.");
			fillPhotoPanel();
			jbtStartGame.setEnabled(true);
		} else {
			if (chosenFiles.size() > numberOfPhotos) {
				jlMessage.setText("You chose too many photos. The first " + numberOfPhotos
						+ " of the selected photos will be used." + " You can start the game now.");
				// removing items so the vector contains only the required number of photos:
				while (chosenFiles.size() > numberOfPhotos) {
					chosenFiles.remove(numberOfPhotos);
				}
				fillPhotoPanel();
				jbtStartGame.setEnabled(true);
			} else {
				if (chosenFiles.size() < numberOfPhotos) {
					jlMessage.setText("Please choose another " + (numberOfPhotos - chosenFiles.size())
							+ " photos from your filesystem.");
				}
			}
		}
	}

	/**
	 * The method sets a GridLayout for the JPanel regarding the amount of photos
	 * used in the game.
	 * 
	 * @param numberOfPhotos number of photos for the game
	 */
	private GridLayout setGridLayout(int numberOfPhotos) {
		switch (numberOfPhotos) {
		case 8:
			thumbSize = 150;
			return new GridLayout(2, 4, 7, 7);
//			break;
		case 10:
			thumbSize = 120;
			return new GridLayout(2, 5, 7, 7);
//			break;
		case 15:
			thumbSize = 120;
			return new GridLayout(3, 5, 7, 7);
//			break;
		default:
			return null;
		}
	}

	private void fillPhotoPanel() {
		for (int i = 0; i < numberOfPhotos; i++) {
			setPhoto(i, chosenFiles.elementAt(i));
		}
	}

	public static void main(String[] args) {
		new PhotoChooserFrame(16);

	}
}
