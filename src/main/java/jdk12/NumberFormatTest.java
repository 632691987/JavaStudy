package jdk12;

import org.junit.Test;

import java.text.NumberFormat;
import java.util.Locale;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class NumberFormatTest {

    @Test
    public void testCompactNumberFormat() {
        var cnf = NumberFormat.getCompactNumberInstance(Locale.UK, NumberFormat.Style.SHORT);
        assertThat(cnf.format(1_0000), equalTo("10K"));
        assertThat(cnf.format(1_9200), equalTo("19K"));
        assertThat(cnf.format(1_000_000), equalTo("1M"));
        assertThat(cnf.format(1L << 30), equalTo("1B"));
        assertThat(cnf.format(1L << 40), equalTo("1T"));
        assertThat(cnf.format(1L << 50), equalTo("1126T"));
    }

}
