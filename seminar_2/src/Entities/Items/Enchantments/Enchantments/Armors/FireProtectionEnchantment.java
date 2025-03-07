package Entities.Items.Enchantments.Enchantments.Armors;

import Engines.Movement.Impulse;
import Engines.Movement.MovementEngine;
import Engines.Movement.Vector;
import Engines.ContextTypes;
import Entities.Items.Enchantments.EnchantmentWeaponTypes;
import Entities.Items.Enchantments.IEnchantment;
import Entities.Items.Item;
import Entities.Items.Weapons.Weapon;
import Engines.MyContext;

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
        if (item instanceof Weapon) {
            return item.getEnchantmentType() == EnchantmentWeaponTypes.MeleeWeapons;
        }
        return false;
    }

    @Override
    public void executeEnchantment(Item item, MyContext context) {
        if(context.type!= ContextTypes.FireAttack)return;
        context.calculatedDefence += (int)(context.basicAttackPower*((double)level/((double)MAX_LEVEL*2.0)));
    }
}
