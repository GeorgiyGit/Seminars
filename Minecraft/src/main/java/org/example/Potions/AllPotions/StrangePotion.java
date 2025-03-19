package org.example.Potions.AllPotions;

import org.example.Engines.MyContext;
import org.example.Potions.IPotion;
import org.example.Potions.PotionDecorator;

public class StrangePotion extends PotionDecorator {
    public StrangePotion(IPotion potion) {
        super(potion);
    }
    @Override
    public void active(MyContext context) {
        context.calculatedAttackPower+= (int) ((double)(getLevel()/2)*context.calculatedAttackPower);
        super.active(context);
    }
}
