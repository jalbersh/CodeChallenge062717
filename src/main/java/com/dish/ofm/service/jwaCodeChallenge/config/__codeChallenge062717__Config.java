package com.dish.ofm.service.jwaCodeChallenge.config;

import com.dish.core.metrics.health.RestServiceHealthStatusIndicator;
import com.dish.ofm.commonutils.MetricsLoggingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;

@Configuration
public class codeChallenge062717__Config {

    @Autowired
    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    public MetricsLoggingHandler metricsLoggingHandler(){
        return new MetricsLoggingHandler(this.applicationName);
    }


    @Bean
    public HealthIndicator getRestHealthIndicator() {
        List<String> uris = new LinkedList<>();
        return new RestServiceHealthStatusIndicator(uris, new RestTemplate());
    }
}
