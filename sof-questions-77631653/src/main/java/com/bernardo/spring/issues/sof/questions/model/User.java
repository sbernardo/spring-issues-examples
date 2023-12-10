package com.bernardo.spring.issues.sof.questions.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document(collection = "entity")
@AllArgsConstructor
public class User {
    @Id
    UUID id;

}