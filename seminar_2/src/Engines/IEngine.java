package Engines;

import java.util.List;

public interface IEngine<T> {
    public void add(T element);
    public void remove(T element);
    public void execute();
}
