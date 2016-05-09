package com.hugolnx.washing.machine.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class ScreenPanel extends JPanel {
	private WashMachineRotatingAnimation rotationAnimation;
	private WashMachineWaterLevel waterLevelAnimation;

	public ScreenPanel() {
		this.setSize(289, 289);
		this.setPreferredSize(new Dimension(289,289));
		this.rotationAnimation = new WashMachineRotatingAnimation();
		this.waterLevelAnimation = new WashMachineWaterLevel();
	}
	
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D graphics2d = (Graphics2D) graphics;
		getRotationAnimation().updateAndDraw(graphics2d);
		getWaterLevelAnimation().updateAndDraw(graphics2d);
	}

	public WashMachineRotatingAnimation getRotationAnimation() {
		return rotationAnimation;
	}

	public WashMachineWaterLevel getWaterLevelAnimation() {
		return waterLevelAnimation;
	}
}