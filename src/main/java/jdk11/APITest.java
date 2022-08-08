package jdk11;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;


public class APITest {

	@Test
	public void testStream() {
		//Create stream
		Stream<Integer> stream1 = Stream.of(3,6,9,12,15,18);

		//stream operation
		stream1.forEach(System.out::println);// 3,6,9,12,15,18
		Stream.of().forEach(System.out::println); // Nothing
	}

	@Test(expected = NullPointerException.class)
	public void testOf() {
		Stream.of(null).forEach(System.out::println);
	}

	@Test
	public void testOf2() {
		Stream.ofNullable(null).forEach(System.out::println);
		Assert.assertTrue(Stream.ofNullable(null).count()==0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testImmutableSet() {
		Set<Integer> set = Set.of(20, 20);
		System.out.println(set.getClass());
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testImmutableList() {
		int[] arr = {1, 9, 3, 2, 8};
		List<String> list1 = Arrays.asList("aa", "yyy", "zzz", "123");
		List<String> list2 = List.of("aa", "bbb", "cc", "DD");

		list1.add("1111");// throw UnsupportedOperationException.class
		list2.add("1111");// throw UnsupportedOperationException.class
	}
}
