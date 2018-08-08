package com.deepaksp.greeting;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class GreetingController {

    private GreetingProperties greetingProperties;

    public GreetingController(GreetingProperties greetingProperties) {
        this.greetingProperties = greetingProperties;
    }

    @GetMapping("/{languageCode}")
    public String getGreeting(@PathVariable String languageCode) {
        log.info("Language Code: " + languageCode);
        log.info("Greeting: " + greetingProperties.getGreetings().get(languageCode.toUpperCase()));
        return greetingProperties.getGreetings()
                .getOrDefault(languageCode.toUpperCase(), greetingProperties.getGreeting());
    }

    @RequestMapping("/")
    public String getGreeting() {
        log.info("Greeting: " + greetingProperties.getGreeting());
        return greetingProperties.getGreeting();
    }
}
