package jdk21;

import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class VirtualThread {

    public static void main(String[] args) {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, 10).forEach(i -> {
                executor.submit(() -> {
                    System.out.println(i);
                });
            });
        }
    }

}
