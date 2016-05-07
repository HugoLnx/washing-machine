package com.hugolnx.washing.machine.observer;

import com.hugolnx.washing.machine.model.WashingMachineObserver;
import com.hugolnx.washing.machine.view.WashMachineRotatingAnimation;

public class RotatingObserver extends WashingMachineObserver {
	private WashMachineRotatingAnimation animation;

	public RotatingObserver(WashMachineRotatingAnimation animation) {
		this.animation = animation;
	}

	@Override
	public void washing() {
		animation.playWatering();
	}
	
	@Override
	public void centrifuging() {
		animation.playCentrifuging();
	}
	
	@Override
	public void stopped() {
		animation.stop();
	}
}
