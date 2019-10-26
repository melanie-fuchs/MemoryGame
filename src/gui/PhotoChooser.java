package gui;

import java.io.File;

import javax.swing.JFileChooser;

public class PhotoChooser extends JFileChooser {
	private File[] selectedFiles;
	
	public PhotoChooser() {
		super();
		this.setLocation(600, 600);
		
		
		selectedFiles = this.getSelectedFiles();
		System.out.println("selected Files: ");
		for(int i = 0; i < selectedFiles.length; i++) {
			System.out.print(selectedFiles[i] + " ");
		}
	}
	
	
}
