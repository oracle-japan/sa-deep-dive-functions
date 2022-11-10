package com.example.fn;

import com.fnproject.fn.testing.*;
import org.junit.*;

import static org.junit.Assert.*;

public class HelloFunctionTest {

    @Rule
    public final FnTestingRule testing = FnTestingRule.createDefault();

    @Test
    public void shouldReturnResponse() {
        testing
                .setConfig("version", "1")
                .givenEvent()
                .withHeader("Fn-Http-Request-URL", "https://example.com/version")
                .withHeader("Fn-Http-H-Content-Type", "application/json")
                .enqueue();
        testing.thenRun(HelloFunction.class, "handleRequest");

        FnResult result = testing.getOnlyResult();
        assertEquals("{\"version\":\"1\"}", result.getBodyAsString());
    }

}