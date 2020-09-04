import java.io.IOException;

public interface Sensor {
    void alarm(Long index , String patientName, String deviceName, double factorValue);
    String getDeviceName();
    double getSafeRangeLowerBound();
    double getSafeRangeUpperBound();
    void readFactorValue() throws IOException;
    double showValue();
    void incrementCounter();
    String getSensorTypeName();
}
