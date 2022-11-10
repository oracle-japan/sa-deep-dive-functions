package com.example.fn;

import com.fnproject.fn.api.FnConfiguration;
import com.fnproject.fn.api.RuntimeContext;
import com.fnproject.fn.api.httpgateway.HTTPGatewayContext;

public class HelloFunction {
    private String version;

    @FnConfiguration
    public void config(RuntimeContext ctx) {
        version = ctx.getConfigurationByKey("VERSION").orElse("0");
    }

    public Response handleRequest() {
        return new Response(version);
    }

}