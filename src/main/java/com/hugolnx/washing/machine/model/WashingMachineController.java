package com.hugolnx.washing.machine.model;

import com.hugolnx.washing.machine.model.statemachine.WashingMachineState;

public class WashingMachineController {
	private Bomb bomb;
	private WashingMachineState state;
	private Valve valve;
	private Timer timer;
	
	public WashingMachineController(WashingMachine machine) {
		this.bomb = new Bomb();
		this.valve = new Valve();
		this.timer = new Timer(this);
		this.state = WashingMachineState.initial(machine, bomb, valve, timer);
		TankSimulator.simulate(bomb, valve, machine, this);
	}
	
	public void start() { this.state = this.state.start(); }
	public void timeOver() { this.state = this.state.timeOver(); }
	public void fullTank() { this.state = this.state.fullTank(); }
	public void emptyTank() { this.state = this.state.emptyTank(); }
}
