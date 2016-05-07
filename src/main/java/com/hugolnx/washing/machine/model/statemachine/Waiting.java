package com.hugolnx.washing.machine.model.statemachine;

import com.hugolnx.washing.machine.model.Bomb;
import com.hugolnx.washing.machine.model.Timer;
import com.hugolnx.washing.machine.model.Valve;
import com.hugolnx.washing.machine.model.WashingMachine;

public class Waiting extends WashingMachineState {
	
	public Waiting(WashingMachine machine, Bomb bomb, Valve valve, Timer timer) {
		super(machine, bomb, valve, timer);
	}

	@Override
	public WashingMachineState start() {
		machine.setCycle(1);
		return transitTo(FillingTank.class);
	}
}