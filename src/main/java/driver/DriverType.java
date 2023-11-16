package driver;

import java.util.Locale;

public enum DriverType {

    ANDROID("Android"),
    IOS("IOS");

    DriverType(final String type) {
        this.driverType = type;
    }

    private final String driverType;

    public String getDriverType() {
        return this.driverType;
    }

    /**
     * Used when determining "platform"
     *
     * @param platformName Android/IoS
     * @return "platform" to upper case
     */
    public static DriverType getDriverByName(String platformName) {
        return DriverType.valueOf(platformName.toUpperCase(Locale.ROOT));
    }
}
