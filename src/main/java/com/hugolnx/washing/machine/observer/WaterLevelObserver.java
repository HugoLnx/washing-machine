package com.hugolnx.washing.machine.observer;

import com.hugolnx.washing.machine.model.WashingMachineObserver;
import com.hugolnx.washing.machine.view.WashMachineWaterLevel;

public class WaterLevelObserver extends WashingMachineObserver {

	private WashMachineWaterLevel animation;

	public WaterLevelObserver(WashMachineWaterLevel animation) {
		this.animation = animation;
	}

	@Override
	public void waterLevelChange(int newLevel) {
		animation.set(newLevel);
	}
}
