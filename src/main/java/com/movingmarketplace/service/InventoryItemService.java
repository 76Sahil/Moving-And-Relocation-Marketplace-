package com.movingmarketplace.service;

import com.movingmarketplace.entity.InventoryItem;
import com.movingmarketplace.repository.InventoryItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service                            //This class contains application/business logic and should be managed by Spring
public class InventoryItemService {

    private final InventoryItemRepository inventoryItemRepository;

    public InventoryItemService(InventoryItemRepository inventoryItemRepository) // constructor injection
    {
        this.inventoryItemRepository = inventoryItemRepository;
    }

    //addItem()
    public InventoryItem addItem(InventoryItem item) {
        return inventoryItemRepository.save(item);
    }

    //getAllItems()
    public List<InventoryItem> getAllItems() {
        return inventoryItemRepository.findAll();
    }

    //getItemById()
    public Optional<InventoryItem> getItemById(Long id) {
        return inventoryItemRepository.findById(id);
    }

    //updateItem()
    public InventoryItem updateItem(Long id, InventoryItem updatedItem) {

        InventoryItem existingItem = inventoryItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory item not found"));

        existingItem.setItemName(updatedItem.getItemName());
        existingItem.setQuantity(updatedItem.getQuantity());
        existingItem.setDescription(updatedItem.getDescription());
        existingItem.setFragile(updatedItem.getFragile());

        return inventoryItemRepository.save(existingItem);
    }

    public void deleteItem(Long id) {
        if (!inventoryItemRepository.existsById(id)) {
            throw new RuntimeException("Inventory item not found");
        }

        inventoryItemRepository.deleteById(id);
    }
}