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
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import fonts.FontRegular;

/**
 * @author yume
 *
 */
public class PhotoChooserFrame extends JFrame {

	private int numberOfCards, numberOfPhotos, thumbPreviewSize, thumbMemorySize, loadedImages;
	private Vector<JLabel> photoLabelVector;
	private JPanel photoPanel, chooserPanel, chooserPanelTop, chooserPanelBottom;
	private JButton jbtLoadImages, jbtStartGame;
	private JFileChooser photoChooser;
	private JFrame thisFrame = this;
	private Vector<File> chosenFiles;
	private Vector<BufferedImage> memoryCardPhotos;
	private JLabel jlMessage;
	private String startMessage;

	private FontRegular fontRegular = new FontRegular(14);
	private FontRegular fontRegularSmall = new FontRegular(12);

	public PhotoChooserFrame(int numberOfCards) {
		this.numberOfCards = numberOfCards;
		this.numberOfPhotos = numberOfCards / 2;
		this.startMessage = "Your cards are now set. You can start the game."; // default value
		this.loadedImages = 0;

		this.memoryCardPhotos = new Vector<BufferedImage>();
		this.photoLabelVector = new Vector<JLabel>();
		for (int i = 0; i < numberOfPhotos; i++) {
			photoLabelVector.add(new JLabel());
		}

		this.setSize(720, 500);
		this.setLocation(453, 0); // placing it right next to the main Memory-Frame to not cover it
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());

		createPhotoPanel();
		createChooserPanel();

		this.add(photoPanel, BorderLayout.CENTER);
		this.add(chooserPanel, BorderLayout.SOUTH);

