package org.example;

import org.example.Engines.Damage.Damage;
import org.example.Engines.Damage.DamageEngine;
import org.example.Engines.FightSystem;
import org.example.Engines.IEngine;
import org.example.Engines.Movement.MovementEngine;
import org.example.Engines.World.WorldService;
import org.example.Utils.AppContainer;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;

public class Main {
    public static void main(String[] args) {
        MutablePicoContainer container = AppContainer.getContainer();
        container.addComponent("DamageEngine", new DamageEngine());
        container.addComponent("MovementEngine", new MovementEngine());
        container.addComponent(WorldService.class, new WorldService());

        //Now we don`t have normal WorldService, so the fighting will be forever (but everything works);
        FightSystem fs = new FightSystem();
        fs.initialize();
        while(!fs.isEnd){
            fs.Round();
        }
    }
}