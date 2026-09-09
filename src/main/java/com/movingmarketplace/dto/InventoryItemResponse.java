package com.movingmarketplace.dto;

public class InventoryItemResponse {

    private Long id;
    private String itemName;
    private Integer quantity;
    private String description;
    private Boolean fragile;

    public InventoryItemResponse() {
    }

    public InventoryItemResponse(
            Long id,
            String itemName,
            Integer quantity,
            String description,
            Boolean fragile) {

        this.id = id;
        this.itemName = itemName;
        this.quantity = quantity;
        this.description = description;
        this.fragile = fragile;
    }

    public Long getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getFragile() {
        return fragile;
    }
}