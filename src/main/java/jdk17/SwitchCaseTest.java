package jdk17;

import org.junit.Assert;
import org.junit.Test;

public class SwitchCaseTest {

    record Book(String title, String author, String isbn) {
        static {
            System.out.println("===============================");
        }
    }

    class Real {

    }


    @Test
    public void test1() {
        Assert.assertEquals(checkObject(new A("title")), "this is class A");
        Assert.assertEquals(checkObject(new B()), "this is class B");
    }

    public String checkObject(Object obj) {
        return switch (obj) {
            case B ignored -> "this is class B";
            case C1 c1 -> "this is class C1";
            case C c -> "this is class C";
            case null -> "It is null";
            default -> "It is an object";
        };
    }


    record A(String title) {}
    record B() {}
    class C {}
    class C1 extends C {}
}
