package strategy2.component;

public class TestMain {
	public static void main(String[] args) {
		Car accent = new Accent();
		Car sonata = new Sonata();
		Car genesis = new Genesis();
		
		Car[] cars = {accent, sonata, genesis};
		
		for(Car c : cars) {
			c.drive();
			c.shape();
			c.isEngine();
			c.isKm();
			c.isFuel();
			
			System.out.println();			
		}
		
		System.out.println("소나타를 하이브리드로 교체하고 연비를 20으로 교체후 소나타는 다음과 같다");
		
		sonata.setFuel(new FuelHybrid());
		sonata.setKm(new km20());
		sonata.isFuel();
		sonata.isKm();
	}
}
