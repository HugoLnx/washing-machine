package com.hugolnx.washing.machine.view;

import java.awt.Graphics2D;

import com.hugolnx.washing.machine.view.utils.Resources;

public class WashMachineRotatingAnimation {
	private static final int ANIMATION_SIZE = 12;
	int speed = 1; // frames to next state
	int frame = 0;
	int animationFrame = 0;
	boolean playing = false;
	
	public void stop() {
		playing = false;
	}
	
	public void playCentrifuging() {
		speed = 2;
		updateFrame();
		playing = true;
	}
	

	public void playWatering() {
		speed = 7;
		updateFrame();
		playing = true;
	}
	
	public void updateAndDraw(Graphics2D graphics2d) {
		if(playing) frame = frame + 1;
		animationFrame = (frame / speed) % ANIMATION_SIZE;
		graphics2d.drawImage(Resources.getWashingMachineImage(animationFrame), 0, 0, 289, 400, null);
	}

	private void updateFrame() {
		frame = animationFrame*speed;
	}

}
