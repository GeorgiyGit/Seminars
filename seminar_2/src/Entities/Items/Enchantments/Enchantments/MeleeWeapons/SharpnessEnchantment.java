package Entities.Items.Enchantments.Enchantments.MeleeWeapons;

import Engines.ContextTypes;
import Engines.Damage.Damage;
import Engines.Damage.DamageType;
import Engines.IEngine;
import Entities.Creatures.BaseCreature;
import Entities.Items.Enchantments.EnchantmentWeaponTypes;
import Entities.Items.Enchantments.IEnchantment;
import Entities.Items.Item;
import Entities.Items.Weapons.Weapon;
import Engines.MyContext;

public class SharpnessEnchantment implements IEnchantment {
    final int level;
    static final int MAX_LEVEL = 5;
    IEngine<Damage> _damageEngine;

    public SharpnessEnchantment(int level, IEngine<Damage> damageEngine) {
        this.level = level;
        _damageEngine = damageEngine;
    }
    @Override
    public String getName() {
        return "Sharpness";
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public boolean isAllowedWeapon(Item item){
        if (item instanceof Weapon){
            return item.getEnchantmentType() == EnchantmentWeaponTypes.MeleeWeapons;
        }
        return false;
    }

    @Override
    public void executeEnchantment(Item item, MyContext context) {
        if (context.type != ContextTypes.Attack) return;

        Weapon weapon = (Weapon) item;
        int attackPower = (int) ((double) weapon.getAttackPower() * ((double) level / ((double) MAX_LEVEL * 2.0)));
        for(BaseCreature defender: context.defenders){
            _damageEngine.add(new Damage(context.attacker, defender, DamageType.Attack, attackPower));
        }
    }
}
