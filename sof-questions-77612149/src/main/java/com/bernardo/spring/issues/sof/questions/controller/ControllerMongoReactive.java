package com.bernardo.spring.issues.sof.questions.controller;

import com.bernardo.spring.issues.sof.questions.model.Entity;
import com.bernardo.spring.issues.sof.questions.model.TestType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.data.mongodb.core.aggregation.Fields.UNDERSCORE_ID;

@RestController
@RequiredArgsConstructor
public class ControllerMongoReactive {

    private final ReactiveMongoTemplate reactiveMongoTemplate;

    @GetMapping("save/into/mongo")
    public String myEndpoint() {
        var entity = new Entity(UUID.fromString("7f6a35fb-a449-4e31-b9c1-7592cc969d83"), new TestType("Hello3"));

        Update update = new Update();
        update.set(Entity.Fields.testType, entity.getTestType());
        update.set("field2", "otherFieldValue");

        return reactiveMongoTemplate
                .bulkOps(BulkOperations.BulkMode.UNORDERED, Entity.class)
                .upsert(Query.query(new Criteria(UNDERSCORE_ID).is(entity.getId())), update)
                .execute()
                .block()
                .toString();
    }

}
