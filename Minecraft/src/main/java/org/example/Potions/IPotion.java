package org.example.Potions;

import org.example.Engines.MyContext;

public interface IPotion {
    public void active(MyContext context);
    public String getName();
    public int getDuration();
    public int getLevel();
}
