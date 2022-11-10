package com.oracle.jp.fn;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.http.client.annotation.*;
import io.micronaut.oraclecloud.function.http.test.FnHttpTest;
import jakarta.inject.Inject;
import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
public class OciVaultIntegrationControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(OciVaultIntegrationControllerTest.class);

    @Inject
    @Client("/sandbox")
    HttpClient client;

    @Test
    public void testIndex() throws Exception {
        assertEquals(HttpStatus.OK, client.toBlocking().exchange("/greet").status());
    }

    @Test
    public void shouldReturnVaultValue() {
        String expected = "Hello world from OCI Vault";
        HttpResponse<String> response = FnHttpTest.invoke(HttpRequest.GET("/sandbox/greet"));
        assertEquals(expected, response.body());
    }

}
