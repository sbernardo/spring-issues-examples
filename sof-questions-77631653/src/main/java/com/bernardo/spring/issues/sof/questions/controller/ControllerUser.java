package com.bernardo.spring.issues.sof.questions.controller;

import com.bernardo.spring.issues.sof.questions.mapper.UserMapper;
import com.bernardo.spring.issues.sof.questions.model.UserDto;
import com.bernardo.spring.issues.sof.questions.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ControllerUser {

    @Autowired
    private UserRepository repository;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("user/{id}")
    public Optional<UserDto> myEndpoint(@PathVariable String id) {
        return repository.findById(UUID.fromString(id)).map(userMapper::toUserDto);
    }

}
