package com.edwinmarrugo.userstohexagonal.infrastructure.output.feign.adapter;

import com.edwinmarrugo.userstohexagonal.domain.spi.ExternalServicePort;
import com.edwinmarrugo.userstohexagonal.infrastructure.output.feign.HelloWorldFeign;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HelloWorldFeignAdapter implements ExternalServicePort {
    private final HelloWorldFeign helloWorldFeign;
    @Override
    public String getHelloWorld() {
        return helloWorldFeign.helloWorld();
    }
}
