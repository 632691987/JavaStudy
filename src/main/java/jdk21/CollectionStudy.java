package jdk21;

import java.util.List;

public class CollectionStudy {

    public static void main(String[] args) {
        List<String> names = List.of("a", "b");
        System.out.println(names.getFirst());
        System.out.println(names.getLast());
    }

}
