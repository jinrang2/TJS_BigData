package singleton.step1;

public class TestMain {
	public static void main(String[] args) {
		/*SingletonClass obj1 = SingletonClass.getInstance();
		SingletonClass obj2 = SingletonClass.getInstance();
		
		if( obj1.equals(obj2)) {
			System.out.println("같네");
		}
		else {
			System.out.println("틀리네");
		}
		
		
		System.out.println("초기화된i값"+obj1.getI());
		obj1.setI(30);
		System.out.println("초기화된i값"+obj2.getI());
		obj2.setI(1000);
		System.out.println("초기화된i값"+obj2.getI());*/
		
		AClass obj3 = AClass.getInstance();
		AClass obj4 = AClass.getInstance();
		
		if( obj3.equals(obj4)) {
			System.out.println("같네");
		}
		else {
			System.out.println("틀리네");
		}
		
		
		System.out.println("초기화된i값"+obj3.getIntVar());
		obj3.setIntVar(30);
		System.out.println("초기화된i값"+obj4.getIntVar());
		obj4.setIntVar(1000);
		System.out.println("초기화된i값"+obj3.getIntVar());
	}
}
