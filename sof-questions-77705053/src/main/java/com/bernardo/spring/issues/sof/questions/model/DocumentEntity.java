package com.bernardo.spring.issues.sof.questions.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document("DOCUMENT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentEntity {

    @Id
    private String id;

    private List<String> field1;

    private String field2;

    private Date field3;

}
