package jdk12;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class SwitchTest {
    /**
     * 1, No break anymore
     * 2, Use ->, instead of ,
     * 3, Multiply case
     * 4, Return value
     */

    @Test
    public void testSwitch1() {
        int count;
        Fruit fruit = Fruit.APPLE;
        switch (fruit) {
            case PEAR -> count = 1;
            case APPLE, GRAPE, MANGO -> count = 2;
            case ORANGE, PAPAYA -> count = 3;
            default -> throw new IllegalStateException("No Such Fruit:" + fruit);
        }
        assertThat(count, Matchers.is(2));
    }

    @Test
    public void testSwitch2() {
        int numberOfLetters;
        Fruit fruit = Fruit.APPLE;
        numberOfLetters = switch (fruit) {
            case PEAR -> 4;
            case APPLE, GRAPE, MANGO -> 5;
            case ORANGE, PAPAYA -> 6;
            default -> throw new IllegalStateException("No Such Fruit:" + fruit);
        };
        assertThat(numberOfLetters, Matchers.is(5));
    }

    @Test
    public void testSwitch3() {
        int numberOfLetters;
        Fruit fruit = Fruit.PAPAYA;
        numberOfLetters = switch (fruit) {
            case PEAR -> 4;
            case APPLE, GRAPE, MANGO -> 5;
            case ORANGE -> 6;
            default -> 7;
        };
        assertThat(numberOfLetters, Matchers.is(7));
    }
}
