package Entities.Items.Enchantments.Enchantments.MeleeWeapons;

import Engines.Damage.Damage;
import Engines.Damage.DamageType;
import Engines.IEngine;
import Engines.Movement.Impulse;
import Engines.Movement.MovementEngine;
import Engines.Movement.Vector;
import Engines.ContextTypes;
import Entities.Creatures.BaseCreature;
import Entities.Items.Enchantments.EnchantmentWeaponTypes;
import Entities.Items.Enchantments.IEnchantment;
import Entities.Items.Item;
import Entities.Items.Weapons.Weapon;
import Engines.MyContext;

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
        if (item instanceof Weapon) {
            return item.getEnchantmentType() == EnchantmentWeaponTypes.MeleeWeapons;
        }
        return false;
    }

    @Override
    public void executeEnchantment(Item item, MyContext context) {
        if(context.type!= ContextTypes.Attack)return;
        Vector viewDirection = context.attacker.getViewDirection();

        Vector vector = new Vector(viewDirection.getX()*level,viewDirection.getY()*level);
        for(BaseCreature defender: context.defenders){
            _movementEngine.add(new Impulse(vector,defender));
        }
    }
}
