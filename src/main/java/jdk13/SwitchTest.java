package jdk13;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class SwitchTest {

    /**
     * yield, is for help return value, when the switch case not use "->"
     */

    @Test
    public void testSwitch1(){
        String x = "3";
        int value = switch(x){
            case "1" : yield  5;
            case "2" : yield  6;
            default :  yield 7;
        };
        assertThat(value, Matchers.is(7));
    }

    @Test
    public void testSwitch2(){
        String x = "3";
        int value = switch(x){
            case "1" -> 5;
            case "2" -> 6;
            default -> {
                yield 7;
            }
        };
        assertThat(value, Matchers.is(7));
    }

}
