package org.example.Entities.Creatures.Other;

import org.example.Engines.Damage.Damage;
import org.example.Engines.Damage.DamageType;
import org.example.Engines.IEngine;
import org.example.Engines.Movement.Impulse;
import org.example.Engines.Movement.Vector;
import org.example.Engines.ScannerEngine.IScanner;
import org.example.Entities.BaseEntity;
import org.example.Entities.Creatures.BaseCreature;

import java.util.List;

public class ArrowEntity extends BaseCreature {
    private final IScanner _scanner;

    private final IEngine<Damage> _damageEngine;
    private final IEngine<Impulse> _impulseEngine;
    private final BaseCreature owner;

    private final int radius = 5;
    public ArrowEntity(String name,
                       int health,
                       int maxHealth,
                       int attackPower,
                       int defensePower,
                       Vector position,
                       int inventoryCount,
                       IScanner scanner,
                       IEngine<Damage> damageEngine,
                       IEngine<Impulse> impulseEngine,
                       BaseCreature owner) {
        super(name, health, maxHealth, attackPower, defensePower, position, inventoryCount);
        _scanner = scanner;
        _damageEngine = damageEngine;
        _impulseEngine = impulseEngine;
        this.owner = owner;
    }

    @Override
    public void defence(Damage damage) {
        health -= (int)damage.getDamage();
    }

    @Override
    public void attack() {
        List<BaseCreature> creatures =  _scanner.getCreatures(position,radius);
        for(BaseCreature creature:creatures) {
            _impulseEngine.add(new Impulse(viewDirection,creature));
            _damageEngine.add(new Damage(owner,creature, DamageType.Attack,attackPower));
        }
    }
}
