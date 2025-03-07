package org.example.Entities.Items.Enchantments.Enchantments.Armors;


import org.example.Engines.Damage.DamageType;
import org.example.Engines.MyContext;
import org.example.Entities.Items.Enchantments.EnchantmentWeaponTypes;
import org.example.Entities.Items.Enchantments.IEnchantment;
import org.example.Entities.Items.Item;

public class FireProtectionEnchantment implements IEnchantment {
    final int level;
    static final int MAX_LEVEL = 3;

    public FireProtectionEnchantment(int level) {
        this.level = level;
    }

    @Override
    public String getName() {
        return "Fire Protection";
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public boolean isAllowedWeapon(Item item) {
        return item.getEnchantmentType() == EnchantmentWeaponTypes.MeleeWeapons;
    }

    @Override
    public void executeEnchantment(Item item, MyContext context) {
        if(context.damageType!= DamageType.Fire)return;
        context.calculatedDefence += (int)(context.basicAttackPower*((double)level/((double)MAX_LEVEL*2.0)));
    }
}
