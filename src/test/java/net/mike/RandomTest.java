package net.mike;

import java.util.Random;

public class RandomTest {
  
	public static void main(String[] randomtest) {
	 
		int length = 16;
		Random r = new Random();
		String s = r.ints(48, 122)
		            .filter(i -> (i < 57 || i > 65) && (i < 90 || i > 97))
		            .mapToObj(i -> (char) i)
		            .limit(length)
		            .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
		            .toString();
		System.out.print(s);
  }
}