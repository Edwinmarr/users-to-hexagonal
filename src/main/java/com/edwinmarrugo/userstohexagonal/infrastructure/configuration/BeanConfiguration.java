package com.edwinmarrugo.userstohexagonal.infrastructure.configuration;

import com.edwinmarrugo.userstohexagonal.application.handler.UsersHandler;
import com.edwinmarrugo.userstohexagonal.application.handler.UsersHandlerImpl;
import com.edwinmarrugo.userstohexagonal.domain.api.UserServicePort;
import com.edwinmarrugo.userstohexagonal.domain.spi.ExternalServicePort;
import com.edwinmarrugo.userstohexagonal.domain.spi.UserPersistencePort;
import com.edwinmarrugo.userstohexagonal.domain.usecase.UserUseCase;
import com.edwinmarrugo.userstohexagonal.infrastructure.output.feign.HelloWorldFeign;
import com.edwinmarrugo.userstohexagonal.infrastructure.output.feign.adapter.HelloWorldFeignAdapter;
import com.edwinmarrugo.userstohexagonal.infrastructure.output.jpa.adapter.UserPersistenceAdapter;
import com.edwinmarrugo.userstohexagonal.infrastructure.output.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final UserRepository userRepository;
    private final HelloWorldFeign helloWorldFeign;

    @Bean
    public UserPersistencePort userPersistencePort(){
        return new UserPersistenceAdapter(userRepository);
    }

    @Bean
    public UserServicePort userServicePort(){
        return new UserUseCase(userPersistencePort(), externalServicePort());
    }
    @Bean
    public UsersHandler usersHandler(){
        return new UsersHandlerImpl(userServicePort());
    }

    @Bean
    public ExternalServicePort externalServicePort(){
        return new HelloWorldFeignAdapter(helloWorldFeign);
    }
}
