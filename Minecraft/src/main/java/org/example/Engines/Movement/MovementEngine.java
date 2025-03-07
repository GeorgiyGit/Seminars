package org.example.Engines.Movement;

import org.example.Engines.IEngine;

import java.util.ArrayList;
import java.util.List;

public class MovementEngine implements IEngine<Impulse> {
    private List<Impulse> impulseList = new ArrayList<Impulse>();

    @Override
    public void add(Impulse element) {
        impulseList.add(element);
    }

    @Override
    public void remove(Impulse element) {
        impulseList.remove(element);
    }

    @Override
    public void execute() {
        //Movement
    }
}
