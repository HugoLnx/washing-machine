package com.hugolnx.washing.machine;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class WashMachineWaterLevel {
	final int X = 250;
	final int Y = 260;
	final int MAX_HEIGHT = 100;
	final int WIDTH = 30;
	final int TRANSITION_SPEED = 1;
	int waterLevel = 0;
	int showingWaterLevel = 0;
	
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
		graphics2d.drawRect(X, Y, WIDTH, MAX_HEIGHT);
	}

	private void drawWithWaterLevel(Graphics2D graphics2d, int waterLevel) {
		graphics2d.setColor(new Color(0, 200, 255));
		int height = waterLevel*(MAX_HEIGHT/100);
		graphics2d.fillRect(X, Y+MAX_HEIGHT-height, WIDTH, height);
	}
}
