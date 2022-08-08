package jdk16;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamStudy {

    @Test
    public void test1() {
        List<String> integersAsString = Arrays.asList("1", "2", "3");
        List<Integer> ints = integersAsString.stream().map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> intsEquivalent = integersAsString.stream().map(Integer::parseInt).toList();
    }

}
