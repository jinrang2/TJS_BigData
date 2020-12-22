import java.util.HashMap;

public class CollectionTest {
	
	public static void main(String[] args) {
		HashMap<Integer, String> test = new HashMap<Integer,String>();
		HashMap<Integer, Double> test2 = new HashMap<Integer,Double>();
		
		test.put(1,"��");
		test.put(2,"��");
		test.put(3,"��");
		test.put(4,"��");
		
		// Ű�������� null�� �˻�
		// containsKey�� false ��ȯ
		if (test.get(5) == null) {
			System.out.println("���� Ű �Դϴ�");			
		} else {
			System.out.println(test.get(1));
		}
		
		test2.put(1,1.0);
		test2.put(2,2.0);
		test2.put(3,3.0);
		test2.put(4,4.0);
		
		if (test.get(1) == null) {
			System.out.println("���� Ű �Դϴ�");			
		} else {
			System.out.println(test.get(1));
		}
		
		// ������ ����Ʈ
		System.out.println(test2.getOrDefault(5, 10.0));
		
		// ������ �߰� ������ null��ȯ�� �ƹ��͵� ����
		System.out.println(test2);
		System.out.println(test2.putIfAbsent(6, 11.0));
		System.out.println(test2.putIfAbsent(7, 11.0));
		System.out.println(test2);
		
		String text = "KOREA KOREA USA USA USA CANADA JAPAN "; 
		HashMap<String, Integer> wordMap = new HashMap<>(); 
		wordMap.put("KOREA", 0); 
		wordMap.put("USA", 0); 
		wordMap.put("CHINA", 0); 
		wordMap.put("JAPAN", 0);
		
		for(String word : text.split(" ")){ 
			wordMap.computeIfPresent(word, (String key, Integer value) -> ++value); 
			//wordMap.putIfPresent(word, (String key, Integer value) -> ++value);
		}
		
		System.out.println("wordMap = " + wordMap);	
	}
}
