package jdk15;

import org.junit.Test;

public class AppTestString
{

    /**
     * 这个实验证明换行符最后取1个位
     */
    @Test
    public void test1() {
        String sql = """
                a
                """;
        //System.out.println(sql.length());//2

        sql = """
                a""";
        System.out.println(sql.length());//1
    }

    /**
     * \s 代表空格
     */
    @Test
    public void test2() {
        String sql = """
                a\s""";
        System.out.println(sql.length());
    }

    /**
     * \s 代表空格
     */
    @Test
    public void test3() {
        String sql = """
                a\
                """;
        System.out.println(sql.length());//   \代表不换行，所以最后还是1个长度
    }
}
