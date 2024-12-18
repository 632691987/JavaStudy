package jdk21;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class VirtualThread {

    public static void main(String[] args) {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            int i = 0;
            while (i++ <= 10000) {
                executor.submit(() -> {
                    System.out.println("hello, I am going to sleep");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("hello, I wake up now");
                });
            }
        }
    }

}
