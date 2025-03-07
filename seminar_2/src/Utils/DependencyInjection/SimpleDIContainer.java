package Utils.DependencyInjection;

import java.util.HashMap;
import java.util.Map;

//Copied from https://medium.com/@AlexanderObregon/implementing-a-lightweight-dependency-injection-container-in-java-8218a147d909
public class SimpleDIContainer {
    private static final Map<Class<?>, Object> instances = new HashMap<>();

    public static <T> void register(Class<T> type, T instance) {
        instances.put(type, instance);
    }

    public static <T> T resolve(Class<T> type) {
        T instance = (T) instances.get(type);

        if (instance == null) {
            throw new IllegalArgumentException("No registered instance found for type: " + type.getName());
        }

        return instance;
    }
}
