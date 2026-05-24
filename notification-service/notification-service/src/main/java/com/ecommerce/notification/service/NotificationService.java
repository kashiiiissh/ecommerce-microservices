package com.ecommerce.notification.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendNotification(String message){

        System.out.println("========== NOTIFICATION ==========");
        System.out.println(message);
        System.out.println("==================================");
    }
}