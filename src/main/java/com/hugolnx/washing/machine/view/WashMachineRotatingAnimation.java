package com.hugolnx.washing.machine.view;

import java.awt.Graphics2D;

import com.hugolnx.washing.machine.view.utils.Images;

public class WashMachineRotatingAnimation {
	private static final int ANIMATION_SIZE = 3;
	int speed = 1; // animation frames per second
	int frame = 0;
	int animationFrame = 0;
	boolean playing = false;
	
	public void stop() {
		playing = false;
	}
	
	public void playCentrifuging() {
		speed = 20;
		updateFrame();
		playing = true;
	}
	

	public void playWatering() {
		speed = 10;
		updateFrame();
		playing = true;
	}
	
	public void updateAndDraw(Graphics2D graphics2d) {
		if(playing) frame = frame + 1;
		animationFrame = (frame / (PaintLoop.FPS/speed)) % ANIMATION_SIZE;
		graphics2d.drawImage(Images.getWashingMachineImage(animationFrame), 0, 0, 289, 289, null);
	}

	private void updateFrame() {
		frame = animationFrame*speed;
	}

}
