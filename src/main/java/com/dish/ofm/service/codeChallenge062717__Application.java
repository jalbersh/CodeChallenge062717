package com.dish.ofm.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class codeChallenge062717__Application {
    private static Logger LOGGER = LoggerFactory.getLogger(codeChallenge062717__Application.class);

    public static void main(String args[]) {
        SpringApplication.run(codeChallenge062717__Application.class, args);
        LOGGER.info("Finished codeChallenge062717__Application initialization...");
    }
}
