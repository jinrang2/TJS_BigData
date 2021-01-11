import java.util.ArrayList;
import java.util.Arrays;

public class StreamTestMain {
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>(
				Arrays.asList("one","two","three","four","five"));
						
		for(String a: arr) {
			System.out.println(a);
		}
		
		arr.stream().forEach(System.out::println);
		
		// allmatch
		// filter 조건 만족하는애
		// map 조건 만족하는 애들에게 할 연산
		// limit 조건 만족하는 애들 최대 몇개
		// skip 최대 몇개는 스킵하고 출력
		// foreach 한바퀴 돈다		
				
		boolean all3size = arr.stream().allMatch(e -> e.length() >= 3);
		
		System.out.println("모두 3글자 이상 :" + all3size);
				
		arr.stream().filter(a -> a.length() == 3).peek(System.out::println)		// 중간결과 출력용
					.map(it -> "#" + it).forEach(System.out::println);
		
		arr.stream().filter(a -> a.length() == 3).limit(2).forEach(System.out::println);	// 
		arr.stream().filter(a -> a.length() == 4).skip(1).forEach(System.out::println);		//
		
		System.out.println("########################");
		
		arr.stream().forEachOrdered(System.out::println);
		
		
		
		
	}

	private static Object asList(String string, String string2, String string3, String string4, String string5) {
		// TODO Auto-generated method stub
		return null;
	}
}
