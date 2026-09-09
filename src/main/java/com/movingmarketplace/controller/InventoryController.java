package com.movingmarketplace.controller;

import com.movingmarketplace.dto.InventoryItemRequest;
import com.movingmarketplace.dto.InventoryItemResponse;
import com.movingmarketplace.service.InventoryItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryItemService inventoryItemService;

    public InventoryController(InventoryItemService inventoryItemService) {
        this.inventoryItemService = inventoryItemService;
    }

    @PostMapping
    public ResponseEntity<InventoryItemResponse> addItem(
            @Valid @RequestBody InventoryItemRequest request) {

        InventoryItemResponse response =
                inventoryItemService.addItem(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<InventoryItemResponse>> getAllItems() {

        return ResponseEntity.ok(
                inventoryItemService.getAllItems()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryItemResponse> getItemById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                inventoryItemService.getItemById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryItemResponse> updateItem(
            @PathVariable Long id,
            @Valid @RequestBody InventoryItemRequest request) {

        return ResponseEntity.ok(
                inventoryItemService.updateItem(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(
            @PathVariable Long id) {

        inventoryItemService.deleteItem(id);

        return ResponseEntity.noContent().build();
    }
}