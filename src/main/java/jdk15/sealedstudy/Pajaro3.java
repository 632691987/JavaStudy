package jdk15.sealedstudy;

public sealed class Pajaro3 implements Flyable permits SubPajaro3
{
    @Override
    public void method1()
    {
        System.out.println("==========================From Pajaro3 class===========================");
    }
}
