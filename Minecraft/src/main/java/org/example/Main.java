package org.example;

import org.example.Engines.Damage.Damage;
import org.example.Engines.Damage.DamageEngine;
import org.example.Engines.FightSystem;
import org.example.Engines.IEngine;
import org.example.Engines.Movement.MovementEngine;
import org.example.Engines.Movement.Vector;
import org.example.Engines.World.IWorldService;
import org.example.Engines.World.WorldService;
import org.example.Entities.Creatures.BaseCreature;
import org.example.Entities.Creatures.Steve;
import org.example.Exceptions.EntityInitializationException;
import org.example.Utils.AppContainer;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        WorldService worldServiceImpl = new WorldService();
        MutablePicoContainer container = AppContainer.getContainer();
        container.addComponent("DamageEngine", new DamageEngine());
        container.addComponent("MovementEngine", new MovementEngine());
        container.addComponent("WorldEngine", worldServiceImpl);
        container.addComponent(WorldService.class, worldServiceImpl);

        //Now we don`t have normal WorldService, so the fighting will be forever (but everything works);
        /*FightSystem fs = new FightSystem();
        fs.initialize();
        while(!fs.isEnd){
            fs.Round();
        }*/

        IWorldService worldService = AppContainer.getContainer().getComponent(WorldService.class);
        IEngine<Damage> damageEngine = (IEngine<Damage>) AppContainer.getContainer().getComponent("DamageEngine");

        IEngine<BaseCreature> worldEngine = (IEngine<BaseCreature>)AppContainer.getContainer().getComponent("WorldEngine");

        Random rand=new Random();

        for(int i=0;i<5;i++){
            try{
                Steve steve = new Steve("Entities.Creatures.Steve: "+i,
                        20,
                        20,
                        5,
                        5,
                        20,
                        false,
                        new Vector(rand.nextInt(20),rand.nextInt(20)),
                        worldService,
                        damageEngine);

                worldEngine.add(steve);
            } catch (EntityInitializationException e) {
                e.printStackTrace();
            }
        }
        List<BaseCreature> creatures =  worldService.getCreatures();

        Steve testSteve = (Steve) creatures.getFirst();

        Steve testSteve2 = (Steve)worldService.findCreature(testSteve.getId());
        if(testSteve.equals(testSteve2)){
            System.out.println("Creatures were the same");
        }
        else{
            System.out.println("Creatures were not the same");
        }

        List<BaseCreature> test2Steves = worldService.filterCreatures("Entities.Creatures.Steve: 3");

        for(BaseCreature creature : test2Steves){
            System.out.println(((Steve)creature).getName());
        }
    }
}