package com.bernardo.spring.issues.sof.questions;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "gateway")
public class ConfigurationPropertiesYml {

    private List<Server> servers;

    private String v1Prefix;

    @Data
    public static class Server {
        private String url;
        private String description;
    }
}