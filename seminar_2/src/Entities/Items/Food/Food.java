package Entities.Items.Food;

import Entities.Items.Item;

public class Food extends Item {
    private final int heal;
    private final int feed;

    public Food(int id, String name, int amount, String type, int heal, int feed, int maxAmount) {
        super(id,name,amount,type,maxAmount);
        this.heal = heal;
        this.feed = feed;
    }

    public int getHeal() {
        return heal;
    }

    public int getFeed() {
        return feed;
    }
}
