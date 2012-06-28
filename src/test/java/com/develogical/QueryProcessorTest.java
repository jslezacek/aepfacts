package com.develogical;

import org.junit.Test;

import java.util.Map;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class QueryProcessorTest {

    @Test
    public void canGreetYou() {
        String result = new QueryProcessor().process("hghkyh: hi");
        assertNotNull(result);
        assertThat(result, is("hello"));
    }

    @Test
    public void canAskYourName() {
        String result = new QueryProcessor().process("hghkyh: what is your name");
        assertNotNull(result);
        assertThat(result, is("A-Team"));
    }

    @Test
    public void canAddNumbers() {
        String result = new QueryProcessor().process("hghkyh: what is 1 plus 2");
        assertNotNull(result);
        assertThat(result, is("3"));
    }

    @Test
    public void canMultiplyNumbers() {
        String result = new QueryProcessor().process("2a7d47a0: what is 9 multiplied by 7");
        assertNotNull(result);
        assertThat(result, is("63"));
    }

    @Test
    public void canComputeLargest() {
        String result = new QueryProcessor().process("hghkyh: which of the following numbers is the largest: 98, 89, 882, 81");
        assertNotNull(result);
        assertThat(result, is("882"));
    }

    @Test
    public void canFindSquareAndCube() {
        String result = new QueryProcessor().process("1f7b3cb0: which of the following numbers is both a square and a cube: 64, 9");
        assertNotNull(result);
        assertThat(result, is("64"));
    }

    @Test
    public void canFindPrimes() {
        String result = new QueryProcessor().process("e4aec270: which of the following numbers are primes: 479, 509, 363, 679");
        assertNotNull(result);
        assertThat(result, is("479, 509"));
    }

    @Test
    public void returnsEmptyStringForUnknownQueries() {
        String result = new QueryProcessor().process("unknown");
        assertNotNull(result);
        assertThat(result, is(""));
    }
}



