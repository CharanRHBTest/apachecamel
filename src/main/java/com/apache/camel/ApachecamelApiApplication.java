package com.apache.camel;

import com.apache.camel.logging.LoggingSpanHandler;
import org.apache.camel.observation.starter.CamelObservation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@CamelObservation
public class ApachecamelApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApachecamelApiApplication.class, args);
    }

    @Bean
    LoggingSpanHandler loggingSpanReporter() {
        return new LoggingSpanHandler();
    }
}
