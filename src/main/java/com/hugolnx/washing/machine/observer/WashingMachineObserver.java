package com.hugolnx.washing.machine.observer;

public abstract class WashingMachineObserver {
	public void waterLevelChange(int newLevel) {};
	public void washing() {};
	public void centrifuging() {};
	public void stopped() {};
}
