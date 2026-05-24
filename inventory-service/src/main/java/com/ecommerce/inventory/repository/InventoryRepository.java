package com.ecommerce.inventory.repository;

import com.ecommerce.inventory.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository
        extends JpaRepository<Inventory, Long> {

    Inventory findByProductId(Long productId);

    boolean existsByProductIdAndQuantityGreaterThan(
            Long productId,
            Integer quantity
    );
}