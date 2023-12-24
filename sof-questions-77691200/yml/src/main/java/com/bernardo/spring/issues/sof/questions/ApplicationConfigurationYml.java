package com.bernardo.spring.issues.sof.questions;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class ApplicationConfigurationYml {

    @Value("${gateway.publicEndpoints}")
    private String[] endpoints;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfigurationYml.class, args);
    }

    @Bean
    ApplicationRunner runAll() {
        return args -> log.info("Configuration {}", Arrays.toString(endpoints));
    }

}
