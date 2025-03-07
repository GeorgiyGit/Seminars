package Entities.Inventory;

import Entities.Items.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<InventoryCell> cells=new ArrayList<InventoryCell>();

    public Inventory(List<InventoryCell> cells) {
        this.cells=cells;
    }
    public Inventory(int count) {
        for (int i = 0; i < count; i++) {
            cells.add(new InventoryCell(null));
        }
    }

    public List<InventoryCell> getCells() {
        return cells;
    }

    public void setItem(Item item, int index){
        cells.get(index).setItem(item);
    }
    public Item getItem(int index){
        return cells.get(index).getItem();
    }

    public void moveItems(int index1, int index2) {
        Item item1 = cells.get(index1).getItem();
        Item item2 = cells.get(index2).getItem();

        cells.get(index1).setItem(item2);
        cells.get(index2).setItem(item1);
    }
}
