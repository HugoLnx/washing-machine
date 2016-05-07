package com.hugolnx.washing.machine.model;

public class Valve {

	private boolean isClosed;

	public Valve() {
		this.isClosed = true;
	}

	public void open() {
		isClosed = false;
	}

	public void close() {
		isClosed = true;
	}

	public boolean isOpened() {
		return !isClosed;
	}
}
