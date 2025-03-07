package Entities.Inventory;

import Entities.Items.Item;

import java.util.List;

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
