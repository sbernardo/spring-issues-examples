package com.bernardo.spring.issues.sof.questions.autoconfiguration;

import com.bernardo.spring.issues.sof.questions.converter.StringTestTypeConverter;
import com.bernardo.spring.issues.sof.questions.converter.TestTypeStringConverter;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.List;

@AutoConfiguration
public class AutoConfigurationReactiveMongo {

    @Bean
    public MongoCustomConversions mongoCustomConversions() {
        return new MongoCustomConversions(List.of(
                new TestTypeStringConverter(),
                new StringTestTypeConverter()
        ));
    }

}
