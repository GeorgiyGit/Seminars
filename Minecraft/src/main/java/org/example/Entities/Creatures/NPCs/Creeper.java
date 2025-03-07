package org.example.Entities.Creatures.NPCs;


import org.example.Engines.Damage.Damage;
import org.example.Engines.Damage.DamageType;
import org.example.Engines.IEngine;
import org.example.Engines.Movement.Vector;
import org.example.Engines.MyContext;
import org.example.Engines.World.IWorldService;
import org.example.Entities.Creatures.BaseCreature;
import org.example.Entities.Inventory.Inventory;
import org.example.Entities.Items.Item;
import org.example.Entities.Items.Tools.Bomb;
import org.example.Entities.Items.Tools.Tool;
import org.example.Utils.AppContainer;

import java.util.ArrayList;
import java.util.List;

public class Creeper extends NPC {
    IWorldService _worldService;
    IEngine<Damage> _damageEngine;
    public Creeper(int id,
                   String name,
                   int health,
                   int maxHealth,
                   int attackPower,
                   int defensePower,
                   Vector position,
                   IWorldService worldService,
                   IEngine<Damage> damageEngine) {
        super(id,name,health,maxHealth,attackPower,defensePower,position,1);
        Tool bomb=new Bomb(41,"Bomb","Bomb",10,1, damageEngine,5);
        inventory.setItem(bomb,0);
        _worldService=worldService;
        _damageEngine=damageEngine;
    }

    @Override
    public void defence(Damage damage) {
        double realDamage = damage.getDamage()-defensePower;
        if(realDamage > 0) {
            health -= (int) realDamage;
        }
    }

    @Override
    public void attack() {
        List<BaseCreature> creatures = _worldService.getCreatures();
        creatures.remove(this);

        for(BaseCreature creature : creatures) {
            _damageEngine.add(new Damage(this,creature, DamageType.Attack,getAttackPower()));
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
}
