package org.example.Engines.Damage;


import org.example.Entities.Creatures.BaseCreature;

public class Damage {
    private final BaseCreature attacker;
    private final BaseCreature defender;
    private final DamageType damageType;
    private final double damage;

    public Damage(BaseCreature attacker, BaseCreature defender, DamageType damageType, double damage) {
        this.attacker = attacker;
        this.defender = defender;
        this.damageType = damageType;
        this.damage = damage;
    }

    public BaseCreature getAttacker() {
        return attacker;
    }

    public BaseCreature getDefender() {
        return defender;
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public double getDamage() {
        return damage;
    }
}
