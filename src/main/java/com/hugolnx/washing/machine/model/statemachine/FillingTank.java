package com.hugolnx.washing.machine.model.statemachine;

import com.hugolnx.washing.machine.model.Bomb;
import com.hugolnx.washing.machine.model.Timer;
import com.hugolnx.washing.machine.model.Valve;
import com.hugolnx.washing.machine.model.WashingMachine;

public class FillingTank extends WashingMachineState {
	public FillingTank(WashingMachine machine, Bomb bomb, Valve valve, Timer timer) {
		super(machine, bomb, valve, timer);
	}
	
	@Override
	public WashingMachineState fullTank() {
		timer.start(10);
		return transitTo(Washing.class);
	}
	
	@Override
	protected void entry() {
		valve.open();
	}
	
	@Override
	protected void exit() {
		valve.close();
	}
}
