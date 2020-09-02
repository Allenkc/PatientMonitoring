public interface Sensor {
    void alarm(String patientName , String deviceName , double factorValue);
    String getDeviceName();
    String getFactorDataSetFileName();
    double getSafeRangeLowerBound();
    double getSafeRangeUpperBound();
    String getIsAttachedTo();
}
