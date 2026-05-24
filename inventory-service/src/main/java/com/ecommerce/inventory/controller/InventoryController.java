package com.ecommerce.inventory.controller;

import com.ecommerce.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/check/{productId}")
    public Boolean isInStock(@PathVariable Long productId){
        return inventoryService.isInStock(productId);
    }
}