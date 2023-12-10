package com.bernardo.spring.issues.sof.questions.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    UUID id;

    String name;

    String surname;

    String value;

}