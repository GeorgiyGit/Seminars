package org.example.Utils;

import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;

public class AppContainer {
    private static final MutablePicoContainer container = new DefaultPicoContainer();
    private AppContainer() {}

    public static MutablePicoContainer getContainer() {
        return container;
    }
}