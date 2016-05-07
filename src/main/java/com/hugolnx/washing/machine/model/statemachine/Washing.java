package com.hugolnx.washing.machine.model.statemachine;

import com.hugolnx.washing.machine.model.Bomb;
import com.hugolnx.washing.machine.model.Timer;
import com.hugolnx.washing.machine.model.Valve;
import com.hugolnx.washing.machine.model.WashingMachine;

public class Washing extends WashingMachineState {

	public Washing(WashingMachine machine, Bomb bomb, Valve valve, Timer timer) {
		super(machine, bomb, valve, timer);
	}
	
	@Override
	public WashingMachineState timeOver() {
		timer.start(2);
		return transitTo(EmptyingTank.class);
	}

	@Override
	protected void entry() {
		machine.slow();
	}
	
	@Override
	protected void exit() {
		machine.stop();
	}
}
