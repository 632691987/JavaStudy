package jdk15.sealedstudy;

public sealed interface Flyable permits Pajaro, Pajaro2, Pajaro3
{
    void method1();
}
