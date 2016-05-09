package com.hugolnx.washing.machine.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.hugolnx.washing.machine.view.utils.PanelFactory;

public class MainWindow extends JFrame {
	private JButton startButton;
	private ScreenPanel screen;
	
	public MainWindow() {
		super("Washing Machine");
		this.startButton = new JButton("Start");
		this.screen = new ScreenPanel();
		
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); //Centraliza
		
		this.add(PanelFactory.stackVertical(screen, startButton));
		this.pack();
		this.setVisible(true);

		PaintLoop.forComponent(screen);
	}
	
	public void onStart(ActionListener listener) {
		startButton.addActionListener(listener);
	}

	public WashMachineRotatingAnimation getMachineComponent() {
		return screen.getRotationAnimation();
	}

	public WashMachineWaterLevel getWaterLevelComponent() {
		return screen.getWaterLevelAnimation();
	}
}
