import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamTestMain {
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		
		arr.add("one");
		arr.add("two");
		arr.add("three");
		arr.add("four");
		arr.add("five");
//		arr.add("six");
//		arr.add("seven");
//		arr.add("eight");
//		arr.add("nine");
//		arr.add("ten");
		
		
		// allmatch
		// filter 조건 만족하는애
		// map 조건 만족하는 애들에게 할 연산
		// limit 조건 만족하는 애들 최대 몇개
		// skip 최대 몇개는 스킵하고 출력
		// foreach 한바퀴 돈다
		
		arr.stream().forEach(System.out::println);
		
		boolean all3size = arr.stream().allMatch(e -> e.length() >= 3);
		
		System.out.println("모두 3글자 이상 :" + all3size);
				
		arr.stream().filter(a -> a.length() == 3).peek(System.out::println)		// 중간결과 출력용
					.map(it -> "#" + it).forEach(System.out::println);
		
		arr.stream().filter(a -> a.length() == 3).limit(2).forEach(System.out::println);	// 
		arr.stream().filter(a -> a.length() == 4).skip(1).forEach(System.out::println);		//
		
		System.out.println("########################");
		
		arr.stream().forEachOrdered(System.out::println);
		
		
		
		
	}
}
