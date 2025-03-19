package org.example.Engines.ScannerEngine;

import org.example.Engines.Movement.Vector;
import org.example.Entities.Creatures.BaseCreature;

import java.util.List;

public interface IScanner {
    public List<BaseCreature> getCreatures(Vector point, int radius);
}
