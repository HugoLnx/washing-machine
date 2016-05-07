package com.hugolnx.washing.machine.model;

public class Bomb {

	private boolean isActive;

	public Bomb() {
		this.isActive = false;
	}

	public void start() {
		isActive = true;
	}

	public void stop() {
		isActive = false;
	}
	
	public boolean isActive() {
		return isActive;
	}

}
