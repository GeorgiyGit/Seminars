package org.example.Entities.Items.Enchantments.Enchantments.MeleeWeapons;


import org.example.Engines.Damage.Damage;
import org.example.Engines.Damage.DamageType;
import org.example.Engines.IEngine;
import org.example.Engines.MyContext;
import org.example.Entities.Creatures.BaseCreature;
import org.example.Entities.Items.Enchantments.EnchantmentWeaponTypes;
import org.example.Entities.Items.Enchantments.IEnchantment;
import org.example.Entities.Items.Item;
import org.example.Entities.Items.Tools.Tool;

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
        return item.getEnchantmentType() == EnchantmentWeaponTypes.MeleeWeapons;
    }

    @Override
    public void executeEnchantment(Item item, MyContext context) {
        Tool weapon = (Tool) item;
        int attackPower = (int) ((double) weapon.getAttackPower() * ((double) level / ((double) MAX_LEVEL * 2.0)));
        for(BaseCreature defender: context.defenders){
            _damageEngine.add(new Damage(context.attacker, defender, DamageType.Attack, attackPower));
        }
    }
}
