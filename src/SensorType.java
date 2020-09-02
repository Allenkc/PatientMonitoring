public enum SensorType {

    PULSESENSOR("PulseSensor"),
    BLOODPRESSURESENSOR("BloodPressureSensor"),
    TEMPERATURE("TemperatureSensor");

    private String name;

    public String getName() {
        return name;
    }

    SensorType(String name) {
        this.name = name;
    }

    public static  SensorType toSensorType(String name) {
        for(SensorType tmp : SensorType.values()){
            if(tmp.getName().equalsIgnoreCase(name)){
                return tmp;
            }
        }
        return null;
    }
}



