package com.deepaksp.greeting;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

@Service
//@EnableFeignClients("name")
public class NameService {

    private NameFeignClient nameFeignClient;

    public NameService(NameFeignClient nameFeignClient) {
        this.nameFeignClient = nameFeignClient;
    }

    public String getName() {
        return nameFeignClient.getName();
    }

    @FeignClient("name")
    static interface NameFeignClient {

        public String getName();
    }
}

