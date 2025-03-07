package Entities.Creatures;

import Engines.Damage.Damage;
import Engines.Movement.Vector;
import Entities.BaseEntity;
import Entities.Inventory.Inventory;
import Entities.Items.Weapons.Weapon;

public abstract class BaseCreature extends BaseEntity {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int attackPower;
    protected int defensePower;
    protected Weapon weapon;
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
    public Weapon getWeapon(){
        return weapon;
    }
    public void setWeapon(Weapon weapon) {
        this.weapon=weapon;
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
}
