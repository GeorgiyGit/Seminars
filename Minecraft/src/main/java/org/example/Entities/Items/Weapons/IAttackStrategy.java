package org.example.Entities.Items.Weapons;

import org.example.Engines.MyContext;

public interface IAttackStrategy {
    public void attack(MyContext context);
    public int getCurrentPoweredTime();
    public int getMaxPoweredTime();
}
