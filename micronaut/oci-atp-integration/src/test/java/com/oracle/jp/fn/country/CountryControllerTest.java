package com.oracle.jp.fn.country;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.oraclecloud.function.http.test.FnHttpTest;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
public class CountryControllerTest {

private static final Logger logger = LoggerFactory.getLogger(CountryControllerTest.class);

    @Test
    void shouldReturnAllCountry() {
        HttpResponse<String> response = FnHttpTest.invoke(HttpRequest.GET("/sandbox/country"));
        String expected = "";
        logger.info(response.body());
        assertEquals(expected, response.body());
    }

}
