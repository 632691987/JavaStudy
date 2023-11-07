package jdk21;

public class SwitchCaseTest {

    public static void main(String[] args) {
        System.out.println(testWithPattern(Integer.parseInt("10")));
        System.out.println(testWithPattern(Long.parseLong("11")));
        System.out.println(testWithPattern(Double.parseDouble("12")));
        System.out.println(testWithPattern("Hello world"));
        System.out.println(testWithPattern(null));
    }

    static String testWithPattern(Object obj) {
        return switch (obj) {
            case Integer i -> "this is Integer i = [%d]".formatted(i);
            case Long l -> "this is Long l = [%d]".formatted(l);
            case Double i -> "this is Double i = [%f]".formatted(i);
            case String s -> "this is String s = [%s]".formatted(s);
            case null -> "this is a null value";
            default -> obj.toString();
        };
    }

}
