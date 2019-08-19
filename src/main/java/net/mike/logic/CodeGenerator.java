package net.mike.logic;

import java.util.Random;

public class CodeGenerator {
	
	private String verifyCode;

	public String getVerifyCode() {
		int length = 16;
		Random r = new Random();
		String s = r.ints(48, 122)
		            .filter(i -> (i < 57 || i > 65) && (i < 90 || i > 97))
		            .mapToObj(i -> (char) i)
		            .limit(length)
		            .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
		            .toString();
		return s;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

}
