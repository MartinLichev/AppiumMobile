package driver;

import java.util.Locale;

public enum DriverType {

    ANDROID("Android"),
    IOS("IOS");

    DriverType(final String type) {
        this.driverType = type;
    }

    private String driverType;
    public String getDriverType() {
        return this.driverType;
    }

    public static DriverType getDriverByName(String platformName){
        return DriverType.valueOf(platformName.toUpperCase(Locale.ROOT));
    }
}
