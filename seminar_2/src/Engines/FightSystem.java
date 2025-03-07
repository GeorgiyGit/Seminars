package Engines;

import Entities.Creatures.BaseCreature;
import Entities.Creatures.NPCs.Creeper;
import Entities.Creatures.Steve;
import Entities.Items.Weapons.Weapon;

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
        for(int i=1;i<count;i++){
            int type = rand.nextInt(3);

            switch (type){
                case 0:
                    Creeper creeper = new Creeper(rand.nextInt(100),"Entities.Creatures.NPCs.Creeper: "+ i,64,64,3,0,5);
                    team.add(creeper);
                    break;
                case 1:
                    Steve steve = new Steve(rand.nextInt(100),"Entities.Creatures.Steve: "+i,20,20,5,5,20,false);
                    team.add(steve);
                    break;
                case 2:
                    Steve superSteve = new Steve(rand.nextInt(100),"Super Entities.Creatures.Steve: "+i,20,20,5,5,20,false);
                    Weapon weapon = new Weapon(rand.nextInt(100),"Sword",1,1,3,10);
                    superSteve.setWeapon(weapon);
                    team.add(superSteve);
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

        String weaponText ="";
        if(n1.getWeapon()!=null)weaponText+=n1.getWeapon().getName();
        System.out.println("First team: " +n1.getId()+"(id) "+n1.getName()+"(name) "+n1.getAttackPower()+ "(attackPower) "+n1.getHealth()+"(health) "+weaponText);

        String weapon2Text ="";
        if(n2.getWeapon()!=null)weapon2Text+=n2.getWeapon().getName();
        System.out.println("Second team: " +n2.getId()+"(id) "+n2.getName()+"(name) "+n2.getAttackPower()+ "(attackPower) "+n2.getHealth()+"(health) "+weapon2Text);

        n1.attack(n2);
        if(n2.getHealth()<=0){
            System.out.println(n2.getId()+" "+n2.getName() +" is dead");
            secondTeam.remove(n2);
        }
        else{
            n2.attack(n1);
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
            String weaponText ="";
            if(n.getWeapon()!=null)weaponText+=n.getWeapon().getName();
            System.out.println(n.getId()+"(id) "+n.getName()+"(name) "+n.getAttackPower()+ "(attackPower) "+n.getHealth()+"(health) "+weaponText);
        }
    }
}
