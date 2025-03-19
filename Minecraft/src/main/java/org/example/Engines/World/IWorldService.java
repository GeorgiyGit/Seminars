package org.example.Engines.World;


import org.example.Entities.Creatures.BaseCreature;

import java.util.List;
import java.util.UUID;

//Will be changed in the future
public interface IWorldService {
    public List<BaseCreature> getCreatures();
    public BaseCreature findCreature(UUID id);
    public List<BaseCreature> filterCreatures(String name);
}
