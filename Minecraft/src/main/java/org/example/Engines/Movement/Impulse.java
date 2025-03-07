package org.example.Engines.Movement;

import org.example.Entities.Creatures.BaseCreature;

public class Impulse {
    private Vector vector;
    private BaseCreature creature;

    public Impulse(Vector vector, BaseCreature creature) {
        this.vector = vector;
        this.creature = creature;
    }

    public Vector getVector() {
        return vector;
    }
    public BaseCreature getCreature() {
        return creature;
    }
}
