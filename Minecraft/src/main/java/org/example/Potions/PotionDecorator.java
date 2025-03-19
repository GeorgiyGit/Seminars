package org.example.Potions;

import org.example.Engines.MyContext;
import org.example.Utils.Counter;

public class PotionDecorator implements IPotion {
    protected final IPotion potion;
    public PotionDecorator(IPotion potion) {
        this.potion = potion;
    }

    @Override
    public void active(MyContext context) {
        Counter.getInstance().increase();
        potion.active(context);
    }

    @Override
    public String getName() {
        return potion.getName();
    }

    @Override
    public int getDuration() {
        return potion.getDuration();
    }

    @Override
    public int getLevel() {
        return potion.getLevel();
    }
}
