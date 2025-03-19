package org.example.Entities.Items.Weapons;

import org.example.Engines.Damage.Damage;
import org.example.Engines.IEngine;
import org.example.Engines.Movement.Impulse;
import org.example.Engines.Movement.Vector;
import org.example.Engines.MyContext;
import org.example.Engines.ScannerEngine.IScanner;
import org.example.Entities.Creatures.BaseCreature;
import org.example.Entities.Creatures.Other.ArrowEntity;
import org.example.Utils.AppContainer;

public class BowStrategy implements IAttackStrategy{
    private final int maxPoweredTime;
    private int currentPoweredTime;
    private final int attackDamage;
    private IEngine<Impulse> _movementEngine;
    private IEngine<BaseCreature> _worldEngine;

    public BowStrategy(int attackDamage,
                       int maxPoweredTime,
                       IEngine<Impulse> movementEngine,
                       IEngine<BaseCreature> worldEngine) {
        this.attackDamage = attackDamage;
        this.maxPoweredTime = maxPoweredTime;
        this.currentPoweredTime = 0;
        _movementEngine = movementEngine;
        _worldEngine = worldEngine;
    }

    @Override
    public void attack(MyContext context) {
        int resPower = (int)(3*(double)currentPoweredTime/(double)maxPoweredTime);
        Vector position = context.attacker.getPosition();
        ArrowEntity arrowEntity = new ArrowEntity("Arrow",
                1,
                1,
                resPower*attackDamage,
                0,
                new Vector(position.getX(),position.getY()),
                0,
                (IScanner) AppContainer.getContainer().getComponent(IScanner.class),
                (IEngine<Damage>) AppContainer.getContainer().getComponent("DamageEngine"),
                (IEngine<Impulse>) AppContainer.getContainer().getComponent("ImpulseEngine"),
                context.attacker
                ); //TODO: Change Id System

        Vector viewDirection = context.attacker.getViewDirection();
        Vector vector = new Vector(viewDirection.getX()*resPower,viewDirection.getY()*resPower);
        _worldEngine.add(arrowEntity);
        _movementEngine.add(new Impulse(vector,arrowEntity));
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
