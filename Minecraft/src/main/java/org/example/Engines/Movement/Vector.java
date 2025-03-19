package org.example.Engines.Movement;

public class Vector {
    private int x;
    private int y;
    public Vector(int x, int y) {
        this.x=x;
        this.y=y;
    }
    public int getX() {
        return x;
    }
    public int getY(){
        return y;
    }

    public double calculateDistanceTo(Vector second) {
        return Math.sqrt(Math.pow(this.x - second.x, 2) + Math.pow(this.y - second.y, 2));
    }
}
