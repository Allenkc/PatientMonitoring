public class BloodPressureSensor extends AbstractSensor {

    protected BloodPressureSensor(String deviceName, String factorDataSetFileName, double safeRangeLowerBound, double safeRangeUpperBound, String isAttachedTo, String sensorType) {
        this.deviceName = deviceName;
        this.factorDataSetFileName = factorDataSetFileName;
        this.safeRangeLowerBound = safeRangeLowerBound;
        this.safeRangeUpperBound = safeRangeUpperBound;
        this.isAttachedTo = isAttachedTo;
        this.detectCounter = 0;
        this.sensorType = sensorType;
    }

}
