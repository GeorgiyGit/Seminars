package org.example.Entities.Items.Tools;


import org.example.Engines.Damage.Damage;
import org.example.Engines.Damage.DamageType;
import org.example.Engines.IEngine;
import org.example.Engines.MyContext;
import org.example.Engines.World.IWorldService;
import org.example.Engines.World.WorldService;
import org.example.Entities.Creatures.BaseCreature;
import org.example.Entities.Items.Enchantments.EnchantmentWeaponTypes;
import org.example.Entities.Items.Enchantments.IEnchantment;
import org.example.Entities.Items.IDurability;
import org.example.Entities.Items.Item;
import org.example.Utils.AppContainer;

public class Tool extends Item implements IDurability {
    protected int attackPower;
    protected int durability;
    IEngine<Damage> _damageEngine;

    public Tool(int id,
                String name,
                String type,
                int attackPower,
                int durability,
                IEngine<Damage> damageEngine) {
        super(id,name,1,type, 1, EnchantmentWeaponTypes.Tools, AppContainer.getContainer().getComponent(WorldService.class));
        this.attackPower=attackPower;
        this.durability = durability;
        _damageEngine=damageEngine;
    }


    public int getAttackPower() {
        return attackPower;
    }

    public int getDurability() {
        return durability;
    }

    public void attack(MyContext context) {
        if(durability <=0)return;
        durability--;

        context.basicAttackPower=attackPower;
        for (IEnchantment enchantment : enchantments) {
            enchantment.executeEnchantment(this, context);
        }
        for(BaseCreature defender:context.defenders) {
            _damageEngine.add(new Damage(context.attacker,defender, DamageType.Attack,getAttackPower()));
        }
    }

    @Override
    public String toString() {
        return "Name: '" + this.getName() + "', Amount: '" + this.getAmount() + "', Max Amount: '" + this.getMaxAmount() + "', Enchantment Type: '" +this.getEnchantmentType()+"', Attack power: '"+this.getAttackPower()+"', Durability: '"+this.getDurability()+"\n";
    }
}