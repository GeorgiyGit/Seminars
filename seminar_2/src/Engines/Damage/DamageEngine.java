package Engines.Damage;

import Engines.IEngine;
import Entities.Creatures.BaseCreature;

import java.util.ArrayList;
import java.util.List;

public class DamageEngine implements IEngine<Damage> {
    List<Damage> damageList=new ArrayList<>();

    @Override
    public void add(Damage element) {
        damageList.add(element);
    }

    @Override
    public void remove(Damage element) {
        damageList.remove(element);
    }

    @Override
    public void execute() {
        for(Damage damage: damageList) {
            BaseCreature defender = damage.getDefender();
            defender.defence(damage);
        }
    }
}
