package strategy3.component;

public class Student extends Person {
	private String ban;
	
	public Student (String id, String name, String ban) {
		super(id, name);
		this.ban = ban;
		
		setJobi(new JobStudy());
		setGeti(new GetStudentPay());		
	}
	
	@Override
	public void print() {
		super.print();
		System.out.println("반:"+ban);
	}
}
