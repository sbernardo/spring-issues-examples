package com.bernardo.spring.issues.sof.questions.repository;

import com.bernardo.spring.issues.sof.questions.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface UserRepository extends MongoRepository<User, UUID> {
}
