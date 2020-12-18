package singleton.step2;

public class SecondClass {

	public SecondClass() {
		
		SingletonClass sObj =  SingletonClass.getInstance();
		System.out.println("SecondClass형 객체 생성");
		System.out.println(sObj.getI());
		sObj.setI(3000);
		System.out.println("변경후 i값(Secondclass에서) " + sObj.getI());
		System.out.println("SecondClass형 생성자 끝===");
	}
	
}
