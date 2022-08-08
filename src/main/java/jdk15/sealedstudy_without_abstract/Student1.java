package jdk15.sealedstudy_without_abstract;

public sealed class Student1 extends Student permits Student2, Student3
{
}
