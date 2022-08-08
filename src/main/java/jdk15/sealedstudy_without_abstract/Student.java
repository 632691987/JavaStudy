package jdk15.sealedstudy_without_abstract;

public sealed class Student permits Student1
{
    public void operation1() {
        System.out.println("Before call operation2");
        System.out.println("After call operation2");
    }

}
