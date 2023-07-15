package com.edwinmarrugo.userstohexagonal.infrastructure.springbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.edwinmarrugo.userstohexagonal")
@EnableJpaRepositories(basePackages = "com.edwinmarrugo.userstohexagonal.infrastructure.output.jpa.repository")
@EntityScan("com.edwinmarrugo.userstohexagonal.infrastructure.output.jpa.entity")
@EnableFeignClients(basePackages = "com.edwinmarrugo.userstohexagonal.infrastructure.output.feign")
public class UsersToHexagonalApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersToHexagonalApplication.class, args);
	}

}
