package Entities.Items.Tools;

import Engines.Damage.Damage;
import Engines.Damage.DamageEngine;
import Engines.IEngine;
import Engines.MyContext;
import Engines.World.IWorldService;
import Entities.Creatures.BaseCreature;
import Entities.Items.Enchantments.EnchantmentWeaponTypes;
import Entities.Items.Enchantments.IEnchantable;
import Entities.Items.Enchantments.IEnchantment;
import Entities.Items.IDurability;
import Entities.Items.Item;
import Utils.DependencyInjection.SimpleDIContainer;

import java.util.ArrayList;
import java.util.List;

public class Tool extends Item implements IDurability {
    protected int attackPower;
    protected int durability;
    IEngine<Damage> _damageEngine

    public Tool(int id, String name, String type, int attackPower, int durability) {
        super(id,name,1,type, 1,EnchantmentWeaponTypes.Tools, SimpleDIContainer.resolve(IWorldService.class));
        this.attackPower=attackPower;
        this.durability = durability;
        _damageEngine = SimpleDIContainer.resolve(IEngine.class);
    }


    public int getAttackPower() {
        return attackPower;
    }

    public int getDurability() {
        return durability;
    }

    public void attack(MyContext context) {
        for (IEnchantment enchantment : enchantments) {
            enchantment.executeEnchantment(this, context);
        }
        context.basicAttackPower=attackPower;
    }

    @Override
    public String toString() {
        return "Name: '" + this.getName() + "', Amount: '" + this.getAmount() + "', Max Amount: '" + this.getMaxAmount() + "', Enchantment Type: '" +this.getEnchantmentType()+"', Attack power: '"+this.getAttackPower()+"', Durability: '"+this.getDurability()+"\n";
    }
}