package com.ecommerce.inventory.service;

import com.ecommerce.inventory.entity.Inventory;
import com.ecommerce.inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public Inventory addStock(Inventory inventory){
        return inventoryRepository.save(inventory);
    }

   public Boolean isInStock(Long productId){
    return inventoryRepository.existsByProductIdAndQuantityGreaterThan(productId,0);
}
    
}