package com.hugolnx.washing.machine.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class TankSimulator {
	public static void simulate(final Bomb bomb, final Valve valve, final WashingMachine machine, final WashingMachineController controller) {
		Timer timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(valve.isOpened()) {
					machine.increaseWaterLevel();
					if(machine.isTankFull()) {
						controller.fullTank();
					}
				}
				else if(bomb.isActive()) {
					machine.decreaseWaterLevel();
					if(machine.isTankEmpty()) {
						controller.emptyTank();
					}
				}
				simulate(bomb,valve,machine,controller);
			}
		});
		timer.setRepeats(false);
		timer.start();
	}
}
