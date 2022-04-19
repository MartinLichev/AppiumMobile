package config;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:capabilities.properties"})
public interface Capabilities extends Config {

    @Key("platformName")
    String platformName();

    @Key("deviceName")
    String deviceName();

    @Key("app")
    String app();
}
