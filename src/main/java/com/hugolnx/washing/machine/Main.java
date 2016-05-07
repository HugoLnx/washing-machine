package com.hugolnx.washing.machine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.hugolnx.washing.machine.model.WashingMachine;
import com.hugolnx.washing.machine.model.WashingMachineController;
import com.hugolnx.washing.machine.observer.RotatingObserver;
import com.hugolnx.washing.machine.observer.WaterLevelObserver;
import com.hugolnx.washing.machine.view.PaintLoop;
import com.hugolnx.washing.machine.view.ScreenPanel;
import com.hugolnx.washing.machine.view.WashMachineRotatingAnimation;
import com.hugolnx.washing.machine.view.WashMachineWaterLevel;
import com.hugolnx.washing.machine.view.utils.PanelFactory;

public class Main {
	public static void main(String[] args) {
			JFrame window = new JFrame("Washing Machine");
			window.setBounds(0, 0, 640, 400);
			window.setResizable(false);
			window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			window.setLocationRelativeTo(null); //Centraliza
			WashMachineRotatingAnimation rotationAnim = new WashMachineRotatingAnimation();
			WashMachineWaterLevel waterLevel = new WashMachineWaterLevel();
			ScreenPanel screen = new ScreenPanel(rotationAnim, waterLevel);
			
			WashingMachine machine = new WashingMachine();
			machine.register(new RotatingObserver(rotationAnim));
			machine.register(new WaterLevelObserver(waterLevel));
			WashingMachineController controller = new WashingMachineController(machine);
			JButton button = createButton(controller);
			window.add(PanelFactory.stackVertical(screen, button));
			window.pack();
			window.setVisible(true);

			PaintLoop.forComponent(screen);
        }

	private static JButton createButton(final WashingMachineController controller) {
		JButton button = new JButton("Start");
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.start();
			}
		});
		return button;
	}
}
