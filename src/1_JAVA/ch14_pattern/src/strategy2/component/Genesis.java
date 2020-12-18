package strategy2.component;

public class Genesis extends Car {
	
	public Genesis() {
		setEngine(new EngineHigh());
		setKm(new km10());		
		setFuel(new FuelGasoline());
	}
	
	@Override
	public void shape() {
		System.out.print("제네시스는 ");
		super.shape();
	}
}
