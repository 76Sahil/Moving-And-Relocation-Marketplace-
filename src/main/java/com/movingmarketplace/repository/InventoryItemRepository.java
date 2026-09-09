package com.movingmarketplace.repository;

import com.movingmarketplace.entity.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long>     //Create a repository for InventoryItem, whose primary-key type is Long.
{
}