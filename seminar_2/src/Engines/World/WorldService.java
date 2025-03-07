package Engines.World;

import Entities.Creatures.BaseCreature;

import java.util.ArrayList;
import java.util.List;

public class WorldService implements IWorldService {
    @Override
    public List<BaseCreature> getCreatures() {
        return new ArrayList<>(); //Will be changed in the future
    }
}
