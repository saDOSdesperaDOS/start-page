package net.mike.validatorTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InvalidValueHandler {
	public static void main(String[] testdrive) {
		Pattern p = Pattern.compile("[A-a],[Z-z],@");
		Matcher m = p.matcher("aaaaabc@");
		boolean b = m.matches();
		System.out.println(b);
	}
}
