import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AbstractSensor implements Sensor {

    protected String sensorType;
    protected String deviceName;
    protected String factorDataSetFileName;
    protected double safeRangeLowerBound;
    protected double safeRangeUpperBound;
    protected String isAttachedTo; //which patient
    protected List<Double> factorValue;
    protected int detectCounter;

    protected AbstractSensor() {
    }

    public String getDeviceName() {
        return deviceName;
    }

    public double getSafeRangeLowerBound() {
        return safeRangeLowerBound;
    }

    public double getSafeRangeUpperBound() {
        return safeRangeUpperBound;
    }

    @Override
    public void alarm(Long index , String patientName, String deviceName, double factorValue) {
        System.out.println("[" + index + "]" + " " + patientName + " is in danger! " +
                "Cause: " + deviceName + " " + factorValue);
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
