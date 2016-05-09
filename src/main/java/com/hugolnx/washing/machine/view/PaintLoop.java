package com.hugolnx.washing.machine.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public abstract class PaintLoop {
	public static final int FPS = 20;
	
	public static void forComponent(final Component component) {
		Timer timer = new Timer(1000/FPS, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				component.repaint();
			}
		});
		timer.setRepeats(true);
		timer.start();
	}

}