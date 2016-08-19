package com.cloud.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "book-service", fallback = BookClientHystrix.class)
public interface BookServiceClient {

	@RequestMapping(method = RequestMethod.GET, value = "/add",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	String add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

}
