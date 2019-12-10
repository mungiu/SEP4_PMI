package model;

public enum SensorDataTypes {
    CO2("CO2"),
    HUMIDITY("Humidity"),
    TEMPERATURE("Temperature"),
    LIGHT("Light");

    private String value;

    SensorDataTypes(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
