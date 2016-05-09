package com.hugolnx.washing.machine.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class WashMachineWaterLevel {
	private final double X = 250;
	private final double Y = 10;
	private final double MAX_HEIGHT = 250;
	private final double WIDTH = 30;
	private final double TRANSITION_SPEED = 1;
	private int waterLevel = 0;
	private double showingWaterLevel = 0;
	
	public void set(int waterLevel) {
		this.waterLevel = waterLevel;
	}

	public void updateAndDraw(Graphics2D graphics2d) {
		if(showingWaterLevel > waterLevel) {
			showingWaterLevel -= TRANSITION_SPEED;
		} else if (showingWaterLevel < waterLevel) {
			showingWaterLevel += TRANSITION_SPEED;
		}
		drawWithWaterLevel(graphics2d, showingWaterLevel);
		graphics2d.setColor(new Color(0, 80, 150));
		graphics2d.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		graphics2d.drawRect((int)X, (int)Y, (int)WIDTH, (int)MAX_HEIGHT);
	}

	private void drawWithWaterLevel(Graphics2D graphics2d, double waterLevel) {
		graphics2d.setColor(new Color(0, 200, 255));
		double height = waterLevel*(MAX_HEIGHT/100);
		graphics2d.fillRect((int)X, (int) (Y+MAX_HEIGHT-height), (int)WIDTH, (int) height);
	}
}
