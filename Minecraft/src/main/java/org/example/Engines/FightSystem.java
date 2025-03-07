package org.example.Engines;


import org.example.Engines.Damage.Damage;
import org.example.Engines.Movement.Vector;
import org.example.Engines.World.IWorldService;
import org.example.Engines.World.WorldService;
import org.example.Entities.Creatures.BaseCreature;
import org.example.Entities.Creatures.NPCs.Creeper;
import org.example.Entities.Creatures.Steve;
import org.example.Entities.Items.Armor.Armor;
import org.example.Entities.Items.Enchantments.Enchantments.Armors.FireProtectionEnchantment;
import org.example.Entities.Items.Enchantments.Enchantments.MeleeWeapons.SharpnessEnchantment;
import org.example.Entities.Items.Tools.Tool;
import org.example.Utils.AppContainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FightSystem {
    private List<BaseCreature> firstTeam;
    private List<BaseCreature> secondTeam;
    int roundCounter=1;
    public boolean isEnd = false;
    Random rand=new Random();
    public FightSystem() {
        firstTeam = new ArrayList<BaseCreature>();
        secondTeam = new ArrayList<BaseCreature>();
        rand.setSeed(System.currentTimeMillis());
    }


    public void initialize(){
        int n1 = rand.nextInt(1,10);
        int n2 = rand.nextInt(1,10);

        initializeTeam(firstTeam,n1);
        initializeTeam(secondTeam,n2);
    }

    private void initializeTeam(List<BaseCreature> team, int count){
        IWorldService worldService = AppContainer.getContainer().getComponent(WorldService.class);
        IEngine<Damage> damageEngine = (IEngine<Damage>) AppContainer.getContainer().getComponent("DamageEngine");
        for(int i=1;i<count;i++){
            int type = rand.nextInt(3);

            switch (type){
                case 0:
                    Creeper creeper = new Creeper(rand.nextInt(100),
                            "Entities.Creatures.NPCs.Creeper: "+ i,
                            64,
                            64,
                            3,
                            0,
                            new Vector(rand.nextInt(20),rand.nextInt(20)),
                            worldService,
                            damageEngine);
                    team.add(creeper);
                    break;
                case 1:
                    Steve steve = new Steve(rand.nextInt(100),
                            "Entities.Creatures.Steve: "+i,
                            20,
                            20,
                            5,
                            5,
                            20,
                            false,
                            new Vector(rand.nextInt(20),rand.nextInt(20)),
                            worldService,
                            damageEngine);
                    team.add(steve);
                    break;
                case 2:
                    Steve steveWithSword = new Steve(rand.nextInt(100),
                            "ESuper Entities.Creatures.Steve: "+i,
                            20,
                            20,
                            5,
                            5,
                            20,
                            false,
                            new Vector(rand.nextInt(20),rand.nextInt(20)),
                            worldService,
                            damageEngine);
                    Tool sword = new Tool(rand.nextInt(100),"Sword","Sword",1,3,damageEngine);
                    sword.applyEnchantment(new SharpnessEnchantment(3,damageEngine));
                    steveWithSword.getInventory().setItem(sword,0);
                    steveWithSword.setArmor(new Armor(rand.nextInt(100),"Diamond Armor","Armor",1,1,10,20));
                    steveWithSword.getArmor().applyEnchantment(new FireProtectionEnchantment(2));
                    team.add(steveWithSword);
                    break;
            }
        }
    }

    public void Round(){
        System.out.println("-------Round "+roundCounter+"-------");

        int index = rand.nextInt(firstTeam.size());
        BaseCreature n1 = firstTeam.get(index);
        int index2 = rand.nextInt(secondTeam.size());
        BaseCreature n2 = secondTeam.get(index2);

        System.out.println("First team: " +n1.toString());
        System.out.println("Second team: " +n2.toString());

        n1.attack();
        if(n2.getHealth()<=0){
            System.out.println(n2.getId()+" "+n2.getName() +" is dead");
            secondTeam.remove(n2);
        }
        else{
            n2.attack();
            if(n1.getHealth()<=0){
                System.out.println(n1.getId()+" "+n1.getName() +" is dead");
                firstTeam.remove(n1);
            }
        }
        System.out.println("\nFirst team: ");
        printTeam(firstTeam);
        System.out.println("\n\nSecond team: ");
        printTeam(secondTeam);
        System.out.println("\n\n");
        if(firstTeam.size()==0){
            System.out.println("Second team win");
            isEnd=true;
        }
        if(secondTeam.size()==0){
            System.out.println("Fist team win");
            isEnd=true;
        }

        System.out.println("\n\n\n\n");
        roundCounter++;
    }

    private void printTeam(List<BaseCreature> team){
        for(BaseCreature n : team){
            System.out.println(n.toString());
        }
    }
}
