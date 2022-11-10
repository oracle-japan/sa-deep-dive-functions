package com.oracle.jp.fn;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import io.micronaut.http.client.annotation.*;
import jakarta.inject.Inject;
import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
public class SimpleResponseControllerTest {

    @Inject
    @Client("/sandbox")
    HttpClient client;

    @Test
    public void testIndex() throws Exception {
        assertEquals(HttpStatus.OK, client.toBlocking().exchange("/greet").status());
    }
}