package com.bernardo.spring.issues.sof.questions;

import com.bernardo.spring.issues.sof.questions.request.RequestEndpoint;
import jakarta.validation.Valid;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostMapping("hello")
    public String myEndpoint(@RequestBody @Valid RequestEndpoint requestEndpoint) {
        return "hello";
    }

}
