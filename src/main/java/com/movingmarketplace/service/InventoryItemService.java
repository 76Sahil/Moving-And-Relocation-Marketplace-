package com.movingmarketplace.service;

import com.movingmarketplace.dto.InventoryItemRequest;
import com.movingmarketplace.dto.InventoryItemResponse;
import com.movingmarketplace.entity.InventoryItem;
import com.movingmarketplace.repository.InventoryItemRepository;
import org.springframework.stereotype.Service;
import com.movingmarketplace.exception.InventoryItemNotFoundException;

import java.util.List;

@Service
public class InventoryItemService {

    private final InventoryItemRepository inventoryItemRepository;

    public InventoryItemService(InventoryItemRepository inventoryItemRepository) {
        this.inventoryItemRepository = inventoryItemRepository;
    }

    public InventoryItemResponse addItem(InventoryItemRequest request) {

        InventoryItem item = new InventoryItem();

        item.setItemName(request.getItemName());
        item.setQuantity(request.getQuantity());
        item.setDescription(request.getDescription());
        item.setFragile(request.getFragile());

        InventoryItem savedItem = inventoryItemRepository.save(item);

        return mapToResponse(savedItem);
    }

    public List<InventoryItemResponse> getAllItems() {

        return inventoryItemRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public InventoryItemResponse getItemById(Long id) {

        InventoryItem item = inventoryItemRepository.findById(id)
                .orElseThrow(() ->
                        new InventoryItemNotFoundException(
                                "Inventory item not found with id: " + id));

        return mapToResponse(item);
    }

    public InventoryItemResponse updateItem(
            Long id,
            InventoryItemRequest request) {

        InventoryItem existingItem = inventoryItemRepository.findById(id)
                .orElseThrow(() ->
                        new InventoryItemNotFoundException(
                                "Inventory item not found with id: " + id));

        existingItem.setItemName(request.getItemName());
        existingItem.setQuantity(request.getQuantity());
        existingItem.setDescription(request.getDescription());
        existingItem.setFragile(request.getFragile());

        InventoryItem updatedItem =
                inventoryItemRepository.save(existingItem);

        return mapToResponse(updatedItem);
    }

    public void deleteItem(Long id) {

        if (!inventoryItemRepository.existsById(id)) {
            throw new InventoryItemNotFoundException(
                    "Inventory item not found with id: " + id);
        }

        inventoryItemRepository.deleteById(id);
    }

    private InventoryItemResponse mapToResponse(InventoryItem item) {

        return new InventoryItemResponse(
                item.getId(),
                item.getItemName(),
                item.getQuantity(),
                item.getDescription(),
                item.getFragile()
        );
    }
}