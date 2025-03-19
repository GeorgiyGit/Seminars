package org.example.Entities;

import java.util.UUID;

public class BaseEntity<T extends BaseEntity<T>> implements Comparable<T> {
    private final UUID id;

    public BaseEntity() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    @Override
    public int compareTo(T o) {
        return id.compareTo(o.getId());
    }

    @Override
    public boolean equals(Object other) {
        if(other==null) return false;
        if(!(other instanceof BaseEntity)) return false;
        return id.equals(((BaseEntity)other).getId());
    }
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
