package Entities.Creatures;

import Engines.Damage.Damage;
import Engines.Movement.Vector;
import Entities.Items.Food.Food;
import Entities.Items.Weapons.Weapon;

public class Steve extends BaseCreature {
    private int hunger;
    private final int maxHunger;
    private boolean godMode;

    public Steve(int id,
                 String name,
                 int health,
                 int maxHealth,
                 int attackPower,
                 int defensePower,
                 int maxHunger,
                 boolean godMode,
                 Vector position) {
        super(id,name,health,maxHealth,attackPower,defensePower,position,10);
        this.maxHunger = maxHunger;
        this.godMode=godMode;
    }

    void consume(Food food) {
        if (food.getAmount() > 0) {
            health = Math.min(health + food.getHeal(), maxHealth);
            hunger = Math.min(hunger + food.getFeed(), maxHunger);

            food.decrementAmount();

            System.out.println(name + " sa najedol, hunger je " + hunger + " health je " + health);
        }
    }
    @Override
    public void defence(Damage damage){

    }

    @Override
    public void attack(){

    }

    @Override public void attack(BaseCreature who) {
        int power = attackPower;
        if(weapon!=null){
            power+=weapon.attack();
        }
        who.defence(power);
    }

    @Override public void defence(int attackPower){
        if(godMode)return;
        health =health- (attackPower-defensePower);
    }
    @Override
    public void defence(Damage damage) {
        if(godMode)return;

    }

    @Override
    public void attack() {

    }

    public int getMaxHunger() {
        return maxHunger;
    }
    public boolean getGodMode() {
        return godMode;
    }
}
