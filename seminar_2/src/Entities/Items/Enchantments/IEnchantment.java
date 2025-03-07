package Entities.Items.Enchantments;

import Entities.Items.Item;
import Engines.MyContext;

public interface IEnchantment {
    String getName();
    int getLevel();
    boolean isAllowedWeapon(Item item);
    void executeEnchantment(Item item, MyContext context);
}
