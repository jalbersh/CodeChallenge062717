package com.dish.ofm.service.PACKAGE_NAME.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class EnvironmentConfig {
    @Autowired
    private Environment environment;
    @Value("${configuredEnvironment}")
    private String configuredEnv;
    private Logger LOGGER = LoggerFactory.getLogger(EnvironmentConfig.class);

    @Bean
    public boolean validProfile() {
        if (!configuredProfileIsActive()) {
            String message = "Expected environment " + configuredEnv + ", from configuration, " +
                "does not match any active spring environment profile: " +
                printActiveProfiles();
            LOGGER.error(message);
            throw new RuntimeException(message);
        }
        return true;
    }

    private String printActiveProfiles() {
        String profileList = "";
        for(String profileName : environment.getActiveProfiles()) {
            profileList += profileName + ", ";
        }
        return profileList.length() > 1 ? profileList.substring(0, profileList.length() - 2) : "";
    }

    private boolean configuredProfileIsActive() {
        for(String profileName : environment.getActiveProfiles()) {
            if (profileName.equals(configuredEnv)) {
                return true;
            }
        }

        if (environment.getActiveProfiles().length == 0 && configuredEnv.equals("default")) {
            return true;
        }
        return false;
    }
}
