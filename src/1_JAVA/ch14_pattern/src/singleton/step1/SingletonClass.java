package singleton.step1;

public class SingletonClass {
	private int i;
	public static SingletonClass instance;
	
	private SingletonClass() {
					
	}
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	
	public static SingletonClass getInstance() {
		if (instance == null) {
			instance = new SingletonClass();
			return instance;
		}
		else {
			return instance;
		}
	}
}
