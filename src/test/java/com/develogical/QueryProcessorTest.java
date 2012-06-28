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
        String result = new QueryProcessor().process("hi");
        assertNotNull(result);
        assertThat(result, is("hello"));
    }

    @Test
    public void canAskYourName() {
        String result = new QueryProcessor().process("what is your name");
        assertNotNull(result);
        assertThat(result, is("A-Team"));
    }

    @Test
    public void canAddNumbers() {
        String result = new QueryProcessor().process("what is 1 plus 2");
        assertNotNull(result);
        assertThat(result, is("3"));
    }

    @Test
    public void returnsEmptyStringForUnknownQueries() {
        String result = new QueryProcessor().process("unknown");
        assertNotNull(result);
        assertThat(result, is(""));
    }
}



