import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO 抽Sensor Abstract Class
 *
 */

public class BloodPressureSensor implements Sensor {

    private String sensorType;
    private String deviceName;
    private String factorDataSetFileName;
    private double safeRangeLowerBound;
    private double safeRangeUpperBound;
    private String isAttachedTo; //which patient
    private List<Double> factorValue;
    private int detectCounter;

    public BloodPressureSensor() {
    }

    public BloodPressureSensor(String deviceName, String factorDataSetFileName, double safeRangeLowerBound, double safeRangeUpperBound, String isAttachedTo, String sensorType) {
        this.deviceName = deviceName;
        this.factorDataSetFileName = factorDataSetFileName;
        this.safeRangeLowerBound = safeRangeLowerBound;
        this.safeRangeUpperBound = safeRangeUpperBound;
        this.isAttachedTo = isAttachedTo;
        this.detectCounter = 0;
        this.sensorType = sensorType;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getFactorDataSetFileName() {
        return factorDataSetFileName;
    }

    public void setFactorDataSetFileName(String factorDataSetFileName) {
        this.factorDataSetFileName = factorDataSetFileName;
    }

    public double getSafeRangeLowerBound() {
        return safeRangeLowerBound;
    }

    public void setSafeRangeLowerBound(double safeRangeLowerBound) {
        this.safeRangeLowerBound = safeRangeLowerBound;
    }

    public double getSafeRangeUpperBound() {
        return safeRangeUpperBound;
    }

    public void setSafeRangeUpperBound(double safeRangeUpperBound) {
        this.safeRangeUpperBound = safeRangeUpperBound;
    }

    public String getIsAttachedTo() {
        return isAttachedTo;
    }

    public void setIsAttachedTo(String isAttachedTo) {
        this.isAttachedTo = isAttachedTo;
    }

    public List<Double> getFactorValue() {
        return factorValue;
    }

    public void setFactorValue(List<Double> factorValue) {
        this.factorValue = factorValue;
    }

    public int getDetectCounter() {
        return detectCounter;
    }

    public void addDetectCounter() {
        this.detectCounter += 1;
    }

    @Override
    public void alarm(String patientName, String deviceName, double factorValue) {
        System.out.print(patientName + " is in danger!" + " Cause: " + deviceName + " " + factorValue);
    }

    @Override
    public void readFactorValue() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(factorDataSetFileName));

        String line = reader.readLine();
        factorValue = new ArrayList<>();
        factorValue.add(Double.parseDouble(line));
        while (line != null) {
            line = reader.readLine();

            if (line != null) {
                factorValue.add(Double.parseDouble(line));
            }

        }

    }

    @Override
    public double showValue() {

        double nowValue = -1;

        if (detectCounter <= factorValue.size() - 1) {
            nowValue = factorValue.get(detectCounter);
        }

        return nowValue;
    }

    public void incrementCounter() {
        detectCounter++;
    }

    @Override
    public String getSensorTypeName() {
        return this.sensorType;
    }
}
