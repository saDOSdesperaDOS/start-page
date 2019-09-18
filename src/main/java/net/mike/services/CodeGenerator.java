package net.mike.services;

import java.util.Random;

public class CodeGenerator {
	//ТУТ НУЖЕН SINGLTON!!!
	private static String instance;
	private CodeGenerator() {
		int length = 16;
		Random r = new Random();
		String code = r.ints(48, 122)
		            .filter(i -> (i < 57 || i > 65) && (i < 90 || i > 97))
		            .mapToObj(i -> (char) i)
		            .limit(length)
		            .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
		            .toString();
		instance = code;
	}
	public static synchronized String getInstance() {
		if(instance == null) 
			instance = new CodeGenerator().toString();
		return instance;
	}
}
