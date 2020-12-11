package strategy3.component;

public class Lecturer extends Person {
	private String subject;
	
	public Lecturer(String id, String name, String subject) {
		super(id,name);
		this.subject = subject;
		
		setJobi(new JobLec());
		setGeti(new GetSalary());
	}
	
	@Override
	public void print() {
		super.print();
		System.out.println("강의과목:"+subject);
	}
}
