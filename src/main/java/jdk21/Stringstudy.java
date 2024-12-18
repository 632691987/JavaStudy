package jdk21;

import static java.util.FormatProcessor.FMT;

public class Stringstudy {

    public static void main(String[] args) {
        String name = "Vincent";
        float salary = 110.1f;
        String str1 = STR."My name is \{ name } and my daily salary is \{ salary }";
        String str2 = FMT."My name is \{ name } and my daily salary is %.2f\{ salary }";
        System.out.println(str1);
        System.out.println(str2);
    }

}
