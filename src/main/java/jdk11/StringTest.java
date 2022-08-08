package jdk11;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileInputStream;

public class StringTest {
	
	@Test
	public void testName3() throws Exception {
		FileInputStream fis = new FileInputStream("src/main/java/jdk11/StringTest.java");
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		String string = new String(buffer);
		string.lines().forEach(System.out::println);
	}
	
	@Test
	public void testLineCount() {
		String string = "mvn\n123\nfff";
		Assert.assertEquals(string.lines().count(), 3);
	}

	@Test
	public void testStringBlankRelated() {
		String string = " \t  \r\n ";
		Assert.assertTrue(string.isBlank());
		
		string = " \t  \r\n abc \tav";
		//strip able to delete non-English space character!
		String string2 = string.strip();
		Assert.assertEquals(string2, "abc \tav");

		String string4 = string.stripLeading();
		Assert.assertEquals(string4, "abc \tav");

		String string5 = " \t  \n abc \tav";
		Assert.assertEquals(string5, " \t  \n abc \tav");
	}

	@Test
	public void testRepeat() {
		String value = "words";
		Assert.assertEquals(value.repeat(3), "wordswordswords");
	}

	@Test
	public void testCase1() {
		Assert.assertEquals(" 12345  ".strip(), "12345");
		Assert.assertEquals(" 12345  ".stripLeading(), "12345  ");
		Assert.assertEquals(" 12345  ".stripTrailing(), " 12345");
		Assert.assertEquals(" 12345  ".repeat(2), " 12345   12345  ");
		Assert.assertTrue("".isBlank());
		Assert.assertEquals("123\n456\n789".lines().findFirst().get(), "123");
	}
}	