		this.setResizable(false);
		this.setVisible(true);
	}

	/**
	 * The method returns an instance of <code>JPanel</code> that has a
	 * <code>GridLayout</code> and an <code>EmptyBorder</code>. The
	 * <code>GridLayout</code> will be set by calling the method
	 * <code>setGridLayout</code>.
	 * 
	 * @return photoPanel an instance of <code>JPanel</code>
	 * 
	 * @see gui.PhotoChooserFrame#setGridLayout(int)
	 */
	private JPanel createPhotoPanel() {
		photoPanel = new JPanel();
		photoPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		photoPanel.setLayout(setGridLayout(numberOfPhotos));

		return photoPanel;
	}

	/**
	 * The method adds files which are passed to the method in an array of
	 * <code>File</code-objects into a vector.
	 * The method sets the number of still required files and then adds
	 * the amount of files into the vector.
	 * 
	 * The method will not load every file into the vector. It will only load
	 * the amount of files that are required to reach the maximum amount
	 * of <code>numberOfPhotos</code>
	 * 
	 * @param filesToAdd an Array of File-objects that have to be added to the
	 *                   <code>chosenFiles</code>-Vector.
	 * 
	 * @see gui.PhotoChooserFrame#numberOfPhotos
	 * @see gui.PhotoChooserFrame#chosenFiles
	 */
	private void addFileToVector(File[] filesToAdd) {
		if (filesToAdd != null && filesToAdd.length > 0) {
			int requiredImages = numberOfPhotos - chosenFiles.size();
			if (filesToAdd.length > requiredImages) {
				startMessage = "Too many images selected. The program will use the first " + requiredImages
						+ " images. " + startMessage;
			}
			for (int i = 0; i < requiredImages; i++) {
				for (File file : filesToAdd) {
					// Prevent the program to load too many files into choseFiles-Vector
					if (requiredImages > 0) {
						if (!chosenFiles.contains(file)) {
							chosenFiles.add(file);
							requiredImages--;
						}
					}
				}
			}
		}
	}

	/**
	 * The method returns an instance of <code>JPanel</code> that has a
	 * <code>BorderLayout</code> and an <code>EmptyBorder</code>.
	 * 
	 * The panel adds another two instance of <code>JPanel</code>, by callint the
	 * methode <code>getChooserPanelTop()</code> and
	 * <code>getChooserPanelBottom</code>
	 * 
	 * @return chooserPanel an instance of <code>JPanel</code>
	 * 
	 * @see gui.PhotoChooserFrame#getChooserPanelTop()
	 * @see gui.PhotoChooserFrame#getChooserPanelBottom()
	 */
	private JPanel createChooserPanel() {
		chooserPanel = new JPanel();
		chooserPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		chooserPanel.setLayout(new BorderLayout());

		chooserPanel.add(getChooserPanelTop(), BorderLayout.CENTER);
		chooserPanel.add(getChooserPanelBottom(), BorderLayout.SOUTH);

		return chooserPanel;
	}

	/**
	 * The method returns an instance of <code>JPanel</code>, that has two
	 * <code>JButton</code>s on it. One of the buttons starts the game, another
	 * button opens a <code>JFileChooser</code> and lets the player choose images
	 * from the filesystem.
	 * 
	 * @return chooserPanelTop an instance of <code>JPanel</code>
	 * 
	 * @see javax.swing.JFileChooser
	 */
	private JPanel getChooserPanelTop() {
		chooserPanelTop = new JPanel();
		// creating the button to load images (opens JFileChooser)
		jbtLoadImages = new JButton("Load Images");
		jbtLoadImages.setFont(fontRegular);
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
		jbtStartGame.setFont(fontRegular);
		jbtStartGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Vector<BufferedImage> resizedImages = new Vector<BufferedImage>();
				for (BufferedImage photo : memoryCardPhotos) {
					resizedImages.add(resizePhoto(photo, thumbMemorySize));
				}
				thisFrame.dispose();
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						new StartMemory(numberOfCards, 2, resizedImages);
					}
				});
			}
		});
		jbtStartGame.setEnabled(false);
		chooserPanelTop.add(jbtStartGame);

		// creating and setting the JFileChooser
		photoChooser = new JFileChooser(".");
		FileNameExtensionFilter extensionFiler = new FileNameExtensionFilter("images", "jpg", "png", "gif", "jpeg");
		photoChooser.setAcceptAllFileFilterUsed(false);
		photoChooser.setMultiSelectionEnabled(true);
		photoChooser.setFileFilter(extensionFiler);
		chosenFiles = new Vector<File>();

		return chooserPanelTop;
	}

	/**
	 * The method returns an instance of <code>JPanel</code>, that has a
	 * <code>JLabel</code> on it. This Label is used to synamically display messages
	 * and instructions for the user.
	 * 
	 * @return chooserPanelBottom an instance of <code>JPanel</code>
	 * 
	 */
	private JPanel getChooserPanelBottom() {
		chooserPanelBottom = new JPanel();

		// creating message with instructions
		jlMessage = new JLabel("Please choose " + numberOfPhotos + " unique photos form your file system");
		jlMessage.setFont(fontRegularSmall);
		chooserPanelBottom.add(jlMessage);

		return chooserPanelBottom;

	}

	/**
	 * The method creates a <code>BufferedImage</code> of a given File, crops it by
	 * calling the method <code>cropPhoto()</code>, resized it by calling the method
	 * <code> resizePhoto</code> and displays it on the photoPanel. The method saves
	 * a cropped, but not resized version of the image in a vector that will later
	 * be used to pass to the game itself.
	 * 
	 * @param fieldNo   int-value that represents the place where image will be
	 *                  displayed in the <code>GridLayout</code>
	 * @param photoFile <code>File</code>-object that will be loaded as a
	 *                  <code>BufferedImage</code>
	 * 
	 * @see java.awt.image.BufferedImage
	 * @see gui.PhotoChooserFrame#memoryCardPhotos
	 * @see gui.PhotoChooserFrame#photoPanel
	 * 
	 */
	public void setPhoto(int fieldNo, File photoFile) {
		try {
			BufferedImage photo = ImageIO.read(photoFile);
			BufferedImage croppedPhoto = cropPhoto(photo);
			memoryCardPhotos.add(croppedPhoto); // adding the cropped version into vector
			BufferedImage resizedPhoto = resizePhoto(croppedPhoto, thumbPreviewSize);
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

	/**
	 * The method returns an instance of <code>BufferedImage</code> that is a
	 * cropped version of the original which is passed as a parameter. The cropped
	 * area within the image varies depending on the format of the image.
	 * 
	 * @param originalPhoto image with original format
	 * @return cropped version of the original image
	 */
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

	/**
	 * The method returns an instance of <code>BufferedImage</code> that is a
	 * resized version of the original which is passed as a parameter. The new size
	 * of the image depends on thumbPreviewSize, which is set according to the
	 * amount of cards that will be used in the game.
	 * 
	 * @param originalPhoto image with original format
	 * @return resized version of the original image
	 * 
	 * @see gui.PhotoChooserFrame#thumbPreviewSize
	 */
	private BufferedImage resizePhoto(BufferedImage originalPhoto, int thumbSize) {
		this.thumbPreviewSize = thumbSize;
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

	/**
	 * The method sets different texts in the status-panel and calls the method
	 * <code>fillPhotoPanel()</code> to fill the panel with the images. The method
	 * further sets the buttons enabled or disabled according to the game's needs.
	 * 
	 * @see gui.PhotoChooserFrame#fillPhotoPanel()
	 * 
	 */
	private void handleLoadedFiles() {
		if (chosenFiles.size() == numberOfPhotos) {
			jlMessage.setText(startMessage);
			fillPhotoPanel();
			jbtStartGame.setEnabled(true);
			jbtLoadImages.setEnabled(false);
		} else {
			if (chosenFiles.size() < numberOfPhotos) {
				jlMessage.setText("Please choose another " + (numberOfPhotos - chosenFiles.size())
						+ " photos from your filesystem.");
			}
			fillPhotoPanel();
		}
	}

	/**
	 * The method sets a GridLayout for the JPanel regarding the amount of photos
	 * used in the game.
	 * 
	 * @param numberOfPhotos number of photos for the game
	 * 
	 * @see gui.PhotoChooserFrame#setPhoto(int, File)
	 */
	private GridLayout setGridLayout(int numberOfPhotos) {
		switch (numberOfPhotos) {
		case 8:
			thumbPreviewSize = 150;
			thumbMemorySize = 146;
			return new GridLayout(2, 4, 7, 7);
		case 10:
			thumbPreviewSize = 120;
			thumbMemorySize = 130;
			return new GridLayout(2, 5, 7, 7);
		case 15:
			thumbPreviewSize = 120;
			thumbMemorySize = 110;
			return new GridLayout(3, 5, 7, 7);
		default:
			return null;
		}
	}

	private void fillPhotoPanel() {
		for (int i = loadedImages; i < chosenFiles.size(); i++) {
			setPhoto(loadedImages, chosenFiles.elementAt(loadedImages));
			loadedImages++;
		}

	}
}
