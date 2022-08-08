package jdk11;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
	
	@Test
	public void testUnlimitedStream() {
		Stream<Integer> stream1 = Stream.iterate(1, t -> (2 * t) + 1);
		List<Integer> lists = stream1.limit(10).collect(Collectors.toList());
		System.out.println(lists);//[1, 3, 7, 15, 31, 63, 127, 255, 511, 1023]
	}

	@Test
	public void testLimitedStream() {
		Stream<Integer> stream1 = Stream.iterate(1, t -> t < 1000, t -> (2 * t) + 1);
		List<Integer> lists = stream1.collect(Collectors.toList());
		System.out.println(lists);//[1, 3, 7, 15, 31, 63, 127, 255, 511]
	}
	
	@Test
	public void testDropAndTake() {
		Stream<Integer> stream1 = Stream.of(3, 9, 20, 22, 40, 7);

		//equal to filter, but it will stop when condition not satisfy
		Stream<Integer> stream2 = stream1.takeWhile(t -> t % 2 != 0);
		//stream2.forEach(System.out::println);//Result is [3,9]
		
		stream1 = Stream.of(3, 9, 20, 22, 40, 7);
		//equal to filter, but it will drop all the element satisfy in the predicate, until first predicate not satisfy
		//so, it will drop [3, 9], and stop on 20
		Stream<Integer> stream3 = stream1.dropWhile(t -> t % 2 != 0);
		stream3.forEach(System.out::println);
	}
	
	@Test
	public void test1() {
		Stream<Integer> stream1 = Stream.of(3, 9, 20, 22, 40);
		stream1.forEach(System.out::println);
		
		System.out.println("***********************************");
		
		Stream<Object> stream2 = Stream.of();
		stream2.forEach(System.out::println);
		
		System.out.println("***********************************");

		Stream<Object> stream3 = Stream.ofNullable(null);
		stream3.forEach(System.out::println);
	}

	@Test
	public void testMapMulti() {
		List<String> list1 = Stream.of("abc", "def", "hij").mapMulti((s, c) -> {
			c.accept(s.toLowerCase());
			c.accept(s.toUpperCase());
		}).map(String::valueOf).toList();

		List<String> list2 = Stream.of("abc", "def", "hij")
				.flatMap(s-> Stream.of(s.toUpperCase(), s.toUpperCase()))
				.toList();

		System.out.println(list1);
		System.out.println(list2);
	}
}
