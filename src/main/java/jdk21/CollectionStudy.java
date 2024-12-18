package jdk21;

import java.util.ArrayList;
import java.util.List;

public class CollectionStudy {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("a");
        names.add("b");
        System.out.println(names.getFirst());
        System.out.println(names.getLast());

        names.addFirst("first element");
        names.addLast("last element");
        System.out.println(names);
    }

}
