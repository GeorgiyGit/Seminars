package org.example.Entities.Creatures;


import org.example.Engines.Damage.Damage;
import org.example.Engines.Movement.Vector;
import org.example.Entities.BaseEntity;
import org.example.Entities.Inventory.Inventory;
import org.example.Entities.Items.Item;

public abstract class BaseCreature extends BaseEntity {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int attackPower;
    protected int defensePower;
    protected Vector position;
    protected Vector viewDirection;
    protected Inventory inventory;

    public BaseCreature(int id, String name, int health, int maxHealth, int attackPower, int defensePower, Vector position, int inventoryCount)
    {
        super(id);
        this.name = name;
        this.health = health;
        this.maxHealth = maxHealth;
        this.attackPower=attackPower;
        this.defensePower=defensePower;
        this.position = position;
        this.viewDirection = new Vector(0,0);
        this.inventory = new Inventory(inventoryCount);
    }
    public BaseCreature(int id, String name, int health, int maxHealth, int attackPower, int defensePower, Vector position, Inventory inventory) {
        super(id);
        this.name = name;
        this.health = health;
        this.maxHealth = maxHealth;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
        this.position = position;
        this.viewDirection = new Vector(0, 0);
        this.inventory = inventory;
    }

    public abstract void defence(Damage damage);
    public abstract void attack();

    public String getName(){
        return name;
    }
    public int getHealth(){
        return health;
    }
    public int getMaxHealth(){
        return maxHealth;
    }
    public int getAttackPower(){
        return attackPower;
    }
    public int getDefensePower(){
        return defensePower;
    }
    public Inventory getInventory(){
        return inventory;
    }

    public Vector getPosition(){
        return position;
    }
    public void setPosition(Vector position) {
        this.position = position;
    }
    public Vector getViewDirection(){
        return viewDirection;
    }
    public void setViewDirection(Vector viewDirection) {
        this.viewDirection = viewDirection;
    }

    @Override
    public String toString() {
        return String.format("Name(%s), health(%d), maxHealth(%d), attackPower(%s), defensePower(%d), ", name, health, maxHealth,attackPower,defensePower);
    }
}
