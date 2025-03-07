package org.example.Entities.Items.Enchantments.Enchantments.MeleeWeapons;


import org.example.Engines.IEngine;
import org.example.Engines.Movement.Impulse;
import org.example.Engines.Movement.Vector;
import org.example.Engines.MyContext;
import org.example.Entities.Creatures.BaseCreature;
import org.example.Entities.Items.Enchantments.EnchantmentWeaponTypes;
import org.example.Entities.Items.Enchantments.IEnchantment;
import org.example.Entities.Items.Item;

public class KnockbackEnchantment implements IEnchantment {
    final int level;
    static final int MAX_LEVEL = 3;
    IEngine<Impulse> _movementEngine;

    public KnockbackEnchantment(int level, IEngine<Impulse> movementEngine) {
        this.level = level;
        _movementEngine=movementEngine;
    }

    @Override
    public String getName() {
        return "Knockback";
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
        Vector viewDirection = context.attacker.getViewDirection();

        Vector vector = new Vector(viewDirection.getX()*level,viewDirection.getY()*level);
        for(BaseCreature defender: context.defenders){
            _movementEngine.add(new Impulse(vector,defender));
        }
    }
}
