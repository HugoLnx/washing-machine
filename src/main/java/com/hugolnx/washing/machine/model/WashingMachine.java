package com.hugolnx.washing.machine.model;

import java.util.ArrayList;
import java.util.List;

public class WashingMachine {
	private int cycle;
	private int waterLevel;
	private List<WashingMachineObserver> observers;
	
	public WashingMachine() {
		this.waterLevel = 0;
		this.cycle = 1;
		this.observers = new ArrayList<>();
	}
	
	public int getCycle() {
		return cycle;
	}

	public void setCycle(int value) {
		cycle = value;
	}

	public void slow() {
		for(WashingMachineObserver observer : observers)
			observer.washing();
	}

	public void fast() {
		for(WashingMachineObserver observer : observers)
			observer.centrifuging();
	}

	public void stop() {
		for(WashingMachineObserver observer : observers)
			observer.stopped();
	}
	
	public void increaseWaterLevel() {
		waterLevel = Math.min(waterLevel+10, 100);
		for(WashingMachineObserver observer : observers)
			observer.waterLevelChange(waterLevel);
	}
	
	public void decreaseWaterLevel() {
		waterLevel = Math.max(waterLevel-10, 0);
		for(WashingMachineObserver observer : observers)
			observer.waterLevelChange(waterLevel);
	}
	
	public void register(WashingMachineObserver o) {
		observers.add(o);
	}

	public boolean isTankFull() {
		return waterLevel == 100;
	}

	public boolean isTankEmpty() {
		return waterLevel == 0;
	}
}
