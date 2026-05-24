package com.ecommerce.notification.controller;

import com.ecommerce.notification.dto.NotificationRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @PostMapping
    public String sendNotification(
            @RequestBody NotificationRequest request){

        System.out.println("NOTIFICATION: "
                + request.getMessage());

        return "Notification Sent";
    }
}