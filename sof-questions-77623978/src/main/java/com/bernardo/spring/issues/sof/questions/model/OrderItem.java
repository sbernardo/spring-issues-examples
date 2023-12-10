package com.bernardo.spring.issues.sof.questions.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "order-item")
@TypeAlias("OrderItem")
public class OrderItem {

    @Id
    String orderItemId;
    BigDecimal price;
    String partNumber;
    String description;
    int quantityInStock;
    List<Supplier> suppliers;
}
