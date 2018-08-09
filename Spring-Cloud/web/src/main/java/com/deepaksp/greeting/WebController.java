package com.deepaksp.greeting;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class WebController {

    private NameService nameService;

    private GreetingService greetingService;

    public WebController(NameService nameService, GreetingService greetingService) {
        this.nameService = nameService;
        this.greetingService = greetingService;
    }

    @GetMapping
    public String index(HttpServletRequest request) {
        String locale = RequestContextUtils.getLocaleResolver(request).resolveLocale(request).toLanguageTag();
        String localeGreeting = greetingService.getGreeting(locale);
        String name = nameService.getName();
        log.info("Locale: " + locale);
        log.info("Name: " + name);
        String greeting = new StringBuilder().append(localeGreeting).append(" ").append(name).toString();
        log.info("Greeting: " + greeting);
        return greeting;
    }
}