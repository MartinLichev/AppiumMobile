package config;

import org.aeonbits.owner.ConfigCache;

public class CapabilitiesManager {

    private CapabilitiesManager() { }

    public static Capabilities capabilities() {
        return ConfigCache.getOrCreate(Capabilities.class);
    }
}
