package com.hugolnx.washing.machine.view.utils;

import java.net.URL;

public class ResourcesFinder {
	private static final String IMGS_FOLDER = "/";

	public static URL getImageURL(String imagePath) {
		String path = IMGS_FOLDER + imagePath;
		return getResourceURL(path);
	}

	private static URL getResourceURL(String path) {
		return new Object().getClass().getResource(path);
	}
}