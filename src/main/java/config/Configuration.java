package config;

import org.aeonbits.owner.Config;

import java.net.URL;
import java.time.Duration;

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
