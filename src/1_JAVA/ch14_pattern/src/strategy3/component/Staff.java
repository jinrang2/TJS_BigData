package strategy3.component;

public class Staff extends Person {
	private String part;
	
	public Staff(String id, String name, String part) {
		super(id,name);
		this.part = part;
		
		setJobi(new JobMng());
		setGeti(new GetSalary());
	}
	
	@Override
	public void print() {
		super.print();
		System.out.println("부서:"+part);
	}
}
