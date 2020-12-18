package com.lec.ex1_string;

public class Ex02 {
	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("ABCXabc");
		String str3 = " ja va  ";
		
		System.out.println("1. " + str1.concat(str2));
		System.out.println("2. " + str1.substring(3) );
		System.out.println("3. " + str1.substring(3,5) );
		System.out.println("4. " + str1.length());		
		System.out.println("5. " + str1.toUpperCase());
		System.out.println("6. " + str2.toLowerCase());
		System.out.println("7. " + str1.charAt(3));
		System.out.println("8. " + str1.indexOf("b"));
		System.out.println("9. " + str1.indexOf("b",3));
		System.out.println("10. "+ str1.lastIndexOf('b'));
		System.out.println("11. "+ str1.indexOf("Z"));
		System.out.println("12. "+ str1.lastIndexOf("z"));
		System.out.println("13. "+ str1.equals(str2));
		System.out.println("14. "+ str1.equalsIgnoreCase(str2));
		System.out.println("15. "+ str3.trim());
		System.out.println("16. "+ str1.replace('a','뭥'));
		System.out.println("17. "+ str1.replace("ab","바꿔"));
		System.out.println(str1);
		
	}
}
