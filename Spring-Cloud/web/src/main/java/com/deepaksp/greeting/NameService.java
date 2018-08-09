package com.deepaksp.greeting;

import org.springframework.stereotype.Service;

@Service
public class NameService {

    private NameFeignClient nameFeignClient;

    public NameService(NameFeignClient nameFeignClient) {
        this.nameFeignClient = nameFeignClient;
    }

    public String getName() {
        return nameFeignClient.getName();
    }

}

