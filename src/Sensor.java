import java.io.IOException;

public interface Sensor {
    void alarm(String patientName , String deviceName , double factorValue);
    String getDeviceName();
    String getFactorDataSetFileName();
    double getSafeRangeLowerBound();
    double getSafeRangeUpperBound();
    String getIsAttachedTo();
    void readFactorValue() throws IOException;
    double showValue();
    void incrementCounter();
}
