package com.oracle.jp.fn;

import io.micronaut.http.annotation.*;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.MediaType;
import io.micronaut.context.annotation.Property;
import io.micronaut.core.annotation.Introspected;

@Controller("/greet")
public class OciVaultIntegrationController {

    @Property(name = "micronaut.application.greet")
    private String text;

    @Produces(MediaType.TEXT_PLAIN)
    @Get
    public String index() {
        return text;
    }

    @Post
    public SampleReturnMessage postMethod(){
      SampleReturnMessage retMessage = new SampleReturnMessage();
      retMessage.setReturnMessage(text);
      return retMessage;
    }
}

@Introspected
class SampleInputMessage{
    private String name;

    public SampleInputMessage() {
    }

    public SampleInputMessage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

@Introspected
class SampleReturnMessage{
    private String returnMessage;
    public String getReturnMessage() {
        return returnMessage;
    }
    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }
}
