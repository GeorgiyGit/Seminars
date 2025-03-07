package Entities.Creatures.NPCs;

import Engines.Movement.Vector;
import Entities.Creatures.BaseCreature;
import Entities.Items.Weapons.Weapon;

public class Creeper extends NPC {
    protected double bombTimer;
    protected boolean isBombActivated;

    public Creeper(int id,
                   String name,
                   int health,
                   int maxHealth,
                   int attackPower,
                   int defensePower,
                   double bombTimer,
                   Vector position) {
        super(id,name,health,maxHealth,attackPower,defensePower,position);
        this.bombTimer=bombTimer;

        this.weapon=new Weapon(41,"Bomb",1,0,10,1);
    }

    @Override public void attack(BaseCreature who) {
        int power = attackPower;
        if(isBombActivated)bombTimer--;
        else isBombActivated=true;
        if(bombTimer<=0){
            power+=weapon.attack();
        }
        who.defence(power);
    }

    public double getBombTimer() {
        return bombTimer;
    }
}
