package jdk13;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class TextBlockTest {

    @Test
    public void test1() {
        String html1 = """
                        <html>
                          <body>
                              <p>Hello, 尚硅谷</p>
                          </body>
                        </html>
                        """;
        assertThat(html1, notNullValue());
    }

    @Test
    public void test3() {
        String text1 = """
abc""";

        String text3 = """
abc
""";
        assertThat(text1.length(), equalTo(3));
        assertThat(text3.length(), equalTo(4));
    }

    @Test
    public void test4() {

        String text1 = "";
        assertThat(text1.length(), equalTo(0));
        String text2 = """
""";
        assertThat(text2.length(), equalTo(0));
        String text3 = """

""";
        assertThat(text3.length(), equalTo(1));

        String text4 = "abc";
        String text5 = """
abc""";
        assertThat(text4, is(text5));
        assertThat(text4, equalTo(text5));
        Assert.assertSame(text5, text4);

        String text6 = """
        it is legal to use "here, haha"
""";
        assertThat(text6, notNullValue());
    }

    //错误的写法
    @Test
    public void text5() {
//        String a = """""";   // 开始分隔符后没有行终止符
//        String b = """ """;  // 开始分隔符后没有行终止符
//        String c = """
//           ";        // 没有结束分隔符
//String d = """
//        abc \ def
//        """;      // 含有未转义的反斜线（请参阅下面的转义处理）
//
//        String e = "abc \ def";
    }

    //文本块连接
    @Test
    public void test9() {
        String type = "String";
        String code = """
              public void print(""" + type + """
               o) {
                  System.out.println(Objects.toString(o));
              }
              """;
        System.out.println(code);

        String code1 = """
              public void print($type o) {
                  System.out.println(Objects.toString(o));
              }
              """.replace("$type", type);
        System.out.println(code1);

        String code2 = String.format("""
              public void print(%s o) {
                  System.out.println(Objects.toString(o));
              }
              """, type);
        System.out.println(code2);
    }
}
