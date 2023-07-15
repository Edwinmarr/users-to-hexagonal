package com.edwinmarrugo.userstohexagonal.infrastructure.output.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "hello-world", url = "${external-api.url}")
public interface HelloWorldFeign {
    @GetMapping("/hello-world")
    String helloWorld();
}
