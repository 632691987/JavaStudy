package jdk15.sealedstudy_with_abstract;

public abstract sealed class Student permits Student1
{

    protected void operation1() {
        System.out.println("Before call operation2");
        operation2();
        System.out.println("After call operation2");
    }

    abstract void operation2();

}
