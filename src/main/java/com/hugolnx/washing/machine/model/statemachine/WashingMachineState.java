package com.hugolnx.washing.machine.model.statemachine;

import java.lang.reflect.InvocationTargetException;

import com.hugolnx.washing.machine.model.Bomb;
import com.hugolnx.washing.machine.model.Timer;
import com.hugolnx.washing.machine.model.Valve;
import com.hugolnx.washing.machine.model.WashingMachine;

public abstract class WashingMachineState {
	protected WashingMachine machine;
	protected Bomb bomb;
	protected Valve valve;
	protected Timer timer;
	
	public WashingMachineState(WashingMachine machine, Bomb bomb, Valve valve, Timer timer) {
		this.machine = machine;
		this.bomb = bomb;
		this.valve = valve;
		this.timer = timer;
	}

	public static WashingMachineState initial(WashingMachine machine, Bomb bomb, Valve valve, Timer timer) {
		Waiting state = new Waiting(machine, bomb, valve, timer);
		state.entry();
		return state;
	}
	
	protected void entry() { }
	protected void exit() { }

	public WashingMachineState start() { return this; }
	public WashingMachineState timeOver() { return this; }
	public WashingMachineState fullTank() { return this; }
	public WashingMachineState emptyTank() { return this; }
	

	protected static WashingMachineState transition(WashingMachineState origin, Class<? extends WashingMachineState> destinyClass) {
		origin.exit();
		WashingMachineState destiny;
		try {
			destiny = destinyClass.getConstructor(WashingMachine.class, Bomb.class, Valve.class, Timer.class)
								  .newInstance(origin.machine, origin.bomb, origin.valve, origin.timer);
			destiny.entry();
			return destiny;
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			throw new RuntimeException("Could not instanciate the class");
		}
	}
	
	protected WashingMachineState transitTo(Class<? extends WashingMachineState> destiny) {
		return WashingMachineState.transition(this, destiny);
	}

}
