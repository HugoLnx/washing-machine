package com.hugolnx.washing.machine.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Timer {

	private final WashingMachineController controller;
	private javax.swing.Timer timer;

	public Timer(WashingMachineController controller) {
		this.controller = controller;
		this.timer = null;
	}

	public void start(int seconds) {
		if(this.timer != null) this.timer.stop();
		
		this.timer = new javax.swing.Timer(seconds*1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.timeOver();
			}
		});
		this.timer.start();
	}

}
