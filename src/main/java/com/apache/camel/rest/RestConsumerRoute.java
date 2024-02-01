package com.apache.camel.rest;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestConsumerRoute extends RouteBuilder {

    @Autowired
    ProducerTemplate template;

    @Override
    public void configure() throws Exception {

        from("timer://rest-consumer?period=1000").routeId("timerRoute")
                .to("direct:route1") // Invokes the restCall route
                .log("Calling another route1 is done.");

        from("direct:route1").routeId("route1")
                .log("Testing trace id and span id")
                .process(exchange -> {
                    log.info("printing something");
                });
    }
}
