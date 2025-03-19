package org.example.Engines.World;


import org.example.Engines.IEngine;
import org.example.Engines.Movement.Impulse;
import org.example.Engines.Movement.Vector;
import org.example.Engines.ScannerEngine.IScanner;
import org.example.Entities.Creatures.BaseCreature;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class WorldService implements IWorldService, IScanner, IEngine<BaseCreature> {
    private List<BaseCreature> creatures = new ArrayList<>();

    @Override
    public List<BaseCreature> getCreatures() {
        return creatures;
    }

    @Override
    public BaseCreature findCreature(UUID id) {
        return creatures.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<BaseCreature> filterCreatures(String name) {
        return creatures.stream().filter(c -> c.getName().equals(name)).toList();
    }

    @Override
    public void add(BaseCreature creature) {
        creatures.add(creature);
    }

    @Override
    public void remove(BaseCreature creature) {
        creatures.remove(creature);
    }

    @Override
    public void execute() {
        //Todo
    }

    @Override
    public List<BaseCreature> getCreatures(Vector point, int radius) {
        List<BaseCreature> selectedCreatures = new ArrayList<>();
        for(BaseCreature creature : creatures) {
            if(creature.getPosition().calculateDistanceTo(point) <= radius) {
                selectedCreatures.add(creature);
            }
        }
        return selectedCreatures;
    }
}
