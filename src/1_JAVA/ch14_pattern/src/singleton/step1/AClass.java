package singleton.step1;

public class AClass {
	private int intVar;
	private static AClass instance; 
	
	private AClass() {}
	
	public static AClass getInstance() {
		if (instance == null) {
			instance = new AClass(); 
		}
		
		return instance;	
	}
	
	/**
	 * @return the intVar
	 */
	public int getIntVar() {
		return intVar;
	}
	/**
	 * @param intVar the intVar to set
	 */
	public void setIntVar(int intVar) {
		this.intVar = intVar;
	}
	
}
