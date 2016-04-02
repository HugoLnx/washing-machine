package com.hugolnx.washing.machine.view.utils;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public abstract class Resources {
	private static Image[] washingMachineImages = new Image[12];

	public static Image getWashingMachineImage(int inx) {
		if(washingMachineImages[inx] == null) {
			String imgName = String.format("washing-machine-%d.png", inx+1);
			washingMachineImages[inx] = imageFromURL(ResourcesFinder.getImageURL(imgName));
		}
		return washingMachineImages[inx];
	}
	
	public static Image getWashingMachineMiddleImage() {
		return imageFromURL(ResourcesFinder.getImageURL("washing-machine-small-middle-filled.png"));
	}

	private static Image imageFromURL(URL url) {
		return new ImageIcon(url).getImage();
	}

}

