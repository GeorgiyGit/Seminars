package Entities.Creatures.NPCs;

import Engines.Movement.Vector;
import Entities.BaseEntity;
import Entities.Creatures.BaseCreature;
import Entities.Items.Weapons.Weapon;

public abstract class NPC extends BaseCreature {

    public NPC(int id, String name, int health, int maxHealth, int attackPower, int defensePower, Vector position)
    {
        super(id,name,health,maxHealth,attackPower,defensePower,position);
    }
}
