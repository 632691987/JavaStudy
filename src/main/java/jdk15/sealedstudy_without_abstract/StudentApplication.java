package jdk15.sealedstudy_without_abstract;

import org.junit.Test;

/**
 *
 * Sealed 类是可以实现的
 *
 */
public class StudentApplication
{
    @Test
    public void test() {
        Student student = new Student();
        student.operation1();
    }

    @Test
    public void test1() {
        Student1 student1 = new Student1();
        student1.operation1();
    }

    @Test
    public void test2() {
        Student2 student2 = new Student2();
        student2.operation1();
    }

    @Test
    public void test3() {
        Student3 student3 = new Student3();
        student3.operation1();
    }

}
