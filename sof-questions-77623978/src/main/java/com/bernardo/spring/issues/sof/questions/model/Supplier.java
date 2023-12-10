package com.bernardo.spring.issues.sof.questions.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "supplier")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

    @Id
    String supplierId;
    String supplierName;
    String supplierPartNumber;
}
