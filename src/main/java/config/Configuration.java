package config;

import org.aeonbits.owner.Config;

import java.net.URL;
import java.time.Duration;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:configuration.properties"})
public interface Configuration extends Config {

    @Key("Appium")
    String Appium();

    @Key("waitTime")
    int waitTime();
}
