package com.hugolnx.washing.machine.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class ScreenPanel extends JPanel {
	private WashMachineRotatingAnimation rotationAnimation;
	private WashMachineWaterLevel waterLevelAnimation;

	public ScreenPanel(WashMachineRotatingAnimation animation, WashMachineWaterLevel waterLevelAnimation) {
		this.setSize(289, 400);
		this.setPreferredSize(new Dimension(289,400));
		this.rotationAnimation = animation;
		this.waterLevelAnimation = waterLevelAnimation;
	}
	
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D graphics2d = (Graphics2D) graphics;
		rotationAnimation.updateAndDraw(graphics2d);
		waterLevelAnimation.updateAndDraw(graphics2d);
	}
}