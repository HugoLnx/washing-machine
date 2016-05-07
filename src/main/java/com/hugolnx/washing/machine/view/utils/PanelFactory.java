package com.hugolnx.washing.machine.view.utils;

import java.awt.Component;
import java.util.Arrays;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public abstract class PanelFactory {
	public static JPanel stackVertical(List<Component> components) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		for (Component component : components) {
			panel.add(component);
		}
		return panel;
	}

	public static JPanel stackHorizontal(List<Component> components) {
		JPanel panel = new JPanel();
		BoxLayout layout = new BoxLayout(panel, BoxLayout.X_AXIS);
		panel.setLayout(layout);
		for (Component component : components) {
			panel.add(component);
		}
		return panel;
	}

	public static JPanel stackHorizontal(Component... components) {
		return stackHorizontal(Arrays.asList(components));
	}
	
	public static JPanel stackVertical(Component... components) {
		return stackVertical(Arrays.asList(components));
	}
	
}