package com.bernardo.spring.issues.sof.questions.controller;

import com.bernardo.spring.issues.sof.questions.model.DocumentEntity;
import com.bernardo.spring.issues.sof.questions.model.request.DocumentEntityRequest;
import com.bernardo.spring.issues.sof.questions.repository.DocumentRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.RandomStringUtils;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.*;

@Log4j2
@RestController
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentRepository repository;

    @GetMapping("documents")
    public List<DocumentEntity> findDocuments(@ParameterObject @Valid DocumentEntityRequest request) {
        return repository.findDocument(request.getField1(), request.getField2(), request.getField3LowerBound(), request.getField3UpperBound());
    }

    @PutMapping("documents")
    public String insertDocuments() {
        var elements = 20;
        List<DocumentEntity> documents = new ArrayList<>();
        var random = new Random();
        for (int i = 0; i < elements; i++) {
            DocumentEntity document = new DocumentEntity();
            document.setId(RandomStringUtils.randomAlphanumeric(10).toUpperCase());

            var elementsField1 = random.nextInt(5);
            String[] myNumbers = new String[elementsField1];
            Arrays.setAll(myNumbers, value -> RandomStringUtils.randomAlphanumeric(10).toUpperCase());

            document.setId(RandomStringUtils.randomAlphanumeric(10).toUpperCase());
            document.setField1(Arrays.stream(myNumbers).toList());
            document.setField2(RandomStringUtils.randomAlphanumeric(10).toUpperCase());
            document.setField3(Date.from(Instant.now()));
            documents.add(document);
        }

        repository.saveAll(documents);

        return "Insert Done!";
    }
}