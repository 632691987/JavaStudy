package jdk12;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ConstableTest {

    @Test
    public void getIntegerConstable() {
        Integer value = 5;
        assertThat(value.resolveConstantDesc(null), is(5));
        assertThat(value.describeConstable().get(), is(5));
    }

    @Test
    public void getFloatConstable() {
        Float value = 5.5f;
        assertThat(value.resolveConstantDesc(null), is(5.5f));
        assertThat(value.describeConstable().get(), is(5.5f));
    }

    @Test
    public void getStringConstable() {
        String name = "abc";
        assertThat(name.resolveConstantDesc(null), is("abc"));
        assertThat(name.describeConstable().get(), is("abc"));
    }

}
