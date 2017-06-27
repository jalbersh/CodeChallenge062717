package com.dish.ofm.service.PACKAGE_NAME.util;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegistryService.class);

    @Autowired
    EurekaClient eurekaClient;

    public String getServiceHostName(String serviceName) {
        String hostName = null;
        try {
            InstanceInfo instance = eurekaClient.getNextServerFromEureka(serviceName, false);
            hostName = instance.getHostName();
            LOGGER.info("Found host name from eureka registry hostName = {}", hostName);

        } catch (Exception e) {
            LOGGER.error("Error while trying to retrieve host name from eureka registry, exception = ", e);
        }
        return hostName;
    }
}
