package org.example.Engines;


import org.example.Engines.Damage.DamageType;
import org.example.Entities.Creatures.BaseCreature;

import java.util.List;

public class MyContext {
    public BaseCreature attacker;
    public List<BaseCreature> defenders;
    public DamageType damageType;

    public double basicDefence;
    public double calculatedDefence;
    public double basicAttackPower;
    //public int calculatedAttackPower;
}
