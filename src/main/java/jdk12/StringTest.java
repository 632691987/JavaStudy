package jdk12;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class StringTest {

    @Test
    public void testTransform() {
        String info1 = "Vincent".transform(info -> info + " Zhang");
        assertThat(info1, equalTo("Vincent Zhang"));
    }

    @Test
    public void testIndent() {
        String result = "1234567890".indent(3);
        assertThat(result, equalTo("   1234567890\n"));
        assertThat(result.length(), equalTo("1234567890".length() + 3 + 1));
    }
}
