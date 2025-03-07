package org.example.Blocks;

import org.example.Entities.Items.Enchantments.IApplyEnchantment;
import org.example.Entities.Items.Enchantments.IEnchantment;
import org.example.Entities.Items.Item;

public class EnchantmentTable implements IApplyEnchantment {
    @Override
    public void applyEnchantment(IEnchantment enchantment, Item item) {
        if (enchantment == null) return;
        item.applyEnchantment(enchantment);
    }
}
