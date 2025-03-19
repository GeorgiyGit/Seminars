package org.example.Exceptions;

public class EntityInitializationException extends Exception {
    private final CustomExceptionTypes type;
    public EntityInitializationException(String errorMessage, CustomExceptionTypes type) {
        super(errorMessage);
        this.type = type;
    }
    public CustomExceptionTypes getType() {
        return type;
    }
}
