package org.example.Entities.Items.Enchantments;


import org.example.Engines.MyContext;
import org.example.Entities.Items.Item;

public interface IEnchantment {
    String getName();
    int getLevel();
    boolean isAllowedWeapon(Item item);
    void executeEnchantment(Item item, MyContext context);
}
