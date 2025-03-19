package org.example.Utils;

public final class Counter {
    private static Counter instance = null;
    int counter = 0;
    public static synchronized Counter getInstance() {
        if (instance == null) {
            instance = new Counter();
        }
        return instance;
    }
    public int getCount(){
        return counter;
    }
    public void increase(){
        counter++;
    }
}
