package com.bernardo.spring.issues.sof.questions;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@Slf4j
@EnableConfigurationProperties(ConfigurationPropertiesYml.class)
@SpringBootApplication
@RequiredArgsConstructor
public class ApplicationConfigurationYml {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfigurationYml.class, args);
    }

    private final ConfigurationPropertiesYml servers;

    @Bean
    ApplicationRunner runAll() {
        return args -> log.info("Configuration {}", servers);
    }

}
