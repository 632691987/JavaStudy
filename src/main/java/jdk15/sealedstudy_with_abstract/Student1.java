package jdk15.sealedstudy_with_abstract;

public abstract sealed class Student1 extends Student permits Student2, Student3
{
}
