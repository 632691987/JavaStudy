package jdk21.scopevalue;

public class Caller {

    public static void main(String[] args) {
        var exampleRunnable1 = new ExampleRunnable(1L);
        var thread1 = new Thread(exampleRunnable1);
        var exampleRunnable2 = new ExampleRunnable(2L);
        var thread2 = new Thread(exampleRunnable2);
        thread1.start();
        thread2.start();
    }

}
