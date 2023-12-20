package com.bernardo.spring.issues.sof.questions;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "gateway")
public class ConfigurationPropertiesYml {

    public List<String> publicEndpoints;

}
