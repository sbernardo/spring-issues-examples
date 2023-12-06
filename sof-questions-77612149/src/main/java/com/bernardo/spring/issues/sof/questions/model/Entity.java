package com.bernardo.spring.issues.sof.questions.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "entity")
@AllArgsConstructor
@FieldNameConstants
public class Entity {

    public static final String COLLECTION_NAME = "entity";

    @Id
    UUID id;

    @Builder.Default
    TestType testType = new TestType("payload");
}