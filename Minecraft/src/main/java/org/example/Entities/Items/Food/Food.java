package org.example.Entities.Items.Food;


import org.example.Engines.IEngine;
import org.example.Engines.World.IWorldService;
import org.example.Engines.World.WorldService;
import org.example.Entities.Items.Enchantments.EnchantmentWeaponTypes;
import org.example.Entities.Items.Item;
import org.example.Utils.AppContainer;
import org.picocontainer.MutablePicoContainer;

public class Food extends Item {
    private final int heal;
    private final int feed;

    public Food(int id,
                String name,
                int amount,
                String type,
                int heal,
                int feed,
                int maxAmount) {
        super(id,name,amount,type,maxAmount, EnchantmentWeaponTypes.Food, AppContainer.getContainer().getComponent(WorldService.class));
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
