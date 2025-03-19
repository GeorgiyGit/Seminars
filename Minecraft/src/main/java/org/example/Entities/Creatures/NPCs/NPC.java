package org.example.Entities.Creatures.NPCs;


import org.example.Engines.Movement.Vector;
import org.example.Entities.Creatures.BaseCreature;
import org.example.Entities.Inventory.Inventory;

public abstract class NPC extends BaseCreature {

    public NPC(String name,
               int health,
               int maxHealth,
               int attackPower,
               int defensePower,
               Vector position,
               Inventory inventory)
    {
        super(name,health,maxHealth,attackPower,defensePower,position,inventory);
    }

    public NPC(String name,
               int health,
               int maxHealth,
               int attackPower,
               int defensePower,
               Vector position,
               int inventoryCount)
    {
        super(name,health,maxHealth,attackPower,defensePower,position,inventoryCount);
    }
}
