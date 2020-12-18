package strategy3.component;

public class Person {
	private String id, name;
	private JobImpl jobi;
	private GetImpl geti;
	
	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void job() {
		jobi.job();
	}
	
	public void get() {
		geti.get();
	}
	
	public void print() {
		System.out.printf("ID:%S\t이름:%S\t",id,name);
	}

	/**
	 * @param jobi the jobi to set
	 */
	public void setJobi(JobImpl jobi) {
		this.jobi = jobi;
	}

	/**
	 * @param geti the geti to set
	 */
	public void setGeti(GetImpl geti) {
		this.geti = geti;
	}
		
	
	
}
