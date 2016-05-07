package com.hugolnx.washing.machine.view.utils;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public abstract class Images {
	private static Image[] washingMachineImages = new Image[12];

	public static Image getWashingMachineImage(int inx) {
		if(washingMachineImages[inx] == null) {
			String imgName = String.format("maquina-%d.jpg", inx+1);
			washingMachineImages[inx] = imageFromURL(ImagesFinder.getImageURL(imgName));
		}
		return washingMachineImages[inx];
	}
	
	public static Image getWashingMachineMiddleImage() {
		return imageFromURL(ImagesFinder.getImageURL("washing-machine-small-middle-filled.png"));
	}

	private static Image imageFromURL(URL url) {
		return new ImageIcon(url).getImage();
	}

}

abstract class ImagesFinder {
	private static final String IMGS_FOLDER = "/";

	public static URL getImageURL(String imagePath) {
		String path = IMGS_FOLDER + imagePath;
		return getResourceURL(path);
	}

	private static URL getResourceURL(String path) {
		return new Object().getClass().getResource(path);
	}
}