package org.example.Entities.Items.Enchantments;

import java.util.List;

public interface IEnchantable {
    List<IEnchantment> getEnchantments();
    void applyEnchantment(IEnchantment enchantment);
    void removeEnchantment(IEnchantment enchantment);
    boolean isEnchanted();
}
