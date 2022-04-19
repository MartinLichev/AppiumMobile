package config;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:capabilities.properties"})
public interface Configuration extends Config {

    @Key("Appium")
    URL Appium();

    @Key("waitTime")
    int waitTime();
}
