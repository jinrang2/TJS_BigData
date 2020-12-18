package strategy2.component;

public class Sonata extends Car {
	
	public Sonata() {
		setEngine(new EngineMid());
		setKm(new km15());		
		setFuel(new FuelGasoline());
	}
	
	@Override
	public void shape() {
		System.out.print("소나타는 ");
		super.shape();
	}
}
