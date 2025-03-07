package org.example.Entities.Items.Armor;


import org.example.Engines.MyContext;
import org.example.Engines.World.WorldService;
import org.example.Entities.Items.Enchantments.EnchantmentWeaponTypes;
import org.example.Entities.Items.Enchantments.IEnchantment;
import org.example.Entities.Items.IDurability;
import org.example.Entities.Items.Item;
import org.example.Utils.AppContainer;

public class Armor extends Item implements IDurability {
    private double defense;
    protected int durability;

    public Armor(int id,
                 String name,
                 String type,
                 int amount,
                 int maxAmount,
                 double defense,
                 int durability) {
        super(id,name, amount, type, maxAmount, EnchantmentWeaponTypes.Armor, AppContainer.getContainer().getComponent(WorldService.class));
        this.defense = defense;
        this.durability = durability;
    }


    public void defense(MyContext context) {
        if(durability <=0)return;
        durability--;

        context.basicDefence=defense;
        for(IEnchantment enchantment: enchantments){
            enchantment.executeEnchantment(this,context);
        }
    }
    public double getDefense() {
        return defense;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    @Override
    public int getDurability() {
        return durability;
    }
}
