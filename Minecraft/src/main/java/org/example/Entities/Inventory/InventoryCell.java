package org.example.Entities.Inventory;


import org.example.Entities.Items.Item;

public class InventoryCell {
    private Item item;

    public InventoryCell(Item item) {
        this.item = item;
    }
    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }
}
