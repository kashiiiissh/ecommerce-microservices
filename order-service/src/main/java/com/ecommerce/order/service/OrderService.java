package com.ecommerce.order.service;

import com.ecommerce.order.client.InventoryClient;
import com.ecommerce.order.client.NotificationClient;
import com.ecommerce.order.client.ProductClient;
import com.ecommerce.order.dto.NotificationRequest;
import com.ecommerce.order.entity.Order;
import com.ecommerce.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private NotificationClient notificationClient;

    @Autowired
private ProductClient productClient;

@Autowired
private InventoryClient inventoryClient;

    public Order saveOrder(Order order){

    Boolean productExists =
            productClient.isProductExists(order.getProductId());

    if(!productExists){
        throw new RuntimeException("Product does not exist");
    }

    Boolean inStock =
            inventoryClient.isInStock(order.getProductId());

    if(!inStock){
        throw new RuntimeException("Product out of stock");
    }

    NotificationRequest request =
            new NotificationRequest();

    request.setMessage(
            "Order placed successfully for product id: "
                    + order.getProductId()
    );

    notificationClient.sendNotification(request);

    return orderRepository.save(order);
}
}