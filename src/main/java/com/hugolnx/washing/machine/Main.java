package com.hugolnx.washing.machine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.hugolnx.washing.machine.model.WashingMachine;
import com.hugolnx.washing.machine.model.WashingMachineController;
import com.hugolnx.washing.machine.observer.RotatingObserver;
import com.hugolnx.washing.machine.observer.WaterLevelObserver;
import com.hugolnx.washing.machine.view.MainWindow;
import com.hugolnx.washing.machine.view.PaintLoop;
import com.hugolnx.washing.machine.view.ScreenPanel;
import com.hugolnx.washing.machine.view.WashMachineRotatingAnimation;
import com.hugolnx.washing.machine.view.WashMachineWaterLevel;
import com.hugolnx.washing.machine.view.utils.PanelFactory;

public class Main {
	public static void main(String[] args) {
		MainWindow window = new MainWindow();
		
		WashingMachine machine = new WashingMachine();
		machine.register(new RotatingObserver(window.getMachineComponent()));
		machine.register(new WaterLevelObserver(window.getWaterLevelComponent()));
		final WashingMachineController controller = new WashingMachineController(machine);

		window.onStart(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.start();
			}
		});
    }

}
