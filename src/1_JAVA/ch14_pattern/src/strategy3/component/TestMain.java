package strategy3.component;

public class TestMain {
	public static void main(String[] args) {
		
		Student st1 = new Student("30301", "강학생", "python반");
		Student st2 = new Student("30302", "강공부", "Java반");
		Lecturer gs1 = new Lecturer("J01  ", "홍강의", "hadoop반");
		Lecturer gs2 = new Lecturer("J02  ", "김수업", "db");
		Staff s = new Staff("A01  ", "신일해", "취업지원");
		Person[] person = {st1, st2, gs1, gs2, s};
		System.out.println("1.업무시간이니 다 일합시다");
		for(Person p : person)
			p.job();
		System.out.println("2.월말엔 다 지급할 것 지급");
		for(Person p : person)
			p.get();
		System.out.println("3.궁금하면 프린트");
		for(Person p : person)
			p.print();

	}
}
