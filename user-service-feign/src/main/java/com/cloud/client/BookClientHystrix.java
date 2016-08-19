package com.cloud.client;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class BookClientHystrix implements BookServiceClient {

    @Override
    public String add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return "" + -9999;
    }

}