package strategy2.component;

public abstract class Car {
	private EngineImpl engine;
	private FuelImpl fuel;
	private KmImpl km;
	
	public void drive() {
		System.out.println("드라이브 할수 있습니다.");
	}
	
	public void shape() {
		System.out.println("door sheet handle이 있습니다");
	}
	
	public void isEngine() {
		engine.engine();
	}
	
	public void isKm() {
		km.km();
	};
	public void isFuel() {
		fuel.fuel();
	}
	
	public void setEngine(EngineImpl engine) {
		this.engine = engine;
	}

	public void setFuel(FuelImpl fuel) {
		this.fuel = fuel;
	}

	public void setKm(KmImpl km) {
		this.km = km;
	}
	
	
	
}
