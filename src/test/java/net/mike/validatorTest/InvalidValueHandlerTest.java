package net.mike.validatorTest;

import net.mike.logic.EmailsCheker;

public class InvalidValueHandlerTest {
	public static void main(String[] testdrive) {
		EmailsCheker checker = new EmailsCheker();
		String email = "@yandex.ru";
		System.out.println(checker.regExpValidator(email));
	}
}
