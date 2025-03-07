package org.example.Entities.Items;


import org.example.Engines.World.IWorldService;
import org.example.Entities.BaseEntity;
import org.example.Entities.Items.Enchantments.EnchantmentWeaponTypes;
import org.example.Entities.Items.Enchantments.IEnchantable;
import org.example.Entities.Items.Enchantments.IEnchantment;

import java.util.ArrayList;
import java.util.List;

public abstract class Item extends BaseEntity implements IEnchantable {
    private final String name;
    private int amount;
    private final int maxAmount;
    private final String type;
    private final EnchantmentWeaponTypes enchantmentType;
    protected List<IEnchantment> enchantments=new ArrayList<>();

    public Item(int id,
                String name,
                int amount,
                String type,
                int maxAmount,
                EnchantmentWeaponTypes enchantmentType,
                IWorldService worldService) {
        super(id);
        this.name = name;
        this.amount = amount;
        this.type = type;
        this.maxAmount = maxAmount;
        this.enchantmentType = enchantmentType;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }
    public int getMaxAmount() {
        return maxAmount;
    }

    public EnchantmentWeaponTypes getEnchantmentType() {
        return enchantmentType;
    }

    @Override
    public List<IEnchantment> getEnchantments() {
        return enchantments;
    }

    @Override
    public void applyEnchantment(IEnchantment enchantment) {
        enchantments.add(enchantment);
    }

    @Override
    public void removeEnchantment(IEnchantment enchantment) {
        enchantments.remove(enchantment);
    }

    @Override
    public boolean isEnchanted() {
        return !enchantments.isEmpty();
    }

    public String getType() {
        return type;
    }

    public void decrementAmount() {
        amount--;
    }
}
