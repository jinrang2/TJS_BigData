package singleton.step2;

public class FirstClass {

	public FirstClass() {
		
		SingletonClass sObj =  SingletonClass.getInstance();
		System.out.println("FirstClass형 객체 생성");
		System.out.println(sObj.getI());
		sObj.setI(999);
		System.out.println("변경후 i값(firstclass에서) " + sObj.getI());
		System.out.println("FirstClass형 생성자 생성");
	}
	
}
