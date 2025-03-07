package org.example.Entities.Items.Tools;

import org.example.Engines.Damage.Damage;
import org.example.Engines.Damage.DamageType;
import org.example.Engines.IEngine;
import org.example.Engines.MyContext;
import org.example.Entities.Creatures.BaseCreature;
import org.example.Entities.Items.Enchantments.IEnchantment;

public class Bomb extends Tool {
    protected int bombTimer;
    protected boolean isBombActivated;

    public Bomb(int id,
                String name,
                String type,
                int attackPower,
                int durability,
                IEngine<Damage> damageEngine,
                int bombTimer) {
        super(id, name, type, attackPower, durability, damageEngine);
        this.bombTimer=bombTimer;
    }

    @Override
    public void attack(MyContext context) {
        context.basicAttackPower = attackPower;
        for (IEnchantment enchantment : enchantments) {
            enchantment.executeEnchantment(this, context);
        }

        int power = attackPower;
        if (isBombActivated) bombTimer--;
        else isBombActivated = true;
        if (bombTimer <= 0) {
            power += getDurability();
        }
        for (BaseCreature defender : context.defenders) {
            _damageEngine.add(new Damage(context.attacker, defender, DamageType.Attack, power));
        }
    }

    public int getBombTimer(){
        return bombTimer;
    }
}
