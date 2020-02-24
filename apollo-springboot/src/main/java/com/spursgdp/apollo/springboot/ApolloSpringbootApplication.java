package com.spursgdp.apollo.springboot;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableApolloConfig
public class ApolloSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApolloSpringbootApplication.class, args);
    }

}
