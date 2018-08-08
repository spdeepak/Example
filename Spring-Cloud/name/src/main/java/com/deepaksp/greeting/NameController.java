package com.deepaksp.greeting;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class NameController {

    private NameProperties nameProperties;

    public NameController(NameProperties nameProperties) {
        this.nameProperties = nameProperties;
    }

    @GetMapping
    public String getName() {
        log.info("Inside Name Micro Service");
        log.info("Name From the Properties file: " + nameProperties.getName());
        return nameProperties.getName();
    }
}
