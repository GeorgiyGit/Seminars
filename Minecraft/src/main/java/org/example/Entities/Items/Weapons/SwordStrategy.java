package org.example.Entities.Items.Weapons;

import org.example.Engines.Damage.Damage;
import org.example.Engines.Damage.DamageType;
import org.example.Engines.IEngine;
import org.example.Engines.MyContext;
import org.example.Entities.Creatures.BaseCreature;

public class SwordStrategy implements IAttackStrategy{
    private final int maxPoweredTime;
    private int currentPoweredTime;
    private final int attackDamage;
    private IEngine<Damage> _damageEngine;

    public SwordStrategy(int attackDamage,
                         int maxPoweredTime,
                         IEngine<Damage> damageEngine) {
        this.attackDamage = attackDamage;
        this.maxPoweredTime = maxPoweredTime;
        this.currentPoweredTime = 0;
        _damageEngine = damageEngine;
    }

    @Override
    public void attack(MyContext context) {
        int resPower = (int)((double)attackDamage*(double)currentPoweredTime/(double)maxPoweredTime);
        for(BaseCreature defender: context.defenders){
            _damageEngine.add(new Damage(context.attacker, defender, DamageType.Attack, resPower));
        }
    }

    @Override
    public int getCurrentPoweredTime() {
        return currentPoweredTime;
    }

    @Override
    public int getMaxPoweredTime() {
        return maxPoweredTime;
    }
}
