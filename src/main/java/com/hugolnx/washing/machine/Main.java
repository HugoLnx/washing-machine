package com.hugolnx.washing.machine;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.hugolnx.washing.machine.view.PaintLoop;
import com.hugolnx.washing.machine.view.ScreenPanel;
import com.hugolnx.washing.machine.view.WashMachineRotatingAnimation;
import com.hugolnx.washing.machine.view.WashMachineWaterLevel;
import com.hugolnx.washing.machine.view.utils.PanelFactory;

public class Main {
	public static void main(String[] args) {
			JFrame window = new JFrame("jogo bolado");
			window.setBounds(0, 0, 640, 400);
			window.setResizable(false);
			window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			window.setLocationRelativeTo(null); //Centraliza
			WashMachineRotatingAnimation rotationAnim = new WashMachineRotatingAnimation();
			WashMachineWaterLevel waterLevel = new WashMachineWaterLevel();
			ScreenPanel screen = new ScreenPanel(rotationAnim, waterLevel);
			JPanel buttons = createButtons(rotationAnim, waterLevel);
			window.add(PanelFactory.stackHorizontal(screen, buttons));
			window.pack();
			window.setVisible(true);

			PaintLoop.forComponent(screen);
        }

	private static JPanel createButtons(final WashMachineRotatingAnimation washMachineAnim, WashMachineWaterLevel waterLevel) {
		List<Component> buttons = new ArrayList<>();
		buttons.add(createButton("Parar",new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				washMachineAnim.stop();
			}
		}));
		
		buttons.add(createButton("Enxaguar", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				washMachineAnim.playWatering();
			}
		}));
		
		buttons.add(createButton("Centrifugar", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				washMachineAnim.playCentrifuging();
			}
		}));
		buttons.add(createButton("0%", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				waterLevel.set(0);
			}
		}));
		buttons.add(createButton("30%", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				waterLevel.set(30);
			}
		}));
		buttons.add(createButton("70%", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				waterLevel.set(70);
			}
		}));
		buttons.add(createButton("100%", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				waterLevel.set(100);
			}
		}));
		return PanelFactory.stackHorizontal(buttons);
	}

	private static JButton createButton(String label, ActionListener listener) {
		JButton button = new JButton(label);
		button.addActionListener(listener);
		return button;
	}
}
