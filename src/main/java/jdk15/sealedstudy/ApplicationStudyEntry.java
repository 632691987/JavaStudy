package jdk15.sealedstudy;

import org.junit.Test;

public class ApplicationStudyEntry
{
    @Test
    public void test1() {
        Flyable f1 = new Pajaro();
        f1.method1();
    }

    @Test
    public void test2() {
        Flyable f1 = new Pajaro2();
        f1.method1();
    }

    @Test
    public void test3() {
        Flyable f1 = new Pajaro3();
        f1.method1();
    }
}
