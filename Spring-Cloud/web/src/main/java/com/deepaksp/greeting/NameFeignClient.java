package com.deepaksp.greeting;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "name",url = "http://localhost:7070")
public interface NameFeignClient {

    @GetMapping
    String getName();
}
