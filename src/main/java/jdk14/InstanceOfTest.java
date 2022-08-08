package jdk14;

import org.junit.Test;

public class InstanceOfTest
{

    @Test
    public void test1() {
        String s1 = "version2";
        Object obj = s1;

        if (obj instanceof String s) {
            System.out.println(s);
        }
    }

}
