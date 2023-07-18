package com.edwinmarrugo.userstohexagonal.infrastructure.configuration;

import com.edwinmarrugo.userstohexagonal.application.handler.UsersHandler;
import com.edwinmarrugo.userstohexagonal.application.handler.UsersHandlerImpl;
import com.edwinmarrugo.userstohexagonal.domain.api.UserServicePort;
import com.edwinmarrugo.userstohexagonal.domain.spi.UserPersistencePort;
import com.edwinmarrugo.userstohexagonal.domain.usecase.UserUseCase;
import com.edwinmarrugo.userstohexagonal.infrastructure.output.jpa.adapter.UserPersistenceAdapter;
import com.edwinmarrugo.userstohexagonal.infrastructure.output.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final UserRepository userRepository;

    @Bean
    public UserPersistencePort userPersistencePort(){
        return new UserPersistenceAdapter(userRepository);
    }

    @Bean
    public UserServicePort userServicePort(){
        return new UserUseCase(userPersistencePort());
    }
    @Bean
    public UsersHandler usersHandler(){
        return new UsersHandlerImpl(userServicePort());
    }

}
