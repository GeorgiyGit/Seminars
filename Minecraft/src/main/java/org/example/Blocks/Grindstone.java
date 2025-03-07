package org.example.Blocks;

import org.example.Entities.Items.Enchantments.IApplyEnchantment;
import org.example.Entities.Items.Enchantments.IEnchantment;
import org.example.Entities.Items.Enchantments.IRemoveEnchantment;
import org.example.Entities.Items.Item;

public class Grindstone implements IRemoveEnchantment {
    @Override
    public void removeEnchantment(IEnchantment enchantment, Item item) {
        if (enchantment == null) return;
        item.removeEnchantment(enchantment);
    }
}
