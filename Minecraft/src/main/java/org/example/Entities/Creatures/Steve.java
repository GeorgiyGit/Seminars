package org.example.Entities.Creatures;


import org.example.Engines.Damage.Damage;
import org.example.Engines.Damage.DamageEngine;
import org.example.Engines.Damage.DamageType;
import org.example.Engines.IEngine;
import org.example.Engines.Movement.Vector;
import org.example.Engines.MyContext;
import org.example.Engines.World.IWorldService;
import org.example.Entities.Items.Armor.Armor;
import org.example.Entities.Items.Food.Food;
import org.example.Entities.Items.Item;
import org.example.Entities.Items.Tools.Tool;

import java.util.ArrayList;
import java.util.List;

public class Steve extends BaseCreature {
    private int hunger;
    private final int maxHunger;
    private boolean godMode;
    private Armor armor;
    private final IWorldService _worldService;
    private final IEngine<Damage> _damageEngine;

    public Steve(int id,
                 String name,
                 int health,
                 int maxHealth,
                 int attackPower,
                 int defensePower,
                 int maxHunger,
                 boolean godMode,
                 Vector position,
                 IWorldService worldService,
                 IEngine<Damage> damageEngine) {
        super(id,name,health,maxHealth,attackPower,defensePower,position,10);
        this.maxHunger = maxHunger;
        this.godMode=godMode;
        _worldService=worldService;
        _damageEngine=damageEngine;
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
        if(godMode)return;
        MyContext context = new MyContext();
        context.attacker=damage.getAttacker();
        context.defenders=new ArrayList<>();
        context.defenders.add(this);
        context.basicAttackPower=damage.getDamage();
        context.damageType=damage.getDamageType();
        armor.defense(context);
        double realDamage = damage.getDamage()-context.calculatedDefence;
        if(realDamage > 0) {
            health -= (int)realDamage;
        }
    }

    @Override
    public void attack(){
        List<BaseCreature> creatures =  _worldService.getCreatures();
        creatures.remove(this);

        for(BaseCreature creature : creatures) {
            _damageEngine.add(new Damage(this,creature,DamageType.Attack,getAttackPower()));
        }

        Item item = inventory.getActiveCell().getItem();
        if(item!=null) {
            MyContext context = new MyContext();
            context.attacker = this;
            context.defenders = creatures;
            context.damageType = DamageType.Attack;
            Tool tool = (Tool) inventory.getActiveCell().getItem();
            tool.attack(context);
        }
    }

    public int getMaxHunger() {
        return maxHunger;
    }
    public boolean getGodMode() {
        return godMode;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}
