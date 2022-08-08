package jdk11;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalTest {
	
	@Test
	public void testOptionalAPI() throws Exception {
		Optional<String> optional = Optional.ofNullable(null);
		String object = optional.orElse("abc");
		Assert.assertTrue(object.equals("abc"));

		Optional<String> object2 = optional.or(() -> Optional.of("vincent"));
		Assert.assertTrue(object2.get().equals("vincent"));
	}

	@Test
	public void testJava9ifPresentOrElse() {
		Optional<Integer> opt1 = Optional.ofNullable(null);
		opt1.ifPresentOrElse( x -> System.out.println("Result found: " + x), () -> System.out.println("Not Found."));
	}

	@Test
	public void forJava9Improvements() {
		Stream<Optional<Entity>> optionalStream = Stream.of(
				Optional.of(new Entity("AA1","BB1")),
				Optional.of(new Entity("AA2","BB2")),
				Optional.of(new Entity("AA3","BB3")),
				Optional.of(new Entity("AA4","BB4")),
				Optional.empty(),
				Optional.ofNullable(null),
				Optional.of(new Entity("AA6","BB6"))
		);

		Stream<Entity> stream2 = optionalStream.flatMap(op -> op.stream());
		List<String> entities = stream2.map(en -> en.getName()).collect(Collectors.toList());
		System.out.println(entities);


		//注意，flatMap 本身是做 stream 的哦
		List<Entity> entities1 = Lists.newArrayList(new Entity("AA1","BB1"));
		Stream<Entity> entityStream = entities1.stream().flatMap(entity-> Stream.of(entity));
	}

	record Entity(String name, String value) {
		String getName() {
			return name;
		}
	}
}
