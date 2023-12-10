package com.bernardo.spring.issues.sof.questions.controller;

import com.bernardo.spring.issues.sof.questions.model.Order;
import com.bernardo.spring.issues.sof.questions.model.OrderItem;
import com.bernardo.spring.issues.sof.questions.model.Supplier;
import com.bernardo.spring.issues.sof.questions.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
public class ControllerUser {

    private final OrderService service;

    @PatchMapping("orders")
    public String myEndpoint() {
        var supplier = new Supplier("suppId1", "Salvatore", "PART_NUM122");
        var suppliers = List.of(supplier);
        var firstOrderItem = new OrderItem("IDIT1", BigDecimal.ONE, "PART_NUM1", "Ordered from Amazon", 1, suppliers);
        var orderItems = new ArrayList<>(List.of(firstOrderItem));
        var order = new Order("ID1", orderItems);
        var orders = List.of(order);

        //First upsert -> new order
        var firstUpsert = service.upsertOrders(orders, orderItems);
        log.info("First upsert result: {}", firstUpsert);

        //Second upsert -> add a new order item on an existing order
        var newOrderItem = new OrderItem("IDIT2", BigDecimal.TEN, "PART_NUM2", "Ordered from Ebay", 100, suppliers);
        orderItems.add(newOrderItem);
        var secondUpsert = service.upsertOrders(orders, orderItems);
        log.info("Second upsert result: {}", secondUpsert);

        //Third upsert -> modified price on existing order item
        order.getOrderItemList().getFirst().setPrice(BigDecimal.valueOf(10000));
        var thirdUpsert = service.upsertOrders(orders, orderItems);
        log.info("Third upsert result: {}", thirdUpsert);

        //Fourth upsert -> writing same order
        var fourthUpsert = service.upsertOrders(orders, orderItems);
        log.info("Fourth upsert result: {}", fourthUpsert);

        return fourthUpsert.toString();
    }

}
