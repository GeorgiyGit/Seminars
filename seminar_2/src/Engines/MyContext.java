package Engines;

import Engines.Movement.Impulse;
import Entities.Creatures.BaseCreature;

import java.util.List;

public class MyContext {
    public BaseCreature attacker;
    public List<BaseCreature> defenders;
    public ContextTypes type;

    public int basicDefence;
    public int calculatedDefence;
    public int basicAttackPower;
    //public int calculatedAttackPower;
}
