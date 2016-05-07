package com.hugolnx.washing.machine.model.statemachine;

import com.hugolnx.washing.machine.model.Bomb;
import com.hugolnx.washing.machine.model.Timer;
import com.hugolnx.washing.machine.model.Valve;
import com.hugolnx.washing.machine.model.WashingMachine;

public class Centrifuging extends WashingMachineState {

	public Centrifuging(WashingMachine machine, Bomb bomb, Valve valve, Timer timer) {
		super(machine, bomb, valve, timer);
	}

	@Override
	public WashingMachineState timeOver() {
		if(machine.getCycle() == 2) {
			return transitTo(Waiting.class);
		} else {
			machine.setCycle(2);
			return transitTo(FillingTank.class);
		}
	}

	@Override
	protected void entry() {
		machine.fast();
	}
	
	@Override
	protected void exit() {
		machine.stop();
	}
}
