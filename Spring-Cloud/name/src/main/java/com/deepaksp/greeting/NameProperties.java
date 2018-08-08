package com.deepaksp.greeting;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class NameProperties {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
