package com.bernardo.spring.issues.sof.questions.service;

import com.bernardo.spring.issues.sof.questions.model.Order;
import com.bernardo.spring.issues.sof.questions.model.OrderItem;
import com.mongodb.bulk.BulkWriteResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Fields;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final MongoOperations mongoOperations;
    private final static String ORDER_COLLECTION = "orders";

    public BulkWriteResult upsertOrders(List<Order> orders, List<OrderItem> ordersItems) {
        BulkWriteResult result = null;
        try {

            if (!ordersItems.isEmpty()) {
                BulkOperations bulkTemplateOperations = mongoOperations.bulkOps(BulkOperations.BulkMode.UNORDERED, ORDER_COLLECTION);
                for (Order order : orders)
                    bulkTemplateOperations
                            .upsert(Query.query(Criteria.where(Fields.UNDERSCORE_ID).is(order.getOrderId())), createOrderUpdate(order));
                result = bulkTemplateOperations.execute();
            }


        } catch (Exception e) {
            log.error("Failed to update orders collection  {}", e.getMessage());
            throw e;
        }
        return result;
    }

    protected Update createOrderUpdate(Order order) {
        Update update = new Update();
        update.set("orderId", order.getOrderId());
        update.set("orderItemList", order.getOrderItemList());
        // how to do for OrderItems
        return update;
    }
}
