package com.hugolnx.washing.machine.model.statemachine;

import com.hugolnx.washing.machine.model.Bomb;
import com.hugolnx.washing.machine.model.Timer;
import com.hugolnx.washing.machine.model.Valve;
import com.hugolnx.washing.machine.model.WashingMachine;

public class EmptyingTank extends WashingMachineState {

	public EmptyingTank(WashingMachine machine, Bomb bomb, Valve valve, Timer timer) {
		super(machine, bomb, valve, timer);
	}
	
	@Override
	public WashingMachineState emptyTank() {
		timer.start(3);
		return transitTo(Centrifuging.class);
	}

	@Override
	protected void entry() {
		bomb.start();
	}
	
	@Override
	protected void exit() {
		bomb.stop();
	}
}
