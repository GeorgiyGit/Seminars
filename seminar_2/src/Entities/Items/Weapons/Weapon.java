package Entities.Items.Weapons;

import Entities.Items.Enchantments.EnchantmentWeaponTypes;
import Entities.Items.IDurability;
import Entities.Items.Item;

public class Weapon extends Item implements IDurability {
    protected int attackPower;
    protected int durability;
    protected Enchantment enchantment;

    public Weapon(int id, String name, String type, int attackPower, int durability, EnchantmentWeaponTypes enchantmentTypes) {
        super(id,name,1,type, 1,enchantmentTypes);
        this.attackPower=attackPower;
        this.durability = durability;
    }


    public int getAttackPower() {
        return attackPower;
    }

    public int getDurability() {
        return durability;
    }

    public int attack(){
        if(durability<=0)return 0;
        int power = attackPower;
        if(enchantment!=null){
            power+= enchantment.getPower();
        }
        durability--;
        return power;
    }

    public Enchantment getEnchantment() {
        return enchantment;
    }

    public void setEnchantment(Enchantment enchantment) {
        this.enchantment = enchantment;
    }
}
