package strategy2.component;

public class Accent extends Car {
	
	public Accent() {
		setEngine(new EngineLow());
		setKm(new km20());		
		setFuel(new FuelDiesel());
	}
	
	@Override
	public void shape() {
		System.out.print("액센트는 ");
		super.shape();
	}
}
