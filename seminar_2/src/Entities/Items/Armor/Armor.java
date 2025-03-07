package Entities.Items.Armor;

import Entities.Items.Enchantments.EnchantmentWeaponTypes;
import Entities.Items.IDurability;
import Entities.Items.Item;

public class Armor extends Item implements IDurability {
    private double defense;
    protected int durability;

    public Armor(int id,
                 String name,
                 int amount,
                 String type,
                 int maxAmount,
                 EnchantmentWeaponTypes enchantmentType,
                 double defense,
                 int durability) {
        super(id,name, amount, type, maxAmount, enchantmentType);
        this.defense = defense;
        this.durability = durability;
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
